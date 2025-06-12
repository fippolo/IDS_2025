package unicam.filierafanesicardinali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.venditori.Produttore;
import unicam.filierafanesicardinali.model.venditori.Venditore;
import unicam.filierafanesicardinali.repository.ProdottoRepository;
import unicam.filierafanesicardinali.repository.VenditoreRepository;
import unicam.filierafanesicardinali.service.HandlerDistributore;
import unicam.filierafanesicardinali.service.HandlerProduttore;
import unicam.filierafanesicardinali.service.HandlerTrasformatore;
import unicam.filierafanesicardinali.model.prodotti.*;

import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@RestController
@RequestMapping("/api/v1/prodotti")
public class ProdottoController {

    private final HandlerDistributore handlerDistributore;
    private final HandlerProduttore handlerProduttore;
    private final HandlerTrasformatore handlerTrasformatore;
    private final ProdottoRepository prodottoRepository;
    //per test
    private final VenditoreRepository venditoreRepository;

    @Autowired
    public ProdottoController(ProdottoRepository prodottoRepository,VenditoreRepository venditoreRepository,
                              HandlerDistributore handlerDistributore, HandlerProduttore handlerProduttore,
                              HandlerTrasformatore handlerTrasformatore) {
        this.prodottoRepository = prodottoRepository;
        this.venditoreRepository = venditoreRepository;
        this.handlerDistributore = handlerDistributore;
        this.handlerProduttore = handlerProduttore;
        this.handlerTrasformatore = handlerTrasformatore;
    }

    @PostMapping("/distributori")
    public ResponseEntity<Prodotto> creaProdottoDistributore(@RequestBody ProdottoDistributore prodotto) {

        if(prodotto.getVenditore() == null) {return ResponseEntity.badRequest().build();}

        Prodotto creato = handlerDistributore.creaProdotto(prodotto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    @PostMapping("/produttori")
    public ResponseEntity<Prodotto> creaProdottoProduttore(@RequestBody ProdottoProduttore prodotto) {

        if(prodotto.getVenditore() == null) {return ResponseEntity.badRequest().build();}

        Prodotto creato = handlerProduttore.creaProdotto(prodotto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    @PostMapping("/trasformatori")
    public ResponseEntity<Prodotto> creaProdottoTrasformatore(@RequestBody ProdottoTrasformatore prodotto) {

        if(prodotto.getVenditore() == null) {return ResponseEntity.badRequest().build();}

        Prodotto creato = handlerTrasformatore.creaProdotto(prodotto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    /**
     * ritorna tutti i prodotti
     * @return tutti i prodotti salvati
     */
    @GetMapping
    public ResponseEntity<List<Prodotto>> listaProdotti() {
        List<Prodotto> prodotti = prodottoRepository.findAll();
        return ResponseEntity.ok(prodotti);
    }

    //per test
    @GetMapping("/test")
    public ResponseEntity<List<Prodotto>> listaProdottiTest(){
        List<Venditore> venditori = venditoreRepository.findAll();
        ProdottoProduttore prodotto = new ProdottoProduttore("testp",11,"testp", (Produttore) venditori.get(0), "testP");
        creaProdottoProduttore(prodotto);
        List<Prodotto> prodotti = prodottoRepository.findAll();
        return ResponseEntity.ok(prodotti);
    }

}
