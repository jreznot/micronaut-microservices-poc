package pl.altkom.asc.lab.micronaut.poc.auth;

import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;

import java.util.Collection;

class CustomBearerAccessRefreshToken extends BearerAccessRefreshToken {

    private String avatar;

    CustomBearerAccessRefreshToken(String username,
                                   Collection<String> roles,
                                   Integer expiresIn,
                                   String accessToken,
                                   String refreshToken,
                                   String tokenType,
                                   String avatar) {
        super(username, roles, expiresIn, accessToken, refreshToken, tokenType);
        this.avatar = avatar;
    }

    public CustomBearerAccessRefreshToken() {
    }

    public String getAvatar() {
        return this.avatar;
    }
}
