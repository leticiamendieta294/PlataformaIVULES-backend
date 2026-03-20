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

import com.ivules.dao.ILaboratorioDao;
import com.ivules.entity.Laboratorio;

import com.ivules.service.LaboratorioService;
import com.ivules.service.PersonasService;
import com.ivules.util.exceptions.IvulesException;


@Service
public class LaboratorioServiceImpl implements LaboratorioService {
	
	@Autowired
	private ILaboratorioDao laboratorioDao;
	
	@Autowired
	private PersonasService personaService;
	
	public LaboratorioServiceImpl(ILaboratorioDao laboratorioDao) {
        this.laboratorioDao = laboratorioDao;
    }
	
	@Override
	@Transactional(readOnly = true)
	public List<Laboratorio> findAll() {
		return (List<Laboratorio>) laboratorioDao.findAll();
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Laboratorio> existByPersonaId(int id) {
		return (List<Laboratorio>) laboratorioDao.existsByPersonaId(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public int count() {
		return (int) laboratorioDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Laboratorio findById(int id) {
		return laboratorioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Laboratorio save(Laboratorio laboratorio) {
		return laboratorioDao.save(laboratorio);
	}

	@Override
	@Transactional
	public void delete(int id) {
		laboratorioDao.deleteById(id);
	}

	@Override
	public List<Laboratorio> buscar(Date fromDate, Date toDate, Laboratorio laboratorio, String orderBy,
			String orderDir, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	@Transactional
	public Laboratorio actualizar(Laboratorio laboratorio) throws IvulesException {
		
			
			if ( laboratorio.getIdLaboratorio() == null ) {
				throw new IvulesException.DataNotFound("Error: laboratorio id es requerido ");
			}
			
			Laboratorio laboratorioActual = findByPersonaIdAndNumero(laboratorio.getPersonas().getPersonaId(),laboratorio.getNumero());
			
			if ( laboratorioActual == null ) {
				String mensaje = "No se pudo editar, el laboratorio ID: "
						.concat(String.valueOf(laboratorioActual.getIdLaboratorio()).concat(" no existe en la base de datos!"));
				throw new IvulesException.DataNotFound(mensaje);
			}
			
			
			return laboratorioDao.save(laboratorio);
		}
	
	@Override
	public Laboratorio findByPersonaIdAndNumero(int id, int numero) throws IvulesException {
		
		List<Laboratorio> sList = laboratorioDao.findByPersonasOrderByNumero(personaService.obtener(id));
		Laboratorio laboratorio = null;
		for (int i = 0; i < sList.size(); i++) {
			
			if (sList.get(i).getNumero()== numero) {
				laboratorio = sList.get(i);
			}
			
		}
		
		
		return laboratorio;
	}
	
	
	@Override
	public int countByNumero(int numero) throws IvulesException {
		
		return (int) laboratorioDao.countByNumero(numero);
	}
	
	@Override
	public List<Laboratorio> findByPersonaId(int id) throws IvulesException {
		return laboratorioDao.findByPersonasOrderByNumero(personaService.obtener(id));
		
	}
	
	
	@Override
	public List<String> comprobarEstadoLaboratorio(int id) throws IvulesException {
		List <Laboratorio> laboratorioList = findByPersonaId(id);
		String r = "";
		int resta = 0;
		List<String> resultado= new ArrayList<>();
		
		
		if(laboratorioList.isEmpty()|| laboratorioList == null) {
			resultado.add("vacio");
			resultado.add("vacio");
			resultado.add("vacio");
			resultado.add("vacio");
			resultado.add("vacio");
		}else {
			
			for (int i = 0; i < laboratorioList.size(); i++) {
				if(laboratorioList.get(i).getBacteria()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getCelularidad() == null) {
					r = "no";
				}else if(laboratorioList.get(i).getCilindros()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getComentarios()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getEsporosMicoticos()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getEsterasaLeucocitaria()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getGermenAislado()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getHematies()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getHongoAislado()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getLeucocitos()==null) {
					r = "no";
			    }else if(laboratorioList.get(i).getOtroGermenAislado()==null) {
					r = "no";
			    }else if(laboratorioList.get(i).getOtroHongoAislado()==null) {
					r = "no";
			    }else if(laboratorioList.get(i).getPresenciaGermenResistente()==null) {
					r = "no";
			    }else if(laboratorioList.get(i).getProteinasPositivo()==null) {
					r = "no";
			    }else if(laboratorioList.get(i).getSangrePositivo()==null) {
					r = "no";
			    }else if(laboratorioList.get(i).getSedimentoUrinario()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getTipoBacteria()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getTipoMicrobio()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getUrocultivo()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoAmikacina()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoAmpicilinaSulbactam()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoCefalotina()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoCefazolin()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoCefepima()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoCeftazidimaavibactam()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoCeftolozanetazobactam()==null) {
					r = "no";
				}
				else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoCeftriaxona()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoCiprofloxacina()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoEBSL()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoImipenem()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoAztreonam()==null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoPiperacilinaTazobactam()==null) {
					r = "no";
				}
				else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoTigecilina()==null) {
					r = "no";
				}
				else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoErtapenem()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoFosfomicina()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoGentamicina()== null) {
					r = "no";	
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoMeropenem()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoNitrofurantoína()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoNorfloxacina()== null) {
					r = "no";	
				}else if(laboratorioList.get(i).getAntibiogramaBaciloGramNegativoTrimetoprimaSulfametox()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoAmpicilina()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoBenzilpenicilina()== null) {
					r = "no";	
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoCefoxitinaScreening()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoCeftarolina()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoCiprofloxacina()== null) {
					r = "no";	
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoClindamicina()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoDaptomicina()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoEritromicina()== null) {
					r = "no";	
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoEstreptomicinaNivelAlto()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoGentamicinaNivelAlto()== null) {
					r = "no";	
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoLevofloxacina()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramResistenciaClindamicina()== null) {
					r = "no";
				}
				else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoLinezolid()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoNitrofurantoína()== null) {
					r = "no";	
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoRifampicina()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoTetraciclina()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoTrimetoprimaSulfametoxazol()== null) {
					r = "no";	
				}else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoOxaciclina()== null) {
					r = "no";
				}
				else if(laboratorioList.get(i).getAntibiogramaCocoGramPositivoVancomicina()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntifungigramaAnfotericinaB()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntifungigramaCaspofungina()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntifungigramaFlucitosina()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntifungigramaFluconazol()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntifungigramaMicafungina()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getAntifungigramaVoriconazol()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getFirmaEncargado()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getTirasBIL()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getTirasBLO()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getTirasGLU()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getTirasKET()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getTirasLEU()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getTirasNIT()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getTiraspH()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getTirasPRO()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getTirasSG()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getTirasURO()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getCategoriaGermen()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getCelularidadRedonda()== null) {
					r = "no";
				}else if(laboratorioList.get(i).getCristales()== null) {
					r = "no";
				}
				else {
					r = "si";
				}
				resultado.add(r);
	}
			if(laboratorioList.size()< 5) {
				resta = 5- laboratorioList.size();
				for (int j = 0; j < resta; j++) {
					resultado.add("vacio");
				}
			}
		}
		
		
			
	return resultado;
}

	
	@Override
	public ByteArrayInputStream exportAllData(int numero) throws Exception {
	//	String[] columns = {"Numero","Codigo","Cedula","Nombres","Apellidos", "Urocultivo","Amikacina"};
		
		String[] columnas = {"codigo","	cedula","nombres", 	"apellidos","edad","estado_civil","sexo","ciudad_residencia",
				
				"laboratorio_numero","leucocitos","esterasa_leucocitaria","hematies","celularidad_plana","celularidad_redonda",
				"cilindros","cilindros_comentarios","cristales","cristales_comentarios",
				
				"tiras_leucocitos",
				"tiras_nitritos","tiras_urobilinogeno","tiras_proteinas","tiras_ph","tiras_sangre",
				"tiras_densidad","tiras_cuerposcetonicos","tiras_bilirrubina","tiras_glucosa",
				"urocultivo","tipo_microbio","tipo_bacteria","germen_asilado","otro_germen_aislado",
				"blee",
				
				"antibiograma_bacilo_gram_amikacina","antibiograma_bacilo_gram_ampicilina_sulbactam",
				"antibiograma_bacilo_gram_aztreonam","antibiograma_bacilo_gram_cefalotina","antibiograma_bacilo_gram_cefazolin",
				"antibiograma_bacilo_gram_cefepima","antibiograma_bacilo_gram_ceftazidimaavibactam",
				"antibiograma_bacilo_gram_ceftolozanetazobactam","antibiograma_bacilo_gram_ceftriaxona",
				"antibiograma_bacilo_gram_ciprofloxacina","antibiograma_bacilo_gram_ebsl",
				"antibiograma_bacilo_gram_ertapenem","antibiograma_bacilo_gram_fosfomicina",
				"antibiograma_bacilo_gram_gentamicina","antibiograma_bacilo_gram_imipenem",
				"antibiograma_bacilo_gram_meropenem","antibiograma_bacilo_gram_nitrofurantoína",
				"antibiograma_bacilo_gram_norfloxacina","antibiograma_bacilo_gram_piperacilinatazobactam",
				"antibiograma_bacilo_gram_tigecilina","antibiograma_bacilo_gram_trimetoprima_sulfametox",
				"presencia_de_germen_resistente","categoria_germen",
				
				"antibiograma_coco_gram_ampicilina","antibiograma_coco_gram_benzilpenicilina",
				"antibiograma_coco_gram_cefoxitina_screening","antibiograma_coco_gram_ceftarolina",
				"antibiograma_coco_gram_ciprofloxacina","antibiograma_coco_gram_clindamicina",
				"antibiograma_coco_gram_daptomicina","antibiograma_coco_gram_eritromicina",
				"antibiograma_coco_gram_estreptomicina_nivel_alto","antibiograma_coco_gram_gentamicina_nivel_alto",
				"antibiograma_coco_gram_levofloxacina","antibiograma_coco_gram_linezolid",
				"antibiograma_coco_gram_nitrofurantoína","antibiograma_coco_gram_oxaciclina",
				"antibiograma_coco_gram_rifampicina","antibiograma_coco_gram_tetraciclina",
				"antibiograma_coco_gram_trimetoprima_sulfametoxazol","antibiograma_coco_gram_vancomicina",
				"antibiograma_coco_gram_resistencia_clindamicina",
				
				"hongo_aislado","otro_hongo_aislado",
				"recuento_colonias_nro_comentario","antifungigrama_anfotericinab","antifungigrama_caspofungina",
				"antifungigrama_flucitosina","antifungigrama_fluconazol","antifungigrama_micafungina",
				"antifungigrama_voriconazol",
				
				"comentarios","firma_encargado","fecha_creacion","usuario_creacion"
};
		
		Workbook workbook = new XSSFWorkbook();
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		
		Sheet sheet = workbook.createSheet("Laboratorio0");
		Row row = sheet.createRow(0);
		final DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


		
		for (int i = 0; i < columnas.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(columnas[i]);
			
		}
		
		List<Laboratorio> labList = this.excelParaLaboratorio(numero);
		int initRow = 1;
		for (Laboratorio laboratorio : labList) {
			row = sheet.createRow(initRow);
			row.createCell(0).setCellValue(laboratorio.getPersonas().getCodigo());
			row.createCell(1).setCellValue(laboratorio.getPersonas().getCedula());
			row.createCell(2).setCellValue(laboratorio.getPersonas().getNombres());
			row.createCell(3).setCellValue(laboratorio.getPersonas().getApellidos());
			row.createCell(4).setCellValue(laboratorio.getPersonas().getEdad());
			row.createCell(5).setCellValue(laboratorio.getPersonas().getEstadoCivil());
			row.createCell(6).setCellValue(laboratorio.getPersonas().getSexo());
			row.createCell(7).setCellValue(laboratorio.getPersonas().getCiudadResidencia());
			row.createCell(8).setCellValue(laboratorio.getNumero());
			/*Primera parte*/
			row.createCell(9).setCellValue(laboratorio.getLeucocitos());
			row.createCell(10).setCellValue(laboratorio.getEsterasaLeucocitaria());
			row.createCell(11).setCellValue(laboratorio.getHematies());
			row.createCell(12).setCellValue(laboratorio.getCelularidad());
			row.createCell(13).setCellValue(laboratorio.getCelularidadRedonda());
			row.createCell(14).setCellValue(laboratorio.getCilindros());
			row.createCell(15).setCellValue(laboratorio.getCilindrosComentarios());
			row.createCell(16).setCellValue(laboratorio.getCristales());
			row.createCell(17).setCellValue(laboratorio.getCristalesComentarios());	
			
			/*Tiras */
			row.createCell(18).setCellValue(laboratorio.getTirasLEU());
			row.createCell(19).setCellValue(laboratorio.getTirasNIT());
			row.createCell(20).setCellValue(laboratorio.getTirasURO());
			row.createCell(21).setCellValue(laboratorio.getTirasPRO());
			row.createCell(22).setCellValue(laboratorio.getTiraspH());
			row.createCell(23).setCellValue(laboratorio.getTirasBLO());
			row.createCell(24).setCellValue(laboratorio.getTirasSG());
			row.createCell(25).setCellValue(laboratorio.getTirasKET());
			row.createCell(26).setCellValue(laboratorio.getTirasBIL());	
			row.createCell(27).setCellValue(laboratorio.getTirasGLU());	
			
			/*"urocultivo"..... */
			
			row.createCell(28).setCellValue(laboratorio.getUrocultivo());
			row.createCell(29).setCellValue(laboratorio.getTipoMicrobio());
			row.createCell(30).setCellValue(laboratorio.getTipoBacteria());
			row.createCell(31).setCellValue(laboratorio.getGermenAisladoTexto());
			row.createCell(32).setCellValue(laboratorio.getOtroGermenAislado());
			row.createCell(33).setCellValue(laboratorio.getBlee());
			
			/*Antibiograma Bacilo----------*/
			
			row.createCell(34).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoAmikacina());
			row.createCell(35).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoAmpicilinaSulbactam());
			row.createCell(36).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoAztreonam());
			row.createCell(37).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoCefalotina());
			row.createCell(38).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoCefazolin());
			row.createCell(39).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoCefepima());
			row.createCell(40).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoCeftazidimaavibactam());
			row.createCell(41).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoCeftolozanetazobactam());
			row.createCell(42).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoCeftriaxona());	
			row.createCell(43).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoCiprofloxacina());	
			row.createCell(44).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoEBSL());
			row.createCell(45).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoErtapenem());
			row.createCell(46).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoFosfomicina());
			row.createCell(47).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoGentamicina());
			row.createCell(48).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoImipenem());
			row.createCell(49).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoMeropenem());
			row.createCell(50).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoNitrofurantoína());
			row.createCell(51).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoNorfloxacina());
			row.createCell(52).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoPiperacilinaTazobactam());
			row.createCell(53).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoTigecilina());
			row.createCell(54).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoTrimetoprimaSulfametox());
			
			/*"presencia_de_germen_resistente","categoria_germen", ----------*/
			row.createCell(55).setCellValue(laboratorio.getPresenciaGermenResistente());
			row.createCell(56).setCellValue(laboratorio.getCategoriaGermen());

/*Antibiograma Coco----------*/
			
			row.createCell(57).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoAmpicilina());
			row.createCell(58).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoBenzilpenicilina());
			row.createCell(59).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoCefoxitinaScreening());
			row.createCell(60).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoCeftarolina());
			row.createCell(61).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoCiprofloxacina());
			row.createCell(62).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoClindamicina());
			row.createCell(63).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoDaptomicina());
			row.createCell(64).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoEritromicina());
			row.createCell(65).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoEstreptomicinaNivelAlto());	
			row.createCell(66).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoGentamicinaNivelAlto());	
			row.createCell(67).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoLevofloxacina());
			row.createCell(68).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoLinezolid());
			row.createCell(69).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoNitrofurantoína());
			row.createCell(70).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoOxaciclina());
			row.createCell(71).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoRifampicina());
			row.createCell(72).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoTetraciclina());
			row.createCell(73).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoTrimetoprimaSulfametoxazol());
			row.createCell(74).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoVancomicina());
			row.createCell(75).setCellValue(laboratorio.getAntibiogramaCocoGramResistenciaClindamicina());
			
/*		Antifungigrama				----------*/
			
			row.createCell(76).setCellValue(laboratorio.getHongoAislado());
			row.createCell(77).setCellValue(laboratorio.getOtroHongoAislado());
			row.createCell(78).setCellValue(laboratorio.getRecuentoColoniasNroComentario());
			row.createCell(79).setCellValue(laboratorio.getAntifungigramaAnfotericinaB());
			row.createCell(80).setCellValue(laboratorio.getAntifungigramaCaspofungina());
			row.createCell(81).setCellValue(laboratorio.getAntifungigramaFlucitosina());
			row.createCell(82).setCellValue(laboratorio.getAntifungigramaFluconazol());
			row.createCell(83).setCellValue(laboratorio.getAntifungigramaMicafungina());
			row.createCell(84).setCellValue(laboratorio.getAntifungigramaVoriconazol());
			
/*		Varios			----------*/
			
			row.createCell(85).setCellValue(laboratorio.getComentarios());
			row.createCell(86).setCellValue(laboratorio.getFirmaEncargado());
			row.createCell(87).setCellValue(laboratorio.getFechaCreacion().format(CUSTOM_FORMATTER));
		//	row.createCell(88).setCellValue(sdf.format(laboratorio.getFechaModificacion()).toString());
			row.createCell(88).setCellValue(laboratorio.getUsuarioCreacion());
				

			initRow++;
		}
		
		/*Sheet sheet1 = workbook.createSheet("Laboratorio 1");
		Row row1 = sheet1.createRow(0);
		
		for (int i = 0; i < columns.length; i++) {
			Cell cell = row1.createCell(i);
			cell.setCellValue(columns[i]);
			
		}
		
		List<Laboratorio> labList1 = this.findByNumeroOrderByPersonas(1);
		int initRow1 = 1;
		for (Laboratorio laboratorio : labList1) {
			row1 = sheet1.createRow(initRow1);
			row1.createCell(0).setCellValue(laboratorio.getNumero());
			row1.createCell(1).setCellValue(laboratorio.getPersonas().getCodigo());
			row1.createCell(2).setCellValue(laboratorio.getPersonas().getCedula());
			row1.createCell(3).setCellValue(laboratorio.getPersonas().getNombres());
			row1.createCell(4).setCellValue(laboratorio.getPersonas().getA);
			row1.createCell(5).setCellValue(laboratorio.getUrocultivo());
			row1.createCell(6).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoAmikacina());
			
			initRow1++;
		}*/
		
		
		
		
			workbook.write(stream);
			workbook.close();
		
		return new ByteArrayInputStream(stream.toByteArray());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Laboratorio> findByNumeroOrderByPersonas(int numero) throws IvulesException {
		return (List<Laboratorio>) laboratorioDao.findByNumeroOrderByPersonas(numero);
	}

	@Override
	@Transactional(readOnly = true)
	public List<String> searchByUrocultivoAndPersonaId(String urocultivo, int personaId) {

		return (List<String>) laboratorioDao.searchByUrocultivoAndPersonaId(urocultivo, personaId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Laboratorio> excelParaLaboratorio(int numero) {
		
		return (List<Laboratorio>) laboratorioDao.excelParaLaboratorio(numero);
	}

	@Override
	public ByteArrayInputStream exportAllDataModificado(int numero) throws Exception {
		
			String[] columnas = {"codigo",
					/*"	cedula","nombres", 	"apellidos",*/
					
					"edad","estado_civil","sexo","ciudad_residencia",
					
					"laboratorio_numero","leucocitos","esterasa_leucocitaria","hematies","celularidad_plana","celularidad_redonda",
					"cilindros","cilindros_comentarios","cristales","cristales_comentarios",
					
					"tiras_leucocitos",
					"tiras_nitritos","tiras_urobilinogeno","tiras_proteinas","tiras_ph","tiras_sangre",
					"tiras_densidad","tiras_cuerposcetonicos","tiras_bilirrubina","tiras_glucosa",
					"urocultivo","tipo_microbio","tipo_bacteria","germen_asilado","otro_germen_aislado",
					"blee",
					
					"antibiograma_bacilo_gram_amikacina","antibiograma_bacilo_gram_ampicilina_sulbactam",
					"antibiograma_bacilo_gram_aztreonam","antibiograma_bacilo_gram_cefalotina","antibiograma_bacilo_gram_cefazolin",
					"antibiograma_bacilo_gram_cefepima","antibiograma_bacilo_gram_ceftazidimaavibactam",
					"antibiograma_bacilo_gram_ceftolozanetazobactam","antibiograma_bacilo_gram_ceftriaxona",
					"antibiograma_bacilo_gram_ciprofloxacina","antibiograma_bacilo_gram_ebsl",
					"antibiograma_bacilo_gram_ertapenem","antibiograma_bacilo_gram_fosfomicina",
					"antibiograma_bacilo_gram_gentamicina","antibiograma_bacilo_gram_imipenem",
					"antibiograma_bacilo_gram_meropenem","antibiograma_bacilo_gram_nitrofurantoína",
					"antibiograma_bacilo_gram_norfloxacina","antibiograma_bacilo_gram_piperacilinatazobactam",
					"antibiograma_bacilo_gram_tigecilina","antibiograma_bacilo_gram_trimetoprima_sulfametox",
					"presencia_de_germen_resistente","categoria_germen",
					
					"antibiograma_coco_gram_ampicilina","antibiograma_coco_gram_benzilpenicilina",
					"antibiograma_coco_gram_cefoxitina_screening","antibiograma_coco_gram_ceftarolina",
					"antibiograma_coco_gram_ciprofloxacina","antibiograma_coco_gram_clindamicina",
					"antibiograma_coco_gram_daptomicina","antibiograma_coco_gram_eritromicina",
					"antibiograma_coco_gram_estreptomicina_nivel_alto","antibiograma_coco_gram_gentamicina_nivel_alto",
					"antibiograma_coco_gram_levofloxacina","antibiograma_coco_gram_linezolid",
					"antibiograma_coco_gram_nitrofurantoína","antibiograma_coco_gram_oxaciclina",
					"antibiograma_coco_gram_rifampicina","antibiograma_coco_gram_tetraciclina",
					"antibiograma_coco_gram_trimetoprima_sulfametoxazol","antibiograma_coco_gram_vancomicina",
					"antibiograma_coco_gram_resistencia_clindamicina",
					
					"hongo_aislado","otro_hongo_aislado",
					"recuento_colonias_nro_comentario","antifungigrama_anfotericinab","antifungigrama_caspofungina",
					"antifungigrama_flucitosina","antifungigrama_fluconazol","antifungigrama_micafungina",
					"antifungigrama_voriconazol",
					
					"comentarios","firma_encargado","fecha_creacion","usuario_creacion"
	};
			
			Workbook workbook = new XSSFWorkbook();
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			
			Sheet sheet = workbook.createSheet("Laboratorio" + numero);
			Row row = sheet.createRow(0);
			final DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


			
			for (int i = 0; i < columnas.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(columnas[i]);
				
			}
			
			List<Laboratorio> labList = this.excelParaLaboratorio(numero);
			int initRow = 1;
			for (Laboratorio laboratorio : labList) {
				row = sheet.createRow(initRow);
				row.createCell(0).setCellValue(laboratorio.getPersonas().getCodigo());
				//row.createCell(1).setCellValue(laboratorio.getPersonas().getCedula());
				//row.createCell(2).setCellValue(laboratorio.getPersonas().getNombres());
				//row.createCell(3).setCellValue(laboratorio.getPersonas().getApellidos());
				row.createCell(1).setCellValue(laboratorio.getPersonas().getEdad());
				row.createCell(2).setCellValue(laboratorio.getPersonas().getEstadoCivil());
				row.createCell(3).setCellValue(laboratorio.getPersonas().getSexo());
				row.createCell(4).setCellValue(laboratorio.getPersonas().getCiudadResidencia());
				row.createCell(5).setCellValue(laboratorio.getNumero());
				/*Primera parte*/
				row.createCell(6).setCellValue(laboratorio.getLeucocitos());
				row.createCell(7).setCellValue(laboratorio.getEsterasaLeucocitaria());
				row.createCell(8).setCellValue(laboratorio.getHematies());
				row.createCell(9).setCellValue(laboratorio.getCelularidad());
				row.createCell(10).setCellValue(laboratorio.getCelularidadRedonda());
				row.createCell(11).setCellValue(laboratorio.getCilindros());
				row.createCell(12).setCellValue(laboratorio.getCilindrosComentarios());
				row.createCell(13).setCellValue(laboratorio.getCristales());
				row.createCell(14).setCellValue(laboratorio.getCristalesComentarios());	
				
				/*Tiras */
				row.createCell(15).setCellValue(laboratorio.getTirasLEU());
				row.createCell(16).setCellValue(laboratorio.getTirasNIT());
				row.createCell(17).setCellValue(laboratorio.getTirasURO());
				row.createCell(18).setCellValue(laboratorio.getTirasPRO());
				row.createCell(19).setCellValue(laboratorio.getTiraspH());
				row.createCell(20).setCellValue(laboratorio.getTirasBLO());
				row.createCell(21).setCellValue(laboratorio.getTirasSG());
				row.createCell(22).setCellValue(laboratorio.getTirasKET());
				row.createCell(23).setCellValue(laboratorio.getTirasBIL());	
				row.createCell(24).setCellValue(laboratorio.getTirasGLU());	
				
				/*"urocultivo"..... */
				
				row.createCell(25).setCellValue(laboratorio.getUrocultivo());
				row.createCell(26).setCellValue(laboratorio.getTipoMicrobio());
				row.createCell(27).setCellValue(laboratorio.getTipoBacteria());
				row.createCell(28).setCellValue(laboratorio.getGermenAisladoTexto());
				row.createCell(29).setCellValue(laboratorio.getOtroGermenAislado());
				row.createCell(30).setCellValue(laboratorio.getBlee());
				
				/*Antibiograma Bacilo----------*/
				
				row.createCell(31).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoAmikacina());
				row.createCell(32).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoAmpicilinaSulbactam());
				row.createCell(33).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoAztreonam());
				row.createCell(34).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoCefalotina());
				row.createCell(35).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoCefazolin());
				row.createCell(36).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoCefepima());
				row.createCell(37).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoCeftazidimaavibactam());
				row.createCell(38).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoCeftolozanetazobactam());
				row.createCell(39).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoCeftriaxona());	
				row.createCell(40).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoCiprofloxacina());	
				row.createCell(41).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoEBSL());
				row.createCell(42).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoErtapenem());
				row.createCell(43).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoFosfomicina());
				row.createCell(44).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoGentamicina());
				row.createCell(45).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoImipenem());
				row.createCell(46).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoMeropenem());
				row.createCell(47).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoNitrofurantoína());
				row.createCell(48).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoNorfloxacina());
				row.createCell(49).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoPiperacilinaTazobactam());
				row.createCell(50).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoTigecilina());
				row.createCell(51).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoTrimetoprimaSulfametox());
				
				/*"presencia_de_germen_resistente","categoria_germen", ----------*/
				row.createCell(52).setCellValue(laboratorio.getPresenciaGermenResistente());
				row.createCell(53).setCellValue(laboratorio.getCategoriaGermen());

	/*Antibiograma Coco----------*/
				
				row.createCell(54).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoAmpicilina());
				row.createCell(55).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoBenzilpenicilina());
				row.createCell(56).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoCefoxitinaScreening());
				row.createCell(57).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoCeftarolina());
				row.createCell(58).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoCiprofloxacina());
				row.createCell(59).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoClindamicina());
				row.createCell(60).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoDaptomicina());
				row.createCell(61).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoEritromicina());
				row.createCell(62).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoEstreptomicinaNivelAlto());	
				row.createCell(63).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoGentamicinaNivelAlto());	
				row.createCell(64).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoLevofloxacina());
				row.createCell(65).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoLinezolid());
				row.createCell(66).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoNitrofurantoína());
				row.createCell(67).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoOxaciclina());
				row.createCell(68).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoRifampicina());
				row.createCell(69).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoTetraciclina());
				row.createCell(70).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoTrimetoprimaSulfametoxazol());
				row.createCell(71).setCellValue(laboratorio.getAntibiogramaCocoGramPositivoVancomicina());
				row.createCell(72).setCellValue(laboratorio.getAntibiogramaCocoGramResistenciaClindamicina());
				
	/*		Antifungigrama				----------*/
				
				row.createCell(73).setCellValue(laboratorio.getHongoAislado());
				row.createCell(74).setCellValue(laboratorio.getOtroHongoAislado());
				row.createCell(75).setCellValue(laboratorio.getRecuentoColoniasNroComentario());
				row.createCell(76).setCellValue(laboratorio.getAntifungigramaAnfotericinaB());
				row.createCell(77).setCellValue(laboratorio.getAntifungigramaCaspofungina());
				row.createCell(78).setCellValue(laboratorio.getAntifungigramaFlucitosina());
				row.createCell(79).setCellValue(laboratorio.getAntifungigramaFluconazol());
				row.createCell(80).setCellValue(laboratorio.getAntifungigramaMicafungina());
				row.createCell(81).setCellValue(laboratorio.getAntifungigramaVoriconazol());
				
	/*		Varios			----------*/
				
				row.createCell(82).setCellValue(laboratorio.getComentarios());
				row.createCell(83).setCellValue(laboratorio.getFirmaEncargado());
				row.createCell(84).setCellValue(laboratorio.getFechaCreacion().format(CUSTOM_FORMATTER));
			//	row.createCell(88).setCellValue(sdf.format(laboratorio.getFechaModificacion()).toString());
				row.createCell(85).setCellValue(laboratorio.getUsuarioCreacion());
					

				initRow++;
			}
			
			/*Sheet sheet1 = workbook.createSheet("Laboratorio 1");
			Row row1 = sheet1.createRow(0);
			
			for (int i = 0; i < columns.length; i++) {
				Cell cell = row1.createCell(i);
				cell.setCellValue(columns[i]);
				
			}
			
			List<Laboratorio> labList1 = this.findByNumeroOrderByPersonas(1);
			int initRow1 = 1;
			for (Laboratorio laboratorio : labList1) {
				row1 = sheet1.createRow(initRow1);
				row1.createCell(0).setCellValue(laboratorio.getNumero());
				row1.createCell(1).setCellValue(laboratorio.getPersonas().getCodigo());
				row1.createCell(2).setCellValue(laboratorio.getPersonas().getCedula());
				row1.createCell(3).setCellValue(laboratorio.getPersonas().getNombres());
				row1.createCell(4).setCellValue(laboratorio.getPersonas().getA);
				row1.createCell(5).setCellValue(laboratorio.getUrocultivo());
				row1.createCell(6).setCellValue(laboratorio.getAntibiogramaBaciloGramNegativoAmikacina());
				
				initRow1++;
			}*/
			
			
			
			
				workbook.write(stream);
				workbook.close();
			
			return new ByteArrayInputStream(stream.toByteArray());
	}
	

	
	/*@Override
	@Transactional(readOnly = true)
	public List<Alergenos> buscar(Date fromDate, Date toDate, Alergenos alergeno, String orderBy, String orderDir, Pageable pageable) {
		List<Alergenos> alergenosList;
		
		Specification<Alergenos> alergenosSpec = (Specification<Alergenos>) (root, cq, cb) -> {
            Predicate p = cb.conjunction();
            if (Objects.nonNull(fromDate) && Objects.nonNull(toDate) && fromDate.before(toDate)) {
                p = cb.and(p, cb.between(root.get("fechaCreacion"), fromDate, toDate));
            }
            if ( alergeno.getAlergenoId() != null ) {
                p = cb.and(p, cb.equal(root.get("alergenoId"), alergeno.getAlergenoId()) );
            }
            if (!StringUtils.isEmpty(alergeno.getCodigo())) {
                p = cb.and(p, cb.like(root.get("codigo"), "%" + alergeno.getCodigo() + "%"));
            }
            if (!StringUtils.isEmpty(alergeno.getDescripcion())) {
                p = cb.and(p, cb.like(root.get("descripcion"), "%" + alergeno.getDescripcion() + "%"));
            }
            if (!StringUtils.isEmpty(alergeno.getEstado())) {
                p = cb.and(p, cb.like(root.get("estado"), "%" + alergeno.getEstado() + "%"));
            }
                        
            String orden = "alergenoId";
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
			alergenosList = alergenosDao.findAll(alergenosSpec, pageable).getContent();			
		}else {
			alergenosList = alergenosDao.findAll(alergenosSpec);
		}
        
        return alergenosList;
    }*/

}
