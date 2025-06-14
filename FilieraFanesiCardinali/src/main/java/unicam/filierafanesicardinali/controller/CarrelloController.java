package unicam.filierafanesicardinali.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.acquisto.Carrello;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.repository.AcquirenteRepository;
import unicam.filierafanesicardinali.repository.CarrelloRepository;
import unicam.filierafanesicardinali.repository.ProdottoRepository;
import unicam.filierafanesicardinali.service.HandlerCarrello;

@RestController
@RequestMapping("/api/v1/carrelli")
public class CarrelloController {
    private final AcquirenteRepository   acquirenteRepository;
    private final CarrelloRepository carrelloRepository;
    private final ProdottoRepository prodottoRepository;
    private final HandlerCarrello handlerCarrello;

    @Autowired
    public CarrelloController(AcquirenteRepository acquirenteRepository, CarrelloRepository carrelloRepository, ProdottoRepository prodottoRepository, HandlerCarrello handlerCarrello) {
        this.acquirenteRepository = acquirenteRepository;
        this.carrelloRepository = carrelloRepository;

        this.prodottoRepository = prodottoRepository;
        this.handlerCarrello = handlerCarrello;
    }

    @PostMapping("/carrello")
    public ResponseEntity<Carrello> registraCarrello(@RequestBody Carrello carrello) {
        try {
            Carrello newCarrello = carrelloRepository.save(carrello);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCarrello);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/{id}/aggiungiprodotto")
    public ResponseEntity<Carrello> aggiungiProdotto(@RequestBody Long id, Prodotto prodotto) {
        if(prodotto == null || !acquirenteRepository.existsById(id)) {return ResponseEntity.badRequest().build();}

        Carrello carrello = acquirenteRepository.findById(id).get().getCarrello();
        Prodotto prodottoadd = prodottoRepository.findById(prodotto.getId()).get();
        carrello = handlerCarrello.aggiungiProdotto(prodottoadd, carrello);

        return ResponseEntity.ok(carrello);
    }


    @DeleteMapping("/{id}/eliminaprodotto")
    public ResponseEntity<Carrello> eliminaProdotto(@PathVariable Long id, Prodotto prodotto) {
        if(prodotto == null || !acquirenteRepository.existsById(id)) {return ResponseEntity.badRequest().build();}

        Carrello carrello = acquirenteRepository.findById(id).get().getCarrello();
        Prodotto prodottodel = prodottoRepository.findById(prodotto.getId()).get();
        carrello = handlerCarrello.eliminaProdotto(prodottodel, carrello);

        return ResponseEntity.ok(carrello);
    }

    @DeleteMapping("{id}/svuotacarrello")
    public ResponseEntity<Carrello> svuotaCarrello(@PathVariable Long id) {
        if(!acquirenteRepository.existsById(id)) {return ResponseEntity.badRequest().build();}

        Carrello carrello = acquirenteRepository.findById(id).get().getCarrello();
        carrello = handlerCarrello.svuotaCarrello(carrello);

        return ResponseEntity.ok(carrello);
    }




}
