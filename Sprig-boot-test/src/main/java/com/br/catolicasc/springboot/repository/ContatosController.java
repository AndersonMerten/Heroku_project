package com.br.catolicasc.springboot.repository;

import com.br.catolicasc.springboot.model.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController("/contatos")
public class ContatosController {
	@Autowired
	private Contatos contatos;

	@GetMapping
	public ModelAndView listar() {
		List<Contato> lista = contatos.findAll();

		ModelAndView modelAndView = new ModelAndView("contatos");
		modelAndView.addObject("contatos", lista);

		return modelAndView;
	}
}
