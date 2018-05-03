package com.aim.recanto.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aim.recanto.CRUD.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{ }
