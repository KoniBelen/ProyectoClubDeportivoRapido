package com.clubdeportivo2.clubdeportivo.service;

import java.util.List;


import com.clubdeportivo2.clubdeportivo.commons.GenericService;
import com.clubdeportivo2.clubdeportivo.model.DeporteModel;

public interface DeporteService extends GenericService<DeporteModel, Integer> {
	
	List<DeporteModel> findByNombreDeporte(String valor);

	List<DeporteModel> findByNombreDeporteLike(String string);


}
