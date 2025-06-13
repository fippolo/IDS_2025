package unicam.filierafanesicardinali.model.venditori;

import unicam.filierafanesicardinali.model.prodotti.Prodotto;

public interface IVenditore {
    public Prodotto creaProdotto(String nome, float prezzo, String descrizione);
}
