package com.xforce.bancosangre.controller;

import static org.junit.Assert.*;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;				// Corregido: cuidado, se debe usar java.util.Date y no java.sql.Date
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.xforce.bancosangre.ApplicationTestConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thymeleaf.standard.expression.AndExpression;

import com.xforce.bancosangre.model.BolsaSangre;
import com.xforce.bancosangre.model.Seccion;
import com.xforce.bancosangre.service.BolsaSangreServiceIML;
import com.xforce.bancosangre.service.IBolsaSangreService;

import org.junit.Test;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ApplicationTestConfig.class)
@WebAppConfiguration
public class BolsaSangreControllerTest {
	@Autowired
	private BolsaSangreController bolsaSangreController; // Cambié nombres de atributos segun uso en Java



	@MockBean
	private BolsaSangreServiceIML bolsaSangreServiceIML; // Se cambió la clase de este atributo (mock) 
// Debe coincidir con el colaborador definido en el Controller a probar

	private List<BolsaSangre> bolsas;
	static Seccion arraySeccion[] = new Seccion[3];

	// Tipo_de_variable[ ] Nombre_del_array = new Tipo_de_variable[dimensión];

	private MockMvc mockMvc;
	
	@Before
	public void initBolsas() throws ParseException {
		
		arraySeccion[0] = new Seccion(1, 4, 7); 	// Corregido: Creado el constructor en la clase Seccion
		arraySeccion[1] = new Seccion(2, 4, 0);	// Corregido: Se cambio indice
		arraySeccion[2] = new Seccion(3, 4, 0);	// Corregido: Se cambio indice

		/*
		 * this.mockMvc = MockMvcBuilders.standaloneSetup(ownerRestController)
		 * .setControllerAdvice(new ExceptionControllerAdvice()) .build(); owners = new
		 * ArrayList<Owner>();
		 * 
		 * Owner owner = new Owner(); owner.setId(1); owner.setFirstName("George");
		 * owner.setLastName("Franklin"); owner.setAddress("110 W. Liberty St.");
		 * owner.setCity("Madison"); owner.setTelephone("6085551023");
		 * owners.add(owner);
		 */
		this.mockMvc = MockMvcBuilders.standaloneSetup(bolsaSangreController)
				.setControllerAdvice(new ExceptionControllerAdvice()).build();
		bolsas = new ArrayList<BolsaSangre>();

		BolsaSangre bolsa = new BolsaSangre();
		bolsa.setId_sangre(1);
		Date date1 = (Date) new SimpleDateFormat("yyyy/MM/dd").parse("2018/11/16");
		bolsa.setFechaIngreso(date1);
		Date date2 = (Date) new SimpleDateFormat("yyyy/MM/dd").parse("2018/11/21");
		bolsa.setFechaSalida(date2);
		Date date3 = (Date) new SimpleDateFormat("yyyy/MM/dd").parse("2018/11/23");
		bolsa.setFechaExpiracion(date3);
		bolsa.setTipo("A");
		bolsa.setSeccion(arraySeccion[0]);//pasa toda la seccion necesito solo el id...
		bolsas.add(bolsa);

	}

	@Test
	public void testMostrar() throws Exception{//listar x id		
		given(this.bolsaSangreServiceIML.findOne(1)).willReturn(bolsas.get(0));
		this.mockMvc.perform(get("/bolsadesangre/bolsasangre/listarbolsa/1")	// Corregido el path
		.accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
// corregido: se agrego . despues de $ y se cambio los nombres de los atributos (sgn BolsaSangre y Seccion)
		.andExpect(jsonPath("$.id_sangre").value(1)) // Correccion nombre atributo
		.andExpect(jsonPath("$.fechaIngreso").value(bolsas.get(0).getFechaIngreso()))
		.andExpect(jsonPath("$.fechaSalida").value(bolsas.get(0).getFechaSalida()))
		.andExpect(jsonPath("$.fechaExpiracion").value(bolsas.get(0).getFechaExpiracion()))
		.andExpect(jsonPath("$.tipo").value(bolsas.get(0).getTipo()))
		// La siguiente línea tiene varias correcciones, la idea es consultar por atributos y no objetos.
		.andExpect(jsonPath("$.seccion.idSeccion").value(bolsas.get(0).getSeccion().getIdSeccion()));	
	}
	@Test
	public void testCrearBolsaSuccess() throws Exception {
    	BolsaSangre nuevaBolsa = bolsas.get(0);
    	
    	nuevaBolsa.setId_sangre(999);
    	nuevaBolsa.setFechaSalida(null);
    	ObjectMapper mapper = new ObjectMapper();
    	String newBolsaAsJSON = mapper.writeValueAsString(nuevaBolsa);
    	System.out.println(newBolsaAsJSON);
    	this.mockMvc.perform(post("/bolsadesangre/bolsasangre/crear").content(newBolsaAsJSON).accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isCreated());
    }

	
}
