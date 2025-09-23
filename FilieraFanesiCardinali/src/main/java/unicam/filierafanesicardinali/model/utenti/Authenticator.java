package unicam.filierafanesicardinali.model.utenti;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import unicam.filierafanesicardinali.model.prodotti.Product;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Authenticator extends User{

    @OneToMany()
    private List<Product> authenticatedProducts;

    public Authenticator(String nome, String email, String password) {
        super(nome, email, password);
        this.authenticatedProducts = new ArrayList<Product>();
    }
    public Authenticator(){}

    public List<Product> getAuthenticatedProducts() {
        return authenticatedProducts;
    }
    public void setAuthenticatedProducts(List<Product> authenticatedProducts) {
        this.authenticatedProducts = authenticatedProducts;
    }

    public void addAuthenticatedProduct(Product p){
        authenticatedProducts.add(p);
    }

    public void removeAuthenticatedProduct(Product p){
        authenticatedProducts.remove(p);
    }
}
