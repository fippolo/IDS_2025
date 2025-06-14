package unicam.filierafanesicardinali.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.acquisto.Carello;
import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;
import unicam.filierafanesicardinali.model.localizzazione.Mappa;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.repository.ProdottoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class HandlerAcquirente {

    private Carello carello;
    private final ProdottoRepository prodottoRepository;

    @Autowired
    public HandlerAcquirente(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
        this.carello = new Carello();
    }

    /**
     *
     * @param prodotto
     */
    public void aggiungiProdotto(Prodotto prodotto) {
        carello.aggiungiProdotto(prodotto);
    }

    /**
     *
     * @param prodotto
     */
    public void eliminaProdotto(Prodotto prodotto) {
        carello.rimuoviProdotto(prodotto);
    }

    public void svuotaCarrello() {
        carello.svuotaCarello();
    }

    public Carello getCarello() {
        return carello;
    }

    public void setCarello(Carello carello) {
        this.carello = carello;
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
