package com.clubdeportivo2.clubdeportivo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	//esto no debería ocuparse
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("listTutor", tutorService.getAll());
		return "listarTutor";
	}

	@PostMapping("/save")
	public String save(TutorModel tutor, Model model) {
		tutorService.save(tutor);
		return "redirect:/socio/";
	}

	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable ("id") Integer id, Model model) {
		if(id!=null && id!=0)
			model.addAttribute("tutor", tutorService.get(id));
		else 
			model.addAttribute("tutor", new TutorModel());
		return "saveTutor";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		tutorService.delete(id);
		return "redirect:/tutor/";
	}


}
