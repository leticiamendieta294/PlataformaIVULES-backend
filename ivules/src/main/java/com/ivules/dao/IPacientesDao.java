package com.ivules.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ivules.entity.Pacientes;
import com.ivules.entity.Personas;

public interface IPacientesDao extends JpaRepository<Pacientes, Integer>, JpaSpecificationExecutor<Pacientes> {
	
	List<Pacientes> findByPersonas(Personas personas);	
	Pacientes findByPacienteId(Integer pacienteId);
}
