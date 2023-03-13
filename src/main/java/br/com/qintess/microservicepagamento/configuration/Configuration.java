package br.com.qintess.microservicepagamento.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

//	private static final String USERNAME = "root";
//	private static final String PASSWORD = "";
//	private static final String URL = "jdbc:mysql//localhost:3306/microservice_pagamentos";

	@Bean

	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


	/*
	 * @Bean
	 * 
	 * public FluentConfiguration flyway() { FluentConfiguration conf =
	 * Flyway.configure().baselineVersion("init"); return conf; }
	 */

	// @Bean(name = "flywayInitializer")
	// public Flyway initFlyWay() {
	// Flyway flyway = Flyway.configure().dataSource(URL, USERNAME,
	// PASSWORD).load();
	// return flyway;
	// }

	// @Autowired(required = false)

	// private PagamentoRepository repository;

}
