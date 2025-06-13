package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.prodotti.ProdottoDistributore;
import unicam.filierafanesicardinali.model.venditori.DistributoreTipicita;
import unicam.filierafanesicardinali.model.venditori.Venditore;
import unicam.filierafanesicardinali.repository.ProdottoRepository;
import unicam.filierafanesicardinali.repository.VenditoreRepository;

import java.util.Optional;

@Service
public class HandlerDistributore extends HandlerVenditore{

    VenditoreRepository venditoreRepository;

    @Autowired
    public HandlerDistributore(ProdottoRepository prodottoRepository, VenditoreRepository venditoreRepository) {
        super(prodottoRepository);
        this.venditoreRepository = venditoreRepository;
    }

    public ProdottoDistributore creaProdotto (ProdottoDistributore prodotto){
        if(prodotto.getVenditore() == null) throw new IllegalArgumentException("Venditore non trovato");

        DistributoreTipicita distributoreProdotto = (DistributoreTipicita) prodotto.getVenditore();

        ProdottoDistributore toReturn = distributoreProdotto.creaProdotto(prodotto.getNome()
                                                            ,prodotto.getPrezzo()
                                                            ,prodotto.getDescrizione());
        return prodottoRepository.save(toReturn);
    }

    public DistributoreTipicita iniziaPacchetto (DistributoreTipicita venditore, String nome, Float prezzo, String descrizione){
        if(venditore == null) throw new IllegalArgumentException("Venditore non trovato");
        DistributoreTipicita distributoreTipicita;
        Optional<Venditore> optionalVenditore = venditoreRepository.findById(venditore.getId());
        if(optionalVenditore.isPresent()){
            distributoreTipicita = (DistributoreTipicita) optionalVenditore.get();
        }
        else throw new IllegalArgumentException("Venditore non trovato");
        distributoreTipicita.startBundle(nome, prezzo, descrizione);
        return venditoreRepository.save(distributoreTipicita);
    }

    public DistributoreTipicita aggiungiProdotto (DistributoreTipicita venditore, Prodotto prodotto){
        if(venditore == null) throw new IllegalArgumentException("Venditore non trovato");
        DistributoreTipicita distributoreTipicita;
        Optional<Venditore> optionalVenditore = venditoreRepository.findById(venditore.getId());
        if(optionalVenditore.isPresent()){
            distributoreTipicita = (DistributoreTipicita) optionalVenditore.get();
        }
        else throw new IllegalArgumentException("Venditore non trovato");
        distributoreTipicita.aggiungiProdotto(prodotto);
        return venditoreRepository.save(distributoreTipicita);
    }

    public ProdottoDistributore salvaBundle (DistributoreTipicita venditore){
        if(venditore == null) throw new IllegalArgumentException("Venditore non trovato");
        DistributoreTipicita distributoreTipicita;
        Optional<Venditore> optionalVenditore = venditoreRepository.findById(venditore.getId());
        if(optionalVenditore.isPresent()){
            distributoreTipicita = (DistributoreTipicita) optionalVenditore.get();
        }
        else throw new IllegalArgumentException("Venditore non trovato");
        ProdottoDistributore prodotto = distributoreTipicita.endBundle();
        venditoreRepository.save(distributoreTipicita);
        return prodottoRepository.save(prodotto);
    }
}
