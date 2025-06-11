package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.ProdottoProduttore;
import unicam.filierafanesicardinali.model.venditori.Produttore;
import unicam.filierafanesicardinali.repository.ProdottoRepository;

@Service
public class HandlerProduttore extends HandlerVenditore{

    public HandlerProduttore(ProdottoRepository prodottoRepository) {
        super(prodottoRepository);
    }

    public ProdottoProduttore creaProdotto(Produttore produttore,String nome, float prezzo, String descrizione, String metodoDiColtivazione){
        ProdottoProduttore prodottoProduttore = produttore.creaProdotto(nome, prezzo, metodoDiColtivazione, descrizione);
        return prodottoRepository.save(prodottoProduttore);



    }

}
