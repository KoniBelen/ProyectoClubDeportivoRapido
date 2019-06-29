package com.clubdeportivo2.clubdeportivo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.context.annotation.Bean;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.clubdeportivo2.clubdeportivo.model.SocioModel;
import com.clubdeportivo2.clubdeportivo.service.SocioService;
import com.clubdeportivo2.clubdeportivo.model.CategoriaModel;
import com.clubdeportivo2.clubdeportivo.service.CategoriaService;
import com.clubdeportivo2.clubdeportivo.service.DeporteService;


@Controller
@RequestMapping(value="/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private DeporteService deporteService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list",categoriaService.getAll()); 
		return "listarCategoria";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable ("id") Integer id , Model model) {
		model.addAttribute("listDeporte",deporteService.getAll());
		if(id!=null && id!=0) {
			model.addAttribute("categoria", categoriaService.get(id));
		}else {
			model.addAttribute("categoria",new CategoriaModel());
		}
		return "saveCategoria";
	}
	/*
	@PostMapping("/save")
	public String save(CategoriaModel categoria, Model model) {
		model.addAttribute("listDeporte",deporteService.getAll());
		categoriaService.save(categoria);
		return "redirect:/categoria/";
	}*/
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("categoria") CategoriaModel categoria, BindingResult result, Model model) {
		model.addAttribute("listDeporte",deporteService.getAll());
		if(result.hasErrors()) {
			model.addAttribute("categoria", categoria);
			return "saveCategoria";
		}
		categoriaService.save(categoria);
		return "redirect:/categoria/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) {
		categoriaService.delete(id);
		return "redirect:/categoria/";
		
	}

	@GetMapping("/get/{id}")
	public String get(@PathVariable("id") Integer id,Model model ) {
		if(id!=null && id!=0) {
			model.addAttribute("categoriaBuscada", categoriaService.get(id));
		}else {
			model.addAttribute("categoriaBuscada",new CategoriaModel());
		}
		return "verCategoria";
	}
	
	@RequestMapping("/search/{nombre}")
	public String search(@PathVariable ("nombre")  String nombre, Model model) {
		model.addAttribute("filteredList", categoriaService.findByNombreCategoriaLike("%"+nombre+"%"));
		return "listarCategoriaFiltered";
	}
		
	


}
