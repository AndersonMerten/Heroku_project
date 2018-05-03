package com.aim.recanto.CRUD.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aim.recanto.CRUD.model.Venda;
import com.aim.recanto.CRUD.service.VendaService;

@Controller
@RequestMapping("venda")
public class VendaController {
	
	@Autowired
    private VendaService service;
     
    @GetMapping("/")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("venda");
        mv.addObject("vendas", service.findAll());
         
        return mv;
    }
     
    @GetMapping("/add")
    public ModelAndView add(Venda venda) {
         
        ModelAndView mv = new ModelAndView("vendaAdd");
        mv.addObject("venda", venda);
         
        return mv;
    }
     
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
         
        return add(service.findOne(id));
    }
     
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
         
        service.delete(id);
         
        return findAll();
    }
 
    @PostMapping("/save")
    public ModelAndView save(@Valid Venda venda, BindingResult result) {
         
        if(result.hasErrors()) {
            return add(venda);
        }
         
        service.save(venda);
         
        return findAll();
    }

}
