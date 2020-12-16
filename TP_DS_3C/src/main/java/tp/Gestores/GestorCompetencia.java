package tp.Gestores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import tp.DAO.CompetenciaDAO;
import tp.DAO.DeporteDAO;
import tp.DAO.LugarDAO;
import tp.DAO.UsuarioDAO;
import tp.DTOs.CompetenciaDTO;
import tp.DTOs.CompetenciaPartidosDTO;
import tp.DTOs.DeporteDTO;
import tp.DTOs.ItemLugarDTO;
import tp.DTOs.ParticipanteDTO;
import tp.app.App;
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
import tp.enums.ModalidadDePuntuacion;

public class GestorCompetencia {	
	
	public static Boolean crearCompetencia(CompetenciaDTO DTO) throws Exception {
		//VALIDACIONES -----------------------------------------------------------------------------------------------
		String CamposVacios="";
		if(DTO.getNombre().isBlank()) {
			CamposVacios=CamposVacios+"La competencia debe tener un nombre. \n";
		}
		if(DTO.getLugares().isEmpty()) {
			CamposVacios=CamposVacios+"La competencia debe tener al menos un lugar de realización. \n";
		}
		if(DTO.getModalidad() == null) {
			CamposVacios=CamposVacios+"Debe indicar una Modalidad de competencia. \n";
		}
		if(DTO.getModalidad()==tp.enums.Modalidad.LIGA) {
			if(DTO.getEmpate()&&DTO.getPuntosXEmpate()==null) {
				CamposVacios=CamposVacios+"Debe ingresar puntos por empate. \n";
			}
			if(DTO.getPuntosXGanado()==null) {
				CamposVacios=CamposVacios+"Debe ingresar puntos por partido ganado. \n";
			}
			if(DTO.getPuntosXPresentarse()==null) {
				CamposVacios=CamposVacios+"Debe ingresar puntos por presentarse. \n";
			}
		}
		switch(DTO.getPuntuacion()) {
		case SETS:
			if(DTO.getCantSets()==null) {
				CamposVacios=CamposVacios+"Debe ingresar una cantidad válida de sets. \n";
			}
			break;
		default:
			if(DTO.getTantosXAusencia()==null) {
				CamposVacios=CamposVacios+"Debe ingresar tantos por ausencia. \n";
			}
		}
		if(!CamposVacios.equals("")) {
			throw new Exception("Campos incompletos: \n"+CamposVacios);
		}
		if(DTO.getPuntuacion()==ModalidadDePuntuacion.SETS &&
				(DTO.getCantSets()%2!=1||DTO.getCantSets()>10)) {
			throw new Exception("La cantidad de sets debe ser impar y menor a 10.");
		}
		if(DTO.getEmpate()&&(DTO.getPuntosXEmpate()>DTO.getPuntosXGanado())) {
			throw new Exception("Los puntos por empate deben ser menor que los puntos por ganar.");
		}
		if((DTO.getModalidad() == Modalidad.LIGA) && (DTO.getPuntosXPresentarse() >= DTO.getPuntosXGanado())) {
			throw new Exception("Los puntos por presentarse deben ser menor que los puntos por ganar.");
		}
		//FIN VALIDACIONES--------------------------------------------------------------------------------------------------------------------------------
		Competencia competencia ;
	if(!(GestorCompetencia.getCompetenciaByName(DTO.getNombre()) == null)) {
		throw new Exception("Ya existe una competencia con ese nombre. Ingrese un nombre distinto");
	}
	Deporte deporte = DeporteDAO.getDeporteById(DTO.getId_deporte());
	Usuario usuario = UsuarioDAO.getUsuarioById(DTO.getId_usuario());
	int result = JOptionPane.showConfirmDialog(null,"Seguro desea agregar una nueva competencia?", "Confirmación",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);
	if(result == JOptionPane.CANCEL_OPTION) {
		return false;
	}
	try {
		switch(DTO.getModalidad()) {
			case LIGA:
				 competencia = new CompetenciaLiga(DTO.getNombre(),DTO.getModalidad(),null,
						 null,DTO.getCantSets(),DTO.getReglamento(),EstadoCompetencia.CREADA, DTO.getPuntuacion(),
						 DTO.getTantosXAusencia(),usuario,deporte,
						 null, DTO.getEmpate(),DTO.getPuntosXPresentarse(),DTO.getPuntosXGanado(),DTO.getPuntosXEmpate());
				 for(ItemLugarDTO dto : DTO.getLugares()) {
						Lugar lugar = LugarDAO.getLugarByCodigo(dto.getCodigo());
						ItemLugar item = new ItemLugar(competencia,lugar,dto.getDisponibilidad());
						competencia.addLugar(item);
					}
				 usuario.addCompetencia(competencia);
				 
				 CompetenciaDAO.Save((CompetenciaLiga)competencia);
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
				 CompetenciaDAO.Save((CompetenciaEliminacionSimple)competencia);
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
				 CompetenciaDAO.Save((CompetenciaEliminacionDoble)competencia);
				 	break;
			}
		}catch(Exception e) {
			throw new Exception("Lo sentimos, algo salió mal. Aguarde un momento e intentelo nuevamente");
		}
		return true;
		}
	
	public static List<DeporteDTO> getDeportes(){
		List<DeporteDTO> lista = DeporteDAO.getDeportesDTO();
		Collections.sort(lista);
		return lista;
		
	}
	public static Competencia getCompetenciaByName(String nombre) {
		return CompetenciaDAO.getCompetenciaByName(nombre);
		
	}
	public static Competencia getCompetenciaByID(Integer id) {
		return CompetenciaDAO.getCompetenciaByID(id);
		
	}


	public static List<ParticipanteDTO> mostrarParticipantes(Integer id_competencia) {
		Competencia competencia = GestorCompetencia.getCompetenciaByID(id_competencia);
		List<ParticipanteDTO> participantesDTO = new ArrayList<>();
		for (Participante p : competencia.getParticipantes()) {
			participantesDTO.add(new ParticipanteDTO(p.getNombre(),p.getEmail()));
		}
		return participantesDTO;
	}

	public static void validar(CompetenciaDTO competencia) throws Exception {

		if(!(competencia.getEstado().equals(EstadoCompetencia.CREADA) || competencia.getEstado().equals(EstadoCompetencia.PLANIFICADA))) {
			throw new Exception("La competencia no se encuentra en estado CREADA / PLANIFICADA. \n"+"No se puede agregar participantes.");
		}
	}

	public static Boolean crearParticipante(CompetenciaDTO compDTO, ParticipanteDTO participanteDTO) throws Exception {
		Competencia competencia = getCompetenciaByID(compDTO.getId_competencia());
		
		if(participanteDTO.getNombre().isBlank() || participanteDTO.getEmail().isBlank()) {
			throw new Exception("El nombre y el mail del participante no pueden ser campos vacíos. \n");
		}
		if(correoNoValido(participanteDTO.getEmail())) {
			throw new Exception("El correo ingresado no es válido. \n Debe tener formato xxx@xx.xxx");
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
		competencia.addParticipante(new Participante(participanteDTO.getNombre(), participanteDTO.getEmail(),competencia));
			try{
				int result = JOptionPane.showConfirmDialog(null,"Seguro desea agregar un nuevo participante?", "Confirmación",
			            JOptionPane.OK_CANCEL_OPTION,
			            JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.OK_OPTION) {
				CompetenciaDAO.Save(competencia);
				return true;
				}else {
					return false;
				}
			}catch(Exception e) {
				throw new Exception("Lo sentimos, algo salió mal. Aguarde un momento e intentelo nuevamente");
			}
	}

	public static List<CompetenciaDTO> listarCompetencias(CompetenciaDTO competenciaDTO) throws Exception {
		String query = "SELECT c FROM Competencia c WHERE id_usuario = '"+competenciaDTO.getId_usuario()+"'"; 
		Boolean flag = false;
		if(!competenciaDTO.getNombre().equals("")) {
				query = query+" AND nombre like '%"+competenciaDTO.getNombre()+"%'";

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
			if(comp.getFixture() == null) {
				c.setId_fixture(null);
			}else {	
				c.setId_fixture(comp.getFixture().getId_fixture());
			}
			competenciasDTO.add(c);
		}
		return competenciasDTO;
	}
	
	public static CompetenciaDTO convertiraDTO(Competencia comp) {
		
		
			CompetenciaDTO c = new CompetenciaDTO();
			c.setNombre(comp.getNombre());
			c.setId_competencia(comp.getId_competencia());
			c.setModalidad(Modalidad.valueOf(comp.getModalidad()));
			c.setId_deporte(comp.getDeporte().getIdDeporte());
			c.setEstado(comp.getEstado());
			for(Participante p: comp.getParticipantes()) {
				c.addParticipante(new ParticipanteDTO(p.getNombre(),p.getEmail()));
			}
			if(comp.getFixture() == null) {
				c.setId_fixture(null);
			}else {	
				c.setId_fixture(comp.getFixture().getId_fixture());
			}
			
		
		return c;
	}

	public CompetenciaPartidosDTO mostrarCompetencia(CompetenciaDTO compDTO) {
		CompetenciaPartidosDTO compPartDTO = new CompetenciaPartidosDTO(compDTO, null);
		return compPartDTO;
	}

	public static CompetenciaDTO getCompetenciaDTObyID(Integer id_competencia) {
		Competencia comp = CompetenciaDAO.getCompetenciaByID(id_competencia);
		return convertiraDTO(comp);
	}

	public static Deporte getDeporteByID(Integer id_deporte) {
		
		return CompetenciaDAO.getDeporteByID(id_deporte);
	}
	
	public static void generarFixture(CompetenciaDTO DTO) throws Exception{
		Competencia competencia=CompetenciaDAO.getCompetenciaByID(DTO.getId_competencia());
		if(competencia.getEstado()==EstadoCompetencia.EN_DISPUTA||competencia.getEstado()==EstadoCompetencia.FINALIZADA) {
			throw new Exception("La competencia ya esta en dispùta o finalizo.");
		}
		if(competencia.getParticipantes().size()<2) {
			throw new Exception("La competencia tiene menos de 2 participantes.");
		}
			try {
				competencia.setFixture(GestorFixture.generarFixture(competencia));
				if(competencia.getEstado()==EstadoCompetencia.CREADA) {
					competencia.setEstado(EstadoCompetencia.PLANIFICADA.toString());
				}
				CompetenciaDAO.Save(competencia);
			}catch(Exception e) {
				throw new Exception("Lo sentimos, algo salió mal. Aguarde un momento e intentelo nuevamente");
			}
		}
	private static boolean correoNoValido(String text) {
		Boolean chequeo = false;
		if(text.isBlank()) chequeo = false;
		
		chequeo = (text.contains("@") && text.contains("."));
		if(chequeo) {
			Integer posArroba =  text.indexOf("@");
			Integer posPunto =  text.indexOf(".");
			chequeo = (text.charAt(0) != '@' && !text.substring(posArroba).isBlank()
					&& posArroba+1 != posPunto
					&& !text.substring(posPunto).isBlank());
		}
			
		return !chequeo;
	}
	
}
