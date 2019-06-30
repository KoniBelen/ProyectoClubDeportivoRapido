package com.clubdeportivo2.clubdeportivo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.clubdeportivo2.clubdeportivo.model.DeporteModel;

public interface DeporteDao extends CrudRepository<DeporteModel, Integer> {

	List<DeporteModel> findByNombreDeporteLike(String valor);
	
	List<DeporteModel> findByNombreDeporte(String nombreDeporte);

}
