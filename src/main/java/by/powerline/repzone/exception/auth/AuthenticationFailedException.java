package by.powerline.repzone.exception.auth;

import org.springframework.security.core.AuthenticationException;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 25.02.2018 23:03
 */
public class AuthenticationFailedException extends AuthenticationException {
    public AuthenticationFailedException(String msg, Throwable t) {
        super(msg, t);
    }

    public AuthenticationFailedException(String msg) {
        super(msg);
    }
}
