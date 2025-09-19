package unicam.filierafanesicardinali.model.prodotti;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.utenti.Seller;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Bundle extends Product {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> productList;

    public Bundle() {
        super();
        this.productList = new ArrayList<>();
    }

    public Bundle(String name, double price, String descrizione, Seller seller, Position productionSite, List<Product> productList) {
        super(name, price, descrizione, seller, productionSite, "bundle");
        this.productList = productList;
    }

    public void addProduct(Product p){
        productList.add(p);
    }

    public List<Product> getProductList() {
        return productList;
    }
}
