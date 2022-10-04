package com.fexmon.fexmonecommerce.service;

import com.fexmon.fexmonecommerce.model.CartModel;

import java.util.List;

public interface CartService {

    List<CartModel> fetchAllCarts();
    CartModel fetchCart(final Long cartId);

    CartModel saveCart();

    CartModel updateCart(final Long productID);

    void deleteCart(final Long cartId);
}
