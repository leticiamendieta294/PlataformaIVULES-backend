package com.ivules.clases;

import java.io.Serializable;


public class UsuarioRolId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer usuario;
	
	private Integer rol;
		
	public UsuarioRolId() {
		super();
	}

	public UsuarioRolId(Integer usuario, Integer rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getRol() {
		return rol;
	}

	public void setRol(Integer rol) {
		this.rol = rol;
	}

}
