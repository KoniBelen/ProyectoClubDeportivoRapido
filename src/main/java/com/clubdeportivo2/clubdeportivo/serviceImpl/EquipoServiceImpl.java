package com.clubdeportivo2.clubdeportivo.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.clubdeportivo2.clubdeportivo.commons.GenericServiceImp;
import com.clubdeportivo2.clubdeportivo.dao.DeporteDao;
import com.clubdeportivo2.clubdeportivo.dao.EquipoDao;
import com.clubdeportivo2.clubdeportivo.dao.RecursoDao;
import com.clubdeportivo2.clubdeportivo.model.DeporteModel;
import com.clubdeportivo2.clubdeportivo.model.EquipoModel;
import com.clubdeportivo2.clubdeportivo.service.EquipoService;

@Service
public class EquipoServiceImpl extends GenericServiceImp<EquipoModel, Integer> implements EquipoService {
	
	@Autowired
	private EquipoDao equipoDao;
	@Override
	public CrudRepository<EquipoModel, Integer> getDao() {
		
		return equipoDao;
	}
	
	@Override
	public List<EquipoModel> findByNombreEquipoLike(String valor) {
		return equipoDao.findByNombreEquipoLike("%"+valor+"%");
	}
	
	@Override
	@Transactional
	public List<EquipoModel> findByNombreEquipo(String valor) {
		return equipoDao.findByNombreEquipo(valor);
	}

}
