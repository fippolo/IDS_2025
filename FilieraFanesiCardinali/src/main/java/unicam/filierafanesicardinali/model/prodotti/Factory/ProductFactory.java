package unicam.filierafanesicardinali.model.prodotti.Factory;

import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Product;

public interface ProductFactory {
    Product createProduct(String name, double price, String descrizione,Long sellerId, Position productionSite);
}
