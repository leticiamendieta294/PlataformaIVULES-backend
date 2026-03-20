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
import org.springframework.dao.DataAccessException;
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
import com.ivules.entity.Personas;
import com.ivules.security.service.RolService;
import com.ivules.service.PersonasService;
import com.ivules.service.UtilesService;
import com.ivules.util.Globales;
import com.ivules.util.Mensaje;
import com.ivules.util.exceptions.IvulesException;

@RestController
@CrossOrigin
@RequestMapping("/auth/personas")
public class PersonasController {


	private PersonasService personasService;

	private UtilesService utiles;
	
	private RolService rolService;
	private ModelMapper modelMapper = new ModelMapper();
	
	private static final String DATE_PATTERN = "yyyy/MM/dd";	
		
	
	@Autowired
	public PersonasController(PersonasService personasService, UtilesService utiles, RolService rolService,
			ModelMapper modelMapper) {
		super();
		this.personasService = personasService;
		this.utiles = utiles;
		this.rolService = rolService;
		this.modelMapper = modelMapper;
	}

	@GetMapping
	public ResponseEntity<List<Personas>> listar() throws IvulesException {
		List<Personas> personasList = null;
		
		personasList = personasService.listaPorPersonaId();
		
		return new ResponseEntity<List<Personas>>(personasList, HttpStatus.OK);
	}
	
	/*@GetMapping(value = "/todos")
	public ResponseEntity<?> listarTodos() throws SigebiException {
		List<Personas> personasList = null;
		
		personasList = personasService.listaPorPersonaId();
		
		return new ResponseEntity<List<Personas>>(personasList, HttpStatus.OK);
	}*/
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Personas> obtener(@PathVariable("id") Integer id) throws IvulesException {
		Personas persona = null;
		
		persona = personasService.obtener(id);

		return new ResponseEntity<Personas>(persona, HttpStatus.OK);
	}
	
	@GetMapping("/buscar")
    public ResponseEntity<List<Personas>> buscarPersonas(
    		@RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date fromDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = DATE_PATTERN) Date toDate,
            @RequestParam(required = false) String filtros,
            @RequestParam(required = false) String page,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) String orderBy,
            @RequestParam(required = false) String orderDir,
            Pageable pageable) throws JsonMappingException, JsonProcessingException, DataAccessException{
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Personas persona = null;
		if(!utiles.isNullOrBlank(filtros)) {
			persona = objectMapper.readValue(filtros, Personas.class);
		}				
		
		List<Personas> personasList = new ArrayList<Personas>();
		
		if ( persona == null ) {
			persona = new Personas();
		}
		
		if ( "-1".equals(size) ) {
			int total = personasService.count();
			int pagina = page != null ? Integer.parseInt(page) : 0;
			pageable = PageRequest.of(pagina, total);
		}	
		
		personasList = personasService.buscar(fromDate, toDate, persona, orderBy, orderDir, pageable);
		
        return new ResponseEntity<List<Personas>>(personasList, HttpStatus.OK);
    }
	
	//@PreAuthorize("hasRole('ROL_ABM_PERSONA') or hasRole('ROL_ADMIN')")
	//@Secured({ "ROL_ABM_PERSONA", "ROL_ADMIN" })
	@PostMapping
	public ResponseEntity<Map<String, Object>> crear(@Valid @RequestBody Personas persona, BindingResult result) throws IvulesException {
		Map<String, Object> response = new HashMap<>();		
		Personas p = modelMapper.map(persona, Personas.class);
		Personas nuevoP = personasService.guardar(p);
		Personas respuestaDTO = modelMapper.map(nuevoP, Personas.class);
		
		if( result.hasErrors() ) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			throw new IvulesException.BusinessException(errors.toString());
		}
		
		//personaNew = personasService.guardar(persona);
		
		response.put("mensaje", "La persona ha sido creada con éxito!");
		response.put("persona", respuestaDTO);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//@PreAuthorize("hasRole('ROL_ABM_PERSONA')")
	//@PreAuthorize("hasRole('ROL_ADMIN')")
	//@Secured({ "ROL_ABM_PERSONA" })
	@PutMapping
	public ResponseEntity<Map<String, Object>> actualizar(@Valid @RequestBody Personas persona, BindingResult result) throws IvulesException {
		Map<String, Object> response = new HashMap<>();
		
		if( result.hasErrors() ) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			throw new IvulesException.BusinessException(errors.toString());
		}
		
		Personas p = modelMapper.map(persona, Personas.class);
		Personas nuevoP = personasService.actualizar(p);
		Personas respuestaDTO = modelMapper.map(nuevoP, Personas.class);

		response.put("mensaje", "La persona ha sido actualizada con éxito!");
		response.put("persona", respuestaDTO);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//@PreAuthorize("hasRole('ROL_ABM_PERSONA') or hasRole('ROL_ADMIN')")
	//@Secured({ "ROL_ABM_PERSONA", "ROL_ADMIN" })
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Map<String, Object>> eliminar(@PathVariable int id) throws IvulesException {
		Map<String, Object> response = new HashMap<>();
		
		if( !rolService.verificarRol(Globales.ROL_ABM_PERSONA) ){
			return new ResponseEntity(new Mensaje("No cuenta con el rol requerido "), HttpStatus.UNAUTHORIZED);
		}
									
		personasService.eliminar(id);

		response.put("mensaje", "Persona eliminada con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
