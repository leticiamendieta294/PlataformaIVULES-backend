 package com.ivules.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cuestionariobasal")
public class CuestionarioBasal {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_cuestionario")
	@SequenceGenerator(name="seq_cuestionario",sequenceName="seq_cuestionario",allocationSize=1)
	private Integer cuestionarioId;
	
	public Integer getCuestionarioId() {
		return cuestionarioId;
	}

	public void setCuestionarioId(Integer cuestionarioId) {
		this.cuestionarioId = cuestionarioId;
	}

	@Column(name = "fecha")
	private LocalDateTime fecha;
	
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

	@Column(name = "participa_estudio", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String participaEstudio;
	
	@Column(name = "urocultivo_positivo", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String urocultivoPositivo;
	
	@Column(name = "menopausia", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String menopausia;
	
	@Column(name = "edad_menopausia", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String edadMenopausia;
	
	@Column(name = "anhos_histerectomia", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String anhosHisterectomia;
	
	@Column(name = "factores_riesgo_sexualmente_activo", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoSexualmenteActivo;
	
	@Column(name = "factores_riesgo_estreñimiento_cronico", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoEstreñimientoCronico;
	
	@Column(name = "factores_riesgo_incontinencia_urinaria", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoIncontinenciaUrinaria;
	
	@Column(name = "factores_riesgo_sondaje_vesical_previo", length = 100)
	@Size(max=100, message="maximo 100 caracteres")	
	private String factoresRiesgoSondajeVesicalPrevio;
	
	@Column(name = "factores_riesgo_litiasis_renal", length = 100)
	@Size(max=100, message="maximo 100 caracteres")	
	private String factoresRiesgoLitiasisRenal;
	
	
	@Column(name = "factores_riesgo_corticoides", length = 100)
	@Size(max=100, message="maximo 100 caracteres")	
	private String factoresRiesgoCorticoides;
	
	
	
	@Column(name = "factores_riesgo_procedimiento_urinario_ginec_previo", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoProcedimientoUrinarioGinecPrevio;
	
	
	@Column(name = "procedimiento_urinario_ginec_previo_especificar", length = 100000)
	@Size(max=100000, message="maximo 100000 caracteres")
	private String procedimientoUrinarioGinecPrevioEspecificar;
	
	@Column(name = "recibio_profilaxis_acorde_guias", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String recibioProfilaxisAcordeGuias;
	
	public String getRecibioProfilaxisAcordeGuias() {
		return recibioProfilaxisAcordeGuias;
	}

	public void setRecibioProfilaxisAcordeGuias(String recibioProfilaxisAcordeGuias) {
		this.recibioProfilaxisAcordeGuias = recibioProfilaxisAcordeGuias;
	}

	@Column(name = "factores_riesgo_antecedentes_ivu_ultimo_anho", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoAntecedentesIvuUltimoAnho;
	
	@Column(name = "germen_si_antecedentes", length = 100000)
	@Size(max=100000, message="maximo 100000 caracteres")
	private String germenSiAntecedentes;
	
	@Column(name = "factores_riesgo_antibioticoterapia_ultimos_6m", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoAntibioticoterapiaUltimos6m;
	
	@Column(name = "antibioticoterapia_ultimos_6m_especificar", length = 100000)
	@Size(max=100000, message="maximo 100000 caracteres")
	private String antibioticoterapiaUltimos6mEspecificar;
	
	
	
	@Column(name = "nro_ivus_ultimo_12meses", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String nroIvusUltimo12meses;
	
	@Column(name = "tipo_individuo", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tipoIndividuo;
	
	@Column(name = "tiempo_evolucion_les", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tiempoEvolucionLes;
	
	@Column(name = "tratamiento_glucocorticoides", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tratamientoGlucocorticoides;
	
	@Column(name = "dosis_diaria_cantidad_mg", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String dosisDiariaCantidadMg;
	
	@Column(name = "dosis_acumulada_ultimo_6meses", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String dosisAcumuladaUltimo6meses;
	
	@Column(name = "tratamiento_inmunosupresores_is", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tratamientoInmunosupresoresIs;
	
	@Column(name = "tipo_is")
	
	private String tipoIs;
	
	
@Column(name = "tipo_is_texto")
	
	private String tipoISTexto;
	
		
	
	public String getTipoISTexto() {
	return tipoISTexto;
}

public void setTipoISTexto(String tipoISTexto) {
	this.tipoISTexto = tipoISTexto;
}

	@Column(name = "otro_tipo_is", length = 100000)
	@Size(max=100000, message="maximo 100000 caracteres")
	private String otroTipoIs;
	@Column(name = "dosis", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String dosis;
	
	@Column(name = "presenta_manifestacion_renal", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String presentaManifestacionRenal;
	
	@Column(name = "estado_encuentra", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String estadoEncuentra;
	
	@Column(name = "sledai_puntos0_30", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String sledaiPuntos0A30;
	
	@Column(name = "factores_riesgo_embarazo", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoEmbarazo;
	
	@Column(name = "otros_factores_riesgo", length = 100000)
	@Size(max=100000, message="maximo 100000 caracteres")
	private String otrosFactoresRiesgo;
	
	/*Nuevos*/
	@Column(name = "factores_riesgo_sindromeSjogren", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoSindromeSjogren;
	
	@Column(name = "factores_riesgo_tipo_estreñimientocronico", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoTipoEstreñimientoCronico;
	
	@Column(name = "factores_riesgo_frecuencia_urinaria_baja", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoFrecuenciaUrinariaBaja;
	
	@Column(name = "factores_riesgo_actividad_sexual_nroveces", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoActividadSexualNroVeces;
	
	@Column(name = "factores_riesgo_tipo_incontinencia_urinaria", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoTipoIncontinenciaUrinaria;
	
	
	@Column(name = "factores_riesgo_enfermedad_renal_cronica", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoEnfermedadRenalCronica;
	
	@Column(name = "factores_riesgo_hiperplasia_prostatica_benigna", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoHiperplasiaProstaticaBenigna;
	
	@Column(name = "factores_riesgo_diabetes", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoDiabetes;
	
	@Column(name = "factores_riesgo_anomaliasanatomicastractourinario", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoAnomaliasAnatomicasTractoUrinario;
	
	
	@Column(name = "factores_riesgo_anomaliasanatomicastractourinarioespecificar", length = 100000)
	@Size(max=100000, message="maximo 100000 caracteres")
	private String factoresRiesgoAnomaliasAnatomicasTractoEspecificar;
	
	
	
	@Column(name = "factores_riesgo_leucopenia", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoLeucopenia;
	
	@Column(name = "factores_riesgo_tipo_leucopenia", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoTipoLeucopenia;
	
	@Column(name = "factores_riesgo_baja_ingestaliquidos", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoBajaIngestaliquidos;
	
	@Column(name = "factores_riesgo_cancer", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoCancer;
	
	@Column(name = "factores_riesgo_otras_causas_inmunodepresion", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String factoresRiesgoOtrasCausasInmunodepresion;
	
	@Column(name = "otras_causas_inmunodepresion_especificar", length = 100000)
	@Size(max=100000, message="maximo 100000 caracteres")
	private String otrasCausasInmunodepresionEspecificar;
	
	public String getFactoresRiesgoBajaIngestaliquidos() {
		return factoresRiesgoBajaIngestaliquidos;
	}

	public void setFactoresRiesgoBajaIngestaliquidos(String factoresRiesgoBajaIngestaliquidos) {
		this.factoresRiesgoBajaIngestaliquidos = factoresRiesgoBajaIngestaliquidos;
	}

	@Column(name = "factores_riesgo_ivus_ultimo_12meses", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String ivusUltimo12meses;
	
	
	@Column(name = "tipoActividadSexual", length = 1000)
	@Size(max=100, message="maximo 1000 caracteres")
	private String tipoActividadSexual;
	
	public String getTipoActividadSexual() {
		return tipoActividadSexual;
	}

	public void setTipoActividadSexual(String tipoActividadSexual) {
		this.tipoActividadSexual = tipoActividadSexual;
	}
	


	@Column(name = "firma_encargado", length = 100000)
	@Size(max=100000, message="maximo 100000 caracteres")
	private String firmaEncargado;
	
	@Column(name = "infeccionVaginal", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String infeccionVaginal;
	
	@Column(name = "nroInfeccionVaginalAnual", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String nroInfeccionVaginalAnual;
	
	
	/*-------------NUEVOS SINTOMAS-----------------------*/

	@Column(name = "sintomas_urinarios", length = 100000)
	@Size(max=100000, message="maximo 100000 caracteres")
	private String sintomasUrinarios;
	
	@Column(name = "sintoma_disuria", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String sintomaDisuria;


	@Column(name = "sintoma_polaquiuria", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String sintomaPolaquiuria;

	@Column(name = "sintoma_tenesmo", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String sintomaTenesmo;
  
	@Column(name = "sintoma_urgencia_miccional", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String sintomaUrgenciaMiccional;

	@Column(name = "sintoma_fiebre", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String sintomaFiebre;
	
	
	@Column(name = "sintoma_dolor_suprapubico", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String sintomaDolorSuprapubico;
	
	@Column(name = "fecha_ingreso", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String fechaIngreso;
	
	@Column(name = "otro_sintomas_IVU", length = 100000)
	@Size(max=100000, message="maximo 100000 caracteres")
	private String otroSintomasIVU;
	
	
	public String getAntiDNAPositivo() {
		return antiDNAPositivo;
	}

	public void setAntiDNAPositivo(String antiDNAPositivo) {
		this.antiDNAPositivo = antiDNAPositivo;
	}

	public String getComplementosBajos() {
		return complementosBajos;
	}

	public void setComplementosBajos(String complementosBajos) {
		this.complementosBajos = complementosBajos;
	}

	public String getAnticuerposSAFpositivos() {
		return anticuerposSAFpositivos;
	}

	public void setAnticuerposSAFpositivos(String anticuerposSAFpositivos) {
		this.anticuerposSAFpositivos = anticuerposSAFpositivos;
	}

	@Column(name = "antiDNA_positivo", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antiDNAPositivo;
	
	
	@Column(name = "complementos_bajos", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String complementosBajos;
	
	
	@Column(name = "anticuerpos_SAF_positivos", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String anticuerposSAFpositivos;
	
	
	
	@OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "personaId", unique = true)
    private Personas personas;
	
	
	
	
	@PrePersist
	private void create() {
		this.fechaCreacion = LocalDateTime.now();
	}
	
	@PreUpdate
	private void update() {
		this.fechaModificacion = LocalDateTime.now();
	}

	public Personas getPersonas() {
		return personas;
	}

	public void setPersonas(Personas personas) {
		this.personas = personas;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getParticipaEstudio() {
		return participaEstudio;
	}

	public void setParticipaEstudio(String participaEstudio) {
		this.participaEstudio = participaEstudio;
	}

	public String getUrocultivoPositivo() {
		return urocultivoPositivo;
	}

	public void setUrocultivoPositivo(String urocultivoPositivo) {
		this.urocultivoPositivo = urocultivoPositivo;
	}

	public String getMenopausia() {
		return menopausia;
	}

	public void setMenopausia(String menopausia) {
		this.menopausia = menopausia;
	}

	public String getEdadMenopausia() {
		return edadMenopausia;
	}

	public void setEdadMenopausia(String edadMenopausia) {
		this.edadMenopausia = edadMenopausia;
	}

	

	public String getFactoresRiesgoSexualmenteActivo() {
		return factoresRiesgoSexualmenteActivo;
	}

	public void setFactoresRiesgoSexualmenteActivo(String factoresRiesgoSexualmenteActivo) {
		this.factoresRiesgoSexualmenteActivo = factoresRiesgoSexualmenteActivo;
	}

	public String getFactoresRiesgoEstreñimientoCronico() {
		return factoresRiesgoEstreñimientoCronico;
	}

	public void setFactoresRiesgoEstreñimientoCronico(String factoresRiesgoEstreñimientoCronico) {
		this.factoresRiesgoEstreñimientoCronico = factoresRiesgoEstreñimientoCronico;
	}

	public String getFactoresRiesgoIncontinenciaUrinaria() {
		return factoresRiesgoIncontinenciaUrinaria;
	}

	public void setFactoresRiesgoIncontinenciaUrinaria(String factoresRiesgoIncontinenciaUrinaria) {
		this.factoresRiesgoIncontinenciaUrinaria = factoresRiesgoIncontinenciaUrinaria;
	}

	public String getFactoresRiesgoSondajeVesicalPrevio() {
		return factoresRiesgoSondajeVesicalPrevio;
	}

	public void setFactoresRiesgoSondajeVesicalPrevio(String factoresRiesgoSondajeVesicalPrevio) {
		this.factoresRiesgoSondajeVesicalPrevio = factoresRiesgoSondajeVesicalPrevio;
	}

	public String getFactoresRiesgoProcedimientoUrinarioGinecPrevio() {
		return factoresRiesgoProcedimientoUrinarioGinecPrevio;
	}

	public void setFactoresRiesgoProcedimientoUrinarioGinecPrevio(String factoresRiesgoProcedimientoUrinarioGinecPrevio) {
		this.factoresRiesgoProcedimientoUrinarioGinecPrevio = factoresRiesgoProcedimientoUrinarioGinecPrevio;
	}

	public String getFactoresRiesgoAntecedentesIvuUltimoAnho() {
		return factoresRiesgoAntecedentesIvuUltimoAnho;
	}

	public void setFactoresRiesgoAntecedentesIvuUltimoAnho(String factoresRiesgoAntecedentesIvuUltimoAnho) {
		this.factoresRiesgoAntecedentesIvuUltimoAnho = factoresRiesgoAntecedentesIvuUltimoAnho;
	}

	public String getFactoresRiesgoAntibioticoterapiaUltimos6m() {
		return factoresRiesgoAntibioticoterapiaUltimos6m;
	}

	public void setFactoresRiesgoAntibioticoterapiaUltimos6m(String factoresRiesgoAntibioticoterapiaUltimos6m) {
		this.factoresRiesgoAntibioticoterapiaUltimos6m = factoresRiesgoAntibioticoterapiaUltimos6m;
	}

	public String getNroIvusUltimo12meses() {
		return nroIvusUltimo12meses;
	}

	public void setNroIvusUltimo12meses(String nroIvusUltimo12meses) {
		this.nroIvusUltimo12meses = nroIvusUltimo12meses;
	}

	public String getTipoIndividuo() {
		return tipoIndividuo;
	}

	public void setTipoIndividuo(String tipoIndividuo) {
		this.tipoIndividuo = tipoIndividuo;
	}

	public String getTiempoEvolucionLes() {
		return tiempoEvolucionLes;
	}

	public void setTiempoEvolucionLes(String tiempoEvolucionLes) {
		this.tiempoEvolucionLes = tiempoEvolucionLes;
	}

	public String getTratamientoGlucocorticoides() {
		return tratamientoGlucocorticoides;
	}

	public void setTratamientoGlucocorticoides(String tratamientoGlucocorticoides) {
		this.tratamientoGlucocorticoides = tratamientoGlucocorticoides;
	}

	public String getDosisDiariaCantidadMg() {
		return dosisDiariaCantidadMg;
	}

	public void setDosisDiariaCantidadMg(String dosisDiariaCantidadMg) {
		this.dosisDiariaCantidadMg = dosisDiariaCantidadMg;
	}

	public String getDosisAcumuladaUltimo6meses() {
		return dosisAcumuladaUltimo6meses;
	}

	public void setDosisAcumuladaUltimo6meses(String dosisAcumuladaUltimo6meses) {
		this.dosisAcumuladaUltimo6meses = dosisAcumuladaUltimo6meses;
	}

	public String getTratamientoInmunosupresoresIs() {
		return tratamientoInmunosupresoresIs;
	}

	public void setTratamientoInmunosupresoresIs(String tratamientoInmunosupresoresIs) {
		this.tratamientoInmunosupresoresIs = tratamientoInmunosupresoresIs;
	}

	public String getTipoIs() {
		return tipoIs;
	}

	public void setTipoIs(String tipoIs) {
		this.tipoIs = tipoIs;
	}

	public String getDosis() {
		return dosis;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	public String getPresentaManifestacionRenal() {
		return presentaManifestacionRenal;
	}

	public void setPresentaManifestacionRenal(String presentaManifestacionRenal) {
		this.presentaManifestacionRenal = presentaManifestacionRenal;
	}

	public String getEstadoEncuentra() {
		return estadoEncuentra;
	}

	public void setEstadoEncuentra(String estadoEncuentra) {
		this.estadoEncuentra = estadoEncuentra;
	}

	public String getSledaiPuntos0A30() {
		return sledaiPuntos0A30;
	}

	public void setSledaiPuntos0A30(String sledaiPuntos0A30) {
		this.sledaiPuntos0A30 = sledaiPuntos0A30;
	}

	public String getFactoresRiesgoEmbarazo() {
		return factoresRiesgoEmbarazo;
	}

	public void setFactoresRiesgoEmbarazo(String factoresRiesgoEmbarazo) {
		this.factoresRiesgoEmbarazo = factoresRiesgoEmbarazo;
	}

	public String getOtrosFactoresRiesgo() {
		return otrosFactoresRiesgo;
	}

	public void setOtrosFactoresRiesgo(String otrosFactoresRiesgo) {
		this.otrosFactoresRiesgo = otrosFactoresRiesgo;
	}

	public String getOtroTipoIs() {
		return otroTipoIs;
	}

	public void setOtroTipoIs(String otroTipoIs) {
		this.otroTipoIs = otroTipoIs;
	}

	public String getFactoresRiesgoLitiasisRenal() {
		return factoresRiesgoLitiasisRenal;
	}

	public void setFactoresRiesgoLitiasisRenal(String factoresRiesgoLitiasisRenal) {
		this.factoresRiesgoLitiasisRenal = factoresRiesgoLitiasisRenal;
	}

	

	

	public String getFactoresRiesgoCorticoides() {
		return factoresRiesgoCorticoides;
	}

	public void setFactoresRiesgoCorticoides(String factoresRiesgoCorticoides) {
		this.factoresRiesgoCorticoides = factoresRiesgoCorticoides;
	}



	public String getFactoresRiesgoSindromeSjogren() {
		return factoresRiesgoSindromeSjogren;
	}

	public void setFactoresRiesgoSindromeSjogren(String factoresRiesgoSindromeSjogren) {
		this.factoresRiesgoSindromeSjogren = factoresRiesgoSindromeSjogren;
	}

	public String getFactoresRiesgoTipoEstreñimientoCronico() {
		return factoresRiesgoTipoEstreñimientoCronico;
	}

	public void setFactoresRiesgoTipoEstreñimientoCronico(String factoresRiesgoTipoEstreñimientoCronico) {
		this.factoresRiesgoTipoEstreñimientoCronico = factoresRiesgoTipoEstreñimientoCronico;
	}

	public String getFactoresRiesgoFrecuenciaUrinariaBaja() {
		return factoresRiesgoFrecuenciaUrinariaBaja;
	}

	public void setFactoresRiesgoFrecuenciaUrinariaBaja(String factoresRiesgoFrecuenciaUrinariaBaja) {
		this.factoresRiesgoFrecuenciaUrinariaBaja = factoresRiesgoFrecuenciaUrinariaBaja;
	}

	public String getFactoresRiesgoActividadSexualNroVeces() {
		return factoresRiesgoActividadSexualNroVeces;
	}

	public void setFactoresRiesgoActividadSexualNroVeces(String factoresRiesgoActividadSexualNroVeces) {
		this.factoresRiesgoActividadSexualNroVeces = factoresRiesgoActividadSexualNroVeces;
	}

	public String getFactoresRiesgoTipoIncontinenciaUrinaria() {
		return factoresRiesgoTipoIncontinenciaUrinaria;
	}

	public void setFactoresRiesgoTipoIncontinenciaUrinaria(String factoresRiesgoTipoIncontinenciaUrinaria) {
		this.factoresRiesgoTipoIncontinenciaUrinaria = factoresRiesgoTipoIncontinenciaUrinaria;
	}

	

	public String getFactoresRiesgoEnfermedadRenalCronica() {
		return factoresRiesgoEnfermedadRenalCronica;
	}

	public void setFactoresRiesgoEnfermedadRenalCronica(String factoresRiesgoEnfermedadRenalCronica) {
		this.factoresRiesgoEnfermedadRenalCronica = factoresRiesgoEnfermedadRenalCronica;
	}

	public String getFactoresRiesgoHiperplasiaProstaticaBenigna() {
		return factoresRiesgoHiperplasiaProstaticaBenigna;
	}

	public void setFactoresRiesgoHiperplasiaProstaticaBenigna(String factoresRiesgoHiperplasiaProstaticaBenigna) {
		this.factoresRiesgoHiperplasiaProstaticaBenigna = factoresRiesgoHiperplasiaProstaticaBenigna;
	}

	public String getFactoresRiesgoDiabetes() {
		return factoresRiesgoDiabetes;
	}

	public void setFactoresRiesgoDiabetes(String factoresRiesgoDiabetes) {
		this.factoresRiesgoDiabetes = factoresRiesgoDiabetes;
	}

	public String getFactoresRiesgoAnomaliasAnatomicasTractoUrinario() {
		return factoresRiesgoAnomaliasAnatomicasTractoUrinario;
	}

	public void setFactoresRiesgoAnomaliasAnatomicasTractoUrinario(String factoresRiesgoAnomaliasAnatomicasTractoUrinario) {
		this.factoresRiesgoAnomaliasAnatomicasTractoUrinario = factoresRiesgoAnomaliasAnatomicasTractoUrinario;
	}


	public String getFactoresRiesgoLeucopenia() {
		return factoresRiesgoLeucopenia;
	}

	public void setFactoresRiesgoLeucopenia(String factoresRiesgoLeucopenia) {
		this.factoresRiesgoLeucopenia = factoresRiesgoLeucopenia;
	}

	public String getFactoresRiesgoTipoLeucopenia() {
		return factoresRiesgoTipoLeucopenia;
	}

	public void setFactoresRiesgoTipoLeucopenia(String factoresRiesgoTipoLeucopenia) {
		this.factoresRiesgoTipoLeucopenia = factoresRiesgoTipoLeucopenia;
	}

	public String getIvusUltimo12meses() {
		return ivusUltimo12meses;
	}

	public void setIvusUltimo12meses(String ivusUltimo12meses) {
		this.ivusUltimo12meses = ivusUltimo12meses;
	}

	public String getFirmaEncargado() {
		return firmaEncargado;
	}

	public void setFirmaEncargado(String firmaEncargado) {
		this.firmaEncargado = firmaEncargado;
	}

	public String getInfeccionVaginal() {
		return infeccionVaginal;
	}

	public void setInfeccionVaginal(String infeccionVaginal) {
		this.infeccionVaginal = infeccionVaginal;
	}

	public String getNroInfeccionVaginalAnual() {
		return nroInfeccionVaginalAnual;
	}

	public void setNroInfeccionVaginalAnual(String nroInfeccionVaginalAnual) {
		this.nroInfeccionVaginalAnual = nroInfeccionVaginalAnual;
	}
	
	
	public String getAntibioticoterapiaUltimos6mEspecificar() {
		return antibioticoterapiaUltimos6mEspecificar;
	}

	public void setAntibioticoterapiaUltimos6mEspecificar(String antibioticoterapiaUltimos6mEspecificar) {
		this.antibioticoterapiaUltimos6mEspecificar = antibioticoterapiaUltimos6mEspecificar;
	}

	public String getFactoresRiesgoCancer() {
		return factoresRiesgoCancer;
	}

	public void setFactoresRiesgoCancer(String factoresRiesgoCancer) {
		this.factoresRiesgoCancer = factoresRiesgoCancer;
	}

	public String getFactoresRiesgoOtrasCausasInmunodepresion() {
		return factoresRiesgoOtrasCausasInmunodepresion;
	}

	public void setFactoresRiesgoOtrasCausasInmunodepresion(String factoresRiesgoOtrasCausasInmunodepresion) {
		this.factoresRiesgoOtrasCausasInmunodepresion = factoresRiesgoOtrasCausasInmunodepresion;
	}



	public String getProcedimientoUrinarioGinecPrevioEspecificar() {
		return procedimientoUrinarioGinecPrevioEspecificar;
	}

	public void setProcedimientoUrinarioGinecPrevioEspecificar(String procedimientoUrinarioGinecPrevioEspecificar) {
		this.procedimientoUrinarioGinecPrevioEspecificar = procedimientoUrinarioGinecPrevioEspecificar;
	}

	public String getOtrasCausasInmunodepresionEspecificar() {
		return otrasCausasInmunodepresionEspecificar;
	}

	public void setOtrasCausasInmunodepresionEspecificar(String otrasCausasInmunodepresionEspecificar) {
		this.otrasCausasInmunodepresionEspecificar = otrasCausasInmunodepresionEspecificar;
	}

	public String getFactoresRiesgoAnomaliasAnatomicasTractoEspecificar() {
		return factoresRiesgoAnomaliasAnatomicasTractoEspecificar;
	}

	public void setFactoresRiesgoAnomaliasAnatomicasTractoEspecificar(
			String factoresRiesgoAnomaliasAnatomicasTractoEspecificar) {
		this.factoresRiesgoAnomaliasAnatomicasTractoEspecificar = factoresRiesgoAnomaliasAnatomicasTractoEspecificar;
	}

	public String getAnhosHisterectomia() {
		return anhosHisterectomia;
	}

	public void setAnhosHisterectomia(String anhosHisterectomia) {
		this.anhosHisterectomia = anhosHisterectomia;
	}

	public String getSintomasUrinarios() {
		return sintomasUrinarios;
	}

	public void setSintomasUrinarios(String sintomasUrinarios) {
		this.sintomasUrinarios = sintomasUrinarios;
	}

	public String getSintomaDisuria() {
		return sintomaDisuria;
	}

	public void setSintomaDisuria(String sintomaDisuria) {
		this.sintomaDisuria = sintomaDisuria;
	}

	public String getSintomaPolaquiuria() {
		return sintomaPolaquiuria;
	}

	public void setSintomaPolaquiuria(String sintomaPolaquiuria) {
		this.sintomaPolaquiuria = sintomaPolaquiuria;
	}

	public String getSintomaTenesmo() {
		return sintomaTenesmo;
	}

	public void setSintomaTenesmo(String sintomaTenesmo) {
		this.sintomaTenesmo = sintomaTenesmo;
	}

	

	public String getSintomaUrgenciaMiccional() {
		return sintomaUrgenciaMiccional;
	}

	public void setSintomaUrgenciaMiccional(String sintomaUrgenciaMiccional) {
		this.sintomaUrgenciaMiccional = sintomaUrgenciaMiccional;
	}

	public String getSintomaFiebre() {
		return sintomaFiebre;
	}

	public void setSintomaFiebre(String sintomaFiebre) {
		this.sintomaFiebre = sintomaFiebre;
	}

	public String getSintomaDolorSuprapubico() {
		return sintomaDolorSuprapubico;
	}

	public void setSintomaDolorSuprapubico(String sintomaDolorSuprapubico) {
		this.sintomaDolorSuprapubico = sintomaDolorSuprapubico;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getOtroSintomasIVU() {
		return otroSintomasIVU;
	}

	public void setOtroSintomasIVU(String otroSintomasIVU) {
		this.otroSintomasIVU = otroSintomasIVU;
	}

	public String getGermenSiAntecedentes() {
		return germenSiAntecedentes;
	}

	public void setGermenSiAntecedentes(String germenSiAntecedentes) {
		this.germenSiAntecedentes = germenSiAntecedentes;
	}
	
	
	
	
	
	
	

}
