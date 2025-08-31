package unicam.filierafanesicardinali.model.acquisto.orders;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int receiptNumber;
    private LocalDateTime emissionDate;

    @OneToOne (cascade = CascadeType.ALL)
    private Order order;

    public Receipt(int receiptNumber, LocalDateTime emissionDate, Order order) {
        this.receiptNumber = receiptNumber;
        this.emissionDate = emissionDate;
        this.order = order;
    }

    public Receipt(){}

    public Long getId() {
        return id;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(int receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public LocalDateTime getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(LocalDateTime emissionDate) {
        this.emissionDate = emissionDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
