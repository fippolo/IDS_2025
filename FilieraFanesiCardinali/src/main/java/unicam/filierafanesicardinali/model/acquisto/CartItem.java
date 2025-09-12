package unicam.filierafanesicardinali.model.acquisto;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.prodotti.Product;

@Embeddable
public class CartItem {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;
    public CartItem() {}
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getSubtotal() { return product.getPrice() * quantity; }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Treat two CartItems as equal if they refer to the same product.
    // This makes merging/contains/indexOf work correctly on the List.
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItem other)) return false;
        return product != null && other.product != null &&
                product.getId() != null && product.getId().equals(other.product.getId());
    }
    @Override public int hashCode() {
        return product != null && product.getId() != null ? product.getId().hashCode() : 0;
    }
}
