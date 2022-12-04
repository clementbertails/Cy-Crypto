package fr.cytech.cy_crypto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CyCryptoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CyCryptoApplication.class, args);
	}
}
