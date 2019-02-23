package com.target.treinamento.banco.banco.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.target.treinamento.banco.banco.FabricaDeConexao;
import com.target.treinamento.banco.banco.LogManager;

public class FuncionarioDAO {

	public void criar(Funcionario funcionario) {

		FabricaDeConexao conexao = new FabricaDeConexao();

		try {
			conexao.abreConexao();

			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO funcionarios");
			sb.append("(nome, cargo, idade, salario)");
			sb.append("VALUES (?, ?, ?, ?)");

			PreparedStatement ps = conexao.getPreparedStatement(sb.toString());

			ps.setString(1, funcionario.getNome());
			ps.setInt(2, funcionario.getCargo());
			ps.setInt(3, funcionario.getIdade());
			ps.setDouble(4, funcionario.getSalario());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
			// TODO: handle finally clause
		}

		try {

			conexao.abreConexao();

			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE funcionarios");
			sb.append("SET id=?, nome=?, cargo=?, idade=?, salario=?");
			sb.append("WHERE <condition>");

			PreparedStatement ps = conexao.getPreparedStatement(sb.toString());

			ps.setString(1, funcionario.getNome());
			ps.setInt(2, funcionario.getCargo());
			ps.setInt(3, funcionario.getIdade());
			ps.setDouble(4, funcionario.getSalario());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
		}

	}

	public List<Funcionario> buscarTodos() {
		FabricaDeConexao conexao = new FabricaDeConexao();
		List<Funcionario> funcionariosLista = new ArrayList<Funcionario>();

		try {
			conexao.setLogManager(new LogManager());
			conexao.abreConexao();

			PreparedStatement ps = conexao
					.getPreparedStatement("SELECT id, nome, cargo, idade, salario FROM funcionarios");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				Funcionario f = new Funcionario();
				f.setId(resultSet.getLong("ID"));
				f.setNome(resultSet.getString("NOME"));
				f.setCargo(resultSet.getInt("CARGO"));
				f.setIdade(resultSet.getInt("IDADE"));
				f.setSalario(resultSet.getDouble("SALARIO"));

				funcionariosLista.add(f);
				

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
			// TODO: handle finally clause
		}

		return funcionariosLista;

	}
}
