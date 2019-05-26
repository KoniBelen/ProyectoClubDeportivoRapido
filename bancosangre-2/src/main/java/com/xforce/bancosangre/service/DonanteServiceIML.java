package com.xforce.bancosangre.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xforce.bancosangre.persistence.DonanteDAO;

import com.xforce.bancosangre.model.Donante;
import com.xforce.bancosangre.service.IDonanteService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DonanteServiceIML implements IDonanteService{

	@Autowired
	private DonanteDAO donantedao;
	
	@Override
    @Transactional(readOnly = true)
	public List<Donante> findAll() {

		return donantedao.findAll();
	}

	@Override
	@Transactional
	public Donante save(Donante donante) {
		
		return donantedao.save(donante);
	}

	@Override
    @Transactional(readOnly = true)
	public Donante findOne(String rut) {
	
		return donantedao.findById(rut).orElse(null);
	}

	@Override
	@Transactional
	public void delete(String rut) {
		donantedao.deleteById(rut);	
	}

	@Override
	public boolean exists(String rut) {
		return donantedao.existsById(rut);
	}

}
