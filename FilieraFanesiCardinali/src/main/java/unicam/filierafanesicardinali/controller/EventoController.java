package unicam.filierafanesicardinali.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.eventi.Animatore;
import unicam.filierafanesicardinali.model.eventi.Event;
import unicam.filierafanesicardinali.repository.AnimatoreRepository;
import unicam.filierafanesicardinali.repository.EventoRepository;
import unicam.filierafanesicardinali.service.HandlerAnimatore;

import java.util.List;

@RestController
@RequestMapping("/api/v1/eventi")
public class EventoController {
    private final HandlerAnimatore handlerAnimatore;
    private final EventoRepository eventoRepository;
    private final AnimatoreRepository animatoreRepository;

    public EventoController(HandlerAnimatore handlerAnimatore, EventoRepository eventoRepository, AnimatoreRepository animatoreRepository) {
        this.handlerAnimatore = handlerAnimatore;
        this.eventoRepository = eventoRepository;
        this.animatoreRepository = animatoreRepository;
    }


    @PostMapping
    public ResponseEntity<Event> creaEvento(@RequestBody Event event) {
        if(event.getAnimatore() == null || animatoreRepository.existsById(event.getAnimatore().getId())  ) {return ResponseEntity.badRequest().build(); }

        Event eventCreato = handlerAnimatore.CreaEvento(event);

        return ResponseEntity.status(HttpStatus.CREATED).body(eventCreato);
    }

    @GetMapping
    public ResponseEntity<List<Event>> listaEventi() {
        List<Event> eventi = eventoRepository.findAll();
        return ResponseEntity.ok(eventi);
    }

    /**
     * Elimina un evento
     * @param id dell'evento
     * @return l'evento eliminato
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Event> deleteEvento(@PathVariable Long id){
        if(eventoRepository.existsById(id)){
            eventoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
