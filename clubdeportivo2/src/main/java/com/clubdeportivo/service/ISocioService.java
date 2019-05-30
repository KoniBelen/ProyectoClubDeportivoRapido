package com.clubdeportivo.service;



import com.clubdeportivo.model.SocioModel;
import java.util.List;

public interface ISocioService {

		List<SocioModel> findAll();
		
		SocioModel save(SocioModel socio);

		SocioModel findOne(Integer id);

	    void delete(Integer id);

	    boolean exists(int id);
		
}
