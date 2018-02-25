package by.powerline.repzone.security.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 20.02.2018 22:37
 */
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Value("${security.access.denied.message}")
    private String accessDeniedMessage;

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedMessage);
    }
}
