package com.github.vlsidlyarevich.application.web.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

/**
 * Jwt configuration properties model.
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "security.jwt.aws")
public class JwtConfiguration {

    private String userPoolId;
    private String region;
    private String cognitoIdentityPoolUrl;
    private String cognitoIdentityPoolUrlSuffix;
    private String jwkUrl;
    private String userNameField;
    private String groupsField;
    private int connectionTimeout;
    private int readTimeout;

    /**
     * Gets jwk url.
     *
     * @return the jwk url
     */
    public String getJwkUrl() {
        if (StringUtils.isEmpty(jwkUrl)) {
            return String.format(cognitoIdentityPoolUrl + cognitoIdentityPoolUrlSuffix, region, userPoolId);
        } else {
            return jwkUrl;
        }
    }
}
