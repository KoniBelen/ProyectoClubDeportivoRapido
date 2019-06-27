package com.clubdeportivo2.clubdeportivo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Service;

import com.clubdeportivo2.clubdeportivo.commons.GenericServiceImp;
import com.clubdeportivo2.clubdeportivo.dao.TutorDao;
import com.clubdeportivo2.clubdeportivo.model.TutorModel;
import com.clubdeportivo2.clubdeportivo.service.TutorService;


@Service
public class TutorServiceImpl extends GenericServiceImp<TutorModel, Integer> implements TutorService{
	
	@Autowired
	private TutorDao tutorDao;
	
	@Override
	public CrudRepository<TutorModel, Integer> getDao() { 
		return tutorDao;
		
	}

}
