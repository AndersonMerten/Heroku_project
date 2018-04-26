package com.br.catolicasc.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.catolicasc.springboot.model.Contato;

public interface Contatos extends JpaRepository<Contato, Long> {

	// Spring Data JPA faz a implementação da interface sozinho.
}
