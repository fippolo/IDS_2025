package unicam.filierafanesicardinali.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.acquisto.Cart;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.utenti.Acquirente;
import unicam.filierafanesicardinali.repository.AcquirenteRepository;
import unicam.filierafanesicardinali.repository.CarrelloRepository;
import unicam.filierafanesicardinali.repository.ProdottoRepository;
import unicam.filierafanesicardinali.service.HandlerCarrello;
import unicam.filierafanesicardinali.service.HandlerSistemaPagamento;

@RestController
@RequestMapping("/api/v1/carrelli")
public class CarrelloController {
    private final AcquirenteRepository   acquirenteRepository;
    private final CarrelloRepository carrelloRepository;
    private final ProdottoRepository prodottoRepository;
    private final HandlerCarrello handlerCarrello;
    private final HandlerSistemaPagamento handlerSistemaPagamento;

    @Autowired
    public CarrelloController(AcquirenteRepository acquirenteRepository, CarrelloRepository carrelloRepository, ProdottoRepository prodottoRepository, HandlerCarrello handlerCarrello, HandlerSistemaPagamento handlerSistemaPagamento) {
        this.acquirenteRepository = acquirenteRepository;
        this.carrelloRepository = carrelloRepository;

        this.prodottoRepository = prodottoRepository;
        this.handlerCarrello = handlerCarrello;
        this.handlerSistemaPagamento = handlerSistemaPagamento;
    }


    @PostMapping("/carrello")
    public ResponseEntity<Cart> registraCarrello(@RequestBody Cart cart) {
        try {
            Cart newCart = carrelloRepository.save(cart);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCart);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Aggiunge un prodotto al carrello dell'acquirente.
     * @param id ID dell'acquirente
     * @param product prodotto da eliminare
     */
    @PostMapping("/{id}/aggiungiprodotto")
    public ResponseEntity<Cart> aggiungiProdotto(@RequestBody Long id, Product product) {
        if(product == null || !acquirenteRepository.existsById(id)) {return ResponseEntity.badRequest().build();}

        Cart cart = acquirenteRepository.findById(id).get().getCarrello();
        Product prodottoadd = prodottoRepository.findById(product.getId()).get();
        cart = handlerCarrello.aggiungiProdotto(prodottoadd, cart);

        return ResponseEntity.ok(cart);
    }

    /**
     * Elimina un prodotto al carrello dell'acquirente.
     * @param id ID dell'acquirente
     * @param product prodotto da eliminare
     */
    @DeleteMapping("/{id}/eliminaprodotto")
    public ResponseEntity<Cart> eliminaProdotto(@PathVariable Long id, Product product) {
        if(product == null || !acquirenteRepository.existsById(id)) {return ResponseEntity.badRequest().build();}

        Cart cart = acquirenteRepository.findById(id).get().getCarrello();
        Product prodottodel = prodottoRepository.findById(product.getId()).get();
        cart = handlerCarrello.eliminaProdotto(prodottodel, cart);

        return ResponseEntity.ok(cart);
    }

    /**
     * Svuota il carrello dell'acquirente.
     * @param id ID dell'acquirente
     */
    @DeleteMapping("/{id}/svuotacarrello")
    public ResponseEntity<Cart> svuotaCarrello(@PathVariable Long id) {
        if(!acquirenteRepository.existsById(id)) {return ResponseEntity.badRequest().build();}

        Cart cart = acquirenteRepository.findById(id).get().getCarrello();
        cart = handlerCarrello.svuotaCarrello(cart);

        return ResponseEntity.ok(cart);
    }

    /**
     * Acquista un prodotto dal carrello
     * @param id dell'animatore
     * @param product da comprare presente nel carrello
     * @return Carrello aggiurnato
     */
    @PostMapping("/{id}/acquistoprodotto")
    public ResponseEntity<Cart> acquistoProdotto(@PathVariable Long id, Product product) {
        if(product == null || !acquirenteRepository.existsById(id)) {return ResponseEntity.badRequest().build();}

        Acquirente acquirente = acquirenteRepository.findById(id).get();
        Product prodottoacq = prodottoRepository.findById(product.getId()).get();
        Cart cart = handlerSistemaPagamento.acquistoProdotto(prodottoacq, acquirente);
        return ResponseEntity.ok(cart);
    }



}
