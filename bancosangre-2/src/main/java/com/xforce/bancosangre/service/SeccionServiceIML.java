package com.xforce.bancosangre.service;

import com.xforce.bancosangre.model.Seccion;
import com.xforce.bancosangre.persistence.SeccionDAO; 
import com.xforce.bancosangre.service.ISeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SeccionServiceIML implements ISeccionService {


    @Autowired
    private SeccionDAO secciondao;

    @Override
    @Transactional(readOnly = true)
    public  List<Seccion> findAll() {
        return secciondao.findAll();
    }

    @Override
    @Transactional
    public Seccion save(Seccion estante) {
        return secciondao.save(estante);
    }

    @Override
    @Transactional(readOnly = true)
    public Seccion findOne(Integer id) {
        return secciondao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
    	secciondao.deleteById(id);
    }

	@Override
	public boolean exists(int id) {
		// TODO Auto-generated method stub
		return secciondao.existsById(id);
	}

	@Override
	public int obtenerNumeroDeBolsas() {
		return secciondao.obtenerCantidadDeBolsas();
	}
 
}