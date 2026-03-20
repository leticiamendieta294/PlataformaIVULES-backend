package com.ivules.security.service;

import java.util.List;

import com.ivules.security.entity.Rol;
import com.ivules.security.entity.Usuario;
import com.ivules.security.entity.UsuarioRol;


public interface UsuarioRolService {

	//public List<Usuarios> findAll();
	
	//public UsuarioRol findById(int id);	
	
	public List<UsuarioRol> findByUsuario(Usuario usuario);
	
	public List<String> listarRolesUsuario(Usuario usuario);
	
	public List<UsuarioRol> findByRol(Rol rol);
	
	/*public Usuarios guardar(Usuarios usuario) throws Exception;
	
	public Usuarios actualizar(Usuarios usuario) throws Exception;*/
	
	public void delete(int id);
	
	//public List<Usuarios> buscar(Date fromDate, Date toDate, Usuarios usuario, List<Integer> personasId, Pageable pageable);
	
	//public List<Usuario> buscar(Date fromDate, Date toDate, Usuario usuario, List<Integer> personasId, Pageable pageable);
	
	/*public UserDetails loadUserByUsername(String username);
	
	public List<GrantedAuthority> buildGrante(byte rol);
	
	public void crearUsuario(Usuarios usuario);*/
	
}
