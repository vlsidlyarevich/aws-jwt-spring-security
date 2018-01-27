package com.github.vlsidlyarevich.application.web.security.service.jwt;

import com.github.vlsidlyarevich.application.web.security.config.JwtConfiguration;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Implementation of {@link JwtUserService} based on AWS jwt.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AwsJwtUserService implements JwtUserService {

    private final JwtConfiguration configuration;

    @Override
    public User getUser(final JWTClaimsSet tokenClaims) {
        final String username = tokenClaims.getClaims().get(configuration.getUserNameField()).toString();

        if (Objects.nonNull(username)) {
            final List<String> groups = (List<String>) tokenClaims.getClaims().get(configuration.getGroupsField());
            final List<GrantedAuthority> grantedAuthorities
                    = convertList(groups, group -> new SimpleGrantedAuthority(group.toUpperCase()));

            return new User(username, "", grantedAuthorities);
        } else {
            throw new RuntimeException("Invalid token");
        }
    }

    private static <T, U> List<U> convertList(final List<T> from, final Function<T, U> func) {
        return from.stream().map(func).collect(Collectors.toList());
    }
}
