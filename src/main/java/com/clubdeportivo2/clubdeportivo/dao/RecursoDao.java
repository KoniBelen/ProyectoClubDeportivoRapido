package com.clubdeportivo2.clubdeportivo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.clubdeportivo2.clubdeportivo.model.RecursoModel;

public interface RecursoDao extends CrudRepository<RecursoModel, Integer> {

	List<RecursoModel> findByNombreRecursoLike(String valor);
	
	List<RecursoModel> findByNombreRecurso(String nombreRecurso);
}
