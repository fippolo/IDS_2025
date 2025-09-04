package unicam.filierafanesicardinali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.social.SocialPost;
import unicam.filierafanesicardinali.service.ProductService;
import unicam.filierafanesicardinali.controller.DTO.ProductCreateRequest;

import java.util.List;


@RestController
@RequestMapping("/api/v1/Product")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody ProductCreateRequest request) {
        return ResponseEntity.ok(productService.createProduct(request.name(), request.price(), request.description(),
                request.site(), request.isBundle(), request.sellerId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){ //done
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){ //done
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}/origin")
    public ResponseEntity<Position> getProductOrigin(@PathVariable Long id){ //done
        return ResponseEntity.ok(productService.getProductSite(id));
    }

    @GetMapping("/{id}/approve")
    public ResponseEntity<Product> approveProduct(@PathVariable Long id){ //done
        return ResponseEntity.ok(productService.approveProduct(id));
    }


    @GetMapping("/{id}/share")
    public ResponseEntity<SocialPost> share(@PathVariable Long id) {
        return ResponseEntity.ok(productService.shareProduct(id));
    }
}
