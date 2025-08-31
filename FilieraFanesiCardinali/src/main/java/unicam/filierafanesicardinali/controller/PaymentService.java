package unicam.filierafanesicardinali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.acquisto.orders.Order;
import unicam.filierafanesicardinali.model.acquisto.orders.Receipt;
import unicam.filierafanesicardinali.model.acquisto.orders.ReceiptNumberGenerator;
import unicam.filierafanesicardinali.repository.ReceiptRepository;

@Repository
public class PaymentService {
    ReceiptRepository receiptRepository;
    ReceiptNumberGenerator numberGenerator;
    @Autowired
    public PaymentService(ReceiptRepository receiptRepository, ReceiptNumberGenerator receiptNumberGenerator) {
        this.receiptRepository = receiptRepository;
        this.numberGenerator = receiptNumberGenerator;
    }

    public Receipt processOrder(Order order){
        order.setPaid(true);
        // payment processing implementation goes here
        Receipt receipt = new Receipt(numberGenerator.next(), order.getInsertionDate(), order);
        return receiptRepository.save(receipt);
    }
}
