package com.fexmon.fexmonecommerce.service.impl;

import com.fexmon.fexmonecommerce.model.CartModel;
import com.fexmon.fexmonecommerce.repository.CartRepository;
import com.fexmon.fexmonecommerce.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public CartModel fetchCart(final Long cartId) {
        return cartRepository.findById(cartId);
    }

    @Override
    public CartModel saveCart(final CartModel cart) {
        return null;
    }

    @Override
    public CartModel updateCart(final CartModel cart, final Long cartId) {
        return null;
    }

    @Override
    public void deleteCart(final Long cartId) {

    }
}
