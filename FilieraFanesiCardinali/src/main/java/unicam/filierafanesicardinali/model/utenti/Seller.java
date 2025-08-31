package unicam.filierafanesicardinali.model.utenti;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Product;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Seller extends User{
    @Embedded
    Position position;

    @OneToMany(cascade = CascadeType.ALL)
    List<Product> onSaleProducts;

    public Seller(String nome, String email, String password, Position position) {
        super(nome, email, password);
        this.position = position;
        this.onSaleProducts = new ArrayList<Product>();
    }

    public Seller() {}

    public List<Product> getOnSaleProducts() {
        return onSaleProducts;
    }
}
