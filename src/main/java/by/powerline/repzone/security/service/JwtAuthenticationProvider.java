package by.powerline.repzone.security.service;

import by.powerline.repzone.model.db.User;
import by.powerline.repzone.repository.UserRepository;
import by.powerline.repzone.security.exception.InvalidTokenAuthenticationException;
import by.powerline.repzone.security.model.JwtAuthenticationToken;
import by.powerline.repzone.security.model.JwtUserDetails;
import by.powerline.repzone.security.model.TokenPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 21.02.2018 1:26
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final AuthenticationHelper authenticationHelper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenPayload tokenPayload = getAndDeserializeToken(authentication);
        validateTokenPayload(tokenPayload);
        User user = this.userRepository.findOne(tokenPayload.getUserId());
        checkNotNull(user, "Token does not contain a user id.");
        return new JwtAuthenticationToken(new JwtUserDetails(user));
    }

    private TokenPayload getAndDeserializeToken(Authentication authentication) {
        String token = StringUtils.trimToNull((String) authentication.getCredentials());
        return authenticationHelper.decodeToken(token);
    }

    private void validateTokenPayload(TokenPayload tokenPayload) {
        checkNotNull(tokenPayload.getUserId(), "Token does not contain a user id.");
    }

    private void checkNotNull(Object value, String badCauseMessage) {
        if (Objects.isNull(value)) {
            throw new InvalidTokenAuthenticationException(badCauseMessage);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
