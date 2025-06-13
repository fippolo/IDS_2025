package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.eventi.Animatore;
import unicam.filierafanesicardinali.model.eventi.Evento;
import unicam.filierafanesicardinali.repository.EventoRepository;

@Service
public class HandlerAnimatore {

    private final EventoRepository eventoRepository;


    public HandlerAnimatore(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }


    public Evento CreaEvento(Evento evento) {
        Animatore animatore = evento.getAnimatore();

        Evento eventoAnimatore = animatore.creaEvento(evento.getNome()
                                          ,evento.getData()
                                          ,evento.getOra()
                                          ,evento.getLuogo());

        return eventoRepository.save(eventoAnimatore);
    }
}
