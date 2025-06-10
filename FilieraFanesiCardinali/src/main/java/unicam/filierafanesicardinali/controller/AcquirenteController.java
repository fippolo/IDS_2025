package unicam.filierafanesicardinali.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.utenti.Acquirente;
import unicam.filierafanesicardinali.repository.AcquirenteRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/acquirenti")
public class AcquirenteController {

    private final AcquirenteRepository acquirenteRepository;

    @Autowired
    public AcquirenteController(AcquirenteRepository acquirenteRepository) {
        this.acquirenteRepository = acquirenteRepository;
    }

    @PostMapping
    public ResponseEntity<Acquirente> createAcquirente(@RequestBody Acquirente acquirente) {
        Acquirente saved = this.acquirenteRepository.save(acquirente);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Acquirente>> getAllAcquirente() {
        List<Acquirente> acquirenti = this.acquirenteRepository.findAll();
        return ResponseEntity.ok(acquirenti);
    }

    @GetMapping
    @RequestMapping("/random")
    public ResponseEntity<Acquirente> generateRandomAcquirente() {
        Acquirente saved = this.acquirenteRepository.save(new Acquirente());
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


}
