package com.clubdeportivo2.clubdeportivo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.clubdeportivo2.clubdeportivo.commons.GenericServiceImp;
import com.clubdeportivo2.clubdeportivo.dao.DeporteDao;
import com.clubdeportivo2.clubdeportivo.model.DeporteModel;
import com.clubdeportivo2.clubdeportivo.service.DeporteService;

@Service
public class DeporteServiceImpl extends GenericServiceImp<DeporteModel, Integer> implements DeporteService{

	@Autowired
	private DeporteDao deporteDao;
	
	@Override
	public CrudRepository<DeporteModel, Integer> getDao() {
		return deporteDao;
	}

	@Override
	public List<DeporteModel> findByNombreDeporteLike(String nombre) {
		
		return deporteDao.findByNombreDeporte(nombre);
	}

	@Override
	public DeporteModel findById(Integer deporteId) {
		// TODO Auto-generated method stub
		return deporteDao.findById(deporteId);
	}

	
	

}
