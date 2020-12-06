package tp.Gestores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import tp.DAO.CompetenciaDAO;
import tp.DAO.DeporteDAO;
import tp.DAO.LugarDAO;
import tp.DAO.UsuarioDAO;
import tp.DTOs.CompetenciaDTO;
import tp.DTOs.CompetenciaPartidosDTO;
import tp.DTOs.DeporteDTO;
import tp.DTOs.ItemLugarDTO;
import tp.DTOs.ParticipanteDTO;
import tp.clases.Competencia;
import tp.clases.CompetenciaEliminacionDoble;
import tp.clases.CompetenciaEliminacionSimple;
import tp.clases.CompetenciaLiga;
import tp.clases.Deporte;
import tp.clases.ItemLugar;
import tp.clases.Lugar;
import tp.clases.Participante;
import tp.clases.Usuario;
import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;

public class GestorCompetencia {

	private CompetenciaDAO competenciaDao = new CompetenciaDAO();
	private Competencia competencia ;
	
	
	public Boolean crearCompetencia(CompetenciaDTO DTO) throws Exception {
	if(!(GestorCompetencia.getCompetenciaByName(DTO.getNombre()) == null)) {
		throw new Exception("Ya existe una competencia con ese nombre. Ingrese un nombre distinto");
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
	public static Competencia getCompetenciaByName(String nombre) {
		return CompetenciaDAO.getCompetenciaByName(nombre);
		
	}
	public static Competencia getCompetenciaByID(Integer id) {
		return CompetenciaDAO.getCompetenciaByID(id);
		
	}

	public static List<CompetenciaDTO> listarCompetencias() {
		return CompetenciaDAO.getAllCompetenciasDTO();
	}

	public static List<ParticipanteDTO> mostrarParticipantes(Integer id_competencia) {
		List<ParticipanteDTO> participantesDTO = new ArrayList<>();
		for (Participante p : CompetenciaDAO.getCompetenciaByID(id_competencia).getParticipantes()) {
			participantesDTO.add(new ParticipanteDTO(p.getNombre(),p.getEmail()));
		}
		return participantesDTO;
	}

	public static void validar(Integer id_competencia) throws Exception {
		Competencia competencia = CompetenciaDAO.getCompetenciaByID(id_competencia);
		if(!(competencia.getEstado().equals(EstadoCompetencia.CREADA) || competencia.getEstado().equals(EstadoCompetencia.PLANIFICADA))) {
			throw new Exception("La competencia no se encuentra en estado CREADA / Planificada. \n"+"No se puede agregar participantes.");
		}
	}

	public static void crearParticipante(Integer id_competencia, ParticipanteDTO participanteDTO) throws Exception {
		Competencia competencia = getCompetenciaByID(id_competencia);
		
		if(participanteDTO.getNombre().equals("") || participanteDTO.getEmail().equals("")) {
			throw new Exception("El Nombre y el Email no pueden ser campos vacíos.") ;
			}
		
		Optional<Participante> participanteByName = competencia.getParticipantes().stream().filter(p -> p.getNombre().equals(participanteDTO.getNombre())).findAny();
		
		if(participanteByName.isPresent()) {
			throw new Exception("Ya existe un participante con ese nombre. Reingrese un nombre distinto.") ;
		}
		
		Optional<Participante> participanteByEmail = competencia.getParticipantes().stream().filter(p -> p.getEmail().equals(participanteDTO.getEmail())).findAny();
		if(participanteByEmail.isPresent()) {
			throw new Exception("Ya existe un participante con ese Email. Reingrese un Email distinto.") ;
		}
		
		competencia.setEstado(EstadoCompetencia.CREADA.toString());
		competencia.addParticipante(new Participante(participanteDTO.getNombre(), participanteDTO.getEmail()));
			try{
				CompetenciaDAO.Save(competencia);
			}catch(Exception e) {
				throw new Exception("Lo sentimos, algo falló en el proceso. Inténtelo de nuevo.");
			}
	}

	public static List<CompetenciaDTO> getCompetenciasByDTO(CompetenciaDTO competenciaDTO) throws Exception {
		String query = "SELECT c FROM Competencia c WHERE id_usuario = '"+competenciaDTO.getId_usuario()+"'"; 
		Boolean flag = false;
		if(!competenciaDTO.getNombre().equals("")) {
				query = query+" AND nombre = '"+competenciaDTO.getNombre()+"'";
				flag = true;
		}
		if(!(competenciaDTO.getModalidad() == null)) {
			
				query = query+" AND modalidad = '"+competenciaDTO.getModalidad().toString()+"'";
				flag = true;
		}
		if(!(competenciaDTO.getId_deporte() == null)) {
			
				query = query+" AND id_deporte = '"+competenciaDTO.getId_deporte()+"'";
				flag = true;
		}
		if(!(competenciaDTO.getEstado() == null)) {
			
				query = query+" AND estado = '"+competenciaDTO.getEstado().toString()+"'";
				flag = true;
		}
		if(!flag) {
			throw new Exception("Debe completar al menos un campo de búsqueda.");
		}
		return convertiraDTO(CompetenciaDAO.getCompetenciasByDTO(query));
	}

	private static List<CompetenciaDTO> convertiraDTO(List<Competencia> competenciasByDTO) {
		List<CompetenciaDTO> competenciasDTO = new ArrayList<>();
		for(Competencia comp : competenciasByDTO) {
			CompetenciaDTO c = new CompetenciaDTO();
			c.setNombre(comp.getNombre());
			c.setId_competencia(comp.getId_competencia());
			c.setModalidad(Modalidad.valueOf(comp.getModalidad()));
			c.setId_deporte(comp.getDeporte().getIdDeporte());
			c.setEstado(comp.getEstado());
			for(Participante p: comp.getParticipantes()) {
				c.addParticipante(new ParticipanteDTO(p.getNombre(),p.getEmail()));
			}
			c.setId_fixture(comp.getFixtureID());
			competenciasDTO.add(c);
		}
		return competenciasDTO;
	}

	public CompetenciaPartidosDTO mostrarCompetencia(CompetenciaDTO compDTO) {
		CompetenciaPartidosDTO compPartDTO = new CompetenciaPartidosDTO(compDTO, null);
		return compPartDTO;
	}

	public static Deporte getDeporteByID(Integer id_deporte) {
		return CompetenciaDAO.getDeporteByID(id_deporte);
		
	}
	
	
	
}
