package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.venditori.Venditore;
import unicam.filierafanesicardinali.repository.ProdottoRepository;

@Service
public class HandlerVenditore {

    protected final ProdottoRepository prodottoRepository;


    public HandlerVenditore(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }

    public Prodotto creaProdotto(Venditore venditore, String nome, float prezzo, String descrizione){
        Prodotto prodotto = venditore.creaProdotto(nome, prezzo, descrizione);
        return prodottoRepository.save(prodotto);
    }


}
