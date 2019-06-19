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
import com.clubdeportivo2.clubdeportivo.model.SocioModel;
import com.clubdeportivo2.clubdeportivo.service.SocioService;
import com.clubdeportivo2.clubdeportivo.model.CuotasModel;
import com.clubdeportivo2.clubdeportivo.service.CuotaService;



@Controller
@RequestMapping(value="/cuota")
public class CuotaController {
	
	@Autowired
	private CuotaService cuotaService;
	@Autowired
	private SocioService socioService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("listCuotas",cuotaService.getAll()); 
		return "listarCuotas";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable ("id") Integer id , Model model) {
		model.addAttribute("listSocio",socioService.getAll());
		if(id!=null && id!=0) {
			model.addAttribute("cuota", cuotaService.get(id));
		}else {
			model.addAttribute("cuota",new CuotasModel());
		}
		return "saveCuotas";
	}
	
	@PostMapping("/save")
	public String save(CuotasModel cuota, Model model) {
		//model.addAttribute("listDeporte",cuotaService.getAll());
		cuotaService.save(cuota);
		return "redirect:/cuota/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) {
		cuotaService.delete(id);
		return "redirect:/cuota/";
		
	}




}
