package unicam.filierafanesicardinali.model.venditori;

import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;

public interface IVenditore {
    public Prodotto creaProdotto(String nome, float prezzo, String descrizione, Indirizzo indirizzo);
}
