package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.ProdottoTrasformatore;
import unicam.filierafanesicardinali.model.venditori.Trasformatore;
import unicam.filierafanesicardinali.repository.ProdottoRepository;
import unicam.filierafanesicardinali.repository.VenditoreRepository;

@Service
public class HandlerTrasformatore extends HandlerVenditore{


    public HandlerTrasformatore(ProdottoRepository prodottoRepository, VenditoreRepository venditoreRepository, HandlerProdotto handlerProdotto) {
        super(prodottoRepository, venditoreRepository, handlerProdotto);

    }

    public ProdottoTrasformatore creaProdotto(ProdottoTrasformatore prodotto){
        if(prodotto.getVenditore() == null) throw new IllegalArgumentException("Venditore non trovato");

        Trasformatore trasformatoreProdotto = (Trasformatore) prodotto.getVenditore();

        ProdottoTrasformatore toReturn = trasformatoreProdotto.creaProdotto(prodotto.getNome()
                                                              ,prodotto.getPrezzo()
                                                              ,prodotto.getProcessoDiTrasformazione()
                                                              ,prodotto.getIndirizzo()
                                                              ,prodotto.getDescrizione());
        return prodottoRepository.save(toReturn);
    }

}
