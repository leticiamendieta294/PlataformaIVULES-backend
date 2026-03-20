package com.ivules.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

@Entity
public class Laboratorio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_laboratorio")
	@SequenceGenerator(name="seq_laboratorio",sequenceName="seq_laboratorio",allocationSize=1)
	private Integer idLaboratorio;
	
	@Column(name = "fecha")
	private LocalDateTime fecha;
	
	@Column(name = "blee")
	private String blee;
	
	public String getBlee() {
		return blee;
	}

	public void setBlee(String blee) {
		this.blee = blee;
	}

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
	
	@Column(name = "leucocitos", length = 10)
	@Size(max=10, message="maximo 10 caracteres")
    private String leucocitos;
    
	@Column(name = "esterasa_leucocitaria", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
    private String esterasaLeucocitaria;
    
	@Column(name = "hematies", length = 10)
	@Size(max=10, message="maximo 10 caracteres")
    private String hematies;
    
    
	@Column(name = "celularidad", length = 10)
	@Size(max=10, message="maximo 10 caracteres")
    private String celularidad;
	
	
	@Column(name = "celularidadRedonda", length = 10)
	@Size(max=10, message="maximo 10 caracteres")
    private String celularidadRedonda;
    
	public String getCelularidadRedonda() {
		return celularidadRedonda;
	}

	public void setCelularidadRedonda(String celularidadRedonda) {
		this.celularidadRedonda = celularidadRedonda;
	}

	@Column(name = "cilindros", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String cilindros;
	
	@Column(name = "cilindrosComentarios", length = 1000)
	@Size(max=100, message="maximo 1000 caracteres")
	private String cilindrosComentarios;
	
	@Column(name = "cristales", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String cristales;
	
	@Column(name = "cristalesComentarios", length = 1000)
	@Size(max=100, message="maximo 1000 caracteres")
	private String cristalesComentarios;
	
	public String getCilindrosComentarios() {
		return cilindrosComentarios;
	}

	public void setCilindrosComentarios(String cilindrosComentarios) {
		this.cilindrosComentarios = cilindrosComentarios;
	}

	public String getCristales() {
		return cristales;
	}

	public void setCristales(String cristales) {
		this.cristales = cristales;
	}

	public String getCristalesComentarios() {
		return cristalesComentarios;
	}

	public void setCristalesComentarios(String cristalesComentarios) {
		this.cristalesComentarios = cristalesComentarios;
	}

	@Column(name = "bacteria", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String bacteria;
	
	@Column(name = "esporos_micoticos", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String esporosMicoticos;
	
	@Column(name = "sedimento_urinario", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String sedimentoUrinario;
	
	@Column(name = "proteínas_positivo", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String proteinasPositivo;
	
	@Column(name = "sangre_positivo", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String sangrePositivo;
	
	
	@Column(name = "comentarios", length = 1000)
	@Size(max=1000, message="maximo 1000 caracteres")
	private String comentarios;
	
	@Column(name = "urocultivo", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String urocultivo;
	
	@Column(name = "tipo_microbio", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tipoMicrobio;
	
	@Column(name = "germen_asilado", length = 10000)
	@Size(max=10000, message="maximo 10000 caracteres")
	private String germenAislado;
	
	@Column(name = "germen_asilado_texto", length = 10000)
	@Size(max=10000, message="maximo 10000 caracteres")
	private String germenAisladoTexto;
	
	@Column(name = "otro_germen_aislado", length = 5000)
	@Size(max=5000, message="maximo 5000 caracteres")
	private String otroGermenAislado;
	
	@Column(name = "tipo_bacteria", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tipoBacteria;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_ampicilina_sulbactam", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoAmpicilinaSulbactam;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_aztreonam", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoAztreonam;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_amikacina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoAmikacina;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_cefazolin", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoCefazolin;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_cefalotina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoCefalotina;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_ceftolozanetazobactam", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoCeftolozanetazobactam;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_ceftazidimaavibactam", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoCeftazidimaavibactam;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_ceftriaxona", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoCeftriaxona;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_cefepima", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoCefepima;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_ciprofloxacina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoCiprofloxacina;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_EBSL", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoEBSL;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_ertapenem", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoErtapenem;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_imipenem", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoImipenem;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_fosfomicina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoFosfomicina;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_gentamicina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoGentamicina;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_meropenem", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoMeropenem;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_norfloxacina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoNorfloxacina;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_nitrofurantoína", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoNitrofurantoína;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_trimetoprima_sulfametox", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoTrimetoprimaSulfametox;
	
	@Column(name = "antibiograma_bacilo_gram_negativo_piperacilinatazobactam", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoPiperacilinaTazobactam;
	
	public String getAntibiogramaBaciloGramNegativoPiperacilinaTazobactam() {
		return antibiogramaBaciloGramNegativoPiperacilinaTazobactam;
	}

	public void setAntibiogramaBaciloGramNegativoPiperacilinaTazobactam(
			String antibiogramaBaciloGramNegativoPiperacilinaTazobactam) {
		this.antibiogramaBaciloGramNegativoPiperacilinaTazobactam = antibiogramaBaciloGramNegativoPiperacilinaTazobactam;
	}

	@Column(name = "antibiograma_bacilo_gram_negativo_tigecilina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaBaciloGramNegativoTigecilina;
	
	@Column(name = "presencia_de_germen_resistente", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String	presenciaGermenResistente; 
	
	
	
	@Column(name = "antibiograma_coco_gram_positivo_ampicilina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoAmpicilina;
	
	@Column(name = "antibiograma_coco_gram_positivo_benzilpenicilina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoBenzilpenicilina;
	
	
	@Column(name = "antibiograma_coco_gram_positivo_cefoxitina_screening", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoCefoxitinaScreening;
	
	@Column(name = "antibiograma_coco_gram_positivo_ceftarolina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoCeftarolina;
	
	@Column(name = "antibiograma_coco_gram_positivo_ciprofloxacina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoCiprofloxacina;
	
	@Column(name = "antibiograma_coco_gram_positivo_levofloxacina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoLevofloxacina;
	
	 
	@Column(name = "antibiograma_coco_gram_positivo_clindamicina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoClindamicina;
	
	@Column(name = "antibiograma_coco_gram_positivo_daptomicina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoDaptomicina;
	
	@Column(name = "antibiograma_coco_gram_positivo_eritromicina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoEritromicina;
	
	@Column(name = "antibiograma_coco_gram_positivo_gentamicina_nivel_alto", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoGentamicinaNivelAlto;
	
	@Column(name = "antibiograma_coco_gram_positivo_estreptomicina_nivel_alto", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoEstreptomicinaNivelAlto;
	@Column(name = "antibiograma_coco_gram_positivo_resistencia_clindamicina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramResistenciaClindamicina;
	
	@Column(name = "antibiograma_coco_gram_positivo_linezolid", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoLinezolid;
	
	@Column(name = "antibiograma_coco_gram_positivo_nitrofurantoína", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoNitrofurantoína;
	
	@Column(name = "antibiograma_coco_gram_positivo_rifampicina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoRifampicina;
	
	@Column(name = "antibiograma_coco_gram_positivo_tetraciclina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoTetraciclina;
	
	@Column(name = "antibiograma_coco_gram_positivo_oxaciclina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoOxaciclina;
	
	@Column(name = "antibiograma_coco_gram_positivo_vancomicina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoVancomicina;
	
	@Column(name = "antibiograma_coco_gram_positivo_trimetoprima_sulfametoxazol", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antibiogramaCocoGramPositivoTrimetoprimaSulfametoxazol;
	
	@Column(name = "hongo_aislado", length = 10000)
	@Size(max=100, message="maximo 10000 caracteres")
	private String hongoAislado;
	
	
	@Column(name = "otro_hongo_aislado", length = 5000)
	@Size(max=5000, message="maximo 5000 caracteres")
	private String otroHongoAislado;
	
	@Column(name = "numero")
	private Integer numero;
	
	//Ultimos agregados
	@Column(name = "tirasLEU", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tirasLEU;
	
	@Column(name = "tirasNIT", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tirasNIT;
	
	
	@Column(name = "tirasURO", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tirasURO;
	
	@Column(name = "tirasPRO", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tirasPRO;
	
	@Column(name = "tiraspH", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tiraspH;
	
	
	@Column(name = "tirasBLO", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tirasBLO;
	
	@Column(name = "tirasSG", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tirasSG;
	
	@Column(name = "tirasKET", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tirasKET;
	
	@Column(name = "tirasBIL", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tirasBIL;
	
	@Column(name = "tirasGLU", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String tirasGLU;
	
	@Column(name = "antifungigramaFluconazol", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antifungigramaFluconazol;
	
	@Column(name = "antifungigramaAnfotericinaB", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antifungigramaAnfotericinaB;
	
	@Column(name = "antifungigramaVoriconazol", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antifungigramaVoriconazol;
	
	
	@Column(name = "antifungigramaMicafungina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antifungigramaMicafungina;
	
	@Column(name = "antifungigramaCaspofungina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antifungigramaCaspofungina;
	
	@Column(name = "antifungigramaFlucitosina", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String antifungigramaFlucitosina;
	
	@Column(name = "categoriaGermen", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String categoriaGermen;
	
	@Column(name = "firmaEncargado", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String firmaEncargado;
	
	@Column(name = "recuentoColoniasNroComentario", length = 10000)
	@Size(max=100, message="maximo 10000 caracteres")
	private String recuentoColoniasNroComentario;

	
	
	
	@Column(name = "fecha_ingreso_muestra", length = 100)
	@Size(max=100, message="maximo 100 caracteres")
	private String fechaIngresoMuestra;
	
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", referencedColumnName = "personaId" )
    private Personas personas;

	public Personas getPersonas() {
		return personas;
	}

	public void setPersonas(Personas personas) {
		this.personas = personas;
	}
	
	@PrePersist
	private void create() {
		this.fechaCreacion = LocalDateTime.now();
	}
	
	@PreUpdate
	private void update() {
		this.fechaModificacion = LocalDateTime.now();
	}

	

	public String getOtroGermenAislado() {
		return otroGermenAislado;
	}

	public void setOtroGermenAislado(String otroGermenAislado) {
		this.otroGermenAislado = otroGermenAislado;
	}

	public String getAntibiogramaBaciloGramNegativoCefalotina() {
		return antibiogramaBaciloGramNegativoCefalotina;
	}

	public void setAntibiogramaBaciloGramNegativoCefalotina(String antibiogramaBaciloGramNegativoCefalotina) {
		this.antibiogramaBaciloGramNegativoCefalotina = antibiogramaBaciloGramNegativoCefalotina;
	}

	public String getOtroHongoAislado() {
		return otroHongoAislado;
	}

	public void setOtroHongoAislado(String otroHongoAislado) {
		this.otroHongoAislado = otroHongoAislado;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getIdLaboratorio() {
		return idLaboratorio;
	}

	public void setIdLaboratorio(Integer idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
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

	public String getLeucocitos() {
		return leucocitos;
	}

	public void setLeucocitos(String leucocitos) {
		this.leucocitos = leucocitos;
	}

	public String getEsterasaLeucocitaria() {
		return esterasaLeucocitaria;
	}

	public void setEsterasaLeucocitaria(String esterasaLeucocitaria) {
		this.esterasaLeucocitaria = esterasaLeucocitaria;
	}

	public String getHematies() {
		return hematies;
	}

	public void setHematies(String hematies) {
		this.hematies = hematies;
	}

	public String getCelularidad() {
		return celularidad;
	}

	public void setCelularidad(String celularidad) {
		this.celularidad = celularidad;
	}

	public String getCilindros() {
		return cilindros;
	}

	public void setCilindros(String cilindros) {
		this.cilindros = cilindros;
	}

	public String getBacteria() {
		return bacteria;
	}

	public void setBacteria(String bacteria) {
		this.bacteria = bacteria;
	}

	public String getEsporosMicoticos() {
		return esporosMicoticos;
	}

	public void setEsporosMicoticos(String esporosMicoticos) {
		this.esporosMicoticos = esporosMicoticos;
	}

	public String getSedimentoUrinario() {
		return sedimentoUrinario;
	}

	public void setSedimentoUrinario(String sedimentoUrinario) {
		this.sedimentoUrinario = sedimentoUrinario;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getUrocultivo() {
		return urocultivo;
	}

	public void setUrocultivo(String urocultivo) {
		this.urocultivo = urocultivo;
	}

	public String getTipoMicrobio() {
		return tipoMicrobio;
	}

	public void setTipoMicrobio(String tipoMicrobio) {
		this.tipoMicrobio = tipoMicrobio;
	}

	public String getGermenAislado() {
		return germenAislado;
	}

	public void setGermenAislado(String germenAislado) {
		this.germenAislado = germenAislado;
	}

	public String getTipoBacteria() {
		return tipoBacteria;
	}

	public void setTipoBacteria(String tipoBacteria) {
		this.tipoBacteria = tipoBacteria;
	}

	public String getAntibiogramaBaciloGramNegativoAmpicilinaSulbactam() {
		return antibiogramaBaciloGramNegativoAmpicilinaSulbactam;
	}

	public void setAntibiogramaBaciloGramNegativoAmpicilinaSulbactam(
			String antibiogramaBaciloGramNegativoAmpicilinaSulbactam) {
		this.antibiogramaBaciloGramNegativoAmpicilinaSulbactam = antibiogramaBaciloGramNegativoAmpicilinaSulbactam;
	}

	public String getAntibiogramaBaciloGramNegativoAmikacina() {
		return antibiogramaBaciloGramNegativoAmikacina;
	}

	public void setAntibiogramaBaciloGramNegativoAmikacina(String antibiogramaBaciloGramNegativoAmikacina) {
		this.antibiogramaBaciloGramNegativoAmikacina = antibiogramaBaciloGramNegativoAmikacina;
	}

	public String getAntibiogramaBaciloGramNegativoCefazolin() {
		return antibiogramaBaciloGramNegativoCefazolin;
	}

	public void setAntibiogramaBaciloGramNegativoCefazolin(String antibiogramaBaciloGramNegativoCefazolin) {
		this.antibiogramaBaciloGramNegativoCefazolin = antibiogramaBaciloGramNegativoCefazolin;
	}

	

	

	public String getAntibiogramaBaciloGramNegativoCeftriaxona() {
		return antibiogramaBaciloGramNegativoCeftriaxona;
	}

	public void setAntibiogramaBaciloGramNegativoCeftriaxona(String antibiogramaBaciloGramNegativoCeftriaxona) {
		this.antibiogramaBaciloGramNegativoCeftriaxona = antibiogramaBaciloGramNegativoCeftriaxona;
	}

	public String getAntibiogramaBaciloGramNegativoCefepima() {
		return antibiogramaBaciloGramNegativoCefepima;
	}

	public void setAntibiogramaBaciloGramNegativoCefepime(String antibiogramaBaciloGramNegativoCefepime) {
		this.antibiogramaBaciloGramNegativoCefepima = antibiogramaBaciloGramNegativoCefepime;
	}

	public String getAntibiogramaBaciloGramNegativoCiprofloxacina() {
		return antibiogramaBaciloGramNegativoCiprofloxacina;
	}

	public void setAntibiogramaBaciloGramNegativoCiprofloxacina(String antibiogramaBaciloGramNegativoCiprofloxacina) {
		this.antibiogramaBaciloGramNegativoCiprofloxacina = antibiogramaBaciloGramNegativoCiprofloxacina;
	}

	public String getAntibiogramaBaciloGramNegativoEBSL() {
		return antibiogramaBaciloGramNegativoEBSL;
	}

	public void setAntibiogramaBaciloGramNegativoEBSL(String antibiogramaBaciloGramNegativoEBSL) {
		this.antibiogramaBaciloGramNegativoEBSL = antibiogramaBaciloGramNegativoEBSL;
	}

	public String getAntibiogramaBaciloGramNegativoErtapenem() {
		return antibiogramaBaciloGramNegativoErtapenem;
	}

	public void setAntibiogramaBaciloGramNegativoErtapenem(String antibiogramaBaciloGramNegativoErtapenem) {
		this.antibiogramaBaciloGramNegativoErtapenem = antibiogramaBaciloGramNegativoErtapenem;
	}

	public String getAntibiogramaBaciloGramNegativoFosfomicina() {
		return antibiogramaBaciloGramNegativoFosfomicina;
	}

	public void setAntibiogramaBaciloGramNegativoFosfomicina(String antibiogramaBaciloGramNegativoFosfomicina) {
		this.antibiogramaBaciloGramNegativoFosfomicina = antibiogramaBaciloGramNegativoFosfomicina;
	}

	public String getAntibiogramaBaciloGramNegativoGentamicina() {
		return antibiogramaBaciloGramNegativoGentamicina;
	}

	public void setAntibiogramaBaciloGramNegativoGentamicina(String antibiogramaBaciloGramNegativoGentamicina) {
		this.antibiogramaBaciloGramNegativoGentamicina = antibiogramaBaciloGramNegativoGentamicina;
	}

	public String getAntibiogramaBaciloGramNegativoMeropenem() {
		return antibiogramaBaciloGramNegativoMeropenem;
	}

	public void setAntibiogramaBaciloGramNegativoMeropenem(String antibiogramaBaciloGramNegativoMeropenem) {
		this.antibiogramaBaciloGramNegativoMeropenem = antibiogramaBaciloGramNegativoMeropenem;
	}

	public String getAntibiogramaBaciloGramNegativoNorfloxacina() {
		return antibiogramaBaciloGramNegativoNorfloxacina;
	}

	public void setAntibiogramaBaciloGramNegativoNorfloxacina(String antibiogramaBaciloGramNegativoNorfloxacina) {
		this.antibiogramaBaciloGramNegativoNorfloxacina = antibiogramaBaciloGramNegativoNorfloxacina;
	}

	public String getAntibiogramaBaciloGramNegativoNitrofurantoína() {
		return antibiogramaBaciloGramNegativoNitrofurantoína;
	}

	public void setAntibiogramaBaciloGramNegativoNitrofurantoína(String antibiogramaBaciloGramNegativoNitrofurantoína) {
		this.antibiogramaBaciloGramNegativoNitrofurantoína = antibiogramaBaciloGramNegativoNitrofurantoína;
	}

	public String getAntibiogramaBaciloGramNegativoTrimetoprimaSulfametox() {
		return antibiogramaBaciloGramNegativoTrimetoprimaSulfametox;
	}

	public void setAntibiogramaBaciloGramNegativoTrimetoprimaSulfametox(
			String antibiogramaBaciloGramNegativoTrimetoprimaSulfametox) {
		this.antibiogramaBaciloGramNegativoTrimetoprimaSulfametox = antibiogramaBaciloGramNegativoTrimetoprimaSulfametox;
	}

	public String getPresenciaGermenResistente() {
		return presenciaGermenResistente;
	}

	public void setPresenciaGermenResistente(String presenciaGermenResistente) {
		this.presenciaGermenResistente = presenciaGermenResistente;
	}

	

	public String getAntibiogramaCocoGramPositivoAmpicilina() {
		return antibiogramaCocoGramPositivoAmpicilina;
	}

	public void setAntibiogramaCocoGramPositivoAmpicilina(String antibiogramaCocoGramPositivoAmpicilina) {
		this.antibiogramaCocoGramPositivoAmpicilina = antibiogramaCocoGramPositivoAmpicilina;
	}

	public String getAntibiogramaCocoGramPositivoBenzilpenicilina() {
		return antibiogramaCocoGramPositivoBenzilpenicilina;
	}

	public void setAntibiogramaCocoGramPositivoBenzilpenicilina(String antibiogramaCocoGramPositivoBenzilpenicilina) {
		this.antibiogramaCocoGramPositivoBenzilpenicilina = antibiogramaCocoGramPositivoBenzilpenicilina;
	}

	public String getAntibiogramaCocoGramPositivoCefoxitinaScreening() {
		return antibiogramaCocoGramPositivoCefoxitinaScreening;
	}

	public void setAntibiogramaCocoGramPositivoCefoxitinaScreening(String antibiogramaCocoGramPositivoCefoxitinaScreening) {
		this.antibiogramaCocoGramPositivoCefoxitinaScreening = antibiogramaCocoGramPositivoCefoxitinaScreening;
	}

	public String getAntibiogramaCocoGramPositivoCeftarolina() {
		return antibiogramaCocoGramPositivoCeftarolina;
	}

	public void setAntibiogramaCocoGramPositivoCeftarolina(String antibiogramaCocoGramPositivoCeftarolina) {
		this.antibiogramaCocoGramPositivoCeftarolina = antibiogramaCocoGramPositivoCeftarolina;
	}

	public String getAntibiogramaCocoGramPositivoCiprofloxacina() {
		return antibiogramaCocoGramPositivoCiprofloxacina;
	}

	public void setAntibiogramaCocoGramPositivoCiprofloxacina(String antibiogramaCocoGramPositivoCiprofloxacina) {
		this.antibiogramaCocoGramPositivoCiprofloxacina = antibiogramaCocoGramPositivoCiprofloxacina;
	}

	public String getAntibiogramaCocoGramPositivoLevofloxacina() {
		return antibiogramaCocoGramPositivoLevofloxacina;
	}

	public void setAntibiogramaCocoGramPositivoLevofloxacina(String antibiogramaCocoGramPositivoLevofloxacina) {
		this.antibiogramaCocoGramPositivoLevofloxacina = antibiogramaCocoGramPositivoLevofloxacina;
	}

	public String getAntibiogramaCocoGramPositivoClindamicina() {
		return antibiogramaCocoGramPositivoClindamicina;
	}

	public void setAntibiogramaCocoGramPositivoClindamicina(String antibiogramaCocoGramPositivoClindamicina) {
		this.antibiogramaCocoGramPositivoClindamicina = antibiogramaCocoGramPositivoClindamicina;
	}

	public String getAntibiogramaCocoGramPositivoDaptomicina() {
		return antibiogramaCocoGramPositivoDaptomicina;
	}

	public void setAntibiogramaCocoGramPositivoDaptomicina(String antibiogramaCocoGramPositivoDaptomicina) {
		this.antibiogramaCocoGramPositivoDaptomicina = antibiogramaCocoGramPositivoDaptomicina;
	}

	public String getAntibiogramaCocoGramPositivoEritromicina() {
		return antibiogramaCocoGramPositivoEritromicina;
	}

	public void setAntibiogramaCocoGramPositivoEritromicina(String antibiogramaCocoGramPositivoEritromicina) {
		this.antibiogramaCocoGramPositivoEritromicina = antibiogramaCocoGramPositivoEritromicina;
	}

	public String getAntibiogramaCocoGramPositivoGentamicinaNivelAlto() {
		return antibiogramaCocoGramPositivoGentamicinaNivelAlto;
	}

	public void setAntibiogramaCocoGramPositivoGentamicinaNivelAlto(
			String antibiogramaCocoGramPositivoGentamicinaNivelAlto) {
		this.antibiogramaCocoGramPositivoGentamicinaNivelAlto = antibiogramaCocoGramPositivoGentamicinaNivelAlto;
	}

	public String getAntibiogramaCocoGramPositivoEstreptomicinaNivelAlto() {
		return antibiogramaCocoGramPositivoEstreptomicinaNivelAlto;
	}

	public void setAntibiogramaCocoGramPositivoEstreptomicinaNivelAlto(
			String antibiogramaCocoGramPositivoEstreptomicinaNivelAlto) {
		this.antibiogramaCocoGramPositivoEstreptomicinaNivelAlto = antibiogramaCocoGramPositivoEstreptomicinaNivelAlto;
	}

	public String getAntibiogramaCocoGramPositivoLinezolid() {
		return antibiogramaCocoGramPositivoLinezolid;
	}

	public void setAntibiogramaCocoGramPositivoLinezolid(String antibiogramaCocoGramPositivoLinezolid) {
		this.antibiogramaCocoGramPositivoLinezolid = antibiogramaCocoGramPositivoLinezolid;
	}

	public String getAntibiogramaCocoGramPositivoNitrofurantoína() {
		return antibiogramaCocoGramPositivoNitrofurantoína;
	}

	public void setAntibiogramaCocoGramPositivoNitrofurantoína(String antibiogramaCocoGramPositivoNitrofurantoína) {
		this.antibiogramaCocoGramPositivoNitrofurantoína = antibiogramaCocoGramPositivoNitrofurantoína;
	}

	public String getAntibiogramaCocoGramPositivoRifampicina() {
		return antibiogramaCocoGramPositivoRifampicina;
	}

	public void setAntibiogramaCocoGramPositivoRifampicina(String antibiogramaCocoGramPositivoRifampicina) {
		this.antibiogramaCocoGramPositivoRifampicina = antibiogramaCocoGramPositivoRifampicina;
	}

	public String getAntibiogramaCocoGramPositivoTetraciclina() {
		return antibiogramaCocoGramPositivoTetraciclina;
	}

	public void setAntibiogramaCocoGramPositivoTetraciclina(String antibiogramaCocoGramPositivoTetraciclina) {
		this.antibiogramaCocoGramPositivoTetraciclina = antibiogramaCocoGramPositivoTetraciclina;
	}

	public String getAntibiogramaCocoGramPositivoVancomicina() {
		return antibiogramaCocoGramPositivoVancomicina;
	}

	public void setAntibiogramaCocoGramPositivoVancomicina(String antibiogramaCocoGramPositivoVancomicina) {
		this.antibiogramaCocoGramPositivoVancomicina = antibiogramaCocoGramPositivoVancomicina;
	}

	public String getAntibiogramaCocoGramPositivoTrimetoprimaSulfametoxazol() {
		return antibiogramaCocoGramPositivoTrimetoprimaSulfametoxazol;
	}

	public void setAntibiogramaCocoGramPositivoTrimetoprimaSulfametoxazol(
			String antibiogramaCocoGramPositivoTrimetoprimaSulfametoxazol) {
		this.antibiogramaCocoGramPositivoTrimetoprimaSulfametoxazol = antibiogramaCocoGramPositivoTrimetoprimaSulfametoxazol;
	}

	public String getHongoAislado() {
		return hongoAislado;
	}

	public void setHongoAislado(String hongoAislado) {
		this.hongoAislado = hongoAislado;
	}

	public String getProteinasPositivo() {
		return proteinasPositivo;
	}

	public void setProteinasPositivo(String proteinasPositivo) {
		this.proteinasPositivo = proteinasPositivo;
	}

	public String getSangrePositivo() {
		return sangrePositivo;
	}

	public void setSangrePositivo(String sangrePositivo) {
		this.sangrePositivo = sangrePositivo;
	}

	public String getAntibiogramaBaciloGramNegativoAztreonam() {
		return antibiogramaBaciloGramNegativoAztreonam;
	}

	public void setAntibiogramaBaciloGramNegativoAztreonam(String antibiogramaBaciloGramNegativoAztreonam) {
		this.antibiogramaBaciloGramNegativoAztreonam = antibiogramaBaciloGramNegativoAztreonam;
	}

	public String getAntibiogramaBaciloGramNegativoCeftolozanetazobactam() {
		return antibiogramaBaciloGramNegativoCeftolozanetazobactam;
	}

	public void setAntibiogramaBaciloGramNegativoCeftolozanetazobactam(
			String antibiogramaBaciloGramNegativoCeftolozanetazobactam) {
		this.antibiogramaBaciloGramNegativoCeftolozanetazobactam = antibiogramaBaciloGramNegativoCeftolozanetazobactam;
	}

	public String getAntibiogramaBaciloGramNegativoCeftazidimaavibactam() {
		return antibiogramaBaciloGramNegativoCeftazidimaavibactam;
	}

	public void setAntibiogramaBaciloGramNegativoCeftazidimaavibactam(
			String antibiogramaBaciloGramNegativoCeftazidimaavibactam) {
		this.antibiogramaBaciloGramNegativoCeftazidimaavibactam = antibiogramaBaciloGramNegativoCeftazidimaavibactam;
	}

	public String getAntibiogramaBaciloGramNegativoImipenem() {
		return antibiogramaBaciloGramNegativoImipenem;
	}

	public void setAntibiogramaBaciloGramNegativoImipenem(String antibiogramaBaciloGramNegativoImipenem) {
		this.antibiogramaBaciloGramNegativoImipenem = antibiogramaBaciloGramNegativoImipenem;
	}

	public String getAntibiogramaBaciloGramNegativoTigecilina() {
		return antibiogramaBaciloGramNegativoTigecilina;
	}

	public void setAntibiogramaBaciloGramNegativoTigecilina(String antibiogramaBaciloGramNegativoTigecilina) {
		this.antibiogramaBaciloGramNegativoTigecilina = antibiogramaBaciloGramNegativoTigecilina;
	}

	public String getAntibiogramaCocoGramResistenciaClindamicina() {
		return antibiogramaCocoGramResistenciaClindamicina;
	}

	public void setAntibiogramaCocoGramResistenciaClindamicina(String antibiogramaCocoGramResistenciaClindamicina) {
		this.antibiogramaCocoGramResistenciaClindamicina = antibiogramaCocoGramResistenciaClindamicina;
	}

	public String getAntibiogramaCocoGramPositivoOxaciclina() {
		return antibiogramaCocoGramPositivoOxaciclina;
	}

	public void setAntibiogramaCocoGramPositivoOxaciclina(String antibiogramaCocoGramPositivoOxaciclina) {
		this.antibiogramaCocoGramPositivoOxaciclina = antibiogramaCocoGramPositivoOxaciclina;
	}

	public void setAntibiogramaBaciloGramNegativoCefepima(String antibiogramaBaciloGramNegativoCefepima) {
		this.antibiogramaBaciloGramNegativoCefepima = antibiogramaBaciloGramNegativoCefepima;
	}

	public String getTirasLEU() {
		return tirasLEU;
	}

	public void setTirasLEU(String tirasLEU) {
		this.tirasLEU = tirasLEU;
	}

	public String getTirasNIT() {
		return tirasNIT;
	}

	public void setTirasNIT(String tirasNIT) {
		this.tirasNIT = tirasNIT;
	}

	public String getTirasURO() {
		return tirasURO;
	}

	public void setTirasURO(String tirasURO) {
		this.tirasURO = tirasURO;
	}

	public String getTirasPRO() {
		return tirasPRO;
	}

	public void setTirasPRO(String tirasPRO) {
		this.tirasPRO = tirasPRO;
	}

	public String getTiraspH() {
		return tiraspH;
	}

	public void setTiraspH(String tiraspH) {
		this.tiraspH = tiraspH;
	}

	public String getTirasBLO() {
		return tirasBLO;
	}

	public void setTirasBLO(String tirasBLO) {
		this.tirasBLO = tirasBLO;
	}

	public String getTirasSG() {
		return tirasSG;
	}

	public void setTirasSG(String tirasSG) {
		this.tirasSG = tirasSG;
	}

	public String getTirasKET() {
		return tirasKET;
	}

	public void setTirasKET(String tirasKET) {
		this.tirasKET = tirasKET;
	}

	public String getTirasBIL() {
		return tirasBIL;
	}

	public void setTirasBIL(String tirasBIL) {
		this.tirasBIL = tirasBIL;
	}

	public String getTirasGLU() {
		return tirasGLU;
	}

	public void setTirasGLU(String tirasGLU) {
		this.tirasGLU = tirasGLU;
	}

	public String getAntifungigramaFluconazol() {
		return antifungigramaFluconazol;
	}

	public void setAntifungigramaFluconazol(String antifungigramaFluconazol) {
		this.antifungigramaFluconazol = antifungigramaFluconazol;
	}

	public String getAntifungigramaAnfotericinaB() {
		return antifungigramaAnfotericinaB;
	}

	public void setAntifungigramaAnfotericinaB(String antifungigramaAnfotericinaB) {
		this.antifungigramaAnfotericinaB = antifungigramaAnfotericinaB;
	}

	public String getAntifungigramaVoriconazol() {
		return antifungigramaVoriconazol;
	}

	public void setAntifungigramaVoriconazol(String antifungigramaVoriconazol) {
		this.antifungigramaVoriconazol = antifungigramaVoriconazol;
	}

	public String getAntifungigramaMicafungina() {
		return antifungigramaMicafungina;
	}

	public void setAntifungigramaMicafungina(String antifungigramaMicafungina) {
		this.antifungigramaMicafungina = antifungigramaMicafungina;
	}

	public String getAntifungigramaCaspofungina() {
		return antifungigramaCaspofungina;
	}

	public void setAntifungigramaCaspofungina(String antifungigramaCaspofungina) {
		this.antifungigramaCaspofungina = antifungigramaCaspofungina;
	}

	public String getAntifungigramaFlucitosina() {
		return antifungigramaFlucitosina;
	}

	public void setAntifungigramaFlucitosina(String antifungigramaFlucitosina) {
		this.antifungigramaFlucitosina = antifungigramaFlucitosina;
	}

	public String getCategoriaGermen() {
		return categoriaGermen;
	}

	public void setCategoriaGermen(String categoriaGermen) {
		this.categoriaGermen = categoriaGermen;
	}

	public String getFirmaEncargado() {
		return firmaEncargado;
	}

	public void setFirmaEncargado(String firmaEncargado) {
		this.firmaEncargado = firmaEncargado;
	}

	public String getRecuentoColoniasNroComentario() {
		return recuentoColoniasNroComentario;
	}

	public void setRecuentoColoniasNroComentario(String recuentoColoniasNroComentario) {
		this.recuentoColoniasNroComentario = recuentoColoniasNroComentario;
	}

	public String getGermenAisladoTexto() {
		return germenAisladoTexto;
	}

	public void setGermenAisladoTexto(String germenAisladoTexto) {
		this.germenAisladoTexto = germenAisladoTexto;
	}

	public String getFechaIngresoMuestra() {
		return fechaIngresoMuestra;
	}

	public void setFechaIngresoMuestra(String fechaIngresoMuestra) {
		this.fechaIngresoMuestra = fechaIngresoMuestra;
	}



	
	
	
	

	
	
	

}
