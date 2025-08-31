package unicam.filierafanesicardinali.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.localizzazione.Mappa;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.repository.ProdottoRepository;

import java.util.List;

@Service
public class HandlerAcquirente {


    private final ProdottoRepository prodottoRepository;

    @Autowired
    public HandlerAcquirente(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;

    }

    public List<Product> consultaProdotti() {
        List<Product> listaProdotti = prodottoRepository.findByStatoTrue();
        return listaProdotti;
    }

    public List<Position> consultaMappa() {
        Mappa mappa = new Mappa();
        List<Position> listaIndirizzi = mappa.getListaIndirizzi();
        return listaIndirizzi;
    }


}
