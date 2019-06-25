package com.clubdeportivo2.clubdeportivo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.clubdeportivo2.clubdeportivo.commons.GenericServiceImp;
import com.clubdeportivo2.clubdeportivo.dao.DeporteDao;
import com.clubdeportivo2.clubdeportivo.dao.EquipoDao;
import com.clubdeportivo2.clubdeportivo.dao.RecursoDao;
import com.clubdeportivo2.clubdeportivo.model.EquipoModel;
import com.clubdeportivo2.clubdeportivo.service.EquipoService;


public class EquipoServiceImpl extends GenericServiceImp<EquipoModel, Integer> implements EquipoService {

	
	@Autowired
	private EquipoDao equipoDao;
	@Override
	public CrudRepository<EquipoModel, Integer> getDao() {
		
		return equipoDao;
	}

}
