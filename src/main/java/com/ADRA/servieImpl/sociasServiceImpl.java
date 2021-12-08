package com.ADRA.servieImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ADRA.entity.socias;
import com.ADRA.repository.SociaRepository;
import com.ADRA.service.SociaService;


@Service
public class sociasServiceImpl implements SociaService {
	
	@Autowired
    SociaRepository sociaRepository;

	@Override
	public List<socias> findAll() {
		// TODO Auto-generated method stub
		return (List<socias>) sociaRepository.findAll();
	}

	@Override
	public socias findById(Long id) {
		// TODO Auto-generated method stub
		return sociaRepository.findById(id).orElse(null);
	}

	@Override
	public socias save(socias socia) {
		// TODO Auto-generated method stub
		return sociaRepository.save(socia);
	}

	@Override
	public void delete(socias socia) {
		sociaRepository.delete(socia);
		
	}
	
	
	

}
