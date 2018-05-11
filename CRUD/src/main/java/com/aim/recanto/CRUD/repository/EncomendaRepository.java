package com.aim.recanto.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aim.recanto.CRUD.model.Encomenda;;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, Long>{ }
