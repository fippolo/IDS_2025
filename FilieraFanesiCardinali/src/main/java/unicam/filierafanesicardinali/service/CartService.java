package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.acquisto.Cart;
import unicam.filierafanesicardinali.model.acquisto.CartItem;
import unicam.filierafanesicardinali.model.acquisto.orders.Receipt;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.acquisto.orders.Order;
import unicam.filierafanesicardinali.model.acquisto.orders.Receipt;
import unicam.filierafanesicardinali.model.utenti.Buyer;
import unicam.filierafanesicardinali.repository.BuyerRepository;
import unicam.filierafanesicardinali.repository.ProductRepository;

import java.util.List;

@Service
public class CartService {

    private final BuyerRepository buyerRepository;
    private final ProductRepository productRepository;
    private final OrderService orderservice;
    private final PaymentService paymentService;

    @Autowired
    public CartService(BuyerRepository buyerRepository, ProductRepository productRepository
    , OrderService orderservice, PaymentService paymentService) {
        this.buyerRepository = buyerRepository;
        this.productRepository = productRepository;
        this.orderservice = orderservice;
        this.paymentService = paymentService;
    }

    public Cart addToCart(Long buyerId, Long ProductId, int qty) {
        Buyer buyer = getBuyer(buyerId);
        Product product = getProduct(ProductId);
        buyer.getCart().getCartItemList().add(new CartItem(product, qty));
        buyerRepository.save(buyer);
        return buyer.getCart();
    }

    public Cart setCartItemQty(Long buyerID, int productIndex, int qty) {
        Buyer buyer = getBuyer(buyerID);
        if(qty <= 0){
            buyer.getCart().getCartItemList().remove(productIndex);
        }
        else{
            if(buyer.getCart().getCartItemList().size() <= productIndex){
                throw new RuntimeException("Prodotto non trovato nel carrello");
            }
            buyer.getCart().getCartItemList().get(productIndex).setQuantity(qty);
        }
        buyer.getCart().getCartItemList().get(productIndex).setQuantity(qty);
        buyerRepository.save(buyer);
        return buyer.getCart();
    }
    private Receipt buyCart(Long buyerID) {
        Buyer buyer = getBuyer(buyerID);
        Cart cart = buyer.getCart();
        Order order = orderservice.createOrder(cart.getCartItemList(), buyerID);
        Receipt receipt = paymentService.processOrder(order);
        if(receipt == null){
            throw new RuntimeException("Errore durante il pagamento");
        }
        cart.emptyCart();
        buyerRepository.save(buyer);
        return new Receipt();
    }

    public Cart getCart(Long buyerID){
        return getBuyer(buyerID).getCart();
    }
    public List<Cart> getAllCarts() {
        return buyerRepository.findAll().stream().map(Buyer::getCart).toList();
    }
    // helper methods
    private Buyer getBuyer(Long buyerID) {
        return buyerRepository.findById(buyerID).orElseThrow(() -> new RuntimeException("Buyer not found with id: " + buyerID));
    }

    private Product getProduct(Long ProductId) {
        return productRepository.findById(ProductId).orElseThrow(() -> new RuntimeException("Product not found with id: " + ProductId));
    }
}
