package unicam.filierafanesicardinali.model.prodotti.Factory;

import org.springframework.stereotype.Component;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.prodotti.SimpleProduct;
import unicam.filierafanesicardinali.model.utenti.Seller;

@Component
public class SimpleProductFactory implements ProductFactory{
    @Override
    public Product createProduct(String name, double price, String descrizione, Seller seller, Position productionSite) {
        return new SimpleProduct(name, price, descrizione, seller, productionSite);
    }
}
