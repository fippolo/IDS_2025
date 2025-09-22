package unicam.filierafanesicardinali.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.social.SocialPost;
import unicam.filierafanesicardinali.service.ProductService;
import unicam.filierafanesicardinali.service.SocialService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Social")
public class SocialController {
    private final SocialService socialService;
    private final ProductService productService;

    @Autowired
    public SocialController(SocialService socialService, ProductService productService) {
        this.socialService = socialService;
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<SocialPost> createSocialPost(@RequestBody Long productId) {
        return ResponseEntity.ok(socialService.createSocialPost(productService.getProduct(productId)));
    }

    @GetMapping
    public ResponseEntity<List<SocialPost>> getAllSocialPost(){
        return ResponseEntity.ok(socialService.getAllSocialPosts());
    }

}
