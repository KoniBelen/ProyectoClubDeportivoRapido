package com.clubdeportivo2.clubdeportivo.conversion;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;

import com.clubdeportivo2.clubdeportivo.model.DeporteModel;
import com.clubdeportivo2.clubdeportivo.service.DeporteService;

public class DeporteModelFormatter implements Formatter<DeporteModel> {

	@Autowired
	private DeporteService deporteService;
	
	public DeporteModelFormatter() {
        super();
	}
	
	@Override
	public String print(DeporteModel object, Locale locale) {
		
	    return (object != null ? object.getIdDeporte().toString() : "");
	
		
	}

	@Override
	public DeporteModel parse(String text, Locale locale) throws ParseException {
		Integer deporteId = Integer.valueOf(text);
		return this.deporteService.get(deporteId);
	}

}
