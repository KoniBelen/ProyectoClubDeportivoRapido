package com.xforce.bancosangre.service;

import com.xforce.bancosangre.model.BolsaSangre;

import java.util.List;

public interface IBolsaSangreService {

	List<BolsaSangre> findAll();

	BolsaSangre save(BolsaSangre bolsaSangre);

	BolsaSangre findOne(Integer rut);

	void delete(Integer rut);

	boolean exists(int rut);

	int obtenerBolsasNoRetiradas();

	int obtenerBolsasRetiradas();
}