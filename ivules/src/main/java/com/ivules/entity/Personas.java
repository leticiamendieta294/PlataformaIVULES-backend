package com.ivules.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Lob;

import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "personas")
public class Personas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_personas")
	@SequenceGenerator(name="seq_personas",sequenceName="seq_personas",allocationSize=1)
	private Integer personaId;
	
	@Column(name = "codigo", length = 20, unique = true, nullable = false)	
	@NotEmpty(message ="no puede estar vacio")
	@Size(max=20, message="maximo 20 caracteres")
	private String codigo;
	
	@Column(name = "cedula", length = 20, unique = true, nullable = false)	
	@NotEmpty(message ="no puede estar vacio")
	@Size(max=20, message="maximo 20 caracteres")
	private String cedula;
	
	@Column(name = "nombres", length = 50, nullable = false)
	@NotEmpty(message ="no puede estar vacio")
	@Size(max=50, message="maximo 50 caracteres")
	private String nombres;	
	
	@Column(name = "apellidos", length = 50, nullable = false)
	@NotEmpty(message ="no puede estar vacio")
	@Size(max=50, message="maximo 50 caracteres")
	private String apellidos;
	
	
	@Column(name = "ciudad_residencia", length = 50)
	@Size(max=50, message="maximo 50 caracteres")
	private String ciudadResidencia;
	
	@Column(name = "edad")
	@Size(max=20, message="maximo 20 caracteres")
	private String edad;
	
	
	@Column(name = "celular")
	@Size(max=20, message="maximo 20 caracteres")
	private String celular;
	
	@Column(name = "sexo", length = 1)
	@Size(max=1, message="maximo 1 caracteres")
	private String sexo;
	
	@Column(name = "estado_civil", length = 15)
	@Size(max=15, message="maximo 15 caracteres")
	private String estadoCivil;
	
	
	
	@Column(name = "opcion_laboratorio")
	@Size(max=20, message="maximo 20 caracteres")
	private String opcionLaboratorio;
	
	
	public String getOpcionLaboratorio() {
		return opcionLaboratorio;
	}

	public void setOpcionLaboratorio(String opcionLaboratorio) {
		this.opcionLaboratorio = opcionLaboratorio;
	}

	@Column(name = "foto")
	@Lob
	private String foto;
	
	/*@OneToOne
    @JoinColumn(name = "estamento_id", referencedColumnName = "estamentoId")
    private Estamentos estamentos;
	
	@OneToOne
    @JoinColumn(name = "carrera_id", referencedColumnName = "carreraId")
    private Carreras carreras;
	
	@OneToOne
    @JoinColumn(name = "departamento_id", referencedColumnName = "departamentoId")
    private Departamentos departamentos;
	
	@OneToOne
    @JoinColumn(name = "dependencia_id", referencedColumnName = "dependenciaId")
    private Dependencias dependencias;*/
		
	
	
	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion;	
	
	@Column(name = "usuario_creacion", length = 15)
	@Size(max=15, message="maximo 15 caracteres")
	private String usuarioCreacion;
	
	@Column(name = "fecha_modificacion")
	private LocalDateTime fechaModificacion;
	
	@Column(name = "usuario_modificacion", length = 15)
	@Size(max=15, message="maximo 15 caracteres")
	private String usuarioModificacion;
	
	@OneToOne(mappedBy = "personas")
    private Pacientes pacientes;
	
	@OneToOne(mappedBy = "personas")
    private Funcionarios funcionarios;
	
	@OneToOne(mappedBy = "personas")
    private Usuarios usuarios;
	
	/*@OneToMany(mappedBy="personas")
    private Set<Seguimiento> seguimientos;*/
	
	@PrePersist
	private void create() {
		this.fechaCreacion = LocalDateTime.now();
	}
	
	@PreUpdate
	private void update() {
		this.fechaModificacion = LocalDateTime.now();
	}

	public Integer getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	


	

	

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	
	
	
	

	
		
}
