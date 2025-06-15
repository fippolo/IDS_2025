package unicam.filierafanesicardinali.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.amministrazione.GestorePiattaforma;
import unicam.filierafanesicardinali.model.venditori.Produttore;
import unicam.filierafanesicardinali.model.venditori.Venditore;
import unicam.filierafanesicardinali.repository.GestoreRepository;
import unicam.filierafanesicardinali.repository.VenditoreRepository;
import unicam.filierafanesicardinali.service.HandlerGestore;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gestori")
public class GestoreController {
    private final HandlerGestore handlerGestore;
    private final GestoreRepository gestoreRepository;
    //test
    private final VenditoreRepository venditoreRepository;

    public GestoreController(HandlerGestore handlerGestore, GestoreRepository gestoreRepository, VenditoreRepository venditoreRepository) {
        this.handlerGestore = handlerGestore;
        this.gestoreRepository = gestoreRepository;
        this.venditoreRepository = venditoreRepository;
    }

    @GetMapping("gestore")
    public ResponseEntity<GestorePiattaforma> registraGestore(@RequestBody GestorePiattaforma gesttore) {
        try {
            GestorePiattaforma newGestore = gestoreRepository.save(gesttore);
            return ResponseEntity.status(HttpStatus.CREATED).body(newGestore);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Verifica un venditore
     * @param venditore da verificare
     * @return il venditore verificato
     */
    @PostMapping("/verifica")
    public ResponseEntity<Venditore> approvaVenditore(@PathVariable Venditore venditore) {
        if(venditore.getId() == null|| venditore.isStato()) {return ResponseEntity.badRequest().build();}

        Venditore prodottoVerificato = handlerGestore.approvaVenditore(venditore.getId());
        return ResponseEntity.ok(prodottoVerificato);
    }

    @GetMapping("/attivi")
    public ResponseEntity<List<Venditore>> listaVenditoriApprovati() {
        return ResponseEntity.ok(venditoreRepository.findByStatoTrue());
    }

    @GetMapping("/nonattivi")
    public ResponseEntity<List<Venditore>> listaVenditoriNonApprovati() {
        return ResponseEntity.ok(venditoreRepository.findByStatoFalse());
    }

    @GetMapping("/test")
    public ResponseEntity<Venditore> testGestore() {
        Produttore testProduttore = new Produttore("testP","testP","testP");
        venditoreRepository.save(testProduttore);
        return ResponseEntity.ok(testProduttore);
    }


}
