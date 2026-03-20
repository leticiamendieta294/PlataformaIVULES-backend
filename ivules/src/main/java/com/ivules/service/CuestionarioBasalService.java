package com.ivules.service;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ivules.entity.CuestionarioBasal;

import com.ivules.util.exceptions.IvulesException;

public interface CuestionarioBasalService {
	
public List<CuestionarioBasal> findAll();
	
	public int count();
	
	public CuestionarioBasal findById(int id);
	
	public CuestionarioBasal save(CuestionarioBasal cuestionariobasal);
	
	public void delete(int id);
	
	public List<CuestionarioBasal> buscar(Date fromDate, Date toDate, CuestionarioBasal cuestionariobasal, String orderBy, String orderDir, Pageable pageable);
	
	public CuestionarioBasal actualizar(CuestionarioBasal cuestionariobasal) throws IvulesException;

	public CuestionarioBasal findByPersonaId(int id) throws IvulesException;
    public boolean comprobarCampos(CuestionarioBasal cuestionarioBasal);

	ByteArrayInputStream exportExcelCuestionarioBasal() throws Exception;
	
	ByteArrayInputStream exportExcelCuestionarioBasalModificado() throws Exception;

	
	List<CuestionarioBasal> excelParaCuestionarioBasal();



}
