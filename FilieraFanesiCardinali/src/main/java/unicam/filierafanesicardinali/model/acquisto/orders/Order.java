package unicam.filierafanesicardinali.model.acquisto.orders;

import jakarta.persistence.*;
import unicam.filierafanesicardinali.model.acquisto.CartItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")  // Modificato il nome della tabella da "order" an "orders"
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double total;
    private LocalDateTime insertionDate;
    private Long idBuyer;
    private boolean isPaid;

    @ElementCollection
    @CollectionTable(
            name = "order_items",
            joinColumns = @JoinColumn(name = "order_id")
    )
    private List<CartItem> orderItems = new ArrayList<>();

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

    public Long getId() {
        return id;
    }

    public Long getIdBuyer() {
        return idBuyer;
    }

    public double getTotal() {
        return total;
    }
}
