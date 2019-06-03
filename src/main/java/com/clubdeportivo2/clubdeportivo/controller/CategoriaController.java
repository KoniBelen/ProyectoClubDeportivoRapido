package com.clubdeportivo2.clubdeportivo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clubdeportivo2.clubdeportivo.model.SocioModel;
import com.clubdeportivo2.clubdeportivo.service.SocioService;
import com.clubdeportivo2.clubdeportivo.model.CategoriaModel;
import com.clubdeportivo2.clubdeportivo.service.CategoriaService;


@Controller
public class CategoriaController {
	
	@Autowired
	private SocioService socioService;
	private CategoriaService categoriaService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list",socioService.getAll()); 
		return "index";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		socioService.delete(id);
		return "redirect:/";
		
	}
	
	@RequestMapping("/serach/{id}")
	public String search(@PathVariable Integer id, Model model) {
		model.addAttribute("laCategoria", categoriaService.get(id));
		return "index";
	}
		
	

}
