package com.xforce.bancosangre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xforce.bancosangre.model.BolsaSangre;
import com.xforce.bancosangre.model.Donante;

import com.xforce.bancosangre.service.DonanteServiceIML;
import com.xforce.bancosangre.service.IBolsaSangreService;

@RestController
@Controller
@RequestMapping(value= "/donantes")
public class DonanteController {

	@Autowired
	private DonanteServiceIML donanteService;
	
	//Listar todos los Donantes
	@GetMapping(value ="/listardonantes", produces = {"application/json"})
	public ResponseEntity< List<Donante>> listar(){
		List<Donante>lista = donanteService.findAll();
    	if (lista.isEmpty()) {
			return new ResponseEntity<List<Donante>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Donante>>(lista, HttpStatus.OK); 
	}
	
	//Listar Donantes por Rut
	@GetMapping(value="/listardonantes/{rut}")
	//@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Donante> mostrar(@PathVariable String rut) {
		
		Donante donante = donanteService.findOne(rut);
		if (donante == null) {
			return new ResponseEntity<Donante>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Donante>(donante, HttpStatus.OK);  	
	}
	
	//Agregar un Donante
	@PostMapping (value= "/ingresardonante")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Donante> ingresar(@RequestBody Donante donante) {
		
		if (donanteService.exists(donante.getRutDonante())!=false) {
			return new ResponseEntity<Donante>(HttpStatus.NOT_ACCEPTABLE);
		}
		donanteService.save(donante);
		return new ResponseEntity<Donante>(donante, HttpStatus.CREATED);  
	}
	
	//Actualizar un Donante
	@PutMapping(value="/actualizardonante/{rut}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Donante> update(@RequestBody Donante donante, @PathVariable String rut) {
		
		Donante donanteActual = donanteService.findOne(rut);

		if (donanteActual == null) {
			return new ResponseEntity<Donante>(HttpStatus.NOT_FOUND);
		} 
		donanteActual.setNombreDonante(donante.getNombreDonante());
		donanteActual.setApellidoDonante(donante.getApellidoDonante());
		donanteActual.setDireccionDonante(donante.getDireccionDonante());
		donanteActual.setTipoSangreDonante(donante.getTipoSangreDonante());
		donanteActual.setfNacimientoDonante(donante.getfNacimientoDonante());
		donanteService.save(donanteActual);
		return new ResponseEntity<Donante>(donanteActual, HttpStatus.ACCEPTED);
	}
	
	//Eliminar un Donante
	@DeleteMapping(value= "/delete/{rut}")
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> delete(@PathVariable String rut) {
		
		Donante donanteActual = donanteService.findOne(rut);
    	if (donanteActual == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
    	donanteService.delete(rut);
    	return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}