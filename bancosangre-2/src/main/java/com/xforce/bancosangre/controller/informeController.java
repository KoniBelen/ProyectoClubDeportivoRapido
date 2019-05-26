package com.xforce.bancosangre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xforce.bancosangre.service.BolsaSangreServiceIML;
import com.xforce.bancosangre.service.DonanteServiceIML;
import com.xforce.bancosangre.service.IBolsaSangreService;
import com.xforce.bancosangre.service.IDonanteService;
import com.xforce.bancosangre.service.ISeccionService;
import com.xforce.bancosangre.service.SeccionServiceIML;
import com.xforce.bancosangre.model.Donante;
import com.xforce.bancosangre.persistence.DonanteDAO;

@Controller
public class informeController {

	@Autowired
	private ISeccionService secc;
	@Autowired
	private IBolsaSangreService bolsaService;
	@Autowired
	private IDonanteService don;

	@GetMapping("/lista")
	public String welcome(Model model) {
		int numeroBolsas = secc.obtenerNumeroDeBolsas();
		model.addAttribute("numeroBolsas", numeroBolsas);
		return "informe";
	}

	@RequestMapping(value = "/bolsasangre/numeroBolsas", method = RequestMethod.GET)
	public String obtenerNumeroDeBolsas(Model model) {
		int numeroBolsas = secc.obtenerNumeroDeBolsas();
		model.addAttribute("numeroBolsas", numeroBolsas);
		return "reporte";
	}

	@GetMapping("/listadonante")
	public String index(Model model) {

		model.addAttribute("donantes", don.findAll());
		return "listadonante";
	}
	@GetMapping("/listarbolsa")
	public String bolsa(Model model) {

		model.addAttribute("bolsa", bolsaService.findAll());
		return "listarbolsa";
	}

	@GetMapping(value = "/bolsasangre/detalleretiro")
	public String obtenerBolsasNoRetiradas(Model model) {
		int cantidadBolsasNoRetiradas = bolsaService.obtenerBolsasNoRetiradas();
		model.addAttribute("bolsasNoRetiradas", cantidadBolsasNoRetiradas);
		int cantidadBolsasRetiradas = bolsaService.obtenerBolsasRetiradas();
		model.addAttribute("bolsasRetiradas", cantidadBolsasRetiradas);
		return "informe";

	}
}
