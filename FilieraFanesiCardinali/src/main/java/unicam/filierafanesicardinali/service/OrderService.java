package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.acquisto.CartItem;
import unicam.filierafanesicardinali.model.acquisto.orders.Order;
import unicam.filierafanesicardinali.model.acquisto.orders.OrderBuilder;
import unicam.filierafanesicardinali.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    private final ObjectFactory<OrderBuilder> builderProvider;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(ObjectFactory<OrderBuilder> builderProvider, OrderRepository orderRepository) {
        this.builderProvider = builderProvider;
        this.orderRepository = orderRepository;
    }

    public Order createOrder(List<CartItem> products, Long buyerID){
        return orderRepository.save(
                builderProvider.getObject()
                .setBuyer(buyerID)
                .withInsertionDate(java.time.LocalDateTime.now())
                .addProducts(products)
                .build());
    }

    public Order GetOrder(Long id){
        return orderRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public List<Order> getBuyersOrders(Long id){
        return orderRepository.findByIdBuyer(id).
                orElseThrow(() -> new RuntimeException("Buyer not found with id: " + id));
    }

    public boolean getOrderStatus(Long id){
        return orderRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Order not found with id: " + id))
                .isPaid();
    }

    public Order updateOrderStatus(Long id, boolean status){
        Order order = orderRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        order.setPaid(status);
        return orderRepository.save(order);
    }
}
