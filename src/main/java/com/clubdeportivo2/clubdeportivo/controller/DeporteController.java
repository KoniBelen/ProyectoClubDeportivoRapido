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
import com.clubdeportivo2.clubdeportivo.model.DeporteModel;
import com.clubdeportivo2.clubdeportivo.model.SearchForm;
import com.clubdeportivo2.clubdeportivo.service.DeporteService;

@Controller
@RequestMapping(value = "/deporte")
public class DeporteController {

	@Autowired
	private DeporteService deporteService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("listDeporte", deporteService.getAll());
		model.addAttribute("form", new SearchForm());
		return "listarDeporte";
	}

	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("deporte") DeporteModel deporte, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("deporte", deporte);
			return "savedeporte";
		}
			deporteService.save(deporte);
			return "redirect:/deporte/";
	}

	@GetMapping("/save/{id}")
	public String showSave(@PathVariable ("id") Integer id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("deporte", deporteService.get(id));
		} else {
			model.addAttribute("deporte", new DeporteModel());
		}
		return "saveDeporte";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		deporteService.delete(id);
		return "redirect:/deporte/";
	}

	@GetMapping("/search")
	public String search(@ModelAttribute SearchForm form,Model model) {
		model.addAttribute("form", form);
		
		model.addAttribute("listDeporte",deporteService.findByNombreDeporteLike(form.getValue()));
		return "listarDeporte";
	}
	
	@GetMapping("/get/{id}")
	public String get(@PathVariable("id") Integer id,Model model ) {
		if(id!=null && id!=0) {
			model.addAttribute("deporteBuscado", deporteService.get(id));
		}else {
			model.addAttribute("deporteBuscado",new DeporteModel());
		}
		return "verDeporte";
	}
}
