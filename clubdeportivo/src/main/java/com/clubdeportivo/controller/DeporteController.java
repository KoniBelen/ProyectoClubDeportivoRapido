package com.clubdeportivo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.clubdeportivo.model.DeporteModel;;

public class DeporteController {

	
//Crear Deportes
    @PostMapping(value = "/deporte/crear")
   // @ResponseStatus(HttpStatus.CREATED)
    public  ResponseEntity<DeporteModel> create(  
    		@RequestBody DeporteModel deporte,BindingResult bindingResult) {

    	if (deporte.getNombreDeporte() == null) {
			return new ResponseEntity<DeporteModel>(HttpStatus.NOT_ACCEPTABLE);
    	}
    	return new ResponseEntity<DeporteModel>(deporte, HttpStatus.CREATED);
    }
}
