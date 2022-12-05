package fr.cytech.cy_crypto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class CyCryptoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CyCryptoApplication.class, args);
	}
}
