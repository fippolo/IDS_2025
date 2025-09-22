package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import unicam.filierafanesicardinali.model.acquisto.orders.Order;
import unicam.filierafanesicardinali.model.acquisto.orders.Receipt;
import unicam.filierafanesicardinali.model.acquisto.orders.ReceiptNumberGenerator;
import unicam.filierafanesicardinali.repository.ReceiptRepository;

import java.util.List;

@Repository
public class PaymentService {

    private final ReceiptRepository receiptRepository;
    private final ReceiptNumberGenerator numberGenerator;
    private final OrderService orderService;


    @Autowired
    public PaymentService(ReceiptRepository receiptRepository, ReceiptNumberGenerator receiptNumberGenerator,
                          OrderService orderService) {
        this.receiptRepository = receiptRepository;
        this.numberGenerator = receiptNumberGenerator;
        this.orderService = orderService;
    }

    public Receipt processOrder(Order order){
        orderService.updateOrderStatus(order.getId(), true);
        // payment processing implementation goes here
        Receipt receipt = new Receipt(numberGenerator.next(), order.getInsertionDate(), order);
        return receiptRepository.save(receipt);
    }

    public Receipt getReceipt(Long id){
        return receiptRepository.findById(id).orElseThrow(() -> new RuntimeException("Receipt not found with id: " + id));
    }


    public List<Receipt> getReceipts(){
        return receiptRepository.findAll();
    }
}
