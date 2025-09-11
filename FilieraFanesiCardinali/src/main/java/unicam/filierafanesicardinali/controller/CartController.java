package unicam.filierafanesicardinali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.filierafanesicardinali.controller.DTO.AddToCartDTO;
import unicam.filierafanesicardinali.controller.DTO.SetItemQtyDTO;
import unicam.filierafanesicardinali.model.acquisto.Cart;
import unicam.filierafanesicardinali.model.acquisto.orders.Receipt;
import unicam.filierafanesicardinali.service.CartService;

import java.util.List;
@RestController
@RequestMapping("/api/v1/Cart")
public class CartController {
    CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }


    @PostMapping("/{idBuyer}/add")
    public ResponseEntity<Cart> addToCart(@PathVariable Long idBuyer, @RequestBody AddToCartDTO addToCart){
        return ResponseEntity.ok(cartService.addToCart(idBuyer, addToCart.productId(), addToCart.qty()));
    }

    @PostMapping("/{idBuyer}/setItemQty")
    public ResponseEntity<Cart> setItemQty(@PathVariable Long idBuyer, @RequestBody SetItemQtyDTO setItemQty){
        return ResponseEntity.ok(cartService.setCartItemQty(idBuyer, setItemQty.productIndex(), setItemQty.qty() ));
    }

    @PostMapping("/{idBuyer}/buy")
    public ResponseEntity<Receipt> buyCart(@PathVariable Long idBuyer){
        return ResponseEntity.ok(cartService.buyCart(idBuyer));
    }

    @GetMapping("/{idBuyer}")
    public ResponseEntity<Cart> getCart(@PathVariable Long idBuyer){
        return ResponseEntity.ok(cartService.getCart(idBuyer));
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts(){
        return ResponseEntity.ok(cartService.getAllCarts());
    }
}
