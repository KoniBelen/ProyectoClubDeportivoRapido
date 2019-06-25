package com.clubdeportivo2.clubdeportivo.controller;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.context.annotation.Bean;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.clubdeportivo2.clubdeportivo.model.EquipoModel;
import com.clubdeportivo2.clubdeportivo.service.EquipoService;
import com.clubdeportivo2.clubdeportivo.model.RecursoModel;
import com.clubdeportivo2.clubdeportivo.service.RecursoService;


/*
@Controller
@RequestMapping(value="/recurso")
public class RecursoController {
	
	@Autowired
	private RecursoService recursoService;
	@Autowired
	private EquipoService equipoService;
	
	//Funcionalidad listar
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("listRecursos",recursoService.getAll()); 
		return "listarRecursos";
	}
	
	/*Funcionalidad Modificar*/
/*AQUI
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable ("id") Integer id , Model model) {
		model.addAttribute("listEquipo",equipoService.getAll());
		if(id!=null && id!=0) {
			model.addAttribute("recurso", recursoService.get(id));
		}else {
			model.addAttribute("recurso",new RecursoModel());
		}
		return "saveRecursos";
	}
	
	
	//Funcionalidad ingresar
	@PostMapping("/save")
	public String save(RecursoModel recurso, Model model) {
		recursoService.save(recurso);
		return "redirect:/recurso/";
	}
	
	//Funcionalidad eliminar
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) {
		recursoService.delete(id);
		return "redirect:/recurso/";
		
	}
	
	//Funcionalidad Ver
	@GetMapping("/get/{id}")
	public String get(@PathVariable("id") Integer id,Model model ) {
		if(id!=null && id!=0) {
			model.addAttribute("recursoBuscado", recursoService.get(id));
		}else {
			model.addAttribute("recusoBuscado",new RecursoModel());
		}
		return "verRecurso";
	}




}
*/