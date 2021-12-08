package com.ADRA.service;

import java.util.List;

import com.ADRA.entity.seminario;

public interface SeminarioService {
	public List<seminario> findAll();

    public seminario findById(Long id);

    public seminario save(seminario semi);

    public void delete(seminario semi);

}
