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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clubdeportivo2.clubdeportivo.commons.GenericService;
import com.clubdeportivo2.clubdeportivo.model.CategoriaModel;
import com.clubdeportivo2.clubdeportivo.model.SearchForm;
import com.clubdeportivo2.clubdeportivo.model.SocioModel;
import com.clubdeportivo2.clubdeportivo.service.CategoriaService;
import com.clubdeportivo2.clubdeportivo.service.SocioService;
import com.clubdeportivo2.clubdeportivo.service.TutorService;

import javassist.expr.NewArray;


@Controller
@RequestMapping(value="/socio")
public class SocioController {
	
	@Autowired
	private SocioService socioService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private TutorService tutorService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list",socioService.getAll()); 
		model.addAttribute("form", new SearchForm());
		return "listarSocio";
	}
	
//----------------------------------------------------------------------
//		Crear
//----------------------------------------------------------------------
@RequestMapping("/save/{id}")
	public String showSave(@PathVariable ("id") Integer id , Model model) {
		model.addAttribute("listCategorias",categoriaService.getAll());
		model.addAttribute("listTutor", tutorService.getAll());
		if(id!=null && id!=0) {
			model.addAttribute("socio", socioService.get(id));
		}else {
			model.addAttribute("socio",new SocioModel());
		}
		return "saveSocio";
	}

	
//----------------------------------------------------------------------
// 		Guardar
//----------------------------------------------------------------------	

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("socio") SocioModel socio , BindingResult result, Model model) {
		model.addAttribute("listCategorias",categoriaService.getAll());
		model.addAttribute("listTutor", tutorService.getAll());
		if(result.hasErrors()) {
			model.addAttribute("socio", socio);
			return "saveSocio";
		}

		socioService.save(socio);
		return "redirect:/socio/";
	} 
//----------------------------------------------------------------------	
	
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

	@GetMapping("/search")
	public String search(@ModelAttribute SearchForm form,Model model) {
		model.addAttribute("form", form);
		
		model.addAttribute("list",socioService.findByNombreSocioLike(form.getValue()));
		return "listarSocio";
	}

}
