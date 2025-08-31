package unicam.filierafanesicardinali.model.venditori;

import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Product;

public interface IVenditore {
    public Product creaProdotto(String nome, float prezzo, String descrizione, Position position);
}
