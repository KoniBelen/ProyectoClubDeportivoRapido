package com.clubdeportivo2.clubdeportivo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.clubdeportivo2.clubdeportivo.model.SocioModel;

public interface SocioDao extends CrudRepository<SocioModel, Integer> {



	List<SocioModel> findByNombreSocioLike(String valor);
	
	@Query(value = "SELECT s FROM socio s WHERE s.nombre_socio = ?1", nativeQuery=true)
	List<SocioModel> findByNombreSocio (String nombreSocio);
}
