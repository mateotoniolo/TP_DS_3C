package tp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import tp.DTOs.CompetenciaDTO;
import tp.DTOs.DeporteDTO;
import tp.DTOs.ItemLugarDTO;
import tp.app.App;
import tp.clases.Competencia;
import tp.clases.CompetenciaEliminacionDoble;
import tp.clases.CompetenciaEliminacionSimple;
import tp.clases.CompetenciaLiga;
import tp.clases.Deporte;
import tp.enums.Modalidad;
import tp.enums.ModalidadDePuntuacion;



public class CompetenciaDAO {

	public static Boolean Save(Competencia comp) {
		App.entity.getTransaction().begin();
		App.entity.persist(comp);
		App.entity.getTransaction().commit();
		return true;
	}
	public Boolean Save(CompetenciaEliminacionDoble comp) {
		App.entity.getTransaction().begin();
		App.entity.persist(comp);
		App.entity.getTransaction().commit();
		return true;
	}
	public Boolean Save(CompetenciaEliminacionSimple comp) {
		App.entity.getTransaction().begin();
		App.entity.persist(comp);
		App.entity.getTransaction().commit();
		return true;
	}
	public Boolean Save(CompetenciaLiga comp) {
		App.entity.getTransaction().begin();
		App.entity.persist(comp);
		App.entity.getTransaction().commit();
		return true;
	}
	public static Competencia getCompetenciaByName(String nombre) {
		Query query=App.entity.createQuery("SELECT c FROM Competencia c WHERE c.nombre = '"+nombre+"'");
		List<Competencia> competencias = (List<Competencia>)query.getResultList();
		if(competencias.isEmpty()) {
			return null;
		}else {
		return competencias.get(0);}
	}
	
	

	public static Competencia getCompetenciaByID(Integer id) {
		Competencia competencia = new Competencia();
		competencia = App.entity.find(Competencia.class, id);
		return competencia;
	}
	public static void update(Competencia competencia) {
		App.entity.getTransaction().begin();
		App.entity.merge(competencia);
		App.entity.getTransaction().commit();
		
	}
	public static List<Competencia> getCompetenciasByDTO(String Query) {
		Query query=App.entity.createQuery(Query);
		List<Competencia> competencias = (List<Competencia>)query.getResultList();
		return competencias;
	}
	public static Deporte getDeporteByID(Integer id_deporte) {
		Deporte deporte = App.entity.find(Deporte.class, id_deporte);
		return deporte;
	}
}
