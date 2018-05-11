package com.aim.recanto.CRUD.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Encomenda {

	@Id
    @GeneratedValue
    private Long id;
	
	@Column(nullable = false, length = 100)
    @NotNull(message = "Cliente é uma informação obrigatória.")
    private String cliente;
	
	@Column(nullable = false, length = 100)
    @NotNull(message = "Contato é uma informação obrigatória.")
    private String contato;
	
	@Column(nullable = false, length = 500)
    @NotNull(message = "Pedido é uma informação obrigatória.")
    private String pedido;
	
	@Column(nullable = false)
	@NotNull(message = "É necessário informar um valor.")
    private float valorPedido;
	

	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(float valorPedido) {
		this.valorPedido = valorPedido;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	
	
}
