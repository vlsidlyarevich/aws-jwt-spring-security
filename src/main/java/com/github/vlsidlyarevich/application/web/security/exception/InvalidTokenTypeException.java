package com.github.vlsidlyarevich.application.web.security.exception;

import lombok.Getter;

/**
 * The type Invalid token type exception.
 */
@Getter
public class InvalidTokenTypeException extends RuntimeException {

    private String message;

    /**
     * Instantiates a new Invalid token type exception.
     *
     * @param message the message
     */
    public InvalidTokenTypeException(final String message) {
        super(message);
        this.message = message;
    }
}
