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

import com.ivules.dto.LaboratorioDTO;
import com.ivules.entity.Laboratorio;
import com.ivules.entity.Personas;
import com.ivules.entity.Seguimiento;
import com.ivules.service.LaboratorioService;
import com.ivules.service.PersonasService;
import com.ivules.service.SeguimientoService;
import com.ivules.util.exceptions.IvulesException;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth/laboratorio")
public class LaboratorioController {
	
	

	private LaboratorioService laboratorioService;
	

	private PersonasService personaService;
	
	 private ModelMapper modelMapper = new ModelMapper();
	
	
	
	private SeguimientoService seguimientoService;
	
	

	@Autowired
	public LaboratorioController(LaboratorioService laboratorioService, PersonasService personaService,
			ModelMapper modelMapper, SeguimientoService seguimientoService) {
		super();
		this.laboratorioService = laboratorioService;
		this.personaService = personaService;
		this.modelMapper = modelMapper;
		this.seguimientoService = seguimientoService;
	}

	//private static final String DATE_PATTERN = "yyyy/MM/dd";
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> insertar(@Valid @RequestBody Laboratorio laboratorio, BindingResult result) throws IvulesException {
		Map<String, Object> response = new HashMap<>();		
		//Laboratorio laboratorioNew = null;
		
		Laboratorio lab = modelMapper.map(laboratorio, Laboratorio.class);
		Laboratorio nuevoLab = laboratorioService.save(lab);
		LaboratorioDTO respuestaDTO = modelMapper.map(nuevoLab, LaboratorioDTO.class);
		
		if( result.hasErrors() ) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		//laboratorioNew = laboratorioService.save(laboratorio);
		
		if (laboratorio.getNumero()==0) {
			Personas personaUpdated = personaService.obtener(laboratorio.getPersonas().getPersonaId());
			
			personaUpdated.setOpcionLaboratorio(laboratorio.getNumero().toString());

			personaService.actualizar(personaUpdated);
		}else if (laboratorio.getNumero()==1) {
			Seguimiento seguimientoUpdated = seguimientoService.obtenerSeguimientoPersonaIdAndNumero(laboratorio.getPersonas().getPersonaId(), 1);
			
		seguimientoUpdated.setLaboratorioUno("1");
		
		seguimientoService.actualizar(seguimientoUpdated);
		}else if (laboratorio.getNumero()==2) {
			
			Seguimiento seguimientoUpdated = seguimientoService.findByPersonaIdAndNumero(laboratorio.getPersonas().getPersonaId(), 2);
			
		seguimientoUpdated.setLaboratorioDos("2");
		
		seguimientoService.actualizar(seguimientoUpdated);
       }else if (laboratorio.getNumero()==3) {
			
			Seguimiento seguimientoUpdated = seguimientoService.findByPersonaIdAndNumero(laboratorio.getPersonas().getPersonaId(), 3);
			
		seguimientoUpdated.setLaboratorioTres("3");
		
		seguimientoService.actualizar(seguimientoUpdated);
		}else if (laboratorio.getNumero()==4) {
			
			Seguimiento seguimientoUpdated = seguimientoService.findByPersonaIdAndNumero(laboratorio.getPersonas().getPersonaId(), 4);
			
		seguimientoUpdated.setLaboratorioCuatro("4");
		
		seguimientoService.actualizar(seguimientoUpdated);
		}
		
		
		
		response.put("mensaje", "El laboratorio ha sido creado con éxito!");
		response.put("laboratorio", respuestaDTO);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Map<String, Object>> actualizar(@Valid @RequestBody Laboratorio laboratorio, BindingResult result) throws IvulesException {
		Map<String, Object> response = new HashMap<>();
		
		Laboratorio lab = modelMapper.map(laboratorio, Laboratorio.class);
		Laboratorio nuevoLab = laboratorioService.actualizar(lab);
		Laboratorio respuestaDTO = modelMapper.map(nuevoLab, Laboratorio.class);
		
		if( result.hasErrors() ) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			throw new IvulesException.BusinessException(errors.toString());
		}
		
	//	Laboratorio laboratorioUpdated = null;

//		laboratorioUpdated = laboratorioService.actualizar(laboratorio);

		response.put("mensaje", "El laboratorio ha sido actualizado con éxito!");
		response.put("laboratorio", respuestaDTO);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Laboratorio> obtener(@PathVariable("id") Integer id) throws IvulesException {
		Laboratorio laboratorio = null;
		
		laboratorio = laboratorioService.findById(id);

		return new ResponseEntity<Laboratorio>(laboratorio, HttpStatus.OK);
	}
	@GetMapping(value = "/ver/{personaId}/{numero}")
	public ResponseEntity<Laboratorio> obtenerByPersonaIdAndNumero(@PathVariable("personaId") Integer id,@PathVariable("numero") Integer numero) throws IvulesException {
		Laboratorio laboratorio = null;
		
		laboratorio = laboratorioService.findByPersonaIdAndNumero(id, numero);

		return new ResponseEntity<Laboratorio>(laboratorio, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/export/{numero}")
	public ResponseEntity<InputStreamResource> exportData(@PathVariable("numero") Integer numero) throws Exception {
		ByteArrayInputStream stream = laboratorioService.exportAllDataModificado(numero);
		
		HttpHeaders headers =  new HttpHeaders();
		final DateTimeFormatter custom_formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		headers.add("Content-Disposition", "attachment; filename= \"Laboratorio_"+numero +" "+LocalDateTime.now().format(custom_formatter)+".xlsx\"");

		return  ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
	}
	
	
	
	
	
	@GetMapping(value = "/existe/{personaId}")
	public ResponseEntity<List<Laboratorio>> existeLaboratorio(@PathVariable("personaId") Integer id) throws IvulesException {
		List<Laboratorio> laboratorios = null;
		
		laboratorios = laboratorioService.existByPersonaId(id);

		return new ResponseEntity<List<Laboratorio>>(laboratorios, HttpStatus.OK);
	}
	
	
	/*@GetMapping(value = "/labExcel/{numero}")
	public ResponseEntity<?> excelLaboratorio(@PathVariable("numero") Integer numero) throws SigebiException {
		List<Laboratorio> laboratorios = null;
		
		laboratorios = laboratorioService.exportAllData(numero);

		return new ResponseEntity<List<Laboratorio>>(laboratorios, HttpStatus.OK);
	}*/
	
	
	
	
}
