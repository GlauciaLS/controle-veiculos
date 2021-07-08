package io.github.glaucials.controleveiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ControleVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleVeiculosApplication.class, args);
	}

}
