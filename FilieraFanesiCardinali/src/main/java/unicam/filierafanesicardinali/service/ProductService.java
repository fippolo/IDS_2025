package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Factory.BundleFactory;
import unicam.filierafanesicardinali.model.prodotti.Factory.SimpleProductFactory;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.social.SocialPost;
import unicam.filierafanesicardinali.model.utenti.Authenticator;
import unicam.filierafanesicardinali.model.utenti.Seller;
import unicam.filierafanesicardinali.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final SimpleProductFactory simpleProductFactory;
    private final BundleFactory bundleFactory;
    private final OrderService orderService;
    private final UserService userService;
    private final CartService cartService;

    @Autowired
    public ProductService(ProductRepository productRepository, SimpleProductFactory simpleProductFactory,
                          BundleFactory bundleFactory, UserService userService, OrderService orderService, CartService cartService) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.orderService = orderService;
        this.simpleProductFactory = simpleProductFactory;
        this.bundleFactory = bundleFactory;
        this.cartService = cartService;
    }

    public Product createProduct(String name, double price, String description, Position site, boolean isBundle, Long sellerId){
        Product p;
        if(isBundle){
            p = bundleFactory.createProduct(name, price, description, userService.getSeller(sellerId), site);
        } else {
            p = simpleProductFactory.createProduct(name, price, description, userService.getSeller(sellerId), site);
        }
        return userService.addProductToSeller(sellerId, p);
    }

    public Product deleteProduct(Long id){
        orderService.deleteCartItemsByProductId(id);
        cartService.removeCartItemsByProductId(id);
        Product toDel = getProduct(id);
        try {
            userService.removeAuthenticatedProduct(toDel);
        } catch(Exception ignored){}
        productRepository.deleteById(id);
        return toDel;
    }

    public Product getProduct(Long id){
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Position getProductSite(Long id){
        return getProduct(id).getProductionSite();
    }

    public Product approveProduct(Long id, Long authId){

        Product product = getProduct(id);
        product.setStato(true);
        userService.addAuthenticatedProduct(authId, product);
        return productRepository.save(product);
    }


}
