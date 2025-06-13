package unicam.filierafanesicardinali.model.venditori;

import unicam.filierafanesicardinali.model.prodotti.Prodotto;

public interface IBuilder {
    
    void startBundle(String nome, float prezzo,String descrizione);
    void aggiungiProdotto(Prodotto prodotto);
    Prodotto endBundle();
}
