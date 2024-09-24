package com.example.atribuicao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AtribuicaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtribuicaoApplication.class, args);
	}

}
