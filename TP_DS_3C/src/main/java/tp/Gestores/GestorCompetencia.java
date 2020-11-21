package tp.Gestores;

import java.util.ArrayList;
import java.util.List;

import tp.DAO.CompetenciaDAO;
import tp.DAO.DeporteDAO;
import tp.DAO.LugarDAO;
import tp.DAO.UsuarioDAO;
import tp.DTOs.CompetenciaDTO;
import tp.DTOs.DeporteDTO;
import tp.DTOs.ItemLugarDTO;
import tp.clases.Competencia;
import tp.clases.CompetenciaEliminacionDoble;
import tp.clases.CompetenciaEliminacionSimple;
import tp.clases.CompetenciaLiga;
import tp.clases.Deporte;
import tp.clases.ItemLugar;
import tp.clases.Lugar;
import tp.clases.Usuario;
import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;

public class GestorCompetencia {

	private CompetenciaDAO competenciaDao = new CompetenciaDAO();
	private Competencia competencia ;
	
	
	public Boolean crearCompetencia(CompetenciaDTO DTO) {
	if(!GestorCompetencia.getCompetenciaByName(DTO.getNombre())) {
		System.out.println("TIRAR EXCEPTION");
	}
	Deporte deporte = DeporteDAO.getDeporteById(DTO.getId_deporte());
	Usuario usuario = UsuarioDAO.getUsuarioById(DTO.getId_usuario());

	switch(DTO.getModalidad()) {
		case LIGA:
			 competencia = new CompetenciaLiga(DTO.getNombre(),DTO.getModalidad(),null,
					 null,DTO.getCantSets(),DTO.getReglamento(),EstadoCompetencia.CREADA, DTO.getPuntuacion(),
					 DTO.getTantosXAusencia(),usuario,deporte,
					 null, DTO.getEmpate());
			 for(ItemLugarDTO dto : DTO.getLugares()) {
					Lugar lugar = LugarDAO.getLugarByCodigo(dto.getCodigo());
					ItemLugar item = new ItemLugar(competencia,lugar,dto.getDisponibilidad());
					competencia.addLugar(item);
				}
			 usuario.addCompetencia(competencia);
			 this.competenciaDao.Save((CompetenciaLiga)competencia);
			 break;
		case ELIMINACION_DIRECTA:
			 competencia = new CompetenciaEliminacionSimple(DTO.getNombre(), DTO.getModalidad(),
					 null,null,DTO.getCantSets(),DTO.getReglamento(),EstadoCompetencia.CREADA,DTO.getPuntuacion(),
					 DTO.getTantosXAusencia(),usuario,deporte);
			 for(ItemLugarDTO dto : DTO.getLugares()) {
					Lugar lugar = LugarDAO.getLugarByCodigo(dto.getCodigo());
					ItemLugar item = new ItemLugar(competencia,lugar,dto.getDisponibilidad());
					competencia.addLugar(item);
				}
			 usuario.addCompetencia(competencia);
			 this.competenciaDao.Save((CompetenciaEliminacionSimple)competencia);
			 break;
		case ELIMINACION_DOBLE:
			 competencia = new CompetenciaEliminacionDoble(DTO.getNombre(), DTO.getModalidad(),
					 null,null,DTO.getCantSets(),DTO.getReglamento(),EstadoCompetencia.CREADA,DTO.getPuntuacion(),
					 DTO.getTantosXAusencia(),usuario,deporte);
			 for(ItemLugarDTO dto : DTO.getLugares()) {
					Lugar lugar = LugarDAO.getLugarByCodigo(dto.getCodigo());
					ItemLugar item = new ItemLugar(competencia,lugar,dto.getDisponibilidad());
					competencia.addLugar(item);
				}
			 usuario.addCompetencia(competencia);
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
