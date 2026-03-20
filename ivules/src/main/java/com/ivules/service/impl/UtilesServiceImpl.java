package com.ivules.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.ivules.service.UtilesService;
@Service
public class UtilesServiceImpl implements UtilesService{
	
	@Override
	@Transactional
	public boolean isNullOrBlank(String param) { 
	    return param == null || param.trim().length() == 0;
	}
}
