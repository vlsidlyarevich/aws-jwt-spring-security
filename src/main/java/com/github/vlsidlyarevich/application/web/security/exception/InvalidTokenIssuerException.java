package com.github.vlsidlyarevich.application.web.security.exception;

import lombok.Getter;

/**
 * Invalid token issuer exception.
 */
@Getter
public class InvalidTokenIssuerException extends RuntimeException {

    private String message;

    /**
     * Instantiates a new Invalid token issuer exception.
     *
     * @param message the message
     */
    public InvalidTokenIssuerException(final String message) {
        super(message);
        this.message = message;
    }
}
