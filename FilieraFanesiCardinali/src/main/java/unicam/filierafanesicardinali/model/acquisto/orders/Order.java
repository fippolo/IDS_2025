package unicam.filierafanesicardinali.model.acquisto.orders;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.acquisto.CartItem;
import unicam.filierafanesicardinali.model.prodotti.Product;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Order {
    @Id
    private Long id;

    private double total;
    private LocalDateTime insertionDate;
    private Long idBuyer;
    private boolean isPaid;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> orderItems;

    public Order(){isPaid = false;}

    public void setInsertionDate(LocalDateTime insertionDate) {
        this.insertionDate = insertionDate;
    }

    public void setIdBuyer(Long idBuyer) {
        this.idBuyer = idBuyer;
    }

    public List<CartItem> getOrderItems() {
        return orderItems;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public LocalDateTime getInsertionDate() {
        return insertionDate;
    }

    public boolean isPaid() {
        return isPaid;
    }
}
