package by.powerline.repzone.security;

import by.powerline.repzone.exception.auth.AuthenticationFailedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 25.02.2018 23:04
 */
public class SecurityHelper {
    public static Authentication getAuthenticationWithCheck() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean checkAuthenticationExist = authentication != null && authentication.isAuthenticated();
        if (checkAuthenticationExist) {
            return authentication;
        }
        throw new AuthenticationFailedException("Authentication failed.");
    }
}
