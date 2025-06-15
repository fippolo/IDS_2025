package unicam.filierafanesicardinali.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.utenti.Acquirente;
import unicam.filierafanesicardinali.model.utenti.UtenteGenerico;
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
    public ResponseEntity<UtenteGenerico> creaUtenteGenerico(@RequestBody UtenteGenerico utente){
        UtenteGenerico newUtente = utenteGenericoRepository.save(utente);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUtente);
    }

    /**
     * Ritorna un utente generico con l'id specificato
     * @param id id da recuperare
     * @return Utente
     */
    @GetMapping("/{id}")
    public ResponseEntity<UtenteGenerico> getUtenteById(@PathVariable Long id) {
        Optional<UtenteGenerico> utente = utenteGenericoRepository.findById(id);
        return utente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Funzione per esaminare la lista di Utenti Generici
     * @return Lista di utenti generici e 200
     */
    @GetMapping
    public ResponseEntity<List<UtenteGenerico>> getAllUtentiGenerici(){
        List<UtenteGenerico> utente = utenteGenericoRepository.findAll();
        return ResponseEntity.ok(utente);
    }

    /**
     * Metodo per cancellare un utente generico con un determinato id
     * @param id id dell'utente da cancellare
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<UtenteGenerico> deleteUtenteGenerico(@PathVariable Long id){
        Optional<UtenteGenerico> utente = utenteGenericoRepository.findById(id);
        if(utente.isPresent()){
            utenteGenericoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/consultaprodotti")
    public ResponseEntity<List<Prodotto>> consultaProdotti(){
        List<Prodotto> listaProdotti = handlerUtenteGenerico.consultaProdotti();
        return ResponseEntity.ok(listaProdotti);
    }

    @GetMapping("/consultamappa")
    public ResponseEntity<List<Indirizzo>> consultaMappa(){
        List<Indirizzo> listaindirizzo = handlerUtenteGenerico.consultaMappa();
        return ResponseEntity.ok(listaindirizzo);
    }
}
