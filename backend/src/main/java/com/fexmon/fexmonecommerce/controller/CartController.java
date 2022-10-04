package com.fexmon.fexmonecommerce.controller;

import com.fexmon.fexmonecommerce.model.CartModel;
import com.fexmon.fexmonecommerce.service.impl.CartServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fexmon")
public class CartController {
    private final CartServiceImpl cartService;

    public CartController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart/{cartId}")
    public CartModel getCartById(@PathVariable final long cartId) {
        return cartService.fetchCart(cartId);
    }

    @GetMapping("/cart")
    public List<CartModel> getAllCarts() {
        return cartService.fetchAllCarts();
    }

    @PostMapping("/cart")
    public CartModel addCart() {
        return cartService.saveCart();
    }

    @PutMapping("/cart/product/{productId}")
    public CartModel updateCart(@PathVariable final long productId) {
        return cartService.updateCart(productId);
    }

    @DeleteMapping("/cart/{id}")
    public void deleteCart(@PathVariable final long id) {
        cartService.deleteCart(id);
    }
}
