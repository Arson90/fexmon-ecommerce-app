package com.fexmon.fexmonecommerce.exception;

public class CartNotFoundException extends RuntimeException{

    public CartNotFoundException(final String message) {
        super(message);
    }

    public static CartNotFoundException createForCartId(final Long cartId) {
        return new CartNotFoundException(String.format("Product → %d not found ", cartId));
    }
}
