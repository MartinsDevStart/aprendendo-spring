package com.martins.aprendendospring;

import com.martins.aprendendospring.infrastructure.entity.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AprendendoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AprendendoSpringApplication.class, args);

		Usuario pedro = new Usuario();
		pedro.setNome("Pedro Martins");
		pedro.setEmail("pedrinho@gmail.com");
		pedro.setSenha("12345");

		System.out.println(pedro.getEmail());
	}

}
