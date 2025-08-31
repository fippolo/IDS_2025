package unicam.filierafanesicardinali.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.filierafanesicardinali.model.eventi.Event;
import unicam.filierafanesicardinali.model.prodotti.Product;
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
    public ResponseEntity<List<Product>> getProdotti(){
        List<Product> listaProdotti = handlerPiattaforma.getAllProdotto();
        return ResponseEntity.ok().body(listaProdotti);
    }

    /**
     * Ritorna un prodotto tramite l'id
     * @param id del prodotto
     * @return il prodotto
     */
    @GetMapping("/prodotto/{id}")
    public ResponseEntity<Product> getProdotto(@PathVariable Long id){
        if(id == null){return ResponseEntity.badRequest().build();}
        Product product = handlerPiattaforma.getProdottoById(id);
        return ResponseEntity.ok().body(product);
    }


    @GetMapping("/evnti")
    public ResponseEntity<List<Event>> getEvnti(){
        List<Event> listaEventi = handlerPiattaforma.getAllEvento();
        return ResponseEntity.ok().body(listaEventi);
    }

    /**
     * Ritorna un evento tramite l'id
     * @param id dell'evento
     * @return l'evento
     */
    @GetMapping("/evento/{id}")
    public ResponseEntity<Event> getEvento(@PathVariable Long id){
        if(id == null){return ResponseEntity.badRequest().build();}
        Event event = handlerPiattaforma.getEventoById(id);
        return ResponseEntity.ok().body(event);
    }


}
