package com.ADRA.service;

import java.util.List;

import com.ADRA.entity.capacitacion;


public interface CapacitacionService {

	public List<capacitacion> findAll();

    public capacitacion findById(Long id);

    public capacitacion save(capacitacion capa);

    public void delete(capacitacion capa);
	
}
