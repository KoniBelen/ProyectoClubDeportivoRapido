package com.clubdeportivo2.clubdeportivo.Validator;



import java.util.Calendar;
import java.util.Date;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidaMayorEdadValidator implements ConstraintValidator<ValidaMayorEdad, Date>{

	@Override
	public boolean isValid(Date fechaNacimientoSocio,ConstraintValidatorContext context) {
		Calendar fechaNac = Calendar.getInstance();
		fechaNac.setTime(fechaNacimientoSocio);
		if(calcularEdad(fechaNac)<18)    return false;
		return true;
	}

	private static int calcularEdad(Calendar fechaNac) {
	    Calendar today = Calendar.getInstance();
	    int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
	    int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
	    int diffDay = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
	    // Si está en ese año pero todavía no los ha cumplido
	    if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
	        diffYear = diffYear - 1;
	    }
	    return diffYear;
	}  		
}

