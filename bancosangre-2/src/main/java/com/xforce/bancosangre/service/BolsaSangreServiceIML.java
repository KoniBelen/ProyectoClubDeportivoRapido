package com.xforce.bancosangre.service;

import com.xforce.bancosangre.model.BolsaSangre;

import com.xforce.bancosangre.persistence.BolsaSangreDAO;
import com.xforce.bancosangre.service.IBolsaSangreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BolsaSangreServiceIML implements IBolsaSangreService {

	@Autowired
	private BolsaSangreDAO bolsasangredao;

	@Override
	@Transactional(readOnly = true)
	public List<BolsaSangre> findAll() {
		return bolsasangredao.findAll();
	}

	@Override
	@Transactional
	public BolsaSangre save(BolsaSangre bolsaSangre) {
		return bolsasangredao.save(bolsaSangre);
	}

	@Override
	@Transactional(readOnly = true)
	public BolsaSangre findOne(Integer id) {
		return bolsasangredao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		bolsasangredao.deleteById(id);
	}

	@Override
	public boolean exists(int id) {
		return bolsasangredao.existsById(id);
	}

	@Override
	public int obtenerBolsasRetiradas() {
		return bolsasangredao.countDateNotNull();
	}

	public int obtenerBolsasNoRetiradas() {
		return bolsasangredao.countDateNull();
	}

}