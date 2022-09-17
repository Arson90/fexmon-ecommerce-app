package com.fexmon.fexmonecommerce.service;

import com.fexmon.fexmonecommerce.model.CartModel;

public interface CartService {

    CartModel fetchCart(final Long cartId);

    CartModel saveCart(final CartModel cart);

    CartModel updateCart(final CartModel cart, final Long cartId);

    void deleteCart(final Long cartId);
}
