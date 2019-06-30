package com.clubdeportivo2.clubdeportivo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clubdeportivo2.clubdeportivo.model.EquipoModel;
import com.clubdeportivo2.clubdeportivo.model.SearchForm;
import com.clubdeportivo2.clubdeportivo.service.CategoriaService;
import com.clubdeportivo2.clubdeportivo.service.EquipoService;

@Controller
@RequestMapping(value="/equipo")
public class EquipoController {
	
	@Autowired
	private EquipoService equipoService;
	

	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("listEquipo",equipoService.getAll());
		model.addAttribute("form", new SearchForm());
		return "listarEquipo";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable ("id") Integer id , Model model) {
		model.addAttribute("listCategoria",categoriaService.getAll());
		model.addAttribute("listEquipo",equipoService.getAll());
		if(id!=null && id!=0) {
			model.addAttribute("equipo", equipoService.get(id));
		}else {
			model.addAttribute("equipo",new EquipoModel());
		}
		return "saveEquipo";
	}
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("equipo") EquipoModel equipo , BindingResult result, Model model) {
		model.addAttribute("listCategoria",categoriaService.getAll());
		if(result.hasErrors()) {
			model.addAttribute("equipo",equipo);
			return "saveEquipo";
		}
		equipoService.save(equipo);
		return "redirect:/equipo/";
	}
	
	@GetMapping("/search")
	public String search(@ModelAttribute SearchForm form,Model model) {
		model.addAttribute("form", form);
		
		model.addAttribute("listEquipo",equipoService.findByNombreEquipoLike(form.getValue()));
		return "listarEquipo";
	}
	
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