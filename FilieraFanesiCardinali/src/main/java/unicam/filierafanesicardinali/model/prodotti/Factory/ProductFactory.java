package unicam.filierafanesicardinali.model.prodotti.Factory;

import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.utenti.Seller;

public interface ProductFactory {
    Product createProduct(String name, double price, String descrizione, Seller seller, Position productionSite);
}
