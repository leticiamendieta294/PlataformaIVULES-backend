package com.ivules.service;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;


import com.ivules.entity.Laboratorio;

import com.ivules.util.exceptions.IvulesException;



public interface LaboratorioService {

    public List<Laboratorio> findAll();
	
	public int count();
	
	public Laboratorio findById(int id);
	
	public Laboratorio save(Laboratorio laboratorio);
	
	public void delete(int id);
	
	public List<Laboratorio> buscar(Date fromDate, Date toDate, Laboratorio laboratorio, String orderBy, String orderDir, Pageable pageable);
	
    public Laboratorio actualizar(Laboratorio laboratorio) throws IvulesException;
	
	public Laboratorio findByPersonaIdAndNumero(int id, int numero) throws IvulesException;

	int countByNumero(int numero) throws IvulesException;
	
	public List<String> comprobarEstadoLaboratorio(int id) throws IvulesException;

	List<Laboratorio> findByPersonaId(int id) throws IvulesException;
	
	List<Laboratorio> findByNumeroOrderByPersonas(int numero) throws IvulesException;
	
	public ByteArrayInputStream exportAllData(int numero) throws Exception;

	List<Laboratorio> existByPersonaId(int id);
	
	List<String> searchByUrocultivoAndPersonaId(String urocultivo, int personaId);
	
	List<Laboratorio> excelParaLaboratorio(int numero);
	
	public ByteArrayInputStream exportAllDataModificado(int numero) throws Exception;
}
