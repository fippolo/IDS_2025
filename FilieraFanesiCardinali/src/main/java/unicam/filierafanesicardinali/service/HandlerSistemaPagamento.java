package unicam.filierafanesicardinali.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.acquisto.Cart;
import unicam.filierafanesicardinali.model.acquisto.SistemaPagamento;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.utenti.Buyer;
import unicam.filierafanesicardinali.repository.CarrelloRepository;
import unicam.filierafanesicardinali.repository.SistemaPagamentoRepository;

@Service
public class HandlerSistemaPagamento {

    private final SistemaPagamentoRepository sistemaPagamentoRepository;
    private final CartService cartService;
    private final CarrelloRepository carrelloRepository;

    public HandlerSistemaPagamento(SistemaPagamentoRepository sistemaPagamentoRepository, CartService cartService, CarrelloRepository carrelloRepository) {
        this.sistemaPagamentoRepository = sistemaPagamentoRepository;
        this.cartService = cartService;
        this.carrelloRepository = carrelloRepository;
    }


    public Cart acquistoProdotto(Product product, Buyer buyer) {
        if(buyer == null || product == null) {throw new IllegalArgumentException("Prodotto nullo o acquirente nullo");}

        Cart cart = carrelloRepository.findById(buyer.getCarrello().getId())
                .orElseThrow(() -> new EntityNotFoundException("Carrello not found"));
        SistemaPagamento pagamento = new SistemaPagamento(buyer, product);
        sistemaPagamentoRepository.save(pagamento);
        cart.rimuoviProdotto(product);
        return carrelloRepository.save(cart);

    }
}
