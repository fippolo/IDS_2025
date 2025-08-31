package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.localizzazione.Mappa;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.repository.ProdottoRepository;
import unicam.filierafanesicardinali.repository.UtenteGenericoRepository;

import java.util.List;

@Service
public class HandlerUtenteGenerico {
    private final UtenteGenericoRepository utenteGenericoRepository;
    private final ProdottoRepository prodottoRepository;

    public HandlerUtenteGenerico(UtenteGenericoRepository utenteGenericoRepository, ProdottoRepository prodottoRepository) {
        this.utenteGenericoRepository = utenteGenericoRepository;
        this.prodottoRepository = prodottoRepository;
    }


    public List<Product> consultaProdotti() {
        List<Product> listaProdotti = prodottoRepository.findAll();
        return listaProdotti;
    }

    public List<Position> consultaMappa() {
        Mappa mappa = new Mappa();
        List<Position> listaIndirizzi = mappa.getListaIndirizzi();
        return listaIndirizzi;
    }

}
