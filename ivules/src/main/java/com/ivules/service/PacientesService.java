package com.ivules.service;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;


import com.ivules.entity.Pacientes;
import com.ivules.util.exceptions.IvulesException;

public interface PacientesService{

	public List<Pacientes> listar() throws IvulesException;
	
	public Pacientes obtener(int id) throws IvulesException;
	
	public int count();
		
	public Pacientes guardar(Pacientes paciente) throws IvulesException;
	
	
	
	public Pacientes actualizar(Pacientes paciente) throws IvulesException;
	
	public void eliminar(int id) throws IvulesException;
	
	public List<Pacientes> buscar(Date fromDate, Date toDate, Pacientes paciente, List<Integer> personasId, String orderBy, String orderDir, Pageable pageable);
	
	public List<Pacientes> buscarNoPaginable(Date fromDate, Date toDate, Pacientes paciente, List<Integer> personasId) throws DataAccessException;
	
	public List<Pacientes> buscarPacientes(Date fromDate, Date toDate, Pacientes paciente, String orderBy, String orderDir, Pageable pageable);
}
