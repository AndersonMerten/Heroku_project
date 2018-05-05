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
import com.aim.recanto.CRUD.model.Devedor;
import com.aim.recanto.CRUD.service.DevedorService;
 
@Controller
@RequestMapping("devedor")
public class DevedorController {
     
    @Autowired
    private DevedorService service;
     
    @GetMapping("/")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("devedor");
        mv.addObject("devedores", service.findAll());
         
        return mv;
    }
     
    @GetMapping("/add")
    public ModelAndView add(Devedor devedor) {
         
        ModelAndView mv = new ModelAndView("devedorAdd");
        mv.addObject("devedor", devedor);
         
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
    public ModelAndView save(@Valid Devedor devedor, BindingResult result) {
         
        if(result.hasErrors()) {
            return add(devedor);
        }
         
        service.save(devedor);
         
        return findAll();
    }
     
}
