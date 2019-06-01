package com.clubdeportivo2.clubdeportivo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clubdeportivo2.clubdeportivo.model.DeporteModel;
import com.clubdeportivo2.clubdeportivo.model.SocioModel;
import com.clubdeportivo2.clubdeportivo.service.DeporteService;

@Controller
@RequestMapping(value="/deporte")
public class DeporteController {

@Autowired 
private DeporteService deporteService;

	@PostMapping("/create/")
	public String save(DeporteModel deporte, Model model) {
		deporteService.save(deporte);
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String save(Integer id, Model model) {
		if(id!=null) {
			model.addAttribute("deporte", deporteService.get(id));
		}
		return "save";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		deporteService.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping("/search/{id}")
	public String search(@PathVariable Integer id, Model model) {
		model.addAttribute("elDeporte",deporteService.get(id)); 
		return "index";
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list",deporteService.getAll()); 
		return "index";
	}
	
}
