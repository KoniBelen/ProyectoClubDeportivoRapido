package com.clubdeportivo2.clubdeportivo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.clubdeportivo2.clubdeportivo.model.RecursoModel;
import com.clubdeportivo2.clubdeportivo.model.SocioModel;
import com.clubdeportivo2.clubdeportivo.model.EquipoModel;

public interface RecursoDao extends CrudRepository<RecursoModel, Integer> {

	List<RecursoModel> findByNombreRecursoLike(String valor);
	
	List<RecursoModel> findByNombreRecurso(String nombreSocio);
}
