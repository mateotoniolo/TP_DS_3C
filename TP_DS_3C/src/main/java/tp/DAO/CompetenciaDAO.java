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
	
	public Boolean SaveCompetenciaModalidad(Competencia comp) {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		Integer id_competencia = this.getIDbyNombre(comp.getNombre());
		switch(comp.getModalidad().toString()) {
		case "LIGA":
			try {
				pstm = con.prepareStatement(
						"INSERT INTO dsi20203c.Competencia_Liga VALUES (?,NULL,NULL,NULL,NULL);");
				pstm.setInt(1,id_competencia);
	
				return pstm.executeUpdate() == 1;
			}catch(Exception e) {
				System.out.println(e.getMessage());	
			}
			finally {
				DataBase.cerrarPstm(pstm);
				DataBase.cerrarConexion(con);
			}
			break;
		case "ELIMINACION_DIRECTA":
			try {
				pstm = con.prepareStatement(
						"INSERT INTO dsi20203c.Competencia_Eliminacion_Directa VALUES (?);");
				pstm.setInt(1, id_competencia);

				return pstm.executeUpdate() == 1;
			}catch(Exception e) {
				System.out.println(e.getMessage());	
			}
			finally {
				DataBase.cerrarPstm(pstm);
				DataBase.cerrarConexion(con);
			}
			break;
		case "ELIMINACION_DOBLE":
			try {
				pstm = con.prepareStatement(
						"INSERT INTO dsi20203c.Competencia_Eliminacion_Doble VALUES (?);");
				pstm.setInt(1, id_competencia);

				return pstm.executeUpdate() == 1;
			}catch(Exception e) {
				System.out.println(e.getMessage());	
			}
			finally {
				DataBase.cerrarPstm(pstm);
				DataBase.cerrarConexion(con);
			}
			break;
	}
		return false;
	}
	
	public static Integer getIDbyNombre(String nombre) {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Integer id_Competencia = null;
		try {
			pstm = con.prepareStatement(
					"SELECT id_competencia FROM dsi20203c.Competencia WHERE nombre = ?");
			pstm.setString(1, nombre);
			rs = pstm.executeQuery();
			while(rs.next()) {
			id_Competencia = rs.getInt(1);}
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		finally {
			DataBase.cerrarRs(rs);
			DataBase.cerrarPstm(pstm);
			DataBase.cerrarConexion(con);
		}
		return id_Competencia;
	}
	
	public static List<CompetenciaDTO> getAllCompetenciasDTO() {
		List<Competencia> listaCompetencias= new ArrayList<>();
		List<CompetenciaDTO> listaCompetenciasDTO= new ArrayList<>();
//		Query query=App.entity.createQuery("SELECT p FROM Competencia p");
//		listaCompetencias=(List<Competencia>)query.getResultList();
//		for (Competencia p : listaCompetencias) {
//			listaCompetenciasDTO.add(new CompetenciaDTO(p.getNombre(), null/*modalidad*/, null/*reglamento*/, p.getCantSets(),
//					p.getModalidadDePuntuacion(),p.getTantosXAusencia(), null/*EMPATE*/, null/*PUNTOSXPRESENTARSE*/, null/*puntosXEmpate*/,
//					null/*puntosXGanado*/, p.getDeporte().getIdDeporte(), p.getLugares(), p.getUsuario().getIdUsuario()));
//		}
		return listaCompetenciasDTO;
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
