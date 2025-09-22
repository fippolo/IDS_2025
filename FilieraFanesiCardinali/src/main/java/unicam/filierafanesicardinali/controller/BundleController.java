package unicam.filierafanesicardinali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.prodotti.Bundle;
import unicam.filierafanesicardinali.service.BundleService;

//TODO: gestire eccezzioni
@RestController
@RequestMapping("/api/v1/Bundle")
public class BundleController {
    private final BundleService bundleService;

    @Autowired
    public BundleController(BundleService bundleService) {
        this.bundleService = bundleService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Bundle> addProduct(@PathVariable Long id, @RequestBody Long productId) {
        return ResponseEntity.ok(bundleService.addProductToBundle(id,productId));
    }
}
