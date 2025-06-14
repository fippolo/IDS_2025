package unicam.filierafanesicardinali.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.filierafanesicardinali.model.eventi.Evento;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.service.HandlerPiattaforma;

import java.util.List;

@RestController
@RequestMapping("/api/v1/piattaforma")
public class PiattaformaController {

    private final HandlerPiattaforma handlerPiattaforma;

    public PiattaformaController(HandlerPiattaforma handlerPiattaforma) {
        this.handlerPiattaforma = handlerPiattaforma;
    }

    @GetMapping("/prodotti")
    public ResponseEntity<List<Prodotto>> getProdotti(){
        List<Prodotto> listaProdotti = handlerPiattaforma.getAllProdotto();
        return ResponseEntity.ok().body(listaProdotti);
    }

    @GetMapping("/prodotto/{id}")
    public ResponseEntity<Prodotto> getProdotto(@PathVariable Long id){
        if(id == null){return ResponseEntity.badRequest().build();}
        Prodotto prodotto = handlerPiattaforma.getProdottoById(id);
        return ResponseEntity.ok().body(prodotto);
    }


    @GetMapping("/evnti")
    public ResponseEntity<List<Evento>> getEvnti(){
        List<Evento> listaEventi = handlerPiattaforma.getAllEvento();
        return ResponseEntity.ok().body(listaEventi);
    }

    @GetMapping("/evento/{id}")
    public ResponseEntity<Evento> getEvento(@PathVariable Long id){
        if(id == null){return ResponseEntity.badRequest().build();}
        Evento evento = handlerPiattaforma.getEventoById(id);
        return ResponseEntity.ok().body(evento);
    }


}
