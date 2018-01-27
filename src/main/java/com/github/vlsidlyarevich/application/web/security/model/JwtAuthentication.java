package com.github.vlsidlyarevich.application.web.security.model;

import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Jwt authentication that extends spring security {@link AbstractAuthenticationToken}.
 */
public class JwtAuthentication extends AbstractAuthenticationToken {

    private static final long serialVersionUID = -1026881493144309417L;

    private final Object principal;
    private JWTClaimsSet jwtClaimsSet;

    /**
     * Instantiates a new Jwt authentication.
     *
     * @param principal    the principal
     * @param jwtClaimsSet the jwt claims set
     * @param authorities  the authorities
     */
    public JwtAuthentication(final Object principal, final JWTClaimsSet jwtClaimsSet,
                             final Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.jwtClaimsSet = jwtClaimsSet;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    /**
     * Gets jwt claims set.
     *
     * @return the jwt claims set
     */
    public JWTClaimsSet getJwtClaimsSet() {
        return jwtClaimsSet;
    }
}
