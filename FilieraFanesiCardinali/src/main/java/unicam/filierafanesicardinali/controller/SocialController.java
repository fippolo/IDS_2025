package unicam.filierafanesicardinali.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.social.ContenutoSocial;
import unicam.filierafanesicardinali.model.social.Social;
import unicam.filierafanesicardinali.model.venditori.DistributoreTipicita;
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


    @PostMapping("/{id}/aggiungicontenuto")
    public ResponseEntity<Social> aggiungicontenutoSocial(@PathVariable Long id, @RequestBody ContenutoSocial contenutoSocial) {
        if(contenutoSocial == null
            || contenutoSocial.getVenditore().getId()== null
            || contenutoSocial.getProdotto().getId()== null
            || !venditoreRepository.existsById(id)
            || !prodottoRepository.existsById(contenutoSocial.getProdotto().getId()))
                {return ResponseEntity.badRequest().build();}
        Venditore venditore = venditoreRepository.findById(contenutoSocial.getVenditore().getId()).get();
        Prodotto prodotto = prodottoRepository.findById(contenutoSocial.getProdotto().getId()).get();

        ContenutoSocial newContenutoSocial = new ContenutoSocial(prodotto,venditore,contenutoSocial.getDescrizione());

        return ResponseEntity.ok(handlerSocial.aggiungiContenuto(newContenutoSocial));


    }

    @DeleteMapping("/{id}/rimuovi")
    public ResponseEntity<Social> rimuoviContenutoSocial(@PathVariable Long id, @RequestBody ContenutoSocial contenutoSocial) {
        if(contenutoSocial == null || !venditoreRepository.existsById(id))
        {return ResponseEntity.badRequest().build();}

        return ResponseEntity.ok(handlerSocial.eliminaContenuto(contenutoSocial));
    }

}
