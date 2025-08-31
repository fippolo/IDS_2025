package unicam.filierafanesicardinali.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.utenti.User;
import unicam.filierafanesicardinali.repository.UtenteGenericoRepository;
import unicam.filierafanesicardinali.service.HandlerUtenteGenerico;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/utentigenerici")
public class UtenteGenericoController {

    private final HandlerUtenteGenerico handlerUtenteGenerico;
    private final UtenteGenericoRepository utenteGenericoRepository;


    @Autowired
    public UtenteGenericoController(HandlerUtenteGenerico handlerUtenteGenerico, UtenteGenericoRepository utenteGenericoRepository ){
        this.handlerUtenteGenerico = handlerUtenteGenerico;
        this.utenteGenericoRepository = utenteGenericoRepository;
    }


    @PostMapping("/crautente")
    public ResponseEntity<User> creaUtenteGenerico(@RequestBody User utente){
        User newUtente = utenteGenericoRepository.save(utente);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUtente);
    }

    /**
     * Ritorna un utente generico con l'id specificato
     * @param id id da recuperare
     * @return Utente
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUtenteById(@PathVariable Long id) {
        Optional<User> utente = utenteGenericoRepository.findById(id);
        return utente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Funzione per esaminare la lista di Utenti Generici
     * @return Lista di utenti generici e 200
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUtentiGenerici(){
        List<User> utente = utenteGenericoRepository.findAll();
        return ResponseEntity.ok(utente);
    }

    /**
     * Metodo per cancellare un utente generico con un determinato id
     * @param id id dell'utente da cancellare
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUtenteGenerico(@PathVariable Long id){
        Optional<User> utente = utenteGenericoRepository.findById(id);
        if(utente.isPresent()){
            utenteGenericoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/consultaprodotti")
    public ResponseEntity<List<Product>> consultaProdotti(){
        List<Product> listaProdotti = handlerUtenteGenerico.consultaProdotti();
        return ResponseEntity.ok(listaProdotti);
    }

    @GetMapping("/consultamappa")
    public ResponseEntity<List<Position>> consultaMappa(){
        List<Position> listaindirizzo = handlerUtenteGenerico.consultaMappa();
        return ResponseEntity.ok(listaindirizzo);
    }
}
