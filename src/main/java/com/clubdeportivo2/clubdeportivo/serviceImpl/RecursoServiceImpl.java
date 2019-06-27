package com.clubdeportivo2.clubdeportivo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.clubdeportivo2.clubdeportivo.commons.GenericServiceImp;
import com.clubdeportivo2.clubdeportivo.dao.RecursoDao;
import com.clubdeportivo2.clubdeportivo.model.RecursoModel;
import com.clubdeportivo2.clubdeportivo.service.RecursoService;

@Service
public class RecursoServiceImpl extends GenericServiceImp<RecursoModel, Integer> implements RecursoService{

	@Autowired
	private RecursoDao recursoDao;
	
	@Override
	public CrudRepository<RecursoModel, Integer> getDao() {
		return recursoDao;
	}

	

	

	
	

}
