package com.ivules.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ivules.entity.Funcionarios;
import com.ivules.entity.Personas;
import com.ivules.entity.Usuarios;

public interface IUsuariosDao extends JpaRepository<Usuarios, Integer>, JpaSpecificationExecutor<Usuarios> {
	
	Usuarios findByCodigoUsuario(String codigoUsuario);	
	List<Usuarios> findByPersonas(Personas personas);	
	List<Usuarios> findByFuncionarios(Funcionarios funcionarios);
}
