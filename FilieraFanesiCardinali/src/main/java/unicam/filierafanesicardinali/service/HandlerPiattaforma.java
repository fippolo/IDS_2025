package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.eventi.Evento;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.repository.EventoRepository;
import unicam.filierafanesicardinali.repository.ProdottoRepository;

import java.util.List;

@Service
public class HandlerPiattaforma {

    private final ProdottoRepository prodottoRepository;
    private final EventoRepository eventoRepository;

    @Autowired
    public HandlerPiattaforma(ProdottoRepository prodottoRepository, EventoRepository eventoRepository) {
        this.prodottoRepository = prodottoRepository;
        this.eventoRepository = eventoRepository;
    }


    public List<Prodotto> getAllProdotto() {
        return prodottoRepository.findAll();

    }

    public List<Evento> getAllEvento() {
        return eventoRepository.findAll();
    }

    public Prodotto getProdottoById(Long id) {
        if(prodottoRepository.existsById(id)) {
            return prodottoRepository.getOne(id);
        }
        throw new IllegalArgumentException("Prodotto non trovato");
    }

    public Evento getEventoById(Long id) {
        if(eventoRepository.existsById(id)) {
            return eventoRepository.getOne(id);
        }
        throw new IllegalArgumentException("Evento non trovato");
    }
}
