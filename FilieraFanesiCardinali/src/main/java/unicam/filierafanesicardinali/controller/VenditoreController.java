package unicam.filierafanesicardinali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.venditori.DistributoreTipicita;
import unicam.filierafanesicardinali.model.venditori.Produttore;
import unicam.filierafanesicardinali.model.venditori.Trasformatore;
import unicam.filierafanesicardinali.model.venditori.Venditore;
import unicam.filierafanesicardinali.repository.VenditoreRepository;


import java.util.ArrayList;
import java.util.List;



/**
 * Controller REST per la gestione dei venditori.
 * Fornisce API per registrazione, autenticazione e gestione dei diversi tipi di venditori.
 */
@RestController
@RequestMapping("/api/v1/venditori")
public class VenditoreController {

    private final VenditoreRepository venditoreRepository;

    @Autowired
    public VenditoreController(VenditoreRepository venditoreRepository) {
        this.venditoreRepository = venditoreRepository;
    }


    @PostMapping("/produttore")
    public ResponseEntity<Produttore> registraProduttore(@RequestBody Produttore produttore) {
        try {
            Produttore newProduttore = venditoreRepository.save(produttore);
            return ResponseEntity.status(HttpStatus.CREATED).body(newProduttore);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Registra un nuovo trasformatore.
     *
     *
     * @return ResponseEntity con il trasformatore creato
     */
    @PostMapping("/trasformatore")
    public ResponseEntity<Trasformatore> registraTrasformatore(@RequestBody Trasformatore trasformatore) {
        try {
            Trasformatore newTrasformatore = venditoreRepository.save(trasformatore);
            return ResponseEntity.status(HttpStatus.CREATED).body(newTrasformatore);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/distributore")
    public ResponseEntity<DistributoreTipicita> registraDistributore(@RequestBody DistributoreTipicita distributoreTipicita) {
        try {
            DistributoreTipicita newDistributore = venditoreRepository.save(distributoreTipicita);
            return ResponseEntity.status(HttpStatus.CREATED).body(newDistributore);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Venditore>> getAllVenditori() {
        List<Venditore> venditori = venditoreRepository.findAll();
        return ResponseEntity.ok(venditori);
    }

    /**
     * Recupera un venditore per ID.
     *
     * @param id ID del venditore
     * @return ResponseEntity con il venditore se trovato
     */
    @GetMapping("/{id}")
    public ResponseEntity<Venditore> getVenditoreById(@PathVariable Long id) {
        return venditoreRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/test")
    public ResponseEntity<List<Venditore>> test() {
        Produttore testProduttore = new Produttore("testP","testP","testP");
        Trasformatore testTrasformatore = new Trasformatore("testT", "testT", "testT");
        DistributoreTipicita testDistributore = new DistributoreTipicita("testD", "testD", "testD");
        List<Venditore> testList = new ArrayList<>();
        testList.add(venditoreRepository.save((Venditore) testTrasformatore));
        testList.add(venditoreRepository.save((Venditore) testProduttore));
        testList.add(venditoreRepository.save((Venditore) testDistributore));
        return ResponseEntity.ok(testList);
    }
}
