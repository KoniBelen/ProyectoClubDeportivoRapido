package com.xforce.bancosangre.service;

import java.util.List;
import com.xforce.bancosangre.model.Donante;;

public interface IDonanteService {

    List<Donante> findAll();

    Donante save(Donante donante);

    Donante findOne(String rut);

    void delete(String rut);


    boolean exists(String rut);
}
