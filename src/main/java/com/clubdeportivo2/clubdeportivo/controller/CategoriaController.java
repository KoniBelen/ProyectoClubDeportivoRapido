package com.clubdeportivo2.clubdeportivo.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clubdeportivo2.clubdeportivo.model.CategoriaModel;
import com.clubdeportivo2.clubdeportivo.service.CategoriaService;


@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list",categoriaService.getAll()); 
		return "index";
	}
	
	
	@PostMapping("/save")
	public String save(CategoriaModel categoria , Model model) {
		categoriaService.save(categoria);
		return "redirect:/";
	}
	
}
