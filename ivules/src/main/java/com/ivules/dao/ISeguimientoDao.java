package com.ivules.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


import com.ivules.entity.Personas;
import com.ivules.entity.Seguimiento;



public interface ISeguimientoDao extends JpaRepository<Seguimiento, Integer>, JpaSpecificationExecutor<Seguimiento> {
	 
	
	List<Seguimiento> findByPersonasOrderByNumero(Personas personas);
	  long countByNumero(int numero);
	  
	  @Query("Select s from Seguimiento s JOIN Personas p on s.personas.personaId=p.personaId where s.numero=?1 and s.fechaCreacion > '2024-03-06 00:00:00' order by s.fechaCreacion")
		List<Seguimiento> excelParaSeguimiento(int numero);
	  
	  @Query("Select s from Seguimiento s JOIN Personas p on s.personas.personaId=p.personaId where s.numero=?1 and s.fechaCreacion > '2024-03-06 00:00:00' order by s.fechaCreacion desc")
		List<Seguimiento> obtenerSeguimientoNumero(int numero);
	  
	  @Query("Select s from Seguimiento s where s.personas.personaId=?1 and s.numero=?2")
		Seguimiento obtenerSeguimientoPersonaIdAndNumero(int personaId,int numero);
	
	
}
