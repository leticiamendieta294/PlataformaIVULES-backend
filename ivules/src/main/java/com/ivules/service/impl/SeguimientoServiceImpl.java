package com.ivules.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

import com.ivules.dao.ISeguimientoDao;

import com.ivules.entity.Seguimiento;
import com.ivules.service.PersonasService;
import com.ivules.service.SeguimientoService;
import com.ivules.util.exceptions.IvulesException;

@Service
public class SeguimientoServiceImpl implements SeguimientoService {
	
	@Autowired
	private ISeguimientoDao seguimientoDao;
	@Autowired
	private PersonasService personaService;

	
	public SeguimientoServiceImpl(ISeguimientoDao seguimientoDao) {
        this.seguimientoDao = seguimientoDao;
    }
	
	@Override
	@Transactional(readOnly = true)
	public List<Seguimiento> findAll() {
		return (List<Seguimiento>) seguimientoDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public int count() {
		return (int) seguimientoDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Seguimiento findById(int id) {
		return seguimientoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Seguimiento save(Seguimiento seguimiento) {
		return seguimientoDao.save(seguimiento);
	}

	@Override
	@Transactional
	public void delete(int id) {
		seguimientoDao.deleteById(id);
	}

	@Override
	public List<Seguimiento> buscar(Date fromDate, Date toDate, Seguimiento seguimiento, String orderBy,
			String orderDir, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seguimiento> findByPersonaId(int id) throws IvulesException {
		return seguimientoDao.findByPersonasOrderByNumero(personaService.obtener(id));
		
	}

	@Override
	public List<String> comprobarEstadoSeguimiento(int id) throws IvulesException {
		List <Seguimiento> seguimientoList = findByPersonaId(id);
		String r = "";
		int resta = 0;
		List<String> resultado= new ArrayList<>();
		
		
		if(seguimientoList.isEmpty()|| seguimientoList == null) {
			resultado.add("vacio");
			resultado.add("vacio");
			resultado.add("vacio");
			resultado.add("vacio");
		}else {
			
			for (int i = 0; i < seguimientoList.size(); i++) {
				if(seguimientoList.get(i).getDosis()== null) {
					r = "no";
				}else if(seguimientoList.get(i).getDosisAcumuladaUltimaVisita() == null) {
					r = "no";
				}else if(seguimientoList.get(i).getDosisDiariaCantidadMg()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getEstadoEncuentra()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getFactoresRiesgoAntecedentesIvu()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getFactoresRiesgoEmbarazo()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getFactoresRiesgoAntibioticoterapiaUltimaVisita()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getFactoresRiesgoEstreñimientoCronico()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getFactoresRiesgoIncontinenciaUrinaria()==null) {
					r = "no";
			    }else if(seguimientoList.get(i).getFactoresRiesgoProcedimientoUrinarioGinecPrevio()==null) {
					r = "no";
			    }else if(seguimientoList.get(i).getGermenAislado()==null) {
					r = "no";
			    }else if(seguimientoList.get(i).getNroIVUs()==null) {
					r = "no";
			    }else if(seguimientoList.get(i).getOtrosFactoresRiesgo()==null) {
					r = "no";
			    }else if(seguimientoList.get(i).getPresentaManifestacionRenal()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getPresentoSintomas()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getSintomasIVU()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getSledaiPuntos0A30()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getTiempoEvolucionLes()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getTipoAntibiotico()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getTipoIs()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getTipoIVU()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getTipoMicrobio()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getTratamientoGlucocorticoides()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getTratamientoInmunosupresoresIs()==null) {
					r = "no";
				}else if(seguimientoList.get(i).getOtroTipoIs()== null) {
					r = "no";
				}else if(seguimientoList.get(i).getOtroGermenAislado()== null) {
					r = "no";
				}
				else if(seguimientoList.get(i).getOtroSintomasIVU()== null) {
					r = "no";
				}else if(seguimientoList.get(i).getFactoresRiesgoLitiasisRenal()== null) {
					r = "no";	
				}else if(seguimientoList.get(i).getFactoresRiesgoCorticoides()== null) {
					r = "no";
				}else if(seguimientoList.get(i).getEstadoEncuentra()== null) {
					r = "no";
				
				}else if(seguimientoList.get(i).getFactoresRiesgoSindromeSjogren()== null) {
					r = "no";
				}else if(seguimientoList.get(i).getFactoresRiesgoTipoEstreñimientoCronico()== null) {
					r = "no";	
				}else if(seguimientoList.get(i).getFactoresRiesgoFrecuenciaUrinariaBaja()== null) {
					r = "no";
				}else if(seguimientoList.get(i).getFactoresRiesgoActividadSexualNroVeces()== null) {
					r = "no";
				}else if(seguimientoList.get(i).getFactoresRiesgoTipoIncontinenciaUrinaria()== null) {
					r = "no";	
				}else if(seguimientoList.get(i).getFactoresRiesgoEnfermedadRenalCronica()== null) {
					r = "no";	
				}else if(seguimientoList.get(i).getFactoresRiesgoHiperplasiaProstaticaBenigna()== null) {
					r = "no";	
				}else if(seguimientoList.get(i).getFactoresRiesgoDiabetes()== null) {
					r = "no";
				}else if(seguimientoList.get(i).getFactoresRiesgoAnomaliasAnatomicasTractoUrinario()== null) {
					r = "no";
				}else if(seguimientoList.get(i).getFactoresRiesgoAnomaliasAnatomicasTractoEspecificar()== null) {
					r = "no";
				}else if(seguimientoList.get(i).getFactoresRiesgoLeucopenia()== null) {
					r = "no";	
				}else if(seguimientoList.get(i).getFactoresRiesgoTipoLeucopenia()== null) {
					r = "no";
				}else if(seguimientoList.get(i).getFirmaEncargado()== null) {
					r = "no";		
				}	
					
			else if(seguimientoList.get(i).getSintomaDisuria()== null) {
				r = "no";	
			}else if(seguimientoList.get(i).getSintomaPolaquiuria()== null) {
				r = "no";	
			}else if(seguimientoList.get(i).getSintomaHematuria()== null) {
				r = "no";
			}else if(seguimientoList.get(i).getSintomaDolorLumbar()== null) {
				r = "no";
			}else if(seguimientoList.get(i).getSintomaFiebre()== null) {
				r = "no";	
			}else if(seguimientoList.get(i).getSintomaPresionAbdomen()== null) {
				r = "no";	
			}else if(seguimientoList.get(i).getSintomaTenesmo()== null) {
				r = "no";
			}else if(seguimientoList.get(i).getSintomaUrgencia()== null) {
				r = "no";	
			}else if(seguimientoList.get(i).getSintomaVomito()== null) {
				r = "no";
				
				
			}else if(seguimientoList.get(i).getSeveridadIVU()== null) {
				r = "no";	
			}else if(seguimientoList.get(i).getClasificacionIVU()== null) {
				r = "no";
				
			}	
				
				else {
					r = "si";
				}
				resultado.add(r);
	}
			if(seguimientoList.size()< 4) {
				resta = 4- seguimientoList.size();
				for (int j = 0; j < resta; j++) {
					resultado.add("vacio");
				}
			}
		}
		
		
			
	return resultado;
}
	
	
	@Override
	@Transactional
	public Seguimiento actualizar(Seguimiento seguimiento) throws IvulesException {
		
		
			
			if ( seguimiento.getIdSeguimiento() == null ) {
				throw new IvulesException.DataNotFound("Error: seguimiento id es requerido ");
			}
			
			Seguimiento seguimientoActual = findByPersonaIdAndNumero(seguimiento.getPersonas().getPersonaId(),seguimiento.getNumero());
			
			if ( seguimientoActual == null ) {
				String mensaje = "No se pudo editar, el seguimiento ID: "
						.concat(String.valueOf(seguimientoActual.getIdSeguimiento()).concat(" no existe en la base de datos!"));
				throw new IvulesException.DataNotFound(mensaje);
			}
			
			
			return seguimientoDao.save(seguimiento);
		}

	@Override
	public Seguimiento findByPersonaIdAndNumero(int id, int numero) throws IvulesException {
		
		List<Seguimiento> sList = seguimientoDao.findByPersonasOrderByNumero(personaService.obtener(id));
		Seguimiento seguimiento = null;
		for (int i = 0; i < sList.size(); i++) {
			
			if (sList.get(i).getNumero()== numero) {
				seguimiento = sList.get(i);
			}
			
		}
		
		
		return seguimiento;
	}
	
	
	@Override
	public int countByNumero(int numero) throws IvulesException {
		
		return (int) seguimientoDao.countByNumero(numero);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Seguimiento> excelParaSeguimiento(int numero) {
		
		return (List<Seguimiento>) seguimientoDao.excelParaSeguimiento(numero);
	}

	@Override
	public ByteArrayInputStream exportAllDataModificado(int numero) throws Exception {
		String[] columns = {"codigo",
				/*"	cedula","nombres", 	"apellidos",*/
				
				"edad","estado_civil","sexo","ciudad_residencia",
						
						"factores_riesgo_menopausia","edad_menopausia","anhos_histerectomia",
						
						
						
                         "factores_riesgo_sexualmente_activo","tipo_actividad_sexual","actividad_sexual_nroveces",	
         				"factores_riesgo_estreñimiento_cronico","tipo_estreñimientocronico",	
         				"factores_riesgo_frecuencia_urinaria_baja","factores_riesgo_baja_ingestaliquidos",	
         				"factores_riesgo_incontinencia_urinaria","tipo_incontinencia_urinaria","factores_riesgo_sondaje_vesical_previo",
         				"factores_riesgo_procedimiento_urinario_ginec_previo","procedimiento_urinario_ginec_previo_especificar",
         				
         				"recibio_profilaxis_acorde_guias","factores_riesgo_infeccion_vaginal",	
         				"nro_infeccion_vaginal_anual","factores_riesgo_antecedentes_ivu",	
         				"factores_riesgo_antibioticoterapia_ultima_visita","antibioticoterapia_ultima_visita_especificar",
         				"factores_riesgo_embarazo","factores_riesgo_litiasis_renal","factores_riesgo_enfermedad_renal_cronica",	
         				"factores_riesgo_hiperplasia_prostatica_benigna","factores_riesgo_diabetes",	
         				"factores_riesgo_anomaliasanatomicastractourinario","anomaliasanatomicastractourinarioespecificar",	
         				"factores_riesgo_corticoides","factores_riesgo_cancer","factores_riesgo_otras_causas_inmunodepresion",	
         				"otras_causas_inmunodepresion_especificar","otros_factores_riesgo",	"","",
                         
                         
                         
						"tipo_individuo","tiempo_evolucion_les",
						"tratamiento_glucocorticoides","dosis_diaria_cantidad_mg","dosis_acumulada_ultimo_visita",	
						"tratamiento_inmunosupresores_is","tipo_is","otro_tipo_is","dosis","presenta_manifestacion_renal",	
						"estado_encuentra","antidna_positivo","",
						"complementos_bajos","factores_riesgo_sindrome_sjogren","factores_riesgo_leucopenia",	
						"tipo_leucopenia","sledai_puntos0_30","firma_encargado",	
						"fecha_creacion","usuario_creacion",
						/*aqui cambia*/
						"seguimiento_numero",
						"historia_ivu_ultima_visita",
						"como_hizo_diagnostico","fecha_diagnostico",	
						"presento_sintomas",
						"sintoma_disuria",
						 "sintoma_dolor_lumbar","sintoma_fiebre","sintoma_hematuria","sintoma_polaquiuria","sintoma_presion_retorcijones_parte_inferior_abdomen","sintoma_tenesmo",
						 "sintoma_urgencia","sintoma_vomito","otro_sintomas_ivu",
						 "trato_con_antibioticos","tratocon_antibioticos_especificar",
						 "bacteriuria_asintomatica_ultima_visita","tratamiento_bacteriuria","tratamiento_bacteriuria_especificar",
						 "tipo_ivu","clasificacion_ivu","severidad_ivu","realizo_urocultivo","tipo_microbio",
                         "germen_aislado", "otro_germen_aislado",
                         "germen_Si_AntecedentesIVU",
                         /*aqui cambio 14 10 2025*/
                         "presento_sintomas_u",
         				"sintoma_disuria_u",
         				 "sintoma_dolor_lumbar_u","sintoma_fiebre_u","sintoma_hematuria_u","sintoma_polaquiuria_u","sintoma_presion_retorcijones_parte_inferior_abdomen_u","sintoma_tenesmo_u",
         				 "sintoma_urgencia_u","sintoma_vomito_u","sintoma_dolorsuprapubico_u","otro_sintomas_ivu_u",
         				"germen_Si_AntecedentesIVU_u",
						
		};
				
				Workbook workbook = new XSSFWorkbook();
				
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				
				Sheet sheet = workbook.createSheet("Seguimiento" + numero);
				Row row = sheet.createRow(0);
				final DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				
				for (int i = 0; i < columns.length; i++) {
					Cell cell = row.createCell(i);
					cell.setCellValue(columns[i]);
					
				}
				List<Seguimiento> sList = this.excelParaSeguimiento(numero);
				int initRow = 1;
				for (Seguimiento s : sList) {
					row = sheet.createRow(initRow);
					row.createCell(0).setCellValue(s.getPersonas().getCodigo());
					//row.createCell(1).setCellValue(cb.getPersonas().getCedula());
				    //row.createCell(2).setCellValue(cb.getPersonas().getNombres());
					//row.createCell(3).setCellValue(cb.getPersonas().getApellidos());
					row.createCell(1).setCellValue(s.getPersonas().getEdad());
					row.createCell(2).setCellValue(s.getPersonas().getEstadoCivil());
					row.createCell(3).setCellValue(s.getPersonas().getSexo());
					row.createCell(4).setCellValue(s.getPersonas().getCiudadResidencia());
					/*				*/
					row.createCell(5).setCellValue(s.getMenopausia());
					row.createCell(6).setCellValue(s.getEdadMenopausia());
					row.createCell(7).setCellValue(s.getAnhosHisterectomia());
					
					
					

					row.createCell(8).setCellValue(s.getFactoresRiesgoSexualmenteActivo());
					row.createCell(9).setCellValue(s.getTipoActividadSexual());
					row.createCell(10).setCellValue(s.getFactoresRiesgoActividadSexualNroVeces());
					
					row.createCell(11).setCellValue(s.getFactoresRiesgoEstreñimientoCronico());
					row.createCell(12).setCellValue(s.getFactoresRiesgoTipoEstreñimientoCronico());
					row.createCell(13).setCellValue(s.getFactoresRiesgoFrecuenciaUrinariaBaja());
					row.createCell(14).setCellValue(s.getFactoresRiesgoBajaIngestaliquidos());	
					row.createCell(15).setCellValue(s.getFactoresRiesgoIncontinenciaUrinaria());	
					row.createCell(16).setCellValue(s.getFactoresRiesgoTipoIncontinenciaUrinaria());
					row.createCell(17).setCellValue(s.getFactoresRiesgoSondajeVesicalPrevio());
					row.createCell(18).setCellValue(s.getFactoresRiesgoProcedimientoUrinarioGinecPrevio());
					row.createCell(19).setCellValue(s.getProcedimientoUrinarioGinecPrevioEspecificar());
					
					row.createCell(20).setCellValue(s.getRecibioProfilaxisAcordeGuias());
					row.createCell(21).setCellValue(s.getInfeccionVaginal());
					row.createCell(22).setCellValue(s.getNroInfeccionVaginalAnual());
					row.createCell(23).setCellValue(s.getFactoresRiesgoAntecedentesIvu());
					row.createCell(24).setCellValue(s.getFactoresRiesgoAntibioticoterapiaUltimaVisita());
					row.createCell(25).setCellValue(s.getAntibioticoterapiaUltimaVisitaEspecificar());
					row.createCell(26).setCellValue(s.getFactoresRiesgoEmbarazo());
					
					/* ----------*/
					row.createCell(27).setCellValue(s.getFactoresRiesgoLitiasisRenal());
					row.createCell(28).setCellValue(s.getFactoresRiesgoEnfermedadRenalCronica());


					
					row.createCell(29).setCellValue(s.getFactoresRiesgoHiperplasiaProstaticaBenigna());
					row.createCell(30).setCellValue(s.getFactoresRiesgoDiabetes());
					row.createCell(31).setCellValue(s.getFactoresRiesgoAnomaliasAnatomicasTractoUrinario());
					row.createCell(32).setCellValue(s.getFactoresRiesgoAnomaliasAnatomicasTractoEspecificar());
					row.createCell(33).setCellValue(s.getFactoresRiesgoCorticoides());
					
					row.createCell(34).setCellValue(s.getFactoresRiesgoCancer());
				
					row.createCell(35).setCellValue(s.getFactoresRiesgoOtrasCausasInmunodepresion());
					row.createCell(36).setCellValue(s.getOtrasCausasInmunodepresionEspecificar());
					row.createCell(37).setCellValue(s.getOtrosFactoresRiesgo());
					row.createCell(38).setCellValue("");
					row.createCell(39).setCellValue("");
					
					row.createCell(40).setCellValue(s.getTipoIndividuo());
					row.createCell(41).setCellValue(s.getTiempoEvolucionLes());
					row.createCell(42).setCellValue(s.getTratamientoGlucocorticoides());

					row.createCell(43).setCellValue(s.getDosisDiariaCantidadMg());
					row.createCell(44).setCellValue(s.getDosisAcumuladaUltimaVisita());
					
					row.createCell(45).setCellValue(s.getTratamientoInmunosupresoresIs());
					row.createCell(46).setCellValue(s.getTipoISTexto());
					row.createCell(47).setCellValue(s.getOtroTipoIs());
					
					row.createCell(48).setCellValue(s.getDosis());
					row.createCell(49).setCellValue(s.getPresentaManifestacionRenal());
					
					row.createCell(50).setCellValue(s.getEstadoEncuentra());
					row.createCell(51).setCellValue(s.getAntiDNAPositivo());
					row.createCell(52).setCellValue("");
					row.createCell(53).setCellValue(s.getComplementosBajos());
					
					row.createCell(54).setCellValue(s.getFactoresRiesgoSindromeSjogren());
					
					row.createCell(55).setCellValue(s.getFactoresRiesgoLeucopenia());
					row.createCell(56).setCellValue(s.getFactoresRiesgoTipoLeucopenia());
					row.createCell(57).setCellValue(s.getSledaiPuntos0A30());
					
					row.createCell(58).setCellValue(s.getFirmaEncargado());
					row.createCell(59).setCellValue(s.getFechaCreacion().format(CUSTOM_FORMATTER));
					
					row.createCell(60).setCellValue(s.getUsuarioCreacion());
					/*aqui cambiamos al ultimo*/
					row.createCell(61).setCellValue(s.getNumero());
					row.createCell(62).setCellValue(s.getHistoriaIVUUltimaVisitaProyecto());
					row.createCell(63).setCellValue(s.getComoHizoDiagnostico());
					row.createCell(64).setCellValue(s.getFechaDiagnostico());
					
					row.createCell(65).setCellValue(s.getPresentoSintomas());
					row.createCell(66).setCellValue(s.getSintomaDisuria());
					row.createCell(67).setCellValue(s.getSintomaDolorLumbar());
					row.createCell(68).setCellValue(s.getSintomaFiebre());	
					
					/* */
					row.createCell(69).setCellValue(s.getSintomaHematuria());
					row.createCell(70).setCellValue(s.getSintomaPolaquiuria());
					row.createCell(71).setCellValue(s.getSintomaPresionAbdomen());
					row.createCell(72).setCellValue(s.getSintomaTenesmo());
					row.createCell(73).setCellValue(s.getSintomaUrgencia());
					row.createCell(74).setCellValue(s.getSintomaVomito());
					row.createCell(75).setCellValue(s.getOtroSintomasIVU());
					row.createCell(76).setCellValue(s.getTratoconAntibioticos());
					row.createCell(77).setCellValue(s.getTratoconAntibioticosEspecificar());	
					row.createCell(78).setCellValue(s.getBacteriuriaAsintomaticaUltimaVisita());	
					
					/*
						
						 */
					
					row.createCell(79).setCellValue(s.getTratamientoBacteriuriaAsintomatica());
					row.createCell(80).setCellValue(s.getTratamientoBacteriuriaAsintomaticaEspecificar());
					row.createCell(81).setCellValue(s.getTipoIVU());
					row.createCell(82).setCellValue(s.getClasificacionIVU());
					row.createCell(83).setCellValue(s.getSeveridadIVU());
					row.createCell(84).setCellValue(s.getUrocultivoPositivo());
					row.createCell(85).setCellValue(s.getTipoMicrobio());
					
					/*					*/
					
					row.createCell(86).setCellValue(s.getGermenAisladoTexto());
					row.createCell(87).setCellValue(s.getOtroGermenAislado());
					row.createCell(88).setCellValue(s.getGermenSiAntecedentes());
					/*nuevo*/
					
					row.createCell(89).setCellValue(s.getSintomasUrinarios());
					row.createCell(90).setCellValue(s.getSintomaUrinarioDisuria());
					row.createCell(91).setCellValue("");
					row.createCell(92).setCellValue(s.getSintomaUrinarioFiebre());
					row.createCell(93).setCellValue("");
					row.createCell(94).setCellValue(s.getSintomaUrinarioPolaquiuria());
					row.createCell(95).setCellValue("");
					row.createCell(96).setCellValue(s.getSintomaUrinarioTenesmo());
					row.createCell(97).setCellValue(s.getSintomaUrinarioUrgenciaMiccional());
					row.createCell(98).setCellValue("");
					row.createCell(99).setCellValue(s.getSintomaUrinarioDolorSuprapubico());
					row.createCell(100).setCellValue(s.getOtroSintomasUrinarios());
					row.createCell(101).setCellValue(s.getGermenSiAntecedentes());

					
					
					
					
						

					initRow++;
				}
				

				
				
				
				
					workbook.write(stream);
					workbook.close();
				
				return new ByteArrayInputStream(stream.toByteArray());
	}

	@Override
	public List<Seguimiento> obtenerSeguimientoNumero(int numero) {
		// TODO Auto-generated method stub
		return seguimientoDao.obtenerSeguimientoNumero(numero);
	}

	@Override
	public Seguimiento obtenerSeguimientoPersonaIdAndNumero(int personaId,int numero) {
		// TODO Auto-generated method stub
		return seguimientoDao.obtenerSeguimientoPersonaIdAndNumero(personaId,numero);
	}

}
                                                                         