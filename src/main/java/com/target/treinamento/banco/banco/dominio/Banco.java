package com.target.treinamento.banco.banco.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BANCOS")
public class Banco {

	
	@Id
	@Column(name="ID")
	@SequenceGenerator(name="bancoSeqGen", sequenceName="bancoSeqGen", allocationSize=1)
	@GeneratedValue(generator="bancoSeqGen")
	private Long id;
	
	
	@Column(name="NOME")
	public String nome;
	
	@OneToMany
	private List<Funcionario> funcionarios;

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

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
}
	
	