package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.social.SocialPost;
import unicam.filierafanesicardinali.repository.ProductRepository;
import unicam.filierafanesicardinali.repository.SocialPostRepository;

import java.util.List;

@Service
public class SocialService {
    private final SocialPostRepository socialPostRepository;
    private final ProductService productService;

    @Autowired
    public SocialService(SocialPostRepository socialPostRepository, ProductService productService) {
        this.socialPostRepository = socialPostRepository;
        this.productService = productService;
    }

    public SocialPost createSocialPost(Long productId){
        //logic to interact with the social media platform goes here
        SocialPost socialpost = new SocialPost(productService.getProduct(productId),
                "placeholder");
        return socialPostRepository.save(socialpost);
    }

    public List<SocialPost> getAllSocialPosts(){
        return socialPostRepository.findAll();
    }
}
