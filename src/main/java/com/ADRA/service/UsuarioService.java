package com.ADRA.service;

import com.ADRA.entity.Usuario;

public interface UsuarioService {
	
    public Usuario findByUsername(String username);
    
}
