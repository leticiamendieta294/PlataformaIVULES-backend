package com.ivules.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.ivules.entity.Parametros;

public interface ParametrosService {
	
	public List<Parametros> findAll();
	
	public Parametros findById(int id);
	
	public int count();
	
	public Parametros save(Parametros parametro);
	
	public void delete(int id);
	
	public List<Parametros> buscar(Date fromDate, Date toDate, Parametros parametro, String orderBy, String orderDir, Pageable pageable);

	@Query("SELECT p FROM Parametros p WHERE p.codigoParametro= ?1")
	Parametros findByCodigo(String path_reportes);
	
}
