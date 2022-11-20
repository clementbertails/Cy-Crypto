package fr.bertailslasgleizes.cy_crypto;

import javax.annotation.processing.Generated;
import javax.swing.Spring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CyCrypto {

	public static void main(String[] args) {
		SpringApplication.run(CyCrypto.class, args);
	}

	public String hello(){
		return "Hello Word !";
	}
}
