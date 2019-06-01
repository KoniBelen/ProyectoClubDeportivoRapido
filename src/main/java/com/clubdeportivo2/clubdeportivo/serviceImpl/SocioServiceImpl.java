package com.clubdeportivo2.clubdeportivo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.clubdeportivo2.clubdeportivo.commons.GenericServiceImp;
import com.clubdeportivo2.clubdeportivo.dao.SocioDao;
import com.clubdeportivo2.clubdeportivo.model.SocioModel;
import com.clubdeportivo2.clubdeportivo.service.SocioService;

@Service
public class SocioServiceImpl extends GenericServiceImp<SocioModel, Integer> implements SocioService{
	
	@Autowired
	private SocioDao socioDao;
	
	@Override
	public CrudRepository<SocioModel, Integer> getDao() { 
		return socioDao;
		
	}
 
}
