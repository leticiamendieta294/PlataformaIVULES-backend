package com.ivules.controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ivules.entity.CuestionarioBasal;
import com.ivules.entity.Laboratorio;
import com.ivules.entity.OpcionesClinica;

import com.ivules.service.CuestionarioBasalService;
import com.ivules.service.LaboratorioService;
import com.ivules.service.OpcionesClinicaService;
import com.ivules.service.SeguimientoService;


import com.ivules.util.exceptions.IvulesException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth/opcionesclinica")
public class OpcionesClinicaController {

	
	private OpcionesClinicaService opcionesClinicaService;
	
	 private ModelMapper modelMapper = new ModelMapper();
		

	private CuestionarioBasalService cuestionariobasalService;
	
	
	private SeguimientoService seguimientoService;
	
	
	private LaboratorioService laboratorioService;
	
	//private static final String DATE_PATTERN = "yyyy/MM/dd";
	
	
	
		
		
	
	@GetMapping
	public ResponseEntity<List<OpcionesClinica>> listar() throws IvulesException {
		List<OpcionesClinica> opcionesClinicaList = null;
		
		opcionesClinicaList = opcionesClinicaService.findAll();
		
		return new ResponseEntity<List<OpcionesClinica>>(opcionesClinicaList, HttpStatus.OK);
	}
	

	@Autowired
	public OpcionesClinicaController(OpcionesClinicaService opcionesClinicaService, ModelMapper modelMapper,
			CuestionarioBasalService cuestionariobasalService, SeguimientoService seguimientoService,
			LaboratorioService laboratorioService) {
		super();
		this.opcionesClinicaService = opcionesClinicaService;
		this.modelMapper = modelMapper;
		this.cuestionariobasalService = cuestionariobasalService;
		this.seguimientoService = seguimientoService;
		this.laboratorioService = laboratorioService;
	}



	@GetMapping(value = "/{id}")
	public ResponseEntity<OpcionesClinica> obtener(@PathVariable("id") Integer id) throws IvulesException {
		OpcionesClinica opcionesClinica = null;
		
		opcionesClinica = opcionesClinicaService.findById(id);
					
		return new ResponseEntity<OpcionesClinica>(opcionesClinica, HttpStatus.OK);
	}
	
	@GetMapping(value="/personaId")
	public ResponseEntity<OpcionesClinica> obtenerPorPersonaId(@RequestParam(value="name") String name) throws IvulesException {
		OpcionesClinica opcionesClinica = null;
		
		
		
		opcionesClinica = opcionesClinicaService.findByPersonaId(Integer.parseInt(name));
					
		return new ResponseEntity<OpcionesClinica>(opcionesClinica, HttpStatus.OK);
	}
	
	/*@GetMapping("/buscar")
    public ResponseEntity<?> buscar(
    		@RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date fromDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date toDate,
            @RequestParam(required = false) String filtros,
            @RequestParam(required = false) String page,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) String orderBy,
            @RequestParam(required = false) String orderDir,
            Pageable pageable) throws JsonMappingException, JsonProcessingException, DataAccessException{
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Areas area = null;
		if(!utiles.isNullOrBlank(filtros)) {
			area = objectMapper.readValue(filtros, Areas.class);
		}				
		
		List<Areas> areasList = new ArrayList<Areas>();
		
		if ( area == null ) {
			area = new Areas();
		}
		if ( "-1".equals(size) ) {
			int total = areasService.count();
			int pagina = page != null ? Integer.parseInt(page) : 0;
			pageable = PageRequest.of(pagina, total);
		}			
		
		areasList = areasService.buscar(fromDate, toDate, area, orderBy, orderDir, pageable);
		
        return new ResponseEntity<List<Areas>>(areasList, HttpStatus.OK);
    }

	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody OpcionesClinica opcionesClinica, BindingResult result) throws IvulesException {
		Map<String, Object> response = new HashMap<>();		
		OpcionesClinica op = modelMapper.map(opcionesClinica, OpcionesClinica.class);
		OpcionesClinica nuevoOp = laboratorioService.save(lab);
		OpcionesClinica respuestaDTO = modelMapper.map(nuevoLab, Laboratorio.class);
		
		if( result.hasErrors() ) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());			
			throw new IvulesException.BusinessException(errors.toString());
		}
		
		opcionesClinicaNew = opcionesClinicaService.save(opcionesClinica);
		
		response.put("mensaje", "El área ha sido creado con éxito!");
		response.put("opcionesClinica", opcionesClinicaNew);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> actualizar(@Valid @RequestBody OpcionesClinica opcionesClinica, BindingResult result) throws IvulesException {
		Map<String, Object> response = new HashMap<>();
				
		OpcionesClinica opcionesClinicaUpdated = null;

		if( result.hasErrors() ) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());			
			response.put("errors", errors);
			throw new IvulesException.BusinessException(errors.toString());
		}
		
		opcionesClinicaUpdated = opcionesClinicaService.save(opcionesClinica);

		response.put("mensaje", "El área ha sido actualizado con éxito!");
		response.put("opcionesClinica", opcionesClinicaUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	/*@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> borrar(@PathVariable int id) throws SigebiException {
		Map<String, Object> response = new HashMap<>();
		
		if( !rolService.verificarRol(Globales.ROL_ABM_CONFIGURACION) ){
			return new ResponseEntity(new Mensaje("No cuenta con el rol requerido "), HttpStatus.UNAUTHORIZED);
		}
		
		areasService.eliminar(id);
		
		response.put("mensaje", "Área eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}*/
	
	@GetMapping(value = "/comprobarEstado/{id}")
	public ResponseEntity<?> comprobarCampos(@PathVariable("id") Integer id) throws IvulesException {
		
		List<String> verificaciones = new ArrayList<>();
		List<String> verificacionesSeguimiento = seguimientoService.comprobarEstadoSeguimiento(id);
	//	v = null;
		
CuestionarioBasal cuestionarioBasal = null;

cuestionarioBasal =  cuestionariobasalService.findByPersonaId(id);
		
		
		
		
	if( cuestionarioBasal== null) {
			verificaciones.add("vacio");
		}else {
			if(cuestionariobasalService.comprobarCampos(cuestionarioBasal)) {
				verificaciones.add("no");
			}else {
				verificaciones.add("si");
			}
			
		}
		
		for (int i = 0; i < verificacionesSeguimiento.size(); i++) {
			verificaciones.add(verificacionesSeguimiento.get(i));
		}
		
		
		
		

		return new ResponseEntity<>(verificaciones, HttpStatus.OK);
	}
	
	@GetMapping(value = "/comprobarEstadoLaboratorio/{id}")
	public ResponseEntity<List<String>> comprobarCamposLaboratorio(@PathVariable("id") Integer id) throws IvulesException {
		
		List<String> verificaciones = new ArrayList<>();
		List<String> verificacionesLaboratorio = laboratorioService.comprobarEstadoLaboratorio(id);
	//	v = null;
		

		
		for (int i = 0; i < verificacionesLaboratorio.size(); i++) {
			verificaciones.add(verificacionesLaboratorio.get(i));
		}
		
		
		
		

		return new ResponseEntity<List<String>>(verificaciones, HttpStatus.OK);
	}
	
	@GetMapping(value = "/comprobarUrocultivo/{id}")
	public ResponseEntity<List<String>> comprobarUrocultivo(@PathVariable("id") Integer id) throws IvulesException {
		
	
		List<String> verificaciones = laboratorioService.searchByUrocultivoAndPersonaId("POSITIVO",id);
	
		
		
		

		return new ResponseEntity<List<String>>(verificaciones, HttpStatus.OK);
	}
}

