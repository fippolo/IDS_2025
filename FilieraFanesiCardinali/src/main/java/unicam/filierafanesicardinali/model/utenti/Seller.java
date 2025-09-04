package unicam.filierafanesicardinali.model.utenti;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Product;

import java.util.ArrayList;
import java.util.List;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Seller extends User{
    @Embedded
    Position position;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("seller-products")
    List<Product> onSaleProducts;

    public Seller(String nome, String email, String password, Position position) {
        super(nome, email, password);
        this.position = position;
        this.onSaleProducts = new ArrayList<Product>();
    }
    public Seller(String nome, String email, String password) {
        super(nome, email, password);
        this.onSaleProducts = new ArrayList<Product>();
        this.position = new Position();
    }

    public Seller() {}

    public List<Product> getOnSaleProducts() {
        return onSaleProducts;
    }
    public void setOnSaleProducts(List<Product> onSaleProducts) {
        this.onSaleProducts = onSaleProducts;
    }
    public void addOnSaleProduct(Product p){
        onSaleProducts.add(p);
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
}
