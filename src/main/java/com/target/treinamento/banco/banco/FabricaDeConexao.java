package com.target.treinamento.banco.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FabricaDeConexao {

	public Connection getConexao() {
		return null;

	}

	public PreparedStatement getPreparedStatement(String sql) {
		return null;
	}
	
	public void fechaConexao() {
		
	}
}
