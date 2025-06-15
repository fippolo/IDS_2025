package unicam.filierafanesicardinali.model.venditori;

import unicam.filierafanesicardinali.model.localizzazione.Indirizzo;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;

public interface IBuilder {
    
    void startBundle(String nome, float prezzo,String descrizione, Indirizzo indirizzo);
    void aggiungiProdotto(Prodotto prodotto);
    Prodotto endBundle();
}
