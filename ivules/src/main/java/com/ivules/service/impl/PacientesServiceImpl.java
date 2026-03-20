package com.ivules.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.ivules.entity.Pacientes;



import com.ivules.service.PacientesService;


import com.ivules.util.exceptions.IvulesException;


@Service
public class PacientesServiceImpl implements PacientesService{

	@Override
	public List<Pacientes> listar() throws IvulesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pacientes obtener(int id) throws IvulesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pacientes guardar(Pacientes paciente) throws IvulesException {
		// TODO Auto-generated method stub
		return null;
	}

	



	@Override
	public Pacientes actualizar(Pacientes paciente) throws IvulesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) throws IvulesException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pacientes> buscar(Date fromDate, Date toDate, Pacientes paciente, List<Integer> personasId,
			String orderBy, String orderDir, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pacientes> buscarNoPaginable(Date fromDate, Date toDate, Pacientes paciente, List<Integer> personasId)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pacientes> buscarPacientes(Date fromDate, Date toDate, Pacientes paciente, String orderBy,
			String orderDir, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
