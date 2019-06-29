package com.clubdeportivo2.clubdeportivo.Validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD,ElementType.FIELD}) //es un campo pasado por post
@Retention(RetentionPolicy.RUNTIME) //sera retenido en tiempo de ejecucion
@Constraint(validatedBy=ValidaRutValidator.class)
public @interface ValidaRut {

	String message() default "Rut no válido";
	Class<? extends Payload>[] payload() default{}; //para cargar los datos
	Class<?>[] groups() default {};
}
