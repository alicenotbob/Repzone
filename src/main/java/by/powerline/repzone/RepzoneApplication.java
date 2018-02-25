package by.powerline.repzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:application.properties", "classpath:custom.properties"})
public class RepzoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepzoneApplication.class, args);
	}
}
