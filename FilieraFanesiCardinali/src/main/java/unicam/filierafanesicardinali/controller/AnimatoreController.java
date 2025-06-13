package unicam.filierafanesicardinali.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.eventi.Animatore;
import unicam.filierafanesicardinali.repository.AnimatoreRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/animatori")
public class AnimatoreController {
    private final AnimatoreRepository animatoreRepository;

    public AnimatoreController(AnimatoreRepository animereRepository, AnimatoreRepository animatoreRepository) {
        this.animatoreRepository = animereRepository;

    }

    @PostMapping("/produttore")
    public ResponseEntity<Animatore> registraAnimatore(@RequestBody Animatore animatore) {
        try {
            Animatore newAnimatore = animatoreRepository.save(animatore);
            return ResponseEntity.status(HttpStatus.CREATED).body(newAnimatore);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Animatore>> getAllAnimatori() {
        List<Animatore> animatori = animatoreRepository.findAll();
        return ResponseEntity.ok(animatori);
    }

    /**
     * Recupera un venditore per ID.
     *
     * @param id ID del venditore
     * @return ResponseEntity con il venditore se trovato
     */
    @GetMapping("/{id}")
    public ResponseEntity<Animatore> getAnimatoreById(@PathVariable Long id) {
        return animatoreRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



}
