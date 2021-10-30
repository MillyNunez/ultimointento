package co.usa.mnnq.mnnq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan(basePackages = {"co.usa.mnnq.mnnq.model"})
@SpringBootApplication
public class MnnqApplication {

	public static void main(String[] args) {
		SpringApplication.run(MnnqApplication.class, args);
	}

}
