package com.ivules.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ivules.entity.Funcionarios;
import com.ivules.security.entity.Usuario;
import com.ivules.util.exceptions.IvulesException;


public interface UsuariosService {

	public int count();
	
	public Usuario findById(int id);	
	
	public Usuario findByFuncionario(Funcionarios funcionario);
	
	public String generarNombreUsuario(Integer personaId) throws IvulesException;
		
	public List<Usuario> buscar(Date fromDate, Date toDate, Usuario usuario, List<Integer> funcionariosId, String orderBy, String orderDir, Pageable pageable);
		
}
