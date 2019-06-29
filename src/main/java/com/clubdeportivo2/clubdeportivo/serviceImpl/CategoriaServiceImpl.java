package com.clubdeportivo2.clubdeportivo.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.clubdeportivo2.clubdeportivo.commons.GenericServiceImp;
import com.clubdeportivo2.clubdeportivo.dao.CategoriaDao;
import com.clubdeportivo2.clubdeportivo.model.CategoriaModel;
import com.clubdeportivo2.clubdeportivo.model.SocioModel;
import com.clubdeportivo2.clubdeportivo.service.CategoriaService;

@Service
public class CategoriaServiceImpl extends GenericServiceImp<CategoriaModel, Integer> implements CategoriaService{
	
	@Autowired
	private CategoriaDao categoriaDao;
	
	@Override
	public CrudRepository<CategoriaModel, Integer> getDao() { 
		return categoriaDao;
		
	}


	@Override
	public List<CategoriaModel> findByNombreCategoriaLike(String valor) {
		return categoriaDao.findByNombreCategoriaLike("%"+valor+"%");
	}
	
	@Override
	@Transactional
	public List<CategoriaModel> findByNombreCategoria(String valor) {
		return categoriaDao.findByNombreCategoria(valor);
	}
 
}

