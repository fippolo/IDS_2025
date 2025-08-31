package unicam.filierafanesicardinali.service;


import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.amministrazione.Curatore;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.repository.ProdottoRepository;

@Service
public class HandlerCuratore {
    private final ProdottoRepository prodottoRepository;


    public HandlerCuratore(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }

    public Product verificaProdotto(Product product, Curatore curatore) {
        return prodottoRepository.save(curatore.approvaProdotto(product));
    }

}
