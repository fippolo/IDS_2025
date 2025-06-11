package unicam.filierafanesicardinali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.filierafanesicardinali.repository.ProdottoRepository;
import unicam.filierafanesicardinali.service.HandlerVenditore;
import unicam.filierafanesicardinali.model.prodotti.*;


@RestController
@RequestMapping("/api/v1/prodotti")
public class ProdottoController {
    private final HandlerVenditore handlerVenditore;
    private final ProdottoRepository prodottoRepository;

    @Autowired
    public ProdottoController(HandlerVenditore handlerVenditore, ProdottoRepository prodottoRepository) {
        this.handlerVenditore = handlerVenditore;
        this.prodottoRepository = prodottoRepository;
    }

    @PostMapping("/distributori")
    public ResponseEntity<Prodotto> creaProdotto(@RequestBody ProdottoDistributore prodotto) {

        //if(prodotto.getVenditore() == null) {return ResponseEntity.badRequest().build();}

        Prodotto creato = handlerVenditore.creaProdotto(prodotto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    @PostMapping("/produttori")
    public ResponseEntity<Prodotto> creaProdotto(@RequestBody ProdottoProduttore prodotto) {

      //  if(prodotto.getVenditore() == null) {return ResponseEntity.badRequest().build();}

        Prodotto creato = handlerVenditore.creaProdotto(prodotto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    @PostMapping("/trasformatori")
    public ResponseEntity<Prodotto> creaProdotto(@RequestBody ProdottoTrasformatore prodotto) {

       // if(prodotto.getVenditore() == null) {return ResponseEntity.badRequest().build();}

        Prodotto creato = handlerVenditore.creaProdotto(prodotto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }


}
