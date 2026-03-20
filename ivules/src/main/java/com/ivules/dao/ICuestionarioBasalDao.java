package com.ivules.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ivules.entity.CuestionarioBasal;

import com.ivules.entity.Personas;



public interface ICuestionarioBasalDao extends JpaRepository<CuestionarioBasal, Integer>, JpaSpecificationExecutor<CuestionarioBasal>  {
	
	
	CuestionarioBasal findByPersonas(Personas personas);
	
	@Query("Select c from CuestionarioBasal c JOIN Personas p on c.personas.personaId=p.personaId where c.fechaCreacion > '2024-03-06 00:00:00'  order by c.fechaCreacion")
	List<CuestionarioBasal> excelParaCuestionarioBasal();

}
