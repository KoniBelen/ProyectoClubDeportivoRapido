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

import com.clubdeportivo2.clubdeportivo.model.SocioModel;
import com.clubdeportivo2.clubdeportivo.model.TutorModel;
import com.clubdeportivo2.clubdeportivo.service.SocioService;
import com.clubdeportivo2.clubdeportivo.service.TutorService;


@Controller
@RequestMapping(value = "/tutor")
public class TutorController {

	@Autowired
	private TutorService tutorService;
	@Autowired
	private SocioService socioService;
	
	SocioModel socio;
	
	//esto no debería ocuparse
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("listTutor", tutorService.getAll());
		return "listarTutor";
	}
	
	/**
	 * Guarda el tutor y redirige al formulario anterior*/

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("tutor") TutorModel tutor, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("tutor", tutor);
			return "saveTutor";
		}
		tutorService.save(tutor);
		socio.setTutor(tutor);
		socioService.save(socio);
		return "redirect:/socio/save/"+socio.getIdSocio();
	}

	/**
	 * Muestra el formulario para crear un tutor
	 * @param idSocio correspondiente al SOCIO para posteriormente poder asignar este tutor 
	 * y además poder redireccionar al formulario en el que se encontraba previamente*/
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable ("id") Integer idSocio, Model model) {
		socio = socioService.get(idSocio);
		model.addAttribute("tutor", new TutorModel());
		return "saveTutor";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		tutorService.delete(id);
		return "redirect:/tutor/";
	}


}
