package unicam.filierafanesicardinali.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.acquisto.orders.Order;
import unicam.filierafanesicardinali.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Order")
public class OrderController {
    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @GetMapping("/Buyer/{id}")
    public ResponseEntity<List<Order>> getAllBuyersOrders(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getBuyersOrders(id));
    }
}
