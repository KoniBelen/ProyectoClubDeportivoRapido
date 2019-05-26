package com.xforce.bancosangre.controller;


import com.xforce.bancosangre.model.Donante;
import com.xforce.bancosangre.model.Seccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xforce.bancosangre.service.SeccionServiceIML;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;


@RestController
@Controller
@RequestMapping(value = "/seccion")
public class SeccionController{

    @Autowired
    private SeccionServiceIML seccionService;
    
    public Seccion s;
 
//listar todos
    @GetMapping(value = "/listarseccion", produces = {"application/json"})
    public ResponseEntity<List<Seccion>> listar(){
    	List<Seccion>lista = seccionService.findAll();
    	if (lista.isEmpty()) {
			return new ResponseEntity<List<Seccion>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Seccion>>(lista, HttpStatus.OK); 
    	
    	
       
    }
    //listar por ID
    @GetMapping(value="/listarseccion/{id}")
    // @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Seccion> mostrar(@PathVariable int id) {
    	Seccion seccion = seccionService.findOne(id);
		if (seccion == null) {
			return new ResponseEntity<Seccion>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Seccion>(seccion, HttpStatus.OK); 
    }
    
    //crear
    @PostMapping(value = "/seccion/crear")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Seccion> create(@RequestBody Seccion seccion) {
    	
    	seccionService.save(seccion);
    	return new ResponseEntity<Seccion>(seccion, HttpStatus.CREATED);  
    }
    
    
    //update
    @PutMapping(value ="/seccion/update/{id}")
   // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Seccion> update(@RequestBody Seccion seccion, @PathVariable int id) {
    	Seccion seccionActual = seccionService.findOne(id);
    	if (seccionActual == null) {
			return new ResponseEntity<Seccion>(HttpStatus.NOT_FOUND);
		} 
    	seccionActual.setNumeroDeEstante(seccion.getNumeroDeEstante());
    	//persiste el cliente actual(merge)
    	 seccionService.save(seccionActual);
    	 return new ResponseEntity<Seccion>(seccionActual, HttpStatus.ACCEPTED);  
    	
    }
    
    @DeleteMapping(value = "/seccion/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable int id) {
    	Seccion seccionActual = seccionService.findOne(id);
    	if (seccionActual == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} 
    	seccionService.delete(id);
    	return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    
    
}
