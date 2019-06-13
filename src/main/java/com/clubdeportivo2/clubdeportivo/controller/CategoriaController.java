package com.clubdeportivo2.clubdeportivo.controller;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.context.annotation.Bean;


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
@RequestMapping(value="/categoria")
public class CategoriaController {
	
	@Autowired
	private SocioService socioService;
	private CategoriaService categoriaService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list",categoriaService.getAll()); 
		return "index";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable ("id") Integer id , Model model) {
		if(id!=null && id!=0) {
			model.addAttribute("categoria", categoriaService.get(id));
		}else {
			model.addAttribute("categoria",new CategoriaModel());
		}
		return "save";
	}
	
	@PostMapping("/save")
	public String save(CategoriaModel categoria , Model model) {
		categoriaService.save(categoria);
		return "redirect:/categoria/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		categoriaService.delete(id);
		return "redirect:/";
		
	}

	@RequestMapping("/search/{nombre}")
	public String search(@PathVariable ("nombre")  String nombre, Model model) {
		model.addAttribute("list", categoriaService.findByNombreCategoria(nombre));
		return "index";
	}
		
	


}
