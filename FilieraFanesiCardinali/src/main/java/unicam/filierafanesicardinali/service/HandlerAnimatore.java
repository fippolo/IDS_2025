package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.eventi.Animatore;
import unicam.filierafanesicardinali.model.eventi.Event;
import unicam.filierafanesicardinali.repository.EventoRepository;

@Service
public class HandlerAnimatore {

    private final EventoRepository eventoRepository;


    public HandlerAnimatore(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }


    public Event CreaEvento(Event event) {
        Animatore animatore = event.getAnimatore();

        Event eventAnimatore = animatore.creaEvento(event.getNome()
                                          , event.getData()
                                          , event.getOra()
                                          , event.getLuogo());

        return eventoRepository.save(eventAnimatore);
    }



}
