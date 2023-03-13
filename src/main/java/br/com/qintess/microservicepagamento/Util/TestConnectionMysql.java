package br.com.qintess.microservicepagamento.Util;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnectionMysql {

	private static final String URL = "jdbc:mysql://localhost:3306/microservice_pagamentos";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	public static String testConnection(String username, String password, String url) throws SQLException, Exception {
		boolean isConected = false;

		java.sql.Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		if (con != null) {
			isConected = true;
			return "Conectado!";
		} else {
			return "Erro";
		}
	}

	public static void main(String args[]) throws SQLException, Exception {
		System.out.println(TestConnectionMysql.testConnection(USERNAME, PASSWORD, URL));
	}
}
