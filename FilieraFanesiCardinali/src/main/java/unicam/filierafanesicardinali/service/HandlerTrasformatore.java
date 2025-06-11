package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.prodotti.ProdottoTrasformatore;
import unicam.filierafanesicardinali.model.venditori.Trasformatore;
import unicam.filierafanesicardinali.repository.ProdottoRepository;

@Service
public class HandlerTrasformatore extends HandlerVenditore{
    public HandlerTrasformatore(ProdottoRepository prodottoRepository) {
        super(prodottoRepository);
    }

    public ProdottoTrasformatore creaProdotto(ProdottoTrasformatore prodotto){
        return prodottoRepository.save(prodotto);
    }

}
