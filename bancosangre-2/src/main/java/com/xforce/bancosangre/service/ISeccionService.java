package com.xforce.bancosangre.service;
import com.xforce.bancosangre.model.Seccion;
import java.util.List;

public interface ISeccionService {

    List<Seccion> findAll();

    Seccion save(Seccion estante);

    Seccion findOne(Integer id);

    void delete(Integer id);
    
    boolean exists(int id);
    
    int obtenerNumeroDeBolsas();
}