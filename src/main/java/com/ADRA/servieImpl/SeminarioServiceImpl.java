package com.ADRA.servieImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ADRA.entity.seminario;
import com.ADRA.repository.SeminarioRepository;
import com.ADRA.service.SeminarioService;

@Service
public class SeminarioServiceImpl implements SeminarioService{

	@Autowired
	SeminarioRepository semiRepository;
	
	@Override
	public List<seminario> findAll() {
		// TODO Auto-generated method stub
		return (List<seminario>) semiRepository.findAll();
	}

	@Override
	public seminario findById(Long id) {
		// TODO Auto-generated method stub
		return semiRepository.findById(id).orElse(null);
	}

	@Override
	public seminario save(seminario semi) {
		// TODO Auto-generated method stub
		return semiRepository.save(semi);
	}

	@Override
	public void delete(seminario semi) {
		// TODO Auto-generated method stub
		semiRepository.delete(semi);
	}

}
