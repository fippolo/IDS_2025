package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;

import unicam.filierafanesicardinali.repository.ProdottoRepository;

@Service
public class HandlerVenditore {

    protected final ProdottoRepository prodottoRepository;

    @Autowired
    public HandlerVenditore(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }

    public Prodotto creaProdotto(Prodotto prodotto){
        return prodottoRepository.save(prodotto);
    }


}
