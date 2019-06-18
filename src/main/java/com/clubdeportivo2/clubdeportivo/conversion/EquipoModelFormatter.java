package com.clubdeportivo2.clubdeportivo.conversion;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;

import com.clubdeportivo2.clubdeportivo.model.DeporteModel;
import com.clubdeportivo2.clubdeportivo.model.EquipoModel;
import com.clubdeportivo2.clubdeportivo.service.EquipoService;

public class EquipoModelFormatter implements Formatter<EquipoModel> {

	@Autowired
	private EquipoService equipoService;
	
	public EquipoModelFormatter() {
        super();
	}
	
	@Override
	public String print(EquipoModel object, Locale locale) {
		
	    return (object != null ? object.getIdEquipo().toString() : "");
	
		
	}

	@Override
	public EquipoModel parse(String text, Locale locale) throws ParseException {
		Integer deporteId = Integer.valueOf(text);
		return this.equipoService.get(deporteId);
	}

}
