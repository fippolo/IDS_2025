package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.social.SocialPost;
import unicam.filierafanesicardinali.model.social.Social;
import unicam.filierafanesicardinali.repository.SocialRepository;
import unicam.filierafanesicardinali.repository.VenditoreRepository;

@Service
public class HandlerSocial {

    private final VenditoreRepository venditoreRepository;
    private final SocialRepository socialRepository;

    public HandlerSocial(VenditoreRepository venditoreRepository, SocialRepository socialRepository) {
        this.venditoreRepository = venditoreRepository;
        this.socialRepository = socialRepository;
    }


    public Social aggiungiContenuto(SocialPost socialPost) {
        if (socialPost == null) {throw new IllegalArgumentException("Contenuto social nullo");}
        Social social = Social.getSocial();
        social.addContenutoSocial(socialPost);
        return socialRepository.save(social);
    }


    public Social eliminaContenuto(SocialPost socialPost) {
        if (socialPost == null) {throw new IllegalArgumentException("Contenuto social null");}
        Social social = Social.getSocial();
        social.addContenutoSocial(socialPost);
        return socialRepository.save(social);
    }
}
