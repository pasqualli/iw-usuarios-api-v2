package br.com.innowise.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class IwUsuariosApiV2Application {

	public static void main(String[] args) {
		SpringApplication.run(IwUsuariosApiV2Application.class, args);
	}

}
