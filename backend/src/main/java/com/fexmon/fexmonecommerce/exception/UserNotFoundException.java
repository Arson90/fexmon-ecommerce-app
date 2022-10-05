package com.fexmon.fexmonecommerce.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
    public static UserNotFoundException createUserNotFoundException(final Long userId) {
        return new UserNotFoundException(String.format("User not found, ID: %d", userId));
    }
}
