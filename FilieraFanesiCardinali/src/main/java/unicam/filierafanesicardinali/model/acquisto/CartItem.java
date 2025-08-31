package unicam.filierafanesicardinali.model.acquisto;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.prodotti.Product;

@Entity
public class CartItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;
    private int quantity;

    public CartItem(){}

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
}
