package unicam.filierafanesicardinali.model.prodotti;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import unicam.filierafanesicardinali.model.localizzazione.Position;

@Entity
@DiscriminatorValue("simple")
public class SimpleProduct extends Product{
    public SimpleProduct(String name, double price, String descrizione, Long sellerId, Position productionSite) {
        super(name, price, descrizione, sellerId, productionSite);
    }

    public SimpleProduct() {
        super();
    }
}
