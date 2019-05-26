package com.xforce.bancosangre.controller;



import com.xforce.bancosangre.service.IBolsaSangreService;
import com.xforce.bancosangre.service.SeccionServiceIML;
import com.xforce.bancosangre.model.BolsaSangre;
import com.xforce.bancosangre.model.Seccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xforce.bancosangre.service.BolsaSangreServiceIML;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.*;


@RestController
@Controller
@RequestMapping(value = "/bolsadesangre")
public class BolsaSangreController{

    @Autowired
    private BolsaSangreServiceIML bolsaService;
    @Autowired 
    private SeccionServiceIML secc;


//listar todos
    @GetMapping(value = "/listarbolsa", produces = {"application/json"})
    public ResponseEntity<List<BolsaSangre>> listar(){
    	List<BolsaSangre>lista = bolsaService.findAll();
    	if (lista.isEmpty()) {
			return new ResponseEntity<List<BolsaSangre>>(HttpStatus.NOT_FOUND);
		}
    	
		return new ResponseEntity<List<BolsaSangre>>(lista, HttpStatus.OK); 
    }
    //listar por ID
    @GetMapping(value="/bolsasangre/listarbolsa/{id}")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BolsaSangre> mostrar(@PathVariable int id) {
    	BolsaSangre bolsa = null;
		bolsa = bolsaService.findOne(id);
		if (bolsa == null) {
			return new ResponseEntity<BolsaSangre>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BolsaSangre>(bolsa, HttpStatus.OK);  	
    }
    
    //crear
   
    @PostMapping(value = "/bolsasangre/crear")
   // @ResponseStatus(HttpStatus.CREATED)
    public  ResponseEntity<BolsaSangre> create(  @RequestBody BolsaSangre bolsasangre,BindingResult bindingResult) {

    	if (bolsasangre.getFechaSalida() != null) {
			return new ResponseEntity<BolsaSangre>(HttpStatus.NOT_ACCEPTABLE);
    	}
    	Date nuevaFecha=bolsasangre.getFechaIngreso();
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(nuevaFecha); 
        calendar.add(Calendar.DAY_OF_YEAR, 7); 
    	bolsasangre.setFechaExpiracion(calendar.getTime());
    	 bolsaService.save(bolsasangre);
    	return new ResponseEntity<BolsaSangre>(bolsasangre, HttpStatus.CREATED);
    }
    
    
    //update
    @PutMapping(value ="/bolsasangre/update/{id}")
   // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BolsaSangre> update(@RequestBody BolsaSangre bolsasangre, @PathVariable int id) {
    	BolsaSangre bolsaActual = bolsaService.findOne(id);

		if (bolsaActual == null) {
			return new ResponseEntity<BolsaSangre>(HttpStatus.NOT_FOUND);
		} 	
    	
    	bolsaActual.setFechaExpiracion(bolsasangre.getFechaExpiracion());
    	bolsaActual.setFechaIngreso(bolsasangre.getFechaIngreso());
    	bolsaActual.setFechaSalida(bolsasangre.getFechaSalida());
    	bolsaActual.setTipo(bolsasangre.getTipo());
    	//persiste el cliente actual(merge)
    	bolsaService.save(bolsaActual);
    	return new ResponseEntity<BolsaSangre>(bolsaActual, HttpStatus.ACCEPTED); 
    	
    }
    
    @DeleteMapping(value = "bolsasangre/delete/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable int id) {
    	BolsaSangre bolsaActual = bolsaService.findOne(id);
    	if (bolsaActual == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
    	bolsaService.delete(id);
    	return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(value = "/bolsasangre/numeroBolsas", method = RequestMethod.GET)
    public String obtenerNumeroDeBolsas(Model model) {
    	int numeroBolsas = secc.obtenerNumeroDeBolsas();
    	model.addAttribute("numeroBolsas", numeroBolsas);
    	return "reporte";
    }
}
