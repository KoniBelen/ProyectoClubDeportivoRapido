package com.xforce.bancosangre.persistence;

import com.xforce.bancosangre.model.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeccionDAO extends JpaRepository<Seccion, Integer> {
	
	@Query(value = "SELECT SUM(cantidad_actual) FROM seccion", nativeQuery = true)
	int obtenerCantidadDeBolsas();
}