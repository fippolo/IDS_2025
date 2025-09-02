package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Factory.BundleFactory;
import unicam.filierafanesicardinali.model.prodotti.Factory.SimpleProductFactory;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.social.SocialPost;
import unicam.filierafanesicardinali.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final SimpleProductFactory simpleProductFactory;
    private final BundleFactory bundleFactory;
    private final SocialService socialService;

    @Autowired
    public ProductService(ProductRepository productRepository, SimpleProductFactory simpleProductFactory,
                          BundleFactory bundleFactory, SocialService socialService) {
        this.productRepository = productRepository;
        this.simpleProductFactory = simpleProductFactory;
        this.bundleFactory = bundleFactory;
        this.socialService = socialService;
    }

    public Product createProduct(String name, double price, String description, Position site, boolean isBundle){
        if(isBundle){
            return productRepository.save(bundleFactory.createProduct(name, price, description, null, site));
        } else {
            return productRepository.save(simpleProductFactory.createProduct(name, price, description, null, site));
        }
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

    public SocialPost shareProduct(Long id){
        return socialService.createSocialPost(getProduct(id));
    }
}
