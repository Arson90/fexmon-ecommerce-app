package com.fexmon.fexmonecommerce.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(final String message) {
        super(message);
    }

    public static ProductNotFoundException createForProductId(final Long productId) {
        return new ProductNotFoundException(String.format("Product → %d not found ", productId));
    }
}
