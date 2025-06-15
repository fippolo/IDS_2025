package unicam.filierafanesicardinali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;
import unicam.filierafanesicardinali.model.venditori.DistributoreTipicita;
import unicam.filierafanesicardinali.model.venditori.Produttore;
import unicam.filierafanesicardinali.model.venditori.Venditore;
import unicam.filierafanesicardinali.repository.ProdottoRepository;
import unicam.filierafanesicardinali.repository.VenditoreRepository;
import unicam.filierafanesicardinali.service.HandlerDistributore;
import unicam.filierafanesicardinali.service.HandlerProdotto;
import unicam.filierafanesicardinali.service.HandlerProduttore;
import unicam.filierafanesicardinali.service.HandlerTrasformatore;
import unicam.filierafanesicardinali.model.prodotti.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prodotti")
public class ProdottoController {

    private final HandlerDistributore handlerDistributore;
    private final HandlerProduttore handlerProduttore;
    private final HandlerTrasformatore handlerTrasformatore;
    private final ProdottoRepository prodottoRepository;
    private final HandlerProdotto handlerProdotto;
    //per test
    private final VenditoreRepository venditoreRepository;

    @Autowired
    public ProdottoController(ProdottoRepository prodottoRepository, VenditoreRepository venditoreRepository,
                              HandlerDistributore handlerDistributore, HandlerProduttore handlerProduttore,
                              HandlerTrasformatore handlerTrasformatore, HandlerProdotto handlerProdotto) {
        this.prodottoRepository = prodottoRepository;
        this.venditoreRepository = venditoreRepository;
        this.handlerDistributore = handlerDistributore;
        this.handlerProduttore = handlerProduttore;
        this.handlerTrasformatore = handlerTrasformatore;
        this.handlerProdotto = handlerProdotto;
    }


    // --- metodi distributore

    @PostMapping("/distributori/creaprodotto")
    public ResponseEntity<Prodotto> creaProdottoDistributore(@RequestBody ProdottoDistributore prodotto) {

        if(prodotto.getVenditore() == null
                || !venditoreRepository.existsById(prodotto.getVenditore().getId())
                || !prodotto.getVenditore().isStato())
                {return ResponseEntity.badRequest().build();}

        Prodotto creato = handlerDistributore.creaProdotto(prodotto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    /**
     * Crea un bundle
     * @param Id del distributore di tipicità
     * @param nome del prodotto
     * @param prezzo del prodotto
     * @param descrizione del prodotto
     * @param indirizzo del prodotto
     * @return il bundle creato
     */
    @PostMapping("/distributori/{Id}/creabundle")
    public ResponseEntity<DistributoreTipicita> creaBundle (@PathVariable Long Id, @RequestBody String nome,
                                                            @RequestBody Float prezzo,@RequestBody String descrizione,
                                                            @RequestBody Indirizzo indirizzo) {
        if(!venditoreRepository.existsById(Id)){return ResponseEntity.badRequest().build();}
        DistributoreTipicita distributoreTipicita = (DistributoreTipicita) venditoreRepository.findById(Id).get();
        distributoreTipicita = handlerDistributore.iniziaPacchetto(distributoreTipicita, nome, prezzo, descrizione, indirizzo);

        return ResponseEntity.status(HttpStatus.CREATED).body(distributoreTipicita);
    }

    /**
     * Aggiunge un prodotto al bundle
     * @param Id del distributore di tipicità
     * @param prodotto da aggiungere
     * @return il distributore di tipicità aggiornato
     */
    @PostMapping("/distributori/{Id}/aggiungiabundle")
    public ResponseEntity<DistributoreTipicita> aggiungiProdotto (@PathVariable Long Id, @RequestBody Prodotto prodotto) {
        if(!venditoreRepository.existsById(Id)){return ResponseEntity.badRequest().build();}
        DistributoreTipicita distributoreTipicita = (DistributoreTipicita) venditoreRepository.findById(Id).get();

        distributoreTipicita=handlerDistributore.aggiungiProdotto(distributoreTipicita, prodotto);

        return ResponseEntity.status(HttpStatus.CREATED).body(distributoreTipicita);
    }

    /**
     * Chiude e salva il bundle
     * @param Id del distributore di tipicità
     * @return il distributore di tipicità aggiornato
     */
    @PostMapping("/distributori/{Id}/salvabundle")
    public ResponseEntity<ProdottoDistributore> salvabundle (@PathVariable Long Id) {
        if(!venditoreRepository.existsById(Id)){return ResponseEntity.badRequest().build();}
        DistributoreTipicita distributoreTipicita = (DistributoreTipicita) venditoreRepository.findById(Id).get();
        ProdottoDistributore prodottoDistributore= handlerDistributore.salvaBundle(distributoreTipicita);


        return ResponseEntity.status(HttpStatus.CREATED).body(prodottoDistributore);

    }


    @PostMapping("/produttori/creaprodotto")
    public ResponseEntity<Prodotto> creaProdottoProduttore(@RequestBody ProdottoProduttore prodotto) {

        if(prodotto.getVenditore() == null
                || !venditoreRepository.existsById(prodotto.getVenditore().getId())
                || !prodotto.getVenditore().isStato())
                {return ResponseEntity.badRequest().build();}

        Prodotto creato = handlerProduttore.creaProdotto(prodotto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    @PostMapping("/trasformatori/creaprodotto")
    public ResponseEntity<Prodotto> creaProdottoTrasformatore(@RequestBody ProdottoTrasformatore prodotto) {

        if(prodotto.getVenditore() == null
                || !venditoreRepository.existsById(prodotto.getVenditore().getId())
                || !prodotto.getVenditore().isStato())
                {return ResponseEntity.badRequest().build();}

        Prodotto creato = handlerTrasformatore.creaProdotto(prodotto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    /**
     * Ritorna tutti i prodotti
     * @return tutti i prodotti salvati
     */
    @GetMapping
    public ResponseEntity<List<Prodotto>> listaProdotti() {
        List<Prodotto> prodotti = prodottoRepository.findAll();
        return ResponseEntity.ok(prodotti);
    }

    /**
     * Elimina un prodotto
     * @param id del prodotto
     * @return il prodotto eliminato
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Prodotto> eliminaProdotto(@PathVariable Long id) {
        if(!prodottoRepository.existsById(id)){return ResponseEntity.badRequest().build();}

        Prodotto prodottoDel = prodottoRepository.findById(id).get();
        handlerProdotto.rimuoviProdotto(prodottoDel);
        return ResponseEntity.status(HttpStatus.OK).body(prodottoDel);
    }

    /**
     * Restituisce tutti i prodotti di un venditore
     *
     * @param id venditore
     * @return lista prodotti di un vendiore
     */
    @GetMapping("/prodottivenditore/{id}")
    public ResponseEntity<List<Prodotto>> prodottiVenditore(@PathVariable Long id) {
        if(!venditoreRepository.existsById(id)){return ResponseEntity.badRequest().build();}
        List<Prodotto> listaProdotti = prodottoRepository.findByVenditoreId(id);
        return ResponseEntity.ok(listaProdotti);
    }


    //per test
    @GetMapping("/test")
    public ResponseEntity<List<Prodotto>> listaProdottiTest(){
        List<Venditore> venditori = venditoreRepository.findAll();
        Indirizzo indirizzo = new Indirizzo();
        ProdottoProduttore prodotto = new ProdottoProduttore("testp",11,"testp", (Produttore) venditori.get(0),indirizzo, "testP");
        creaProdottoProduttore(prodotto);
        List<Prodotto> prodotti = prodottoRepository.findAll();
        return ResponseEntity.ok(prodotti);
    }


    @GetMapping("/test/distributori")
    public ResponseEntity<Prodotto> listaProdottiTestDistributori(){
        DistributoreTipicita testDistributore = new DistributoreTipicita("testD", "testD", "testD");
        testDistributore.setStato(true);
        venditoreRepository.save(testDistributore);
        Indirizzo indirizzo = new Indirizzo();
        ProdottoDistributore pro = new ProdottoDistributore("test", 11, "testP", testDistributore,indirizzo, null);

        Prodotto prodotto = creaProdottoDistributore(pro).getBody();

        testDistributore = creaBundle(testDistributore.getId(), "test", 11F, "test", indirizzo).getBody();

        testDistributore = aggiungiProdotto(testDistributore.getId(),prodotto).getBody();

        ProdottoDistributore prodot = salvabundle(testDistributore.getId()).getBody();

        return ResponseEntity.ok(prodot);
    }

}
