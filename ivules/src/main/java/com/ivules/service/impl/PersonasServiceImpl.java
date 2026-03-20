package com.ivules.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.ivules.dao.IPersonasDao;

import com.ivules.entity.Personas;

import com.ivules.service.PersonasService;
import com.ivules.service.UtilesService;
import com.ivules.util.exceptions.IvulesException;


@Service
public class PersonasServiceImpl implements PersonasService{

	@Autowired
	private IPersonasDao personasDao;
	
	@Autowired
	private UtilesService utiles;
	
	public PersonasServiceImpl(IPersonasDao personasDao) {
        this.personasDao = personasDao;
    }
	
	@Override
	@Transactional(readOnly = true)
	public List<Personas> listar() throws IvulesException {
		List<Personas> personasList = personasDao.findAll();
		
		if( personasList.isEmpty()) {
			throw new IvulesException.DataNotFound("No se encontraron datos");
		}
		
		return personasList;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Personas> listaPorPersonaId() throws IvulesException {
		List<Personas> personasList = personasDao.findAllByOrderByPersonaIdDesc();
		
		if( personasList.isEmpty()) {
			throw new IvulesException.DataNotFound("No se encontraron datos");
		}
		
		return personasList;
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return (int) personasDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Personas obtener(int id) throws IvulesException {
		
		Personas persona = personasDao.findById(id).orElse(null);
		
		
		
		if( persona == null ) {						
			String mensaje = "La persona con ID: ".concat(String.valueOf(id).concat(" no existe en la base de datos!"));
			throw new IvulesException.DataNotFound(mensaje);
		}
		return persona;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Personas obtenerPorCedula(String cedula) throws IvulesException {
		
		Personas persona = personasDao.findByCedula(cedula);
		
		if( persona == null ) {						
			String mensaje = "La persona con cédula: ".concat(String.valueOf(cedula).concat(" no existe en la base de datos!"));
			throw new IvulesException.DataNotFound(mensaje);
		}
		return persona;
	}

	@Override
	@Transactional
	public Personas guardar(Personas persona) throws IvulesException {
		
		Personas personaDb = personasDao.findByCedula(persona.getCedula());
		
		if( personaDb != null ) {
			throw new IvulesException.DataAlreadyExist("Ya existe una persona con cédula: " + persona.getCedula());
		}
		
		
		return personasDao.save(persona);
	}
	
	@Override
	@Transactional
	public Personas actualizar(Personas persona) throws IvulesException {
		
		if ( persona.getPersonaId() == null ) {
			throw new IvulesException.DataNotFound("Error: persona id es requerido ");
		}
		
		Personas personaActual = obtener(persona.getPersonaId());
		
		if ( personaActual == null ) {
			String mensaje = "No se pudo editar, la persona ID: "
					.concat(String.valueOf(persona.getPersonaId()).concat(" no existe en la base de datos!"));
			throw new IvulesException.DataNotFound(mensaje);
		}
		
		
		return personasDao.save(persona);
	}

	@Override
	@Transactional
	public void eliminar(int id) throws IvulesException {
		
		if ( utiles.isNullOrBlank(String.valueOf(id)) ) {
			throw new IvulesException.DataNotFound("Error: persona id es requerido ");
		}
		
		Personas personaActual = obtener(id);
		
		if ( personaActual == null ) {
			String mensaje = "La persona ID: "
					.concat(String.valueOf(id).concat(" no existe en la base de datos!"));
			throw new IvulesException.DataNotFound(mensaje);
		}
		personasDao.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Personas> buscar(Date fromDate, Date toDate, Personas persona, String orderBy, String orderDir, Pageable pageable) {
		
		List<Personas> personasList = new ArrayList<Personas>();
		
		Specification<Personas> personasSpec = (Specification<Personas>) (root, cq, cb) -> {
		
            Predicate p = cb.conjunction();
            if (Objects.nonNull(fromDate) && Objects.nonNull(toDate) && fromDate.before(toDate)) {
                p = cb.and(p, cb.between(root.get("fechaCreacion"), fromDate, toDate));
            }
            if ( persona.getPersonaId() != null ) {
                p = cb.and(p, cb.equal(root.get("personaId"), persona.getPersonaId()) );
            }
            if (!StringUtils.isEmpty(persona.getCodigo())) {
                p = cb.and(p, cb.equal(root.get("codigo"), persona.getCodigo()));
            }
            if (!StringUtils.isEmpty(persona.getCedula())) {
                p = cb.and(p, cb.equal(root.get("cedula"), persona.getCedula()));
            }
            if (!StringUtils.isEmpty(persona.getNombres())) {
                p = cb.and(p, cb.like(cb.lower(root.get("nombres")), "%" + persona.getNombres().toLowerCase() + "%"));
            }
            if (!StringUtils.isEmpty(persona.getApellidos())) {
                p = cb.and(p, cb.like(cb.lower(root.get("apellidos")), "%" + persona.getApellidos().toLowerCase() + "%"));
            }
            String orden = "personaId";
            if (!StringUtils.isEmpty(orderBy)) {
            	orden = orderBy;
            }
            if("asc".equalsIgnoreCase(orderDir)){
            	cq.orderBy(cb.asc(root.get(orden)));
            }else {
            	cq.orderBy(cb.desc(root.get(orden)));
            }
            return p;
        };
        
        if(pageable != null) {
        	personasList = personasDao.findAll(personasSpec, pageable).getContent();			
		}else {
			personasList = personasDao.findAll(personasSpec);
		}
   
        
        return personasList;
    }
	
	@Override
	@Transactional(readOnly = true)
	public List<Personas> buscarNoPaginable(Date fromDate, Date toDate, Personas persona) {
		List<Personas> personasList = personasDao.findAll((Specification<Personas>) (root, cq, cb) -> {
            
			Predicate p = cb.conjunction();
            if (Objects.nonNull(fromDate) && Objects.nonNull(toDate) && fromDate.before(toDate)) {
                p = cb.and(p, cb.between(root.get("fechaCreacion"), fromDate, toDate));
            }
            if ( persona.getPersonaId() != null ) {
                p = cb.and(p, cb.equal(root.get("personaId"), persona.getPersonaId()) );
            }
            if (!StringUtils.isEmpty(persona.getCedula())) {
                p = cb.and(p, cb.equal(root.get("cedula"), persona.getCedula()));
            }
            if (!StringUtils.isEmpty(persona.getNombres())) {
                p = cb.and(p, cb.like(cb.lower(root.get("nombres")), "%" + persona.getNombres().toLowerCase() + "%"));
            }
            if (!StringUtils.isEmpty(persona.getApellidos())) {
                p = cb.and(p, cb.like(cb.lower(root.get("apellidos")), "%" + persona.getApellidos().toLowerCase() + "%"));
            }
         
            cq.orderBy(cb.desc(root.get("personaId")));
            return p;
        });
        return personasList;
    }

}
