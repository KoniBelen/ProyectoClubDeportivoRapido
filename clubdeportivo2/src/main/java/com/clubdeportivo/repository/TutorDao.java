package com.clubdeportivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clubdeportivo.model.TutorModel;

@Repository
public interface TutorDao extends JpaRepository<TutorModel, Integer>{

}
