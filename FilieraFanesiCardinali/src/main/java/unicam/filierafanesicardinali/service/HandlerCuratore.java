package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.repository.ProdottoRepository;

@Service
public class HandlerCuratore {
    private final ProdottoRepository prodottoRepository;


    public HandlerCuratore(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }

    public Prodotto verificaProdotto(Long prodottoId) {
        Prodotto prodotto = prodottoRepository.findById(prodottoId)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato con id: " + prodottoId));
        prodotto.setStato(true);
        return prodottoRepository.save(prodotto);
    }

}
