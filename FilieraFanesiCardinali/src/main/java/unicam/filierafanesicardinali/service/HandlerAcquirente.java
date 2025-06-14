package unicam.filierafanesicardinali.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.acquisto.Carrello;
import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;
import unicam.filierafanesicardinali.model.localizzazione.Mappa;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.repository.ProdottoRepository;

import java.util.List;

@Service
public class HandlerAcquirente {


    private final ProdottoRepository prodottoRepository;

    @Autowired
    public HandlerAcquirente(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;

    }

    public List<Prodotto> consultaProdotti() {
        List<Prodotto> listaProdotti = prodottoRepository.findByStatoTrue();
        return listaProdotti;
    }

    public List<Indirizzo> consultaMappa() {
        Mappa mappa = new Mappa();
        List<Indirizzo> listaIndirizzi = mappa.getListaIndirizzi();
        return listaIndirizzi;
    }


}
