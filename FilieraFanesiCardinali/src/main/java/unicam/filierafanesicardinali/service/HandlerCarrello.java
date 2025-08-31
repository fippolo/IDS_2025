package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.acquisto.Cart;
import unicam.filierafanesicardinali.model.prodotti.Product;
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
     * @param product
     * @param cart
     * @return il carrello aggiornato
     */
    public Cart aggiungiProdotto(Product product, Cart cart) {
        cart.aggiungiProdotto(product);
        return carrelloRepository.save(cart);
    }

    /**
     *Elimina un prodotto dal carrello
     * @param product
     * @param cart
     * @return il carrello aggiornato
     */
    public Cart eliminaProdotto(Product product, Cart cart) {
        cart.rimuoviProdotto(product);
        return carrelloRepository.save(cart);
    }

    /**
     * Svuota il carrello
     * @param cart
     * @return il carrello aggiornato
     */
    public Cart svuotaCarrello(Cart cart) {
        cart.svuotaCarello();
        return carrelloRepository.save(cart);
    }




}
