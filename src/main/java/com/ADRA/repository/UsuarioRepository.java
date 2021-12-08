package com.ADRA.repository;

import org.springframework.data.repository.CrudRepository;

import com.ADRA.entity.Usuario;

public interface UsuarioRepository extends CrudRepository <Usuario, Long>{
	
    public Usuario findByUsername(String username);

}
