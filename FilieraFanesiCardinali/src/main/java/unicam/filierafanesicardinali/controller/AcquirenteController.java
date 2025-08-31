package unicam.filierafanesicardinali.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.utenti.Buyer;
import unicam.filierafanesicardinali.repository.AcquirenteRepository;
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
     * @param buyer oggetto da salvare
     * @return stauts code created e body dell'oggetto salvato
     */
    @PostMapping
    public ResponseEntity<Buyer> createAcquirente(@RequestBody Buyer buyer){
        Buyer newBuyer = acquirenteRepository.save(buyer);

        carrelloRepository.save(buyer.getCarrello());
        return ResponseEntity.status(HttpStatus.CREATED).body(newBuyer);
    }

    /**
     * Ritorna un acquirente con l'id specificato
     * @param id id da recuperare
     * @return Acquirente
     */
    @GetMapping("/{id}")
    public ResponseEntity<Buyer> getAcquirenteById(@PathVariable Long id) {
        Optional<Buyer> acquirente = acquirenteRepository.findById(id);
        return acquirente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Funzione per esaminare la lista di acquirenti
     * @return Lista di acquirenti e 200
     */
    @GetMapping
    public ResponseEntity<List<Buyer>> getAllAcquirente(){
        List<Buyer> buyer = acquirenteRepository.findAll();
        return ResponseEntity.ok(buyer);
    }

    /**
     * Metodo per cancellare un acquirente con un determinato id
     * @param id id dell'utente da cancellare
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Buyer> deleteAcquirente(@PathVariable Long id){
        Optional<Buyer> acquirente = acquirenteRepository.findById(id);
        if(acquirente.isPresent()){
            acquirenteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/consultaprodotti")
    public ResponseEntity<List<Product>> consultaProdotti(){
        List<Product> listaProdotti = handlerAcquirente.consultaProdotti();
        return ResponseEntity.ok(listaProdotti);
    }


    @GetMapping("/consultamappa")
    public ResponseEntity<List<Position>> consultaMappa(){
        List<Position> listaIndirizzi = handlerAcquirente.consultaMappa();
        return ResponseEntity.ok(listaIndirizzi);
    }


}
