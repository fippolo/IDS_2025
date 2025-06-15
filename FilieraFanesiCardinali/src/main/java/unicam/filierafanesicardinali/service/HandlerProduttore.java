package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.ProdottoProduttore;
import unicam.filierafanesicardinali.model.venditori.Produttore;
import unicam.filierafanesicardinali.repository.ProdottoRepository;
import unicam.filierafanesicardinali.repository.VenditoreRepository;

@Service
public class HandlerProduttore extends HandlerVenditore{



    public HandlerProduttore(ProdottoRepository prodottoRepository, VenditoreRepository venditoreRepository, HandlerProdotto handlerProdotto) {
        super(prodottoRepository,venditoreRepository, handlerProdotto);

    }

    public ProdottoProduttore creaProdotto(ProdottoProduttore prodotto){
        if(prodotto.getVenditore() == null) throw new IllegalArgumentException("Venditore non trovato");

        Produttore produttoreProdotto = (Produttore) prodotto.getVenditore();

        ProdottoProduttore toReturn = produttoreProdotto.creaProdotto(prodotto.getNome()
                                                        ,prodotto.getPrezzo()
                                                        ,prodotto.getDescrizione()
                                                        ,prodotto.getMetodoDiColtivazione()
                                                        ,prodotto.getIndirizzo());
        return prodottoRepository.save(toReturn);

    }

}
