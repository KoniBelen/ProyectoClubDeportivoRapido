package com.clubdeportivo2.clubdeportivo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.clubdeportivo2.clubdeportivo.commons.GenericServiceImp;
import com.clubdeportivo2.clubdeportivo.dao.CuotaDao;
import com.clubdeportivo2.clubdeportivo.model.CuotasModel;
import com.clubdeportivo2.clubdeportivo.service.CuotaService;

@Service
public class CuotaServiceImpl extends GenericServiceImp<CuotasModel, Integer> implements CuotaService{

	@Autowired
	private CuotaDao cuotaDao;
	
	@Override
	public CrudRepository<CuotasModel, Integer> getDao() {
		return cuotaDao;
	}

	

	

	
	

}
