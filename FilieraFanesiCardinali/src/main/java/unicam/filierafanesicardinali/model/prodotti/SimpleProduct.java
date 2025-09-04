package unicam.filierafanesicardinali.model.prodotti;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.utenti.Seller;

@Entity
@DiscriminatorValue("simple")
public class SimpleProduct extends Product{
    public SimpleProduct(String name, double price, String descrizione, Seller seller, Position productionSite) {
        super(name, price, descrizione, seller, productionSite, "simple");
    }

    public SimpleProduct() {
        super();
    }
}
