package com.ivules.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivules.dao.IOpcionesClinicaDao;

import com.ivules.entity.OpcionesClinica;


import com.ivules.service.OpcionesClinicaService;


@Service
public class OpcionesClinicaServiceImpl implements OpcionesClinicaService{

	@Autowired
	private IOpcionesClinicaDao opcionesClinicaDao;

	
	

	

	
	public OpcionesClinicaServiceImpl(IOpcionesClinicaDao opcionesClinicaDao) {
		super();
		this.opcionesClinicaDao = opcionesClinicaDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<OpcionesClinica> findAll() {
		return (List<OpcionesClinica>) opcionesClinicaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public OpcionesClinica findById(int id) {
		return opcionesClinicaDao.findById(id).orElse(null);
	}

	@Transactional
	public OpcionesClinica save(OpcionesClinica historialClinico) {		
		return opcionesClinicaDao.save(historialClinico);
	}
	
	@Transactional
	public OpcionesClinica actualizar(OpcionesClinica historialClinico) throws Exception {			
		return opcionesClinicaDao.save(historialClinico);
	}

	@Override
	@Transactional
	public void delete(int id) {
		opcionesClinicaDao.deleteById(id);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	@Transactional(readOnly = true)
	public OpcionesClinica findByPersonaId(int id) {
		
		
		OpcionesClinica opcionesClinica = opcionesClinicaDao.findByPersonas(id);
		return opcionesClinica;
	}

	
	
		
}
