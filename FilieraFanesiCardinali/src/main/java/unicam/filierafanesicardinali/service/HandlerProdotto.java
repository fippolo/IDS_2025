package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.repository.ProdottoRepository;

import java.util.List;

@Service
public class HandlerProdotto {
    private final ProdottoRepository prodottoRepository;

    public HandlerProdotto(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }


    public void rimuoviListaProdotti(List<Prodotto> prodottiDaRimuovere) {
        if(prodottiDaRimuovere.isEmpty())throw new IllegalArgumentException("Lista Vuota");
        for(Prodotto prodotto : prodottiDaRimuovere){
            prodottoRepository.delete(prodotto);
        }
    }

    public void rimuoviProdotto(Prodotto prodotto) {
        if(!prodottoRepository.existsById(prodotto.getId())) throw new IllegalArgumentException("Prodotto non trovato");
        prodottoRepository.delete(prodotto);
    }
}
