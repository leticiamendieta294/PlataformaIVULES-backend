package com.ivules.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivules.entity.Pacientes;
import com.ivules.entity.Parametros;
import com.ivules.security.service.RolService;
import com.ivules.service.ParametrosService;
import com.ivules.service.UtilesService;
import com.ivules.util.Globales;
import com.ivules.util.Mensaje;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth/parametros")
public class ParametrosController {
	
	
	private ParametrosService parametrosService;
	
	private UtilesService utiles;

	private RolService rolService;
	
	private static final String DATE_PATTERN = "yyyy/MM/dd";
	
	private ModelMapper modelMapper = new ModelMapper();
		
	
	@Autowired
	public ParametrosController(ParametrosService parametrosService, UtilesService utiles, RolService rolService,
			ModelMapper modelMapper) {
		super();
		this.parametrosService = parametrosService;
		this.utiles = utiles;
		this.rolService = rolService;
		this.modelMapper = modelMapper;
	}

	@GetMapping
	public ResponseEntity<List<Parametros>> listar() {
		Map<String, Object> response = new HashMap<>();
		List<Parametros> parametrosList = null;

		parametrosList = parametrosService.findAll();

		/*if( parametrosList.isEmpty()) {
			response.put("mensaje", "No se encontraron datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}*/
		return new ResponseEntity<List<Parametros>>(parametrosList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Parametros> obtener(@PathVariable("id") Integer id){
		Map<String, Object> response = new HashMap<>();
		Parametros parametro = null;

		parametro = parametrosService.findById(id);
		
		/*if( parametro == null ) {
			response.put("mensaje", "El parametro con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}*/
		
		return new ResponseEntity<Parametros>(parametro, HttpStatus.OK);
	}
	
	@GetMapping("/buscar")
    public ResponseEntity<List<Parametros>> buscarParametros(
    		@RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date fromDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date toDate,
            @RequestParam(required = false) String filtros,
            @RequestParam(required = false) String page,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) String orderBy,
            @RequestParam(required = false) String orderDir,
            Pageable pageable) throws JsonMappingException, JsonProcessingException{
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Parametros parametro = null;
		if(!utiles.isNullOrBlank(filtros)) {
			parametro = objectMapper.readValue(filtros, Parametros.class);
		}				
		
		List<Parametros> parametroList = new ArrayList<Parametros>();
		
		if ( parametro == null ) {
			parametro = new Parametros();
		}
		
		if ("-1".equals(size)) {
			int total = parametrosService.count();
			int pagina = page != null ? Integer.parseInt(page) : 0;
			pageable = PageRequest.of(pagina, total);
		}
		
		parametroList = parametrosService.buscar(fromDate, toDate, parametro, orderBy, orderDir, pageable);
		
        return new ResponseEntity<List<Parametros>>(parametroList, HttpStatus.OK);
    }

	@PostMapping
	public ResponseEntity<?> insertar(@Valid @RequestBody Parametros parametro, BindingResult result) {
		Map<String, Object> response = new HashMap<>();		
		Parametros par = modelMapper.map(parametro, Parametros.class);
		Parametros nuevoPar = parametrosService.save(par);
		Parametros respuestaDTO = modelMapper.map(nuevoPar, Parametros.class);;
		
		if( result.hasErrors() ) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
	//	parametroNew = parametrosService.save(parametro);
		
		response.put("mensaje", "El parámetro ha sido creado con éxito!");
		response.put("parametro", respuestaDTO);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> modificar(@Valid @RequestBody Parametros parametro, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		
		
		if ( parametro.getParametroId() == null ) {
			response.put("mensaje", "Error: parámetro id es requerido");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		Parametros par = modelMapper.map(parametro, Parametros.class);
		Parametros nuevoPar = parametrosService.save(par);
		Parametros respuestaDTO = modelMapper.map(nuevoPar, Parametros.class);

		if( result.hasErrors() ) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if ( respuestaDTO == null ) {
			response.put("mensaje", "Error: no se pudo editar, el parámetro ID: "
					.concat(String.valueOf(respuestaDTO.getParametroId()).concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		//parametroUpdated = parametrosService.save(parametro);;

		response.put("mensaje", "El parámetro ha sido actualizado con éxito!");
		response.put("parametro", respuestaDTO);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Map<String, Object>> eliminar(@PathVariable int id) {
		Map<String, Object> response = new HashMap<>();
		
		if( !rolService.verificarRol(Globales.ROL_ABM_CONFIGURACION) ){
			return new ResponseEntity(new Mensaje("No cuenta con el rol requerido "), HttpStatus.UNAUTHORIZED);
		}
		
		if ( utiles.isNullOrBlank(String.valueOf(id)) ) {
			response.put("mensaje", "Error: parametro id es requerido");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		Parametros parametroActual = parametrosService.findById(id);
		
		if ( parametroActual == null ) {
			response.put("mensaje", "El paramátro ID: "
					.concat(String.valueOf(id).concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
					
		parametrosService.delete(id);
		
		response.put("mensaje", "Parámetro eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
