package com.ivules.security.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.Table;


import com.ivules.clases.UsuarioRolId;

@Entity
@Table(name = "usuario_rol")
@IdClass(UsuarioRolId.class)
public class UsuarioRol implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
	
	@Id
	@OneToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    private Rol rol;
		
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
