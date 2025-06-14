package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.acquisto.Carrello;
import unicam.filierafanesicardinali.model.acquisto.SistemaPagamento;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
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


    public Carrello acquistoProdotto(Prodotto prodotto, Acquirente acquirente) {
        if(acquirente == null || prodotto == null) {throw new IllegalArgumentException("Prodotto nullo o acquirente nullo");}

        Carrello carrello = carrelloRepository.findById(acquirente.getCarrello().getId()).get();

        SistemaPagamento pagamento = new SistemaPagamento(acquirente, prodotto);
        sistemaPagamentoRepository.save(pagamento);
        carrello.rimuoviProdotto(prodotto);
        return carrelloRepository.save(carrello);

    }
}
