package unicam.filierafanesicardinali.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.acquisto.Cart;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.utenti.Buyer;
import unicam.filierafanesicardinali.service.CartService;
import unicam.filierafanesicardinali.service.HandlerSistemaPagamento;

@RestController
@RequestMapping("/api/v1/carrelli")
public class CartController {
    private final CartService cartService;
    private final HandlerSistemaPagamento handlerSistemaPagamento;

    @Autowired
    public CartController() {
        this.acquirenteRepository = acquirenteRepository;
        this.carrelloRepository = carrelloRepository;

        this.prodottoRepository = prodottoRepository;
        this.cartService = cartService;
        this.handlerSistemaPagamento = handlerSistemaPagamento;
    }


    @PostMapping("/carrello")
    public ResponseEntity<Cart> registraCarrello(@RequestBody Cart cart) {
        try {
            Cart newCart = carrelloRepository.save(cart);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCart);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Aggiunge un prodotto al carrello dell'acquirente.
     * @param id ID dell'acquirente
     * @param product prodotto da eliminare
     */
    @PostMapping("/{id}/aggiungiprodotto")
    public ResponseEntity<Cart> aggiungiProdotto(@RequestBody Long id, Product product) {
        if(product == null || !acquirenteRepository.existsById(id)) {return ResponseEntity.badRequest().build();}

        Cart cart = acquirenteRepository.findById(id).get().getCarrello();
        Product prodottoadd = prodottoRepository.findById(product.getId()).get();
        cart = cartService.addToCart(prodottoadd, cart);

        return ResponseEntity.ok(cart);
    }

    /**
     * Elimina un prodotto al carrello dell'acquirente.
     * @param id ID dell'acquirente
     * @param product prodotto da eliminare
     */
    @DeleteMapping("/{id}/eliminaprodotto")
    public ResponseEntity<Cart> eliminaProdotto(@PathVariable Long id, Product product) {
        if(product == null || !acquirenteRepository.existsById(id)) {return ResponseEntity.badRequest().build();}

        Cart cart = acquirenteRepository.findById(id).get().getCarrello();
        Product prodottodel = prodottoRepository.findById(product.getId()).get();
        cart = cartService.eliminaProdotto(prodottodel, cart);

        return ResponseEntity.ok(cart);
    }

    /**
     * Svuota il carrello dell'acquirente.
     * @param id ID dell'acquirente
     */
    @DeleteMapping("/{id}/svuotacarrello")
    public ResponseEntity<Cart> svuotaCarrello(@PathVariable Long id) {
        if(!acquirenteRepository.existsById(id)) {return ResponseEntity.badRequest().build();}

        Cart cart = acquirenteRepository.findById(id).get().getCarrello();
        cart = cartService.svuotaCarrello(cart);

        return ResponseEntity.ok(cart);
    }

    /**
     * Acquista un prodotto dal carrello
     * @param id dell'animatore
     * @param product da comprare presente nel carrello
     * @return Carrello aggiurnato
     */
    @PostMapping("/{id}/acquistoprodotto")
    public ResponseEntity<Cart> acquistoProdotto(@PathVariable Long id, Product product) {
        if(product == null || !acquirenteRepository.existsById(id)) {return ResponseEntity.badRequest().build();}

        Buyer buyer = acquirenteRepository.findById(id).get();
        Product prodottoacq = prodottoRepository.findById(product.getId()).get();
        Cart cart = handlerSistemaPagamento.acquistoProdotto(prodottoacq, buyer);
        return ResponseEntity.ok(cart);
    }



}
