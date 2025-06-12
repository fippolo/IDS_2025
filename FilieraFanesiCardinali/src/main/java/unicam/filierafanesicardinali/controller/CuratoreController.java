package unicam.filierafanesicardinali.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.amministrazione.Curatore;
import unicam.filierafanesicardinali.model.prodotti.Prodotto;
import unicam.filierafanesicardinali.model.prodotti.ProdottoProduttore;
import unicam.filierafanesicardinali.model.venditori.Produttore;
import unicam.filierafanesicardinali.repository.CuratoreRepository;
import unicam.filierafanesicardinali.repository.ProdottoRepository;
import unicam.filierafanesicardinali.repository.VenditoreRepository;
import unicam.filierafanesicardinali.service.HandlerCuratore;

@RestController
@RequestMapping("/api/v1/curatori")
public class CuratoreController {
    private final CuratoreRepository curatoreRepository;
    private final HandlerCuratore handlerCuratore;
    //test
    private final ProdottoRepository prodottoRepository;
    private final VenditoreRepository venditoreRepository;

    public CuratoreController(CuratoreRepository curatoreRepository, HandlerCuratore handlerCuratore, ProdottoRepository prodottoRepository, VenditoreRepository venditoreRepository) {
        this.curatoreRepository = curatoreRepository;
        this.handlerCuratore = handlerCuratore;
        this.prodottoRepository = prodottoRepository;
        this.venditoreRepository = venditoreRepository;
    }


    @GetMapping("curatore")
    public ResponseEntity<Curatore> registraCuratore(@RequestBody Curatore curatore) {
        try {
            Curatore newCuratore = curatoreRepository.save(curatore);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCuratore);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/verifica/{id}")
    public ResponseEntity<Prodotto> verificaProdotto(@PathVariable Long id) {
        Prodotto prodottoVerificato = handlerCuratore.verificaProdotto(id);
        return ResponseEntity.ok(prodottoVerificato);
    }


    @GetMapping("/test")
    public ResponseEntity<Long>test(){
        Produttore testProduttore = new Produttore("testP","testP","testP");
        venditoreRepository.save(testProduttore);
        ProdottoProduttore testProdotto = testProduttore.creaProdotto("test",11,"test","test");
        prodottoRepository.save(testProdotto);
        return ResponseEntity.ok(testProdotto.getId());
    }



}
