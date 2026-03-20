package com.ivules.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivules.dao.ICuestionarioBasalDao;
import com.ivules.entity.CuestionarioBasal;

import com.ivules.service.CuestionarioBasalService;
import com.ivules.service.PersonasService;
import com.ivules.util.exceptions.IvulesException;

@Service
public class CuestionarioBasalServiceImpl implements CuestionarioBasalService {
	
	@Autowired
	private ICuestionarioBasalDao cuestionariobasalDao;
	
	@Autowired
	private PersonasService personaService;
	
	public CuestionarioBasalServiceImpl(ICuestionarioBasalDao cuestionariobasalDao) {
        this.cuestionariobasalDao = cuestionariobasalDao;
    }
	
	@Override
	@Transactional(readOnly = true)
	public List<CuestionarioBasal> findAll() {
		return (List<CuestionarioBasal>) cuestionariobasalDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public int count() {
		return (int) cuestionariobasalDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public CuestionarioBasal findById(int id) {
		return cuestionariobasalDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CuestionarioBasal save(CuestionarioBasal cuestionariobasal) {
		return cuestionariobasalDao.save(cuestionariobasal);
	}

	@Override
	@Transactional
	public void delete(int id) {
		cuestionariobasalDao.deleteById(id);
	}

	@Override
	public List<CuestionarioBasal> buscar(Date fromDate, Date toDate, CuestionarioBasal cuestionariobasal, String orderBy,
			String orderDir, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public CuestionarioBasal actualizar(CuestionarioBasal cuestionariobasal) throws IvulesException {
		
		
			
			if ( cuestionariobasal.getCuestionarioId() == null ) {
				throw new IvulesException.DataNotFound("Error: cuestionario id es requerido ");
			}
			
			CuestionarioBasal cuestionarioBasalActual = findById(cuestionariobasal.getCuestionarioId());
			
			if ( cuestionarioBasalActual == null ) {
				String mensaje = "No se pudo editar, el cuestionario ID: "
						.concat(String.valueOf(cuestionariobasal.getCuestionarioId()).concat(" no existe en la base de datos!"));
				throw new IvulesException.DataNotFound(mensaje);
			}
			
			
			return cuestionariobasalDao.save(cuestionariobasal);
		}

	@Override
	public boolean comprobarCampos(CuestionarioBasal cuestionarioBasal) {
		boolean resultado= false;
		if(cuestionarioBasal.getDosis()== null) {
			resultado = true;
		}else if (cuestionarioBasal.getDosisAcumuladaUltimo6meses() == null){
			resultado = true;
		}else if (cuestionarioBasal.getDosisDiariaCantidadMg() == null) {
			resultado = true;
		}else if (cuestionarioBasal.getEdadMenopausia() == null) {
			resultado = true;
		}else if(cuestionarioBasal.getEstadoEncuentra()== null) {
			resultado = true;
		}else if( cuestionarioBasal.getFactoresRiesgoAntecedentesIvuUltimoAnho()== null) {
			resultado = true;
		}else if(cuestionarioBasal.getFactoresRiesgoAntibioticoterapiaUltimos6m() == null) {
			resultado = true;
		}else if(cuestionarioBasal.getFactoresRiesgoEmbarazo() == null) {
			resultado = true;
		}else if( cuestionarioBasal.getFactoresRiesgoEstreñimientoCronico() == null) {
			resultado = true;
		}else if( cuestionarioBasal.getFactoresRiesgoIncontinenciaUrinaria() == null) {
			resultado = true;
		}else if(cuestionarioBasal.getFactoresRiesgoProcedimientoUrinarioGinecPrevio() == null) {
			resultado = true;
		}else if(cuestionarioBasal.getFactoresRiesgoSondajeVesicalPrevio() == null) {
			resultado = true;
		}else if( cuestionarioBasal.getMenopausia() == null) {
			resultado = true;
		}else if (cuestionarioBasal.getNroIvusUltimo12meses() == null) {
			resultado = true;
		}else if (cuestionarioBasal.getOtrosFactoresRiesgo() == null) {
			resultado = true;
		}else if (cuestionarioBasal.getParticipaEstudio() == null) {
			resultado = true;
		}else if( cuestionarioBasal.getPresentaManifestacionRenal() == null) {
			resultado = true;
		}else if (cuestionarioBasal.getSledaiPuntos0A30() == null) {
			resultado = true;
		}else if(cuestionarioBasal.getTiempoEvolucionLes() == null) {
			resultado = true;
		}else if(cuestionarioBasal.getTipoIndividuo() == null) {
			resultado = true;
		}else if(cuestionarioBasal.getTipoIs() == null) {
			resultado = true;
		}else if( cuestionarioBasal.getTratamientoGlucocorticoides() == null) {
			resultado = true;
		}else if (cuestionarioBasal.getTratamientoInmunosupresoresIs() == null) {
			resultado = true;
		}else if(cuestionarioBasal.getUrocultivoPositivo()== null) {
			resultado = true;
		}else if(cuestionarioBasal.getOtroTipoIs()== null) {
			resultado = true;
			
		}else if(cuestionarioBasal.getEstadoEncuentra()== null) {
			resultado = true;
		}
		else if(cuestionarioBasal.getFactoresRiesgoLitiasisRenal()== null) {
			resultado = true;	
		}else if(cuestionarioBasal.getFactoresRiesgoCorticoides()== null) {
			resultado = true;

		}else if(cuestionarioBasal.getFactoresRiesgoSindromeSjogren()== null) {
				resultado = true;
			}else if(cuestionarioBasal.getFactoresRiesgoTipoEstreñimientoCronico()== null) {
				resultado = true;	
			}else if(cuestionarioBasal.getFactoresRiesgoFrecuenciaUrinariaBaja()== null) {
				resultado = true;
			}else if(cuestionarioBasal.getFactoresRiesgoActividadSexualNroVeces()== null) {
				resultado = true;
			}else if(cuestionarioBasal.getFactoresRiesgoTipoIncontinenciaUrinaria()== null) {
				resultado = true;	
			}else if(cuestionarioBasal.getFactoresRiesgoEnfermedadRenalCronica()== null) {
				resultado = true;	
			}else if(cuestionarioBasal.getFactoresRiesgoHiperplasiaProstaticaBenigna()== null) {
				resultado = true;	
			}else if(cuestionarioBasal.getFactoresRiesgoDiabetes()== null) {
				resultado = true;
			}else if(cuestionarioBasal.getFactoresRiesgoAnomaliasAnatomicasTractoUrinario()== null) {
				resultado = true;
			}else if(cuestionarioBasal.getFactoresRiesgoAnomaliasAnatomicasTractoUrinario()== null) {
				resultado = true;
			}else if(cuestionarioBasal.getFactoresRiesgoLeucopenia()== null) {
				resultado = true;	
			}else if(cuestionarioBasal.getFactoresRiesgoTipoLeucopenia()== null) {
				resultado = true;
			}else if(cuestionarioBasal.getIvusUltimo12meses()== null) {
				resultado = true;	
			}else if(cuestionarioBasal.getFirmaEncargado()== null) {
				resultado = true;	
			
		}else {
			resultado = false;
		}
		return resultado;
	}

	@Override
	public CuestionarioBasal findByPersonaId(int id) throws IvulesException {
		return cuestionariobasalDao.findByPersonas(personaService.obtener(id));
	}

	
	@Override
	public ByteArrayInputStream exportExcelCuestionarioBasal() throws Exception {
		String[] columns = {"codigo","	cedula","nombres", 	"apellidos","edad","estado_civil","sexo","ciudad_residencia",
				
				"menopausia","edad_menopausia",	
				"factores_riesgo_sexualmente_activo","tipo_actividad_sexual","actividad_sexual_nroveces",	
				"factores_riesgo_estreñimiento_cronico","tipo_estreñimientocronico",	
				"factores_riesgo_frecuencia_urinaria_baja","factores_riesgo_baja_ingestaliquidos",	
				"factores_riesgo_incontinencia_urinaria","tipo_incontinencia_urinaria","factores_riesgo_sondaje_vesical_previo",
				"factores_riesgo_procedimiento_urinario_ginec_previo","procedimiento_urinario_ginec_previo_especificar",
				
				"recibio_profilaxis_acorde_guias","factores_riesgo_infeccion_vaginal",	
				"nro_infeccion_vaginal_anual","factores_riesgo_antecedentes_ivu_ultimo_anho",	
				"factores_riesgo_antibioticoterapia_ultimos_6m","antibioticoterapia_ultimos_6m_especificar",
				"factores_riesgo_embarazo","factores_riesgo_litiasis_renal","factores_riesgo_enfermedad_renal_cronica",	
				"factores_riesgo_hiperplasia_prostatica_benigna","factores_riesgo_diabetes",	
				"factores_riesgo_anomaliasanatomicastractourinario","anomaliasanatomicastractourinarioespecificar",	
				"factores_riesgo_corticoides","factores_riesgo_cancer","factores_riesgo_otras_causas_inmunodepresion",	
				"otras_causas_inmunodepresion_especificar","otros_factores_riesgo",	
				"ivus_ultimo_12meses","nro_ivus_ultimo_12meses","tipo_individuo","tiempo_evolucion_les",
				"tratamiento_glucocorticoides","dosis_diaria_cantidad_mg","dosis_acumulada_ultimo_6meses",	
				"tratamiento_inmunosupresores_is","tipo_is","otro_tipo_is","dosis","presenta_manifestacion_renal",	
				"estado_encuentra","antidna_positivo","anticuerpos_saf_positivos",	
				"complementos_bajos","factores_riesgo_sindrome_sjogren","factores_riesgo_leucopenia",	
				"tipo_leucopenia","sledai_puntos0_30","firma_encargado",	
				"fecha_creacion","usuario_creacion"
				
				
};
		
		Workbook workbook = new XSSFWorkbook();
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		
		Sheet sheet = workbook.createSheet("CuestionarioBasal");
		Row row = sheet.createRow(0);
		final DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		for (int i = 0; i < columns.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(columns[i]);
			
		}
		List<CuestionarioBasal> cbList = this.excelParaCuestionarioBasal();
		int initRow = 1;
		for (CuestionarioBasal cb : cbList) {
			row = sheet.createRow(initRow);
			row.createCell(0).setCellValue(cb.getPersonas().getCodigo());
			row.createCell(1).setCellValue(cb.getPersonas().getCedula());
			row.createCell(2).setCellValue(cb.getPersonas().getNombres());
			row.createCell(3).setCellValue(cb.getPersonas().getApellidos());
			row.createCell(4).setCellValue(cb.getPersonas().getEdad());
			row.createCell(5).setCellValue(cb.getPersonas().getEstadoCivil());
			row.createCell(6).setCellValue(cb.getPersonas().getSexo());
			row.createCell(7).setCellValue(cb.getPersonas().getCiudadResidencia());
			/*				*/
			row.createCell(8).setCellValue(cb.getMenopausia());
			row.createCell(9).setCellValue(cb.getEdadMenopausia());
			row.createCell(10).setCellValue(cb.getFactoresRiesgoSexualmenteActivo());
			row.createCell(11).setCellValue(cb.getTipoActividadSexual());
			row.createCell(12).setCellValue(cb.getFactoresRiesgoActividadSexualNroVeces());
			row.createCell(13).setCellValue(cb.getFactoresRiesgoEstreñimientoCronico());
			row.createCell(14).setCellValue(cb.getFactoresRiesgoTipoEstreñimientoCronico());
			row.createCell(15).setCellValue(cb.getFactoresRiesgoFrecuenciaUrinariaBaja());
			row.createCell(16).setCellValue(cb.getFactoresRiesgoBajaIngestaliquidos());
			row.createCell(17).setCellValue(cb.getFactoresRiesgoIncontinenciaUrinaria());	
			
			/* */
			row.createCell(18).setCellValue(cb.getFactoresRiesgoTipoIncontinenciaUrinaria());
			row.createCell(19).setCellValue(cb.getFactoresRiesgoSondajeVesicalPrevio());
			row.createCell(20).setCellValue(cb.getFactoresRiesgoProcedimientoUrinarioGinecPrevio());
			row.createCell(21).setCellValue(cb.getProcedimientoUrinarioGinecPrevioEspecificar());
			row.createCell(22).setCellValue(cb.getRecibioProfilaxisAcordeGuias());
			row.createCell(23).setCellValue(cb.getInfeccionVaginal());
			row.createCell(24).setCellValue(cb.getNroInfeccionVaginalAnual());
			row.createCell(25).setCellValue(cb.getFactoresRiesgoAntecedentesIvuUltimoAnho());
			row.createCell(26).setCellValue(cb.getFactoresRiesgoAntibioticoterapiaUltimos6m());	
			row.createCell(27).setCellValue(cb.getAntibioticoterapiaUltimos6mEspecificar());	
			
			/*
				
				 */
			
			row.createCell(28).setCellValue(cb.getFactoresRiesgoEmbarazo());
			row.createCell(29).setCellValue(cb.getFactoresRiesgoLitiasisRenal());
			row.createCell(30).setCellValue(cb.getFactoresRiesgoEnfermedadRenalCronica());
			row.createCell(31).setCellValue(cb.getFactoresRiesgoHiperplasiaProstaticaBenigna());
			row.createCell(32).setCellValue(cb.getFactoresRiesgoDiabetes());
			row.createCell(33).setCellValue(cb.getFactoresRiesgoAnomaliasAnatomicasTractoUrinario());
			
			/*					*/
			
			row.createCell(34).setCellValue(cb.getFactoresRiesgoAnomaliasAnatomicasTractoEspecificar());
			row.createCell(35).setCellValue(cb.getFactoresRiesgoCorticoides());
			row.createCell(36).setCellValue(cb.getFactoresRiesgoCancer());
			row.createCell(37).setCellValue(cb.getFactoresRiesgoOtrasCausasInmunodepresion());
			row.createCell(38).setCellValue(cb.getOtrasCausasInmunodepresionEspecificar());
			row.createCell(39).setCellValue(cb.getOtrosFactoresRiesgo());
			row.createCell(40).setCellValue(cb.getIvusUltimo12meses());
			row.createCell(41).setCellValue(cb.getNroIvusUltimo12meses());
			row.createCell(42).setCellValue(cb.getTipoIndividuo());	
			row.createCell(43).setCellValue(cb.getTiempoEvolucionLes());	
			row.createCell(44).setCellValue(cb.getTratamientoGlucocorticoides());
			row.createCell(45).setCellValue(cb.getDosisDiariaCantidadMg());
			row.createCell(46).setCellValue(cb.getDosisAcumuladaUltimo6meses());
			row.createCell(47).setCellValue(cb.getTratamientoInmunosupresoresIs());
			row.createCell(48).setCellValue(cb.getTipoISTexto());
			row.createCell(49).setCellValue(cb.getOtroTipoIs());
			row.createCell(50).setCellValue(cb.getDosis());
			row.createCell(51).setCellValue(cb.getPresentaManifestacionRenal());
			row.createCell(52).setCellValue(cb.getEstadoEncuentra());
			row.createCell(53).setCellValue(cb.getAntiDNAPositivo());
			row.createCell(54).setCellValue(cb.getAnticuerposSAFpositivos());
			
			/* ----------*/
			row.createCell(55).setCellValue(cb.getComplementosBajos());
			row.createCell(56).setCellValue(cb.getFactoresRiesgoSindromeSjogren());

/*"firma_encargado",	
				"fecha_creacion","fecha_modificacion","usuario_creacion"----------*/
			
			row.createCell(57).setCellValue(cb.getFactoresRiesgoLeucopenia());
			row.createCell(58).setCellValue(cb.getFactoresRiesgoTipoLeucopenia());
			row.createCell(59).setCellValue(cb.getSledaiPuntos0A30());
			row.createCell(60).setCellValue(cb.getFirmaEncargado());
			row.createCell(61).setCellValue(cb.getFechaCreacion().format(CUSTOM_FORMATTER));
			
			row.createCell(62).setCellValue(cb.getUsuarioCreacion());
			
				

			initRow++;
		}
		

		
		
		
		
			workbook.write(stream);
			workbook.close();
		
		return new ByteArrayInputStream(stream.toByteArray());
	}

	@Override
	@Transactional(readOnly = true)
	public List<CuestionarioBasal> excelParaCuestionarioBasal() {
		return (List<CuestionarioBasal>) cuestionariobasalDao.excelParaCuestionarioBasal();
	}

	@Override
	public ByteArrayInputStream exportExcelCuestionarioBasalModificado() throws Exception {
String[] columns = {"codigo",
		/*"	cedula","nombres", 	"apellidos",*/
		
		"edad","estado_civil","sexo","ciudad_residencia",
				
				"factores_riesgo_menopausia","edad_menopausia",	"anhos_histerectomia",	
				"factores_riesgo_sexualmente_activo","tipo_actividad_sexual","actividad_sexual_nroveces",	
				"factores_riesgo_estreñimiento_cronico","tipo_estreñimientocronico",	
				"factores_riesgo_frecuencia_urinaria_baja","factores_riesgo_baja_ingestaliquidos",	
				"factores_riesgo_incontinencia_urinaria","tipo_incontinencia_urinaria","factores_riesgo_sondaje_vesical_previo",
				"factores_riesgo_procedimiento_urinario_ginec_previo","procedimiento_urinario_ginec_previo_especificar",
				
				"recibio_profilaxis_acorde_guias","factores_riesgo_infeccion_vaginal",	
				"nro_infeccion_vaginal_anual","factores_riesgo_antecedentes_ivu_ultimo_anho",	
				"factores_riesgo_antibioticoterapia_ultimos_6m","antibioticoterapia_ultimos_6m_especificar",
				"factores_riesgo_embarazo","factores_riesgo_litiasis_renal","factores_riesgo_enfermedad_renal_cronica",	
				"factores_riesgo_hiperplasia_prostatica_benigna","factores_riesgo_diabetes",	
				"factores_riesgo_anomaliasanatomicastractourinario","anomaliasanatomicastractourinarioespecificar",	
				"factores_riesgo_corticoides","factores_riesgo_cancer","factores_riesgo_otras_causas_inmunodepresion",	
				"otras_causas_inmunodepresion_especificar","otros_factores_riesgo",	
				"ivus_ultimo_12meses","nro_ivus_ultimo_12meses","tipo_individuo","tiempo_evolucion_les",
				"tratamiento_glucocorticoides","dosis_diaria_cantidad_mg","dosis_acumulada_ultimo_6meses",	
				"tratamiento_inmunosupresores_is","tipo_is","otro_tipo_is","dosis","presenta_manifestacion_renal",	
				"estado_encuentra","antidna_positivo","anticuerpos_saf_positivos",	
				"complementos_bajos","factores_riesgo_sindrome_sjogren","factores_riesgo_leucopenia",	
				"tipo_leucopenia","sledai_puntos0_30","firma_encargado",	
				"fecha_creacion","usuario_creacion",
				
				/*aqui cambia*/
					
				"presento_sintomas",
				"sintoma_disuria",
				 "sintoma_dolor_lumbar","sintoma_fiebre","sintoma_hematuria","sintoma_polaquiuria","sintoma_presion_retorcijones_parte_inferior_abdomen","sintoma_tenesmo",
				 "sintoma_urgencia","sintoma_vomito","sintoma_dolorsuprapubico","otro_sintomas_ivu",
				"germen_Si_AntecedentesIVU",
               
				
				
};
		
		Workbook workbook = new XSSFWorkbook();
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		
		Sheet sheet = workbook.createSheet("CuestionarioBasal");
		Row row = sheet.createRow(0);
		final DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		for (int i = 0; i < columns.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(columns[i]);
			
		}
		List<CuestionarioBasal> cbList = this.excelParaCuestionarioBasal();
		int initRow = 1;
		for (CuestionarioBasal cb : cbList) {
			row = sheet.createRow(initRow);
			row.createCell(0).setCellValue(cb.getPersonas().getCodigo());
			//row.createCell(1).setCellValue(cb.getPersonas().getCedula());
		    //row.createCell(2).setCellValue(cb.getPersonas().getNombres());
			//row.createCell(3).setCellValue(cb.getPersonas().getApellidos());
			row.createCell(1).setCellValue(cb.getPersonas().getEdad());
			row.createCell(2).setCellValue(cb.getPersonas().getEstadoCivil());
			row.createCell(3).setCellValue(cb.getPersonas().getSexo());
			row.createCell(4).setCellValue(cb.getPersonas().getCiudadResidencia());
			/*				*/
			row.createCell(5).setCellValue(cb.getMenopausia());
			row.createCell(6).setCellValue(cb.getEdadMenopausia());
			row.createCell(7).setCellValue(cb.getAnhosHisterectomia());
			row.createCell(8).setCellValue(cb.getFactoresRiesgoSexualmenteActivo());
			row.createCell(9).setCellValue(cb.getTipoActividadSexual());
			row.createCell(10).setCellValue(cb.getFactoresRiesgoActividadSexualNroVeces());
			row.createCell(11).setCellValue(cb.getFactoresRiesgoEstreñimientoCronico());
			row.createCell(12).setCellValue(cb.getFactoresRiesgoTipoEstreñimientoCronico());
			row.createCell(13).setCellValue(cb.getFactoresRiesgoFrecuenciaUrinariaBaja());
			row.createCell(14).setCellValue(cb.getFactoresRiesgoBajaIngestaliquidos());
			row.createCell(15).setCellValue(cb.getFactoresRiesgoIncontinenciaUrinaria());	
			
			/* */
			row.createCell(16).setCellValue(cb.getFactoresRiesgoTipoIncontinenciaUrinaria());
			row.createCell(17).setCellValue(cb.getFactoresRiesgoSondajeVesicalPrevio());
			row.createCell(18).setCellValue(cb.getFactoresRiesgoProcedimientoUrinarioGinecPrevio());
			row.createCell(19).setCellValue(cb.getProcedimientoUrinarioGinecPrevioEspecificar());
			row.createCell(20).setCellValue(cb.getRecibioProfilaxisAcordeGuias());
			row.createCell(21).setCellValue(cb.getInfeccionVaginal());
			row.createCell(22).setCellValue(cb.getNroInfeccionVaginalAnual());
			row.createCell(23).setCellValue(cb.getFactoresRiesgoAntecedentesIvuUltimoAnho());
			row.createCell(24).setCellValue(cb.getFactoresRiesgoAntibioticoterapiaUltimos6m());	
			row.createCell(25).setCellValue(cb.getAntibioticoterapiaUltimos6mEspecificar());	
			
			/*
				
				 */
			
			row.createCell(26).setCellValue(cb.getFactoresRiesgoEmbarazo());
			row.createCell(27).setCellValue(cb.getFactoresRiesgoLitiasisRenal());
			row.createCell(28).setCellValue(cb.getFactoresRiesgoEnfermedadRenalCronica());
			row.createCell(29).setCellValue(cb.getFactoresRiesgoHiperplasiaProstaticaBenigna());
			row.createCell(30).setCellValue(cb.getFactoresRiesgoDiabetes());
			row.createCell(31).setCellValue(cb.getFactoresRiesgoAnomaliasAnatomicasTractoUrinario());
			
			/*					*/
			
			row.createCell(32).setCellValue(cb.getFactoresRiesgoAnomaliasAnatomicasTractoEspecificar());
			row.createCell(33).setCellValue(cb.getFactoresRiesgoCorticoides());
			row.createCell(34).setCellValue(cb.getFactoresRiesgoCancer());
			row.createCell(35).setCellValue(cb.getFactoresRiesgoOtrasCausasInmunodepresion());
			row.createCell(36).setCellValue(cb.getOtrasCausasInmunodepresionEspecificar());
			row.createCell(37).setCellValue(cb.getOtrosFactoresRiesgo());
			row.createCell(38).setCellValue(cb.getIvusUltimo12meses());
			row.createCell(39).setCellValue(cb.getNroIvusUltimo12meses());
			row.createCell(40).setCellValue(cb.getTipoIndividuo());	
			row.createCell(41).setCellValue(cb.getTiempoEvolucionLes());	
			row.createCell(42).setCellValue(cb.getTratamientoGlucocorticoides());
			row.createCell(43).setCellValue(cb.getDosisDiariaCantidadMg());
			row.createCell(44).setCellValue(cb.getDosisAcumuladaUltimo6meses());
			row.createCell(45).setCellValue(cb.getTratamientoInmunosupresoresIs());
			row.createCell(46).setCellValue(cb.getTipoISTexto());
			row.createCell(47).setCellValue(cb.getOtroTipoIs());
			row.createCell(48).setCellValue(cb.getDosis());
			row.createCell(49).setCellValue(cb.getPresentaManifestacionRenal());
			row.createCell(50).setCellValue(cb.getEstadoEncuentra());
			row.createCell(51).setCellValue(cb.getAntiDNAPositivo());
			row.createCell(52).setCellValue(cb.getAnticuerposSAFpositivos());
			
			/* ----------*/
			row.createCell(53).setCellValue(cb.getComplementosBajos());
			row.createCell(54).setCellValue(cb.getFactoresRiesgoSindromeSjogren());

/*"firma_encargado",	
				"fecha_creacion","fecha_modificacion","usuario_creacion"----------*/
			
			row.createCell(55).setCellValue(cb.getFactoresRiesgoLeucopenia());
			row.createCell(56).setCellValue(cb.getFactoresRiesgoTipoLeucopenia());
			row.createCell(57).setCellValue(cb.getSledaiPuntos0A30());
			row.createCell(58).setCellValue(cb.getFirmaEncargado());
			row.createCell(59).setCellValue(cb.getFechaCreacion().format(CUSTOM_FORMATTER));
			
			row.createCell(60).setCellValue(cb.getUsuarioCreacion());
			
			/*"presento_sintomas",
				"sintoma_disuria",
				 "sintoma_dolor_lumbar","sintoma_fiebre","sintoma_hematuria","sintoma_polaquiuria","sintoma_presion_retorcijones_parte_inferior_abdomen","sintoma_tenesmo",
				 "sintoma_urgencia","sintoma_vomito","sintoma_dolorsuprasubico","otro_sintomas_ivu",
				"germen_Si_AntecedentesIVU",*/
			row.createCell(61).setCellValue(cb.getSintomasUrinarios());
			row.createCell(62).setCellValue(cb.getSintomaDisuria());
			row.createCell(63).setCellValue("");
			row.createCell(64).setCellValue(cb.getSintomaFiebre());
			row.createCell(65).setCellValue("");
			row.createCell(66).setCellValue(cb.getSintomaPolaquiuria());
			row.createCell(67).setCellValue("");
			row.createCell(68).setCellValue(cb.getSintomaTenesmo());
			row.createCell(69).setCellValue(cb.getSintomaUrgenciaMiccional());
			row.createCell(70).setCellValue("");
			row.createCell(71).setCellValue(cb.getSintomaDolorSuprapubico());
			row.createCell(72).setCellValue(cb.getOtroSintomasIVU());
			row.createCell(73).setCellValue(cb.getGermenSiAntecedentes());



			
				

			initRow++;
		}
		

		
		
		
		
			workbook.write(stream);
			workbook.close();
		
		return new ByteArrayInputStream(stream.toByteArray());
	}


	

}
