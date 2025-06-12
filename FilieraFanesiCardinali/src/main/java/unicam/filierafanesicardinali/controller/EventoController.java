package unicam.filierafanesicardinali.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.eventi.Evento;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.prodotti.ProdottoDistributore;
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
    public ResponseEntity<Evento> creaEvento(@RequestBody Evento evento) {
        if(evento.getAnimatore() == null || animatoreRepository.existsById(evento.getAnimatore().getId())  ) {return ResponseEntity.badRequest().build(); }

        Evento eventoCreato = handlerAnimatore.CreaEvento(evento);

        return ResponseEntity.status(HttpStatus.CREATED).body(eventoCreato);
    }

    @GetMapping
    public ResponseEntity<List<Evento>> listaEventi() {
        List<Evento> eventi = eventoRepository.findAll();
        return ResponseEntity.ok(eventi);
    }

}
