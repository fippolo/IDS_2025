package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.acquisto.Cart;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.repository.BuyerRepository;
import unicam.filierafanesicardinali.repository.CarrelloRepository;

@Service
public class CartService {

    private final BuyerRepository buyerRepository;

    @Autowired
    public CartService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    /**
     *Aggiunge un prodotto al carrello
     * @param product
     * @param cart
     * @return il carrello aggiornato
     */
    public Cart addToCart(Long buyerId, Long ProductId, int qty) {

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
