package unicam.filierafanesicardinali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.social.SocialPost;
import unicam.filierafanesicardinali.repository.SocialPostRepository;

import java.util.List;

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

    public void deleteSocialPostByProductId(Long id){
        SocialPost sp = socialPostRepository.findByProductId(id);
        socialPostRepository.deleteById(sp.getId());
    }

    public List<SocialPost> getAllSocialPosts(){
        return socialPostRepository.findAll();
    }
}
