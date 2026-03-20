package com.ivules.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ivules.entity.Funcionarios;
import com.ivules.entity.Personas;

public interface IFuncionariosDao extends JpaRepository<Funcionarios, Integer>, JpaSpecificationExecutor<Funcionarios> {
	List<Funcionarios> findByPersonas(Personas personas);
}
