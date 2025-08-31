package unicam.filierafanesicardinali.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.acquisto.Cart;
import unicam.filierafanesicardinali.model.acquisto.SistemaPagamento;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.utenti.Acquirente;
import unicam.filierafanesicardinali.repository.CarrelloRepository;
import unicam.filierafanesicardinali.repository.SistemaPagamentoRepository;

@Service
public class HandlerSistemaPagamento {

    private final SistemaPagamentoRepository sistemaPagamentoRepository;
    private final HandlerCarrello handlerCarrello;
    private final CarrelloRepository carrelloRepository;

    public HandlerSistemaPagamento(SistemaPagamentoRepository sistemaPagamentoRepository, HandlerCarrello handlerCarrello, CarrelloRepository carrelloRepository) {
        this.sistemaPagamentoRepository = sistemaPagamentoRepository;
        this.handlerCarrello = handlerCarrello;
        this.carrelloRepository = carrelloRepository;
    }


    public Cart acquistoProdotto(Product product, Acquirente acquirente) {
        if(acquirente == null || product == null) {throw new IllegalArgumentException("Prodotto nullo o acquirente nullo");}

        Cart cart = carrelloRepository.findById(acquirente.getCarrello().getId())
                .orElseThrow(() -> new EntityNotFoundException("Carrello not found"));
        SistemaPagamento pagamento = new SistemaPagamento(acquirente, product);
        sistemaPagamentoRepository.save(pagamento);
        cart.rimuoviProdotto(product);
        return carrelloRepository.save(cart);

    }
}
