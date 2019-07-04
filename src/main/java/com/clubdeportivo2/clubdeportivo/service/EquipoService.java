package com.clubdeportivo2.clubdeportivo.service;

import java.util.List;

import com.clubdeportivo2.clubdeportivo.commons.GenericService;
import com.clubdeportivo2.clubdeportivo.model.EquipoModel;

public interface EquipoService extends GenericService<EquipoModel, Integer> {
	
	List<EquipoModel> findByNombreEquipo(String valor);

	List<EquipoModel> findByNombreEquipoLike(String string);

}
