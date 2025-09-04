package unicam.filierafanesicardinali.model.prodotti;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import unicam.filierafanesicardinali.model.localizzazione.Position;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Bundle extends Product {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> listaProdotti;

    public Bundle() {
        super();
        this.listaProdotti = new ArrayList<>();
    }

    public Bundle(String name, double price, String descrizione, Long sellerId, Position productionSite, List<Product> listaProdotti) {
        super(name, price, descrizione, sellerId, productionSite);
        this.listaProdotti = listaProdotti;
    }

    public void addProduct(Product p){
        listaProdotti.add(p);
    }

    public List<Product> getListaProdotti() {
        return listaProdotti;
    }
}
