package com.clubdeportivo2.clubdeportivo.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;


public abstract class GenericServiceImp<T,ID extends Serializable> implements GenericService<T, ID> {

	@Override
	public T save(T entity) {
		return getDao().save(entity);
	}

	@Override
	public void delete(ID id) {
		getDao().deleteById(id);
		
	}

	/**
	 * Obtiene un objeto por la id
	 * @param id
	 * @return retorna null si el objeto no existe, sino retorna el objeto*/
	@Override
	public T get(ID id) {
		Optional<T> obj = getDao().findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	@Override
	public List<T> getAll() {
		List<T> lista = new ArrayList<>();
		getDao().findAll().forEach(obj->lista.add(obj));
		return lista;
	}

	@Override
	public T update(ID id, T entity) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public abstract CrudRepository<T, ID> getDao();
	

}
