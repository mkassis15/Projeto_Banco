package com.target.treinamento.banco.banco.dao;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity //eu sou uma persistence class
@Table(name = "FUNCIONARIOS") // quero que crie uma tabela ou mapeie essa tabela com este nome.

public class Funcionario {
	
	@Id
	@Column(name="ID")
	@SequenceGenerator(name = "geradorDeId", sequenceName= "funcionarios_id_seq", allocationSize=5)
	@GeneratedValue(generator="geradorDeId")
	
	private Long id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="CARGO")
	private Integer cargo;
	
	@Column(name="IDADE")
	private Integer idade;
	
	@Column(name="SALARIO")
	private Double salario;
	
	@Column(name="DATA_INCLUSAO")
	@Temporal(TemporalType.DATE)
	private Calendar dataInclusao;
	
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cargo=" + cargo + ", idade=" + idade + ", salario="
				+ salario + ", dataInclusao=" + dataInclusao + "]";
	}

	public Funcionario(Long id, String nome, Integer cargo, Integer idade, Double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.idade = idade;
		this.salario = salario;
	}
	
	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCargo() {
		return cargo;
	}

	public void setCargo(Integer cargo) {
		this.cargo = cargo;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idade == null) {
			if (other.idade != null)
				return false;
		} else if (!idade.equals(other.idade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}
}
