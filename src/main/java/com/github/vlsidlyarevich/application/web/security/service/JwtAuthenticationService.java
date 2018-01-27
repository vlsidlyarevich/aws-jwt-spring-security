package com.github.vlsidlyarevich.application.web.security.service;

import com.github.vlsidlyarevich.application.web.security.model.JwtAuthentication;
import com.github.vlsidlyarevich.application.web.security.service.jwt.JwtProcessor;
import com.github.vlsidlyarevich.application.web.security.service.jwt.JwtUserService;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;

/**
 * Jwt based implementation of {@link AuthenticationService}.
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JwtAuthenticationService implements AuthenticationService {

    @Value("${security.jwt.auth-header-name}")
    private String authHeaderName;

    private final JwtUserService jwtUserService;
    private final JwtProcessor jwtProcessor;

    @Override
    public Authentication authenticate(final HttpServletRequest request) {
        final String token = request.getHeader(authHeaderName);
        final Optional<JWTClaimsSet> tokenClaims = parseToken(token);

        return tokenClaims.map(this::getAuthenticationFromTokenClaims).orElse(null);
    }

    private Optional<JWTClaimsSet> parseToken(final String token) {
        if (Objects.nonNull(token)) {
            return Optional.ofNullable(jwtProcessor.processJwt(token));
        } else {
            return Optional.empty();
        }
    }

    private JwtAuthentication getAuthenticationFromTokenClaims(final JWTClaimsSet tokenClaims) {
        final User user = jwtUserService.getUser(tokenClaims);
        return new JwtAuthentication(user, tokenClaims, user.getAuthorities());
    }
}
