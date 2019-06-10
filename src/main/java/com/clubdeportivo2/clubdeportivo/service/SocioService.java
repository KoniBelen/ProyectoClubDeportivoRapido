package com.clubdeportivo2.clubdeportivo.service;

import java.util.List;

import com.clubdeportivo2.clubdeportivo.commons.GenericService;

import com.clubdeportivo2.clubdeportivo.model.SocioModel;



public interface SocioService extends GenericService<SocioModel, Integer>

{

	List<SocioModel> findByNombreSocio(String valor);

	List<SocioModel> findByNombreSocioLike(String valor);

}
