package com.ivules.service;

import java.util.List;

import com.ivules.entity.OpcionesClinica;



public interface OpcionesClinicaService {
	
	public List<OpcionesClinica> findAll();
	
	public int count();
	
	public OpcionesClinica findById(int id);
	
	public OpcionesClinica save(OpcionesClinica opcionesclinica);
	
	public void delete(int id);
	
	public OpcionesClinica findByPersonaId(int id);
	
	
	
	
	//public List<Diagnosticos> buscar(Date fromDate, Date toDate, Diagnosticos diagnostico, String orderBy, String orderDir, Pageable pageable);
	
	
}
