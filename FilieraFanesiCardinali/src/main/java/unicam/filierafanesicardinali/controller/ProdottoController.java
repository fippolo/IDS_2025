package unicam.filierafanesicardinali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.filierafanesicardinali.repository.ProdottoRepository;
import unicam.filierafanesicardinali.service.HandlerVenditore;
import unicam.filierafanesicardinali.model.prodotti.*;


@RestController
@RequestMapping("/api/v1/prodotti")
public class ProdottoController {
    private final HandlerVenditore handlerVenditore;
    private final ProdottoRepository prodottoRepository;

    @Autowired
    public ProdottoController(HandlerVenditore handlerVenditore, ProdottoRepository prodottoRepository) {
        this.handlerVenditore = handlerVenditore;
        this.prodottoRepository = prodottoRepository;
    }

}
