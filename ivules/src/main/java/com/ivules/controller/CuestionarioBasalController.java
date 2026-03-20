package com.ivules.controller;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivules.configuration.CuestionarioBasalDTO;
import com.ivules.entity.CuestionarioBasal;

import com.ivules.service.CuestionarioBasalService;

import com.ivules.util.exceptions.IvulesException;



@RestController
@CrossOrigin
@RequestMapping("/auth/cuestionariobasal")
public class CuestionarioBasalController {
	
	
	private CuestionarioBasalService cuestionariobasalService;
	
	 private ModelMapper modelMapper = new ModelMapper();


	
	
	 @Autowired
	public CuestionarioBasalController(CuestionarioBasalService cuestionariobasalService) {
		super();
		this.cuestionariobasalService = cuestionariobasalService;
		
	}



	@PostMapping
	public ResponseEntity<Map<String, Object>> insertar(@Valid @RequestBody CuestionarioBasal cuestionariobasal, BindingResult result) {
		Map<String, Object> response = new HashMap<>();		
		
		
		CuestionarioBasal cbasal = modelMapper.map(cuestionariobasal, CuestionarioBasal.class);
        CuestionarioBasal nuevoCBasal = cuestionariobasalService.save(cbasal);
        CuestionarioBasalDTO respuestaDTO = modelMapper.map(nuevoCBasal, CuestionarioBasalDTO.class);
		
		
		
		if( result.hasErrors() ) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
	   
		
		//cuestionariobasalNew = cuestionariobasalService.save(cuestionariobasal);
	    
		
		response.put("mensaje", "El cuestionario basal ha sido creado con éxito!");
		response.put("cuestionariobasal", respuestaDTO);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<CuestionarioBasal>> listar() throws IvulesException {
		List<CuestionarioBasal> cuestionariobasalList = null;
		
		cuestionariobasalList = cuestionariobasalService.findAll();
		
		return new ResponseEntity<List<CuestionarioBasal>>(cuestionariobasalList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CuestionarioBasal> obtener(@PathVariable("id") Integer id) throws IvulesException {
		CuestionarioBasal cuestionarioBasal = null;
		
		cuestionarioBasal = cuestionariobasalService.findById(id);

		return new ResponseEntity<CuestionarioBasal>(cuestionarioBasal, HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<Map<String, Object>> actualizar(@Valid @RequestBody CuestionarioBasal cuestionariobasal, BindingResult result) throws IvulesException {
		Map<String, Object> response = new HashMap<>();
		
		CuestionarioBasal cbasal = modelMapper.map(cuestionariobasal, CuestionarioBasal.class);
        CuestionarioBasal nuevoCBasal = cuestionariobasalService.actualizar(cbasal);
        CuestionarioBasalDTO respuestaDTO = modelMapper.map(nuevoCBasal, CuestionarioBasalDTO.class);

		
		if( result.hasErrors() ) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			throw new IvulesException.BusinessException(errors.toString());
		}
		
		//CuestionarioBasal cuestionariobasalUpdated = null;

		//cuestionariobasalUpdated = cuestionariobasalService.actualizar(cuestionariobasal);

		response.put("mensaje", "El cuestionario basal ha sido actualizado con éxito!");
		response.put("cuestionariobasal", respuestaDTO);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/pacienteId/{personaId}")
	public ResponseEntity<CuestionarioBasal> obtenerByPersona(@PathVariable("personaId") Integer id) throws IvulesException {
		CuestionarioBasal cuestionarioBasal = null;
		
		cuestionarioBasal = cuestionariobasalService.findByPersonaId(id);

		return new ResponseEntity<CuestionarioBasal>(cuestionarioBasal, HttpStatus.OK);
	}
	
	/*@GetMapping(value = "/export/cuestionarioBasal/{personaId}")
	public ResponseEntity<InputStreamResource> exportData(@PathVariable("personaId") Integer id) throws Exception {
		ByteArrayInputStream stream = cuestionariobasalService.exportExcelCuestionarioBasal(id);
		
		HttpHeaders headers =  new HttpHeaders();
		
		headers.add("Content-Disposition", "attachment; filename= \"cuestionario_basal"+ new Date()+".xlsx\"");

		return  ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
	}
	*/
	
	@GetMapping(value = "/export")
	public ResponseEntity<InputStreamResource> exportData() throws Exception {
		ByteArrayInputStream stream = cuestionariobasalService.exportExcelCuestionarioBasalModificado();
		
		HttpHeaders headers =  new HttpHeaders();
		final DateTimeFormatter custom_formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		headers.add("Content-Disposition", "attachment; filename= \"CuestionarioBasal"+LocalDateTime.now().format(custom_formatter)+".xlsx\"");

		return  ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
	}
	

}
