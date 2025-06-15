package unicam.filierafanesicardinali.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;
import unicam.filierafanesicardinali.model.utenti.Acquirente;
import unicam.filierafanesicardinali.repository.AcquirenteRepository;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.repository.CarrelloRepository;
import unicam.filierafanesicardinali.service.HandlerAcquirente;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/acquirenti")
public class AcquirenteController {

    private final AcquirenteRepository acquirenteRepository;
    private final HandlerAcquirente handlerAcquirente;
    private final CarrelloRepository carrelloRepository;

    @Autowired
    public AcquirenteController(AcquirenteRepository acquirenteRepository, HttpSession httpSession, HandlerAcquirente handlerAcquirente, CarrelloRepository carrelloRepository) {
        this.acquirenteRepository = acquirenteRepository;
        this.handlerAcquirente = handlerAcquirente;
        this.carrelloRepository = carrelloRepository;
    }

    /**
     * Crea un acquirente
     * @param acquirente oggetto da salvare
     * @return stauts code created e body dell'oggetto salvato
     */
    @PostMapping
    public ResponseEntity<Acquirente> createAcquirente(@RequestBody Acquirente acquirente){
        Acquirente newAcquirente = acquirenteRepository.save(acquirente);

        carrelloRepository.save(acquirente.getCarrello());
        return ResponseEntity.status(HttpStatus.CREATED).body(newAcquirente);
    }

    /**
     * Ritorna un acquirente con l'id specificato
     * @param id id da recuperare
     * @return Acquirente
     */
    @GetMapping("/{id}")
    public ResponseEntity<Acquirente> getAcquirenteById(@PathVariable Long id) {
        Optional<Acquirente> acquirente = acquirenteRepository.findById(id);
        return acquirente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Funzione per esaminare la lista di acquirenti
     * @return Lista di acquirenti e 200
     */
    @GetMapping
    public ResponseEntity<List<Acquirente>> getAllAcquirente(){
        List<Acquirente> acquirente = acquirenteRepository.findAll();
        return ResponseEntity.ok(acquirente);
    }

    /**
     * Metodo per cancellare un acquirente con un determinato id
     * @param id id dell'utente da cancellare
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Acquirente> deleteAcquirente(@PathVariable Long id){
        Optional<Acquirente> acquirente = acquirenteRepository.findById(id);
        if(acquirente.isPresent()){
            acquirenteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/consultaprodotti")
    public ResponseEntity<List<Prodotto>> consultaProdotti(){
        List<Prodotto> listaProdotti = handlerAcquirente.consultaProdotti();
        return ResponseEntity.ok(listaProdotti);
    }


    @GetMapping("/consultamappa")
    public ResponseEntity<List<Indirizzo>> consultaMappa(){
        List<Indirizzo> listaIndirizzi = handlerAcquirente.consultaMappa();
        return ResponseEntity.ok(listaIndirizzi);
    }


}
