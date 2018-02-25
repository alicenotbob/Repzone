package by.powerline.repzone.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 20.02.2018 22:30
 */
public class InvalidTokenAuthenticationException extends AuthenticationException {

    public InvalidTokenAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public InvalidTokenAuthenticationException(String msg) {
        super(msg);
    }
}
