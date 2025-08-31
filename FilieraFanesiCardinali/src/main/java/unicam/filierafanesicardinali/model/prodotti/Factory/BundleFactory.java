package unicam.filierafanesicardinali.model.prodotti.Factory;

import org.springframework.stereotype.Component;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Bundle;
import unicam.filierafanesicardinali.model.prodotti.Product;

import java.util.List;

@Component
public class BundleFactory implements ProductFactory{

    @Override
    public Product createProduct(String name, double price, String descrizione, Long sellerId, Position productionSite) {
        return new Bundle(name, price, descrizione, sellerId, productionSite, List.of()); // creat intial without any item
    }

    public Product createProduct(String name, double price, String descrizione, Long sellerId, Position productionSite, List<Product> listaProdotti) {
        return new Bundle(name, price, descrizione, sellerId, productionSite, listaProdotti);
    }
}
