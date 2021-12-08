package com.ADRA.servieImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ADRA.entity.capacitacion;
import com.ADRA.repository.CapacitacionRepository;
import com.ADRA.service.CapacitacionService;

@Service
public class CapacitacionServiceImpl implements CapacitacionService{

	@Autowired 
	CapacitacionRepository capaRepository;
	
	@Override
	public List<capacitacion> findAll() {
		// TODO Auto-generated method stub
		return (List<capacitacion>) capaRepository.findAll();
	}

	@Override
	public capacitacion findById(Long id) {
		// TODO Auto-generated method stub
		return capaRepository.findById(id).orElse(null);
	}

	@Override
	public capacitacion save(capacitacion capa) {
		// TODO Auto-generated method stub
		return capaRepository.save(capa);
	}

	@Override
	public void delete(capacitacion capa) {
		capaRepository.delete(capa);

		
	}

}
