package com.ivules.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ivules.entity.Personas;
import com.ivules.util.exceptions.IvulesException;

public interface PersonasService {
	
	public List<Personas> listar() throws IvulesException ;
	
	public Personas obtener(int id) throws IvulesException;
	
	public int count();
	
	public Personas obtenerPorCedula(String cedula) throws IvulesException;
	
	public Personas guardar(Personas persona) throws IvulesException;
	
	public Personas actualizar(Personas persona) throws IvulesException;
	
	public void eliminar(int id) throws IvulesException;
	
	public List<Personas> buscar(Date fromDate, Date toDate, Personas persona, String orderBy, String orderDir, Pageable pageable);
	
	public List<Personas> buscarNoPaginable(Date fromDate, Date toDate, Personas persona);

	List<Personas> listaPorPersonaId() throws IvulesException;
	
	
}
