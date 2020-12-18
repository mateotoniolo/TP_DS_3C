package tp.DTOs;

import java.util.ArrayList;
import java.util.List;

import tp.Gestores.GestorCompetencia;
import tp.clases.Deporte;
import tp.clases.Fecha;
import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;
import tp.enums.ModalidadDePuntuacion;

public class CompetenciaPartidosDTO {
	
	private CompetenciaDTO competencia;
	private List<PartidoDTO> partidos = new ArrayList<>();
	
	public CompetenciaPartidosDTO(CompetenciaDTO comp, List<PartidoDTO> games) {
		this.competencia = comp;
		this.partidos = games;
	}
	
	
	public Integer getId_competencia() {
		return competencia.getId_competencia();
	}
	
	public String getNombre() {
		return competencia.getNombre();
	}
	
	public Modalidad getModalidad() {
		return competencia.getModalidad();
	}
	
	public Deporte getDeporte() {
		return GestorCompetencia.getDeporteByID(competencia.getId_deporte());
	}
	
	public EstadoCompetencia getEstado() {
		return competencia.getEstado();
	}
	
//	public Integer getId_fixture() {
//		return fixture.getId_fixture();
//	}
//	
//	public List<Fecha> getListaFechas() {
//		return fixture.getListaFechas();
//	}


	public boolean isCreated() {
		return (!partidos.isEmpty());
	}


	public CompetenciaDTO getCompetencia() {
		return competencia;
	}


	public void setCompetencia(CompetenciaDTO competencia) {
		this.competencia = competencia;
	}


//	public FixtureDTO getFixture() {
//		return fixture;
//	}
//
//
//	public void setFixture(FixtureDTO fixture) {
//		this.fixture = fixture;
//	}


	public List<PartidoDTO> getPartidos() {
		return partidos;
	}


	public void setPartidos(List<PartidoDTO> partidos) {
		this.partidos = partidos;
	}
	
}
