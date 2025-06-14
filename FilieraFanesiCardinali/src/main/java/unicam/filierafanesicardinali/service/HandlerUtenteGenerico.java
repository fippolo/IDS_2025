package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;
import unicam.filierafanesicardinali.model.localizzazione.Mappa;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
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


    public List<Prodotto> consultaProdotti() {
        List<Prodotto> listaProdotti = prodottoRepository.findAll();
        return listaProdotti;
    }

    public List<Indirizzo> consultaMappa() {
        Mappa mappa = new Mappa();
        List<Indirizzo> listaIndirizzi = mappa.getListaIndirizzi();
        return listaIndirizzi;
    }

}
