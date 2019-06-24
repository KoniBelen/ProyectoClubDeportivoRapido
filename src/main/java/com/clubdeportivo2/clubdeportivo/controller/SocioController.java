package com.clubdeportivo2.clubdeportivo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clubdeportivo2.clubdeportivo.model.CategoriaModel;
import com.clubdeportivo2.clubdeportivo.model.SocioModel;
import com.clubdeportivo2.clubdeportivo.service.SocioService;


@Controller
@RequestMapping(value="/socio")
public class SocioController {
	
	@Autowired
	private SocioService socioService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list",socioService.getAll()); 
		return "listarSocio";
	}
	
//----------------------------------------------------------------------
//		Crear
//----------------------------------------------------------------------
@RequestMapping("/save/{id}")
	public String showSave(@PathVariable ("id") Integer id , Model model) {
		if(id!=null && id!=0) {
			model.addAttribute("socio", socioService.get(id));
		}else {
			model.addAttribute("socio",new SocioModel());
		}
		return "save";
	}
	
//----------------------------------------------------------------------
// 		Guardar
//----------------------------------------------------------------------	

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("socio") SocioModel socio , BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("socio", socio);
			return "save";
		}
		socioService.save(socio);
		return "redirect:/socio/";
	} 
//----------------------------------------------------------------------	
	
	/*@GetMapping("/search/{valor}")
	public String search(@PathVariable("valor") String valor,Model model) {
		model.addAttribute("filteredList",socioService.findByNombreSocioLike("%"+valor+"%"));
		return "listarSocioFiltered";
	}*/
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		socioService.delete(id);
		return "redirect:/socio/";
		
	}
	@GetMapping("/get/{id}")
	public String get(@PathVariable("id") Integer id,Model model ) {
		if(id!=null && id!=0) {
			model.addAttribute("socioBuscado", socioService.get(id));
		}else {
			model.addAttribute("socioBuscado",new SocioModel());
		}
		return "verSocio";
	}

	@GetMapping("/search/{valor}")
	public String search(@PathVariable("valor") String valor,Model model) {
		model.addAttribute("filteredList",socioService.findByNombreSocio(valor));
		return "listarSocioFiltered";
	}
}
