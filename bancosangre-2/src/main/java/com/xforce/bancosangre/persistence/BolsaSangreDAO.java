package com.xforce.bancosangre.persistence;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import com.xforce.bancosangre.model.BolsaSangre;
/**
 * Repository class for <code>Owner</code> domain objects All method names are compliant with Spring Data naming
 * conventions so this interface can easily be extended for Spring Data See here: http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 * @author Vitaliy Fedoriv
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BolsaSangreDAO extends JpaRepository<BolsaSangre, Integer> {

	@Query(value = "SELECT COUNT(id_sangre) FROM BOLSA_SANGRE WHERE BOLSA_SANGRE.FECHA_RETIRO IS NULL", nativeQuery = true)
	int countDateNull();

	@Query(value = "SELECT COUNT(id_sangre) FROM bolsa_sangre WHERE bolsa_sangre.fecha_retiro IS NOT NULL", nativeQuery = true)
	int countDateNotNull();
}
