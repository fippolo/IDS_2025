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

    private Carrello carrello;
    private final ProdottoRepository prodottoRepository;

    @Autowired
    public HandlerAcquirente(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
        this.carrello = new Carrello();
    }

    /**
     *
     * @param prodotto
     */
    public void aggiungiProdotto(Prodotto prodotto) {
        carrello.aggiungiProdotto(prodotto);
    }

    /**
     *
     * @param prodotto
     */
    public void eliminaProdotto(Prodotto prodotto) {
        carrello.rimuoviProdotto(prodotto);
    }

    public void svuotaCarrello() {
        carrello.svuotaCarello();
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
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
