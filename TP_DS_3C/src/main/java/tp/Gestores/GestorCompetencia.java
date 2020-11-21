package tp.Gestores;

import java.util.List;

import tp.DAO.CompetenciaDAO;
import tp.DAO.DeporteDAO;
import tp.DTOs.CompetenciaDTO;
import tp.DTOs.DeporteDTO;
import tp.clases.Competencia;
import tp.clases.CompetenciaEliminacionDoble;
import tp.clases.CompetenciaEliminacionSimple;
import tp.clases.CompetenciaLiga;
import tp.clases.Deporte;
import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;

public class GestorCompetencia {

	private CompetenciaDAO competenciaDao = new CompetenciaDAO();
	private Competencia competencia ;
	
	
	public Boolean Save(CompetenciaDTO DTO) {
	if(!this.getCompetenciaByName(DTO.getNombre())) {
		System.out.println("TIRAR EXCEPTION");
	}
	Deporte deporte = DeporteDAO.getDeporteById(DTO.getId_deporte());
	switch(DTO.getModalidad()) {
		case LIGA:
			 competencia = new CompetenciaLiga(DTO.getNombre(),DTO.getModalidad(),null,
					 null,DTO.getCantSets(),DTO.getReglamento(),EstadoCompetencia.CREADA, DTO.getPuntuacion(),
					 DTO.getTantosXAusencia(),DTO.getId_usuario(),deporte,
					 null,DTO.getLugares(),DTO.getEmpate());
			 this.competenciaDao.Save((CompetenciaLiga)competencia);
			 break;
		case ELIMINACION_DIRECTA:
			 competencia = new CompetenciaEliminacionSimple(DTO.getNombre(), DTO.getModalidad(),
					 null,null,DTO.getCantSets(),DTO.getReglamento(),EstadoCompetencia.CREADA,DTO.getPuntuacion(),
					 DTO.getTantosXAusencia(),DTO.getId_usuario(),deporte,DTO.getLugares());
			 this.competenciaDao.Save((CompetenciaEliminacionSimple)competencia);
			 break;
		case ELIMINACION_DOBLE:
			 competencia = new CompetenciaEliminacionDoble(DTO.getNombre(), DTO.getModalidad(),
					 null,null,DTO.getCantSets(),DTO.getReglamento(),EstadoCompetencia.CREADA,DTO.getPuntuacion(),
					 DTO.getTantosXAusencia(),DTO.getId_usuario(),deporte,DTO.getLugares());
			 this.competenciaDao.Save((CompetenciaEliminacionDoble)competencia);
			 	break;
		}
		
		return true;
		}
	
	public static List<DeporteDTO> getDeportes(){
		
		return DeporteDAO.getDeportesDTO();
		
	}
	public static Boolean getCompetenciaByName(String nombre) {
		if(CompetenciaDAO.getCompetenciaByName(nombre) == null) {
			return true;
		}else {
			return false;
		}
	}

	public static List<CompetenciaDTO> listarCompetencias() {
		return CompetenciaDAO.getAllCompetenciasDTO();
	}
}
