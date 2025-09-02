package unicam.filierafanesicardinali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.model.acquisto.Cart;
import unicam.filierafanesicardinali.model.acquisto.orders.Receipt;
import unicam.filierafanesicardinali.service.CartService;

import java.util.List;
//TODO: gestire eccezzioni
@RestController
@RequestMapping("/api/v1/Cart")
public class CartController {
    CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }


    @PostMapping("/{id}/add")
    public ResponseEntity<Cart> addToCart(@PathVariable Long id, @RequestBody Long productId, @RequestBody int qty){
        return ResponseEntity.ok(cartService.addToCart(id, productId, qty));
    }

    @PostMapping("/{id}/setItemQty")
    public ResponseEntity<Cart> setItemQty(@PathVariable Long id,@RequestBody Integer productIndex, @RequestBody Integer qty){
        return ResponseEntity.ok(cartService.setCartItemQty(id, productIndex, qty));
    }

    @PostMapping("/{id}/buy")
    public ResponseEntity<Receipt> buyCart(@PathVariable Long id){
        return ResponseEntity.ok(cartService.buyCart(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id){
        return ResponseEntity.ok(cartService.getCart(id));
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts(){
        return ResponseEntity.ok(cartService.getAllCarts());
    }
}
