package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.prodotti.ProdottoDistributore;
import unicam.filierafanesicardinali.model.prodotti.ProdottoTrasformatore;
import unicam.filierafanesicardinali.model.venditori.DistributoreTipicita;
import unicam.filierafanesicardinali.model.venditori.Trasformatore;
import unicam.filierafanesicardinali.repository.ProdottoRepository;

@Service
public class HandlerDistributore extends HandlerVenditore{
    public HandlerDistributore(ProdottoRepository prodottoRepository) {
        super(prodottoRepository);
    }

    public ProdottoDistributore creaProdotto (ProdottoDistributore prodotto){
        if(prodotto.getVenditore() == null) throw new IllegalArgumentException("Venditore non trovato");

        DistributoreTipicita distributoreProdotto = (DistributoreTipicita) prodotto.getVenditore();

        ProdottoDistributore toReturn = distributoreProdotto.creaPacchetto(prodotto.getNome()
                                                            ,prodotto.getPrezzo()
                                                            ,prodotto.getDescrizione()
                                                            ,prodotto.getListaProdotti());
        return prodottoRepository.save(toReturn);
    }
}
