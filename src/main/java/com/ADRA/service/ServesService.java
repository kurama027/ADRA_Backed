package com.ADRA.service;

import java.util.List;

import com.ADRA.entity.servicioespiritual;
public interface ServesService {
	
	public List<servicioespiritual> findAll();

    public servicioespiritual findById(Long id);

    public servicioespiritual save(servicioespiritual serves);

    public void delete(servicioespiritual serves);

}
