package com.clubdeportivo2.clubdeportivo.serviceImpl;

import org.springframework.data.repository.CrudRepository;

import com.clubdeportivo2.clubdeportivo.commons.GenericServiceImp;
import com.clubdeportivo2.clubdeportivo.model.DeporteModel;

public class DeporteServiceImpl extends GenericServiceImp<DeporteModel, Integer> {

	@Override
	public CrudRepository<DeporteModel, Integer> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
