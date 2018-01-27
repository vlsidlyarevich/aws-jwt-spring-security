package com.github.vlsidlyarevich.application.web.security.service.jwt;

import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.security.core.userdetails.User;

/**
 * Service for obtaining {@link User} from jwt payload.
 */
public interface JwtUserService {

    /**
     * Gets user from token payload.
     *
     * @param tokenClaims the token claims
     * @return the user
     */
    User getUser(JWTClaimsSet tokenClaims);
}
