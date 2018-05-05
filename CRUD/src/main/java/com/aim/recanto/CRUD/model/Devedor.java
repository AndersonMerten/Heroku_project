package com.aim.recanto.CRUD.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
 
@Entity
public class Devedor{
 
 
    @Id
    @GeneratedValue
    private Long id;
     
    @Column(nullable = false, length = 100)
    @NotNull(message = "Nome é uma informação obrigatória.")
    private String nome;
     
	@Column(nullable = false)
	@NotNull(message = "É necessário informar um valor.")
    private float divida;
     
    @Column(nullable = false, length = 200)
    @NotNull(message = "Contato é uma informação obrigatória.")
    private String contato;
     
    @Column(length = 500)
    private String observacoes;
    
    
    

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

	public float getDivida() {
		return divida;
	}

	public void setDivida(float divida) {
		this.divida = divida;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

   
    
}