package by.powerline.repzone.security.service;

import by.powerline.repzone.security.exception.InvalidTokenAuthenticationException;
import by.powerline.repzone.security.model.TokenPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;
import java.util.Objects;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 20.02.2018 23:04
 */
@Component
@RequiredArgsConstructor
public class AuthenticationHelper {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationHelper.class);

    @Value("${security.authentication.token.http_header}")
    private String AUTHENTICATION_TOKEN_HEADER;

    @Value("${security.authentication.token.expiration_time: 1000000000000000000}")
    private long AUTHENTICATION_TOKEN_EXPIRATION_TIME;

    @Value("${security.authentication.token.generation.secret}")
    private String AUTHENTICATION_TOKEN_GENERATION_SECRET;

    private final ObjectMapper objectMapper;

    public String generateToken(final Long userId) {
        try {
            TokenPayload payload = this.getPayload(userId);
            String token = this.objectMapper.writeValueAsString(payload);
            return JwtHelper.encode(
                    token,
                    new MacSigner(AUTHENTICATION_TOKEN_GENERATION_SECRET)
            ).getEncoded();
        } catch (JsonProcessingException e) {
            logger.error(String.format("Error generating token.\n%s", e));
            throw new InternalAuthenticationServiceException("Error generating token.", e);
        }
    }

    public TokenPayload decodeToken(final String token) {
        checkNotNullToken(token);
        Jwt jwt = JwtHelper.decode(token);
        JwtVerification(jwt);
        return getPayload(jwt);
    }

    private void JwtVerification(Jwt jwt) throws InvalidTokenAuthenticationException {
        try {
            jwt.verifySignature(new MacSigner(AUTHENTICATION_TOKEN_GENERATION_SECRET));
        } catch (Exception e) {
            logger.error("Token signature verification failure.");
            throw new InvalidTokenAuthenticationException("Token signature verification failure.", e);
        }
    }

    private void checkNotNullToken(final String token) throws InvalidTokenAuthenticationException {
        if (Objects.isNull(token)) {
            logger.error("Token is null or blank.");
            throw new InvalidTokenAuthenticationException("Token is null or blank.");
        }
    }

    private TokenPayload getPayload(Jwt jwt) throws InvalidTokenAuthenticationException {
        try {
            return this.objectMapper.readValue(jwt.getClaims(), TokenPayload.class);
        } catch (IOException e) {
            throw new InvalidTokenAuthenticationException("Token parsing failed.", e);
        }
    }

    private TokenPayload getPayload(final Long userId) {
        Long expirationTime = Instant.now().getEpochSecond() + AUTHENTICATION_TOKEN_EXPIRATION_TIME;
        return new TokenPayload(userId, expirationTime);
    }
}
