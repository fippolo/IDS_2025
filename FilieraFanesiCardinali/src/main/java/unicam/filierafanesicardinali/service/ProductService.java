package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Factory.BundleFactory;
import unicam.filierafanesicardinali.model.prodotti.Factory.SimpleProductFactory;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.social.SocialPost;
import unicam.filierafanesicardinali.model.utenti.Seller;
import unicam.filierafanesicardinali.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final SimpleProductFactory simpleProductFactory;
    private final BundleFactory bundleFactory;
    private final SocialService socialService;
    private final UserService userService;

    @Autowired
    public ProductService(ProductRepository productRepository, SimpleProductFactory simpleProductFactory,
                          BundleFactory bundleFactory, SocialService socialService, UserService userService) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.simpleProductFactory = simpleProductFactory;
        this.bundleFactory = bundleFactory;
        this.socialService = socialService;
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
        Product toDel = getProduct(id);
        socialService.deleteSocialPostByProductId(toDel.getId());
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

    public Product approveProduct(Long id){
        // TODO: salvare l'authenticator che approva il prodotto, aggiungendo id authenticator nel metodo
        Product product = getProduct(id);
        product.setStato(true);
        return productRepository.save(product);
    }


}
