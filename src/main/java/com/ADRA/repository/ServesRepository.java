package com.ADRA.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ADRA.entity.servicioespiritual;

@Repository
public interface ServesRepository extends CrudRepository<servicioespiritual, Long>{

	
	
}
