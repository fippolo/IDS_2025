package unicam.filierafanesicardinali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.filierafanesicardinali.model.acquisto.orders.Receipt;
import unicam.filierafanesicardinali.service.PaymentService;

import java.util.List;

//TODO: gestire eccezzioni
@RestController
@RequestMapping("/api/v1/Receipt")
public class PaymentController {
    PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receipt> getReceipt(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getReceipt(id));
    }

    @GetMapping
    public ResponseEntity<List<Receipt>> getAllReceipts() {
        return ResponseEntity.ok(paymentService.getReceipts());
    }
}
