package com.aim.recanto.CRUD.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aim.recanto.CRUD.service.DevedorService;
import com.aim.recanto.CRUD.service.EncomendaService;
import com.aim.recanto.CRUD.service.VendaService;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
    private VendaService Vservice;
	@Autowired
	private DevedorService Dservice;
	@Autowired
	private EncomendaService Eservice;
	
	 @GetMapping("/")
	    public ModelAndView findAll() {
	         
	        ModelAndView mv = new ModelAndView("index");
	        mv.addObject("qtdDevedores", Dservice.contDevedores());
	        mv.addObject("totalDivida", Dservice.totalDevido()); 
	        mv.addObject("qtdEncomendas", Eservice.contEncomenda());
	        mv.addObject("hoje", Vservice.getDateToday());
	        mv.addObject("totalVendas", Vservice.getVendasDia(new Date()));
	        return mv;
	    }

}
