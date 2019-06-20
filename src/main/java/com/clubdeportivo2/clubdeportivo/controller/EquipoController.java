package com.clubdeportivo2.clubdeportivo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clubdeportivo2.clubdeportivo.model.EquipoModel;
import com.clubdeportivo2.clubdeportivo.service.EquipoService;

@Controller
@RequestMapping(value="/equipo")
public class EquipoController {
	
	@Autowired
	private EquipoService equipoService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list",equipoService.getAll()); 
		return "listarEquipo";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable ("id") Integer id , Model model) {
		model.addAttribute("listEquipos",equipoService.getAll());
		if(id!=null && id!=0) {
			model.addAttribute("equipo", equipoService.get(id));
		}else {
			model.addAttribute("equipo",new EquipoModel());
		}
		return "saveEquipo";
	}
	@PostMapping("/save")
	public String save(EquipoModel equipo , Model model) {
		equipoService.save(equipo);
		return "redirect:/equipo/";
	}
	
	/*
	@GetMapping("/search/{valor}")
	public String search(@PathVariable("valor") String valor,Model model) {
		model.addAttribute("filteredList",equipoService.findByNombreEquipoLike("%"+valor+"%"));
		return "listarEquipoFiltered";
	}
	*/
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		equipoService.delete(id);
		return "redirect:/equipo/";
		
	}
	@GetMapping("/get/{id}")
	public String get(@PathVariable("id") Integer id,Model model ) {
		if(id!=null && id!=0) {
			model.addAttribute("equipoBuscado", equipoService.get(id));
		}else {
			model.addAttribute("equipoBuscado",new EquipoModel());
		}
		return "verEquipo";
	}

}
