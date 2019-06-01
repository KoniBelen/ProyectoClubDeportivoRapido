package com.clubdeportivo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clubdeportivo.model.DeporteModel;
import com.clubdeportivo.repository.DeporteDao;

@Service
public class DeporteServiceIML  implements IDeporteService{

	@Autowired
	private DeporteDao deportedao;
	
	@Override
	@Transactional(readOnly = true)
	public List<DeporteModel> findAll(){
		return deportedao.findAll();
	}

	@Override
	public DeporteModel save(DeporteModel deporte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeporteModel findOne(Integer id_deporte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id_deporte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(int id_deporte) {
		// TODO Auto-generated method stub
		return false;
	}

}
