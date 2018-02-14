package com.sanches.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sanches.application.entyties.Empresa;
import com.sanches.application.repository.EmpresaRepository;
import com.sanches.application.security.utils.SenhaUtils;

@SpringBootApplication(scanBasePackages={
		"com.sanches.repository"})
public class DemoApplication {

	@Autowired	
	private EmpresaRepository empresaRepository;

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

		persistirDados(); 
	}

	private void persistirDados() {
		Empresa empresa = new Empresa();
		empresa.setCnpj("30039779890");
		empresa.setRazaoSocial("Cleber S.A.>");

		this.empresaRepository.save(empresa);

		List<Empresa> empresas = this.empresaRepository.findAll();

		empresas.forEach(System.out::println);

		empresa = this.empresaRepository.findByCnpj("30039779890");

		System.out.println(empresa);
	}

}
