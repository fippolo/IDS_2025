package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.repository.ProdottoRepository;

import java.util.List;

@Service
public class HandlerProdotto {
    private final ProdottoRepository prodottoRepository;

    public HandlerProdotto(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }


    public void rimuoviListaProdotti(List<Product> prodottiDaRimuovere) {
        if(prodottiDaRimuovere.isEmpty())throw new IllegalArgumentException("Lista Vuota");
        for(Product product : prodottiDaRimuovere){
            prodottoRepository.delete(product);
        }
    }

    public void rimuoviProdotto(Product product) {
        if(!prodottoRepository.existsById(product.getId())) throw new IllegalArgumentException("Prodotto non trovato");
        prodottoRepository.delete(product);
    }
}
