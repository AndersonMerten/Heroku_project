package com.aim.recanto.CRUD.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aim.recanto.CRUD.model.Venda;
import com.aim.recanto.CRUD.repository.VendaRepository;

@Service
public class VendaService {

	 @Autowired
	    private VendaRepository repository;
	     
	    public List<Venda> findAll() {
	        return repository.findAll();
	    }
	     
	    public Venda findOne(Long id) {
	        return repository.getOne(id);
	    }
	     
	    public Venda save(Venda venda) {
	        return repository.saveAndFlush(venda);
	    }
	     
	    public void delete(Long id) {
	        repository.deleteById(id);
	    }
	    
	    public String getDateToday() {
	    	Date today = new Date();
	    	return (today.getDate()) +"/"+ (today.getMonth()+1) +"/"+ (today.getYear()+1900);
	    }
	    
	    public int getVendasDia(Date data) {
	    	List<Venda> vendas = repository.findAll();
	    	int valorVendas = 0;
	    	for (Venda venda : vendas) {
	    		if(venda.getData().getDay() == data.getDay() && venda.getData().getMonth() == data.getMonth()) {
	    			valorVendas += venda.getValor();
	    		}
				
			}
	    	return valorVendas;
	    }
	
	    
}
