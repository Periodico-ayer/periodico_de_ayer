package com.periodico.newspaper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
public class NewspaperApplication {

	public static void main(String[] args) {
		Dotenv dotenv= Dotenv.configure().load();
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_NAME", dotenv.get("DB_NAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

		SpringApplication.run(NewspaperApplication.class, args);
		System.out.println("Connected Successfully");
	}

}
