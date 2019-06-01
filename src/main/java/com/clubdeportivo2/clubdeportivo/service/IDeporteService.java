package com.clubdeportivo.service;

import java.util.List;

import com.clubdeportivo.model.DeporteModel;

public interface IDeporteService {

	List<DeporteModel> findAll();
	
	DeporteModel save(DeporteModel deporte);
	
	DeporteModel findOne(Integer id_deporte);
	
	void delete(Integer id_deporte);
	
	boolean exists(int id_deporte);
}
