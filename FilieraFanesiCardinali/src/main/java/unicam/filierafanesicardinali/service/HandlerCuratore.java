package unicam.filierafanesicardinali.service;


import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.amministrazione.Curatore;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.repository.ProdottoRepository;

@Service
public class HandlerCuratore {
    private final ProdottoRepository prodottoRepository;


    public HandlerCuratore(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }

    public Prodotto verificaProdotto(Prodotto prodotto, Curatore curatore) {
        return prodottoRepository.save(curatore.approvaProdotto(prodotto));
    }

}
