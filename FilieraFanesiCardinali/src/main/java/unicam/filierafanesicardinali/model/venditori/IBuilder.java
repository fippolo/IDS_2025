package unicam.filierafanesicardinali.model.venditori;

import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Product;

public interface IBuilder {
    
    void startBundle(String nome, float prezzo,String descrizione, Position position);
    void aggiungiProdotto(Product product);
    Product endBundle();
}
