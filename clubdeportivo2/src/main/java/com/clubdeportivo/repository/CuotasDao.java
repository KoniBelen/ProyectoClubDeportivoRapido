package com.clubdeportivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clubdeportivo.model.CuotasModel;

@Repository
public interface CuotasDao extends JpaRepository <CuotasModel,Integer>{

}
