package unicam.filierafanesicardinali.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.Bundle;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.repository.ProductRepository;

@Service
public class BundleService {
    private final ProductRepository productRepository;

    @Autowired
    public BundleService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Bundle addProductToBundle(Long bundleId, Long productId){
        Product product = getProductById(bundleId);
        Bundle bundle;
        if(!(product instanceof Bundle)){
            throw new RuntimeException("Product is not a bundle");
        } else {
            bundle = (Bundle) product;
        }
        bundle.addProduct(getProductById(productId));
        return productRepository.save(bundle);
    }

    //helper methods
    private Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
}
