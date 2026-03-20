package com.ivules.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ivules.entity.OpcionesClinica;



public interface IOpcionesClinicaDao extends JpaRepository<OpcionesClinica, Integer>, JpaSpecificationExecutor<OpcionesClinica> {
	OpcionesClinica findByOpcionesClinicaId(Integer opcionesClinicaId);
	
	@Query(  value = "SELECT * FROM opciones_clinica u WHERE u.persona_id = ?1", 
  nativeQuery = true)
	OpcionesClinica findByPersonas(int id);
}
