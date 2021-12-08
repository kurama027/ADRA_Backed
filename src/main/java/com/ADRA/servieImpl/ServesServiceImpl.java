package com.ADRA.servieImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ADRA.entity.servicioespiritual;
import com.ADRA.repository.ServesRepository;
import com.ADRA.service.ServesService;

@Service
public class ServesServiceImpl implements ServesService{

	@Autowired 
	ServesRepository servesRepository;
	
	@Override
	public List<servicioespiritual> findAll() {
		// TODO Auto-generated method stub
		return (List<servicioespiritual>) servesRepository.findAll();

	}

	@Override
	public servicioespiritual findById(Long id) {
		// TODO Auto-generated method stub
		return servesRepository.findById(id).orElse(null);
	}

	@Override
	public servicioespiritual save(servicioespiritual serves) {
		// TODO Auto-generated method stub
		return servesRepository.save(serves);
	}

	@Override
	public void delete(servicioespiritual serves) {
		// TODO Auto-generated method stub 
		servesRepository.delete(serves);

		
	} 
	
	

}
