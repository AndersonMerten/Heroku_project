package com.aim.recanto.CRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.aim.recanto.CRUD.model.Devedor;
import com.aim.recanto.CRUD.repository.DevedorRepository;

@Service
public class DevedorService {
     
    @Autowired
    private DevedorRepository repository;
     
    public List<Devedor> findAll() {
        return repository.findAll();
    }
     
    public Devedor findOne(Long id) {
        return repository.getOne(id);
    }
     
    public Devedor save(Devedor devedor) {
        return repository.saveAndFlush(devedor);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }
}