package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.acquisto.Carrello;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.repository.CarrelloRepository;

@Service
public class HandlerCarrello {

    private final CarrelloRepository carrelloRepository;

    @Autowired
    public HandlerCarrello(CarrelloRepository carrelloRepository) {
        this.carrelloRepository = carrelloRepository;
    }

    /**
     *Aggiunge un prodotto al carrello
     * @param prodotto
     * @param carrello
     * @return il carrello aggiornato
     */
    public Carrello aggiungiProdotto(Prodotto prodotto, Carrello carrello) {
        carrello.aggiungiProdotto(prodotto);
        return carrelloRepository.save(carrello);
    }

    /**
     *Elimina un prodotto dal carrello
     * @param prodotto
     * @param carrello
     * @return il carrello aggiornato
     */
    public Carrello eliminaProdotto(Prodotto prodotto, Carrello carrello) {
        carrello.rimuoviProdotto(prodotto);
        return carrelloRepository.save(carrello);
    }

    /**
     * Svuota il carrello
     * @param carrello
     * @return il carrello aggiornato
     */
    public Carrello svuotaCarrello(Carrello carrello) {
        carrello.svuotaCarello();
        return carrelloRepository.save(carrello);
    }




}
