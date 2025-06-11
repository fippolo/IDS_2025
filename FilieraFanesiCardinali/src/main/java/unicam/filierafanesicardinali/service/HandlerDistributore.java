package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.prodotti.ProdottoDistributore;
import unicam.filierafanesicardinali.model.venditori.DistributoreTipicita;
import unicam.filierafanesicardinali.repository.ProdottoRepository;

@Service
public class HandlerDistributore extends HandlerVenditore{
    public HandlerDistributore(ProdottoRepository prodottoRepository) {
        super(prodottoRepository);
    }

    public ProdottoDistributore creaProdotto (DistributoreTipicita distributoreTipicita, String nome, float prezzo, String descrizione){
        ProdottoDistributore prodottoDistributore = (ProdottoDistributore) distributoreTipicita.creaProdotto(nome,prezzo, descrizione);
        return prodottoRepository.save(prodottoDistributore);
    }
}
