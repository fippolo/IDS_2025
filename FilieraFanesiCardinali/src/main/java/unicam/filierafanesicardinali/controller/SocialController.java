package unicam.filierafanesicardinali.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.prodotti.Product;
import unicam.filierafanesicardinali.model.social.SocialPost;
import unicam.filierafanesicardinali.model.social.Social;
import unicam.filierafanesicardinali.model.venditori.Venditore;
import unicam.filierafanesicardinali.repository.ProdottoRepository;
import unicam.filierafanesicardinali.repository.SocialRepository;
import unicam.filierafanesicardinali.repository.VenditoreRepository;
import unicam.filierafanesicardinali.service.HandlerSocial;

@RestController
@RequestMapping("/api/v1/social")
public class SocialController {
    private final SocialRepository socialRepository;
    private final VenditoreRepository venditoreRepository;
    private final ProdottoRepository prodottoRepository;
    private final HandlerSocial handlerSocial;


    public SocialController(SocialRepository socialRepository, VenditoreRepository venditoreRepository, ProdottoRepository prodottoRepository, HandlerSocial handlerSocial) {
        this.socialRepository = socialRepository;
        this.venditoreRepository = venditoreRepository;
        this.prodottoRepository = prodottoRepository;
        this.handlerSocial = handlerSocial;
    }


    /**
     * Un venditore aggiunge un contunuto social
     * @param id del venditore
     * @param socialPost
     * @return il social aggiornato
     */
    @PostMapping("/{id}/aggiungicontenuto")
    public ResponseEntity<Social> aggiungicontenutoSocial(@PathVariable Long id, @RequestBody SocialPost socialPost) {
        if(socialPost == null
            || socialPost.getVenditore().getId()== null
            || socialPost.getProdotto().getId()== null
            || !venditoreRepository.existsById(id)
            || !prodottoRepository.existsById(socialPost.getProdotto().getId()))
                {return ResponseEntity.badRequest().build();}
        Venditore venditore = venditoreRepository.findById(socialPost.getVenditore().getId()).get();
        Product product = prodottoRepository.findById(socialPost.getProdotto().getId()).get();

        SocialPost newSocialPost = new SocialPost(product,venditore, socialPost.getDescrizione());

        return ResponseEntity.ok(handlerSocial.aggiungiContenuto(newSocialPost));


    }

    /**
     * Un venditore rimuove un suo contenuto social
     * @param id del venditore
     * @param socialPost
     * @return il social aggiornato
     */
    @DeleteMapping("/{id}/rimuovi")
    public ResponseEntity<Social> rimuoviContenutoSocial(@PathVariable Long id, @RequestBody SocialPost socialPost) {
        if(socialPost == null || !venditoreRepository.existsById(id) || socialPost.getVenditore().getId() != id)
        {return ResponseEntity.badRequest().build();}

        return ResponseEntity.ok(handlerSocial.eliminaContenuto(socialPost));
    }

}
