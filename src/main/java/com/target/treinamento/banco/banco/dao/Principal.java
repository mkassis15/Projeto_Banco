package com.target.treinamento.banco.banco.dao;

import java.util.List;

public class Principal {

	public static void main(String[] args) {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		List<Funcionario> funcionarios = funcionarioDAO.buscarTodos();

		for (Funcionario func : funcionarios) {
			
			System.out.println(func);
		}

	}
}
