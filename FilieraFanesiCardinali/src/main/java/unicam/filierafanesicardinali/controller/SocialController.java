package unicam.filierafanesicardinali.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.social.SocialPost;
import unicam.filierafanesicardinali.service.ProductService;
import unicam.filierafanesicardinali.service.SocialService;

@RestController
@RequestMapping("/api/v1/Social")
public class SocialController {
    SocialService socialService;
    ProductService productService;
    @Autowired
    public SocialController(SocialService socialService, ProductService productService) {
        this.socialService = socialService;
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<SocialPost> createSocialPost(@RequestBody Long productId) {
        return ResponseEntity.ok(socialService.createSocialPost(productService.getProduct(productId)));
    }
}
