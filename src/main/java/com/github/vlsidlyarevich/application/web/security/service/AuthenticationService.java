package com.github.vlsidlyarevich.application.web.security.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * Service providing {@link Authentication} by {@link HttpServletRequest}.
 */
public interface AuthenticationService {

    /**
     * Get {@link Authentication} by {@link HttpServletRequest}.
     *
     * @param request the request
     * @return the authentication
     */
    Authentication authenticate(HttpServletRequest request);
}
