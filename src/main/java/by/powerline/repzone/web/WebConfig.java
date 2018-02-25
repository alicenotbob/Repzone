package by.powerline.repzone.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 20.02.2018 20:24
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Value("${security.authentication.token.expiration_time: 1000000000000000000}")
    private long tokenExpirationTime;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(false)
                .maxAge(tokenExpirationTime);
    }
}
