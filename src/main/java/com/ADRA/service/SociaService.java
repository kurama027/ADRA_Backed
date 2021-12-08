package com.ADRA.service;

import java.util.List;

import com.ADRA.entity.socias;


public interface SociaService {
	public List<socias> findAll();

    public socias findById(Long id);

    public socias save(socias socia);

    public void delete(socias socia);

}
