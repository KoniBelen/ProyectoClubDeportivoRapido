package com.xforce.bancosangre.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xforce.bancosangre.model.Donante;

@Repository
public interface DonanteDAO extends JpaRepository<Donante, String>{


}
