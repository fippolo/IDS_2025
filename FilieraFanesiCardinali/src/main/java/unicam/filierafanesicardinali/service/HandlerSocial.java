package unicam.filierafanesicardinali.service;

import org.springframework.stereotype.Service;
import unicam.filierafanesicardinali.model.social.ContenutoSocial;
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


    public Social aggiungiContenuto(ContenutoSocial contenutoSocial) {
        if (contenutoSocial == null) {throw new IllegalArgumentException("Contenuto social nullo");}
        Social social = Social.getSocial();
        social.addContenutoSocial(contenutoSocial);
        return socialRepository.save(social);
    }


    public Social eliminaContenuto(ContenutoSocial contenutoSocial) {
        if (contenutoSocial == null) {throw new IllegalArgumentException("Contenuto social null");}
        Social social = Social.getSocial();
        social.addContenutoSocial(contenutoSocial);
        return socialRepository.save(social);
    }
}
