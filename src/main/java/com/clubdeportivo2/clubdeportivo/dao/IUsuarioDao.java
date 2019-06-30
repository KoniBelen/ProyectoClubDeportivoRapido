package com.clubdeportivo2.clubdeportivo.dao;

import org.springframework.data.repository.CrudRepository;

import com.clubdeportivo2.clubdeportivo.model.Usuario;;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
}
