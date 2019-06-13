package com.clubdeportivo2.clubdeportivo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.clubdeportivo2.clubdeportivo.model.DeporteModel;

public interface DeporteDao extends CrudRepository<DeporteModel, Integer> {
	@Query("SELECT a FROM DeporteModel a WHERE a.nombreDeporte=:nombre")
	 List<DeporteModel> findByNombreDeporte(@Param("nombre") String nombre);

}
