package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.venditori.Venditore;
import unicam.filierafanesicardinali.repository.VenditoreRepository;

@Service
public class HandlerGestore {
    private final VenditoreRepository venditoreRepository;

    public HandlerGestore(VenditoreRepository venditoreRepository) {
        this.venditoreRepository = venditoreRepository;
    }

    public Venditore approvaVenditore(Long idVenditore){
        Venditore venditore = venditoreRepository.findById(idVenditore)
                .orElseThrow(() -> new RuntimeException("Venditore non trovato con id: " + idVenditore));
        venditore.setStato(true);
        return venditoreRepository.save(venditore);
    }



}
