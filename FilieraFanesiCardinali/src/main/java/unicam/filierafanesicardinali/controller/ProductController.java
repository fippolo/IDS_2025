package unicam.filierafanesicardinali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.localizzazione.Position;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.social.SocialPost;
import unicam.filierafanesicardinali.service.ProductService;
import unicam.filierafanesicardinali.controller.DTO.ProductCreateRequest;
import unicam.filierafanesicardinali.service.SocialService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/Product")
public class ProductController {
    private final SocialService socialService;
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService, SocialService socialService) {
        this.productService = productService;
        this.socialService = socialService;
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
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
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
    public ResponseEntity<Product> approveProduct(@PathVariable Long id, @RequestBody Long authId){ //done
        return ResponseEntity.ok(productService.approveProduct(id, authId));
    }



}
