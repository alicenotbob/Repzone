package by.powerline.repzone;

import by.powerline.repzone.security.SecurityConfig;
import by.powerline.repzone.web.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:application.properties", "classpath:custom.properties"})
public class RepzoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepzoneApplication.class, args);
	}
}
