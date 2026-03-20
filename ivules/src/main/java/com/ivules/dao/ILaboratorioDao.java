package com.ivules.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


import com.ivules.entity.Laboratorio;
import com.ivules.entity.Personas;



public interface ILaboratorioDao extends JpaRepository<Laboratorio, Integer>, JpaSpecificationExecutor<Laboratorio>  {
	List<Laboratorio> findByPersonasOrderByNumero(Personas personas);
	  long countByNumero(int numero);
	  
/*Select l.numero, l.urocultivo, p.cedula, p.nombres
	
	FROM public.laboratorio l join public.personas p  on l.persona_id = p.persona_id where l.numero = 0;*/
	  
	
		List<Laboratorio> findByNumeroOrderByPersonas(int numero);
		
		@Query("SELECT l FROM Laboratorio l WHERE l.personas.personaId=?1 AND l.fechaCreacion > '2024-02-15 00:00:00'")
		List<Laboratorio> existsByPersonaId(int id);
		
		
		@Query("SELECT l.numero FROM Laboratorio l WHERE l.urocultivo LIKE ?1% AND l.personas.personaId=?2 AND l.fechaCreacion>= '2024-02-15 00:00:00' ORDER BY l.numero")
		List<String> searchByUrocultivoAndPersonaId(String urocultivo, int id);
		
		/*@Query(nativeQuery = true, value = "SELECT  p.cedula, p.nombres, p.apellidos, p.edad,p.estado_civil, p.celular,p.sexo, p.ciudad_residencia,\r\n"
				+ "numero,leucocitos, esterasa_leucocitaria,hematies,celularidad, celularidad_redonda, cilindros, \r\n"
				+ "cilindros_comentarios, cristales, cristales_comentarios,tirasleu,tirasnit,tirasuro, tiraspro,tirasph, \r\n"
				+ " tirasblo,tirassg, tirasket,tirasbil, tirasglu,  \r\n"
				+ " urocultivo, tipo_microbio, tipo_bacteria,germen_asilado, otro_germen_aislado,blee, \r\n"
				+ "antibiograma_bacilo_gram_negativo_amikacina, antibiograma_bacilo_gram_negativo_ampicilina_sulbactam, \r\n"
				+ "antibiograma_bacilo_gram_negativo_aztreonam, antibiograma_bacilo_gram_negativo_cefalotina, \r\n"
				+ "antibiograma_bacilo_gram_negativo_cefazolin, antibiograma_bacilo_gram_negativo_cefepima, \r\n"
				+ "antibiograma_bacilo_gram_negativo_ceftazidimaavibactam, \r\n"
				+ "antibiograma_bacilo_gram_negativo_ceftolozanetazobactam, \r\n"
				+ "antibiograma_bacilo_gram_negativo_ceftriaxona, \r\n"
				+ "antibiograma_bacilo_gram_negativo_ciprofloxacina, \r\n"
				+ "antibiograma_bacilo_gram_negativo_ebsl, \r\n"
				+ "antibiograma_bacilo_gram_negativo_ertapenem, antibiograma_bacilo_gram_negativo_fosfomicina, \r\n"
				+ "antibiograma_bacilo_gram_negativo_gentamicina, antibiograma_bacilo_gram_negativo_imipenem, \r\n"
				+ "antibiograma_bacilo_gram_negativo_meropenem, \"antibiograma_bacilo_gram_negativo_nitrofurantoína\", \r\n"
				+ "antibiograma_bacilo_gram_negativo_norfloxacina, antibiograma_bacilo_gram_negativo_piperacilinatazobactam, \r\n"
				+ "antibiograma_bacilo_gram_negativo_tigecilina, antibiograma_bacilo_gram_negativo_trimetoprima_sulfametox, \r\n"
				+ "presencia_de_germen_resistente,categoria_germen,\r\n"
				+ "antibiograma_coco_gram_positivo_ampicilina, antibiograma_coco_gram_positivo_benzilpenicilina, \r\n"
				+ "antibiograma_coco_gram_positivo_cefoxitina_screening, antibiograma_coco_gram_positivo_ceftarolina,\r\n"
				+ "antibiograma_coco_gram_positivo_ciprofloxacina, antibiograma_coco_gram_positivo_clindamicina, \r\n"
				+ "antibiograma_coco_gram_positivo_daptomicina, antibiograma_coco_gram_positivo_eritromicina,\r\n"
				+ "antibiograma_coco_gram_positivo_estreptomicina_nivel_alto, antibiograma_coco_gram_positivo_gentamicina_nivel_alto, \r\n"
				+ "antibiograma_coco_gram_positivo_levofloxacina, antibiograma_coco_gram_positivo_linezolid, \r\n"
				+ "\"antibiograma_coco_gram_positivo_nitrofurantoína\", antibiograma_coco_gram_positivo_oxaciclina, \r\n"
				+ "antibiograma_coco_gram_positivo_rifampicina, antibiograma_coco_gram_positivo_tetraciclina, \r\n"
				+ "antibiograma_coco_gram_positivo_trimetoprima_sulfametoxazol, antibiograma_coco_gram_positivo_vancomicina, \r\n"
				+ "antibiograma_coco_gram_positivo_resistencia_clindamicina, hongo_aislado, otro_hongo_aislado,\r\n"
				+ "recuento_colonias_nro_comentario,antifungigrama_anfotericinab, \r\n"
				+ "antifungigrama_caspofungina, antifungigrama_flucitosina, antifungigrama_fluconazol, antifungigrama_micafungina, \r\n"
				+ "antifungigrama_voriconazol,  firma_encargado, comentarios, firma_encargado,\r\n"
				+ "l.fecha_creacion, l.fecha_modificacion,   \r\n"
				+ "l.usuario_creacion\r\n"
				+ "	FROM public.laboratorio l join personas p on l.persona_id=p.persona_id where l.numero=?1 order by l.fecha_creacion;")
		List<String> excelParaLaboratorio(int numero);*/
		
		@Query("Select l from Laboratorio l JOIN Personas p on l.personas.personaId=p.personaId where l.numero=?1 and l.fechaCreacion > '2024-03-06 00:00:00' order by l.fechaCreacion")
		List<Laboratorio> excelParaLaboratorio(int numero);
		
		
		
		
}
