package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.social.SocialPost;
import unicam.filierafanesicardinali.repository.SocialPostRepository;

@Service
public class SocialService {
    private final SocialPostRepository socialPostRepository;

    @Autowired
    public SocialService(SocialPostRepository socialPostRepository) {
        this.socialPostRepository = socialPostRepository;
    }

    public SocialPost createSocialPost(Product product){
        SocialPost socialpost = new SocialPost(product, "placeholder");
        return socialPostRepository.save(socialpost);
    }
}
