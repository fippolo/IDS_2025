package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;

import unicam.filierafanesicardinali.model.venditori.Venditore;
import unicam.filierafanesicardinali.repository.ProdottoRepository;
import unicam.filierafanesicardinali.repository.VenditoreRepository;

import java.util.List;

@Service
public class HandlerVenditore {

    protected final ProdottoRepository prodottoRepository;
    protected final VenditoreRepository venditoreRepository;
    protected final HandlerProdotto handlerProdotto;

    @Autowired
    public HandlerVenditore(ProdottoRepository prodottoRepository, VenditoreRepository venditoreRepository, HandlerProdotto handlerProdotto) {
        this.prodottoRepository = prodottoRepository;
        this.venditoreRepository = venditoreRepository;
        this.handlerProdotto = handlerProdotto;

    }

    public Prodotto creaProdotto(Prodotto prodotto){
        return prodottoRepository.save(prodotto);
    }

    public void rimuoviVenditore(Venditore venditore){
        if(!venditoreRepository.existsById(venditore.getId())){
            throw new RuntimeException("Venditore non trovato");
        }
        List<Prodotto> prodottiDaRimuovere = prodottoRepository.findByVenditoreId(venditore.getId());
        handlerProdotto.rimuoviListaProdotti(prodottiDaRimuovere);
        venditoreRepository.delete(venditore);

    }

}
