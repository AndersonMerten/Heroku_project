package com.aim.recanto.CRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aim.recanto.CRUD.model.Encomenda;
import com.aim.recanto.CRUD.repository.EncomendaRepository;

@Service
public class EncomendaService {
	
	@Autowired
    private EncomendaRepository repository;
     
    public List<Encomenda> findAll() {
        return repository.findAll();
    }
     
    public Encomenda findOne(Long id) {
        return repository.getOne(id);
    }
     
    public Encomenda save(Encomenda encomenda) {
        return repository.saveAndFlush(encomenda);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public int contEncomenda() {
    	return repository.findAll().size();
    }
}
