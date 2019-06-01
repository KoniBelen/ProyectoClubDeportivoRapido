package com.clubdeportivo2.clubdeportivo.commons;

import java.io.Serializable;
import java.util.List;
/**
 * Esta clase sirve para ocupar los mismos servicios en todos, para el CRUD sin tanto copy/paste
 * 
 * */

public interface GenericService<T,ID  extends Serializable> {

	T save(T entity);
	void delete(ID id);
	T get(ID id);
	List<T> getAll();
	T update (ID id, T entity);
}
