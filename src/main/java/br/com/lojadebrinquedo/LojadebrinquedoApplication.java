package br.com.lojadebrinquedo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.lojadebrinquedo")
public class LojadebrinquedoApplication {
	public static void main(String[] args) {
		SpringApplication.run(LojadebrinquedoApplication.class, args);
	}
}

