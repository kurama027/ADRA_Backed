package com.ADRA.service;

import java.util.List;

import com.ADRA.entity.banco;

public interface BancoService {
	
	public List<banco> findAll(); 
	
	public banco findById(Long id); 
	
	public banco save (banco bank); 
	
	public void delete(banco bank);
	
}
