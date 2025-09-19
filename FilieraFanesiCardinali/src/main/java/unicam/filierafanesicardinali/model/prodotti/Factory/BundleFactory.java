package unicam.filierafanesicardinali.model.prodotti.Factory;

import org.springframework.stereotype.Component;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Bundle;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.utenti.Seller;

import java.util.List;

@Component
public class BundleFactory implements ProductFactory{

    @Override
    public Product createProduct(String name, double price, String descrizione, Seller seller, Position productionSite) {
        return new Bundle(name, price, descrizione, seller, productionSite, List.of()); // creat intial without any item
    }


}
