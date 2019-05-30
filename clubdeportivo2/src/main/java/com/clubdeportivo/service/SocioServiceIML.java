package com.clubdeportivo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubdeportivo.model.SocioModel;
import com.clubdeportivo.repository.SocioDao;
import com.clubdeportivo.service.ISocioService;


@Service
public class SocioServiceIML implements ISocioService {

	@Autowired
	private SocioDao socioDao;
	
	@Transactional(readOnly=true)
	public List<SocioModel> findAll() {
		
		return socioDao.findAll();
	}

	@Transactional
	public SocioModel save(SocioModel socio) {
		
		return socioDao.save(socio);
	}

	
	@Transactional(readOnly=true)
	public SocioModel findOne(Integer id) {
		
		return socioDao.findById(id).orElse(null);
	}

	
	@Transactional
	public void delete(Integer id) {
		socioDao.deleteById(id);
		
	}

	public boolean exists(int id) {
		
		return socioDao.existsById(id);
	}

}
