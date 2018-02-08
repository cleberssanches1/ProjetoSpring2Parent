package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sanches.security.utils.SenhaUtils;

@SpringBootApplication
public class DemoApplication {

	@Value("${paginacao_qtd_por_pagina}")
	private int qtdPaginas;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Quantidade de linhas por página: " + qtdPaginas);
			
			login();
		};
	}

	private void login() {

		String senhaParam = "123456";

		String senhaHash = SenhaUtils.gerarBCriptString(senhaParam);
		System.out.println(senhaHash);

		String senhaHash2 = SenhaUtils.gerarBCriptString(senhaParam);
		System.out.println(senhaHash);

		boolean validade = SenhaUtils.senhaValida("123456", senhaHash2);

		System.out.println(validade ? "Senha válida!" : "Senha inválida!");

	}

}
