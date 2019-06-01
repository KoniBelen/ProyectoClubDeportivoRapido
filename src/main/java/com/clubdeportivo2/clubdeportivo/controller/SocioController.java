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


@Controller
public class SocioController {
	
	@Autowired
	private SocioService socioService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list",socioService.getAll()); 
		return "index";
	}
	
	@GetMapping("/save/{id}")
	public String save(Integer id, Model model) {
		if(id!=null) {
			model.addAttribute("socio", socioService.get(id));
		}
		return "save";
	}
	
	@PostMapping("/save/")
	public String save(SocioModel socio, Model model) {
		socioService.save(socio);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		socioService.delete(id);
		return "redirect:/";
		
	}

}
