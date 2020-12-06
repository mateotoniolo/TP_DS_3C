package tp.DTOs;

import java.util.List;

import tp.clases.Deporte;
import tp.clases.Fecha;
import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;
import tp.enums.ModalidadDePuntuacion;

public class CompetenciaPartidosDTO {
	
	private CompetenciaDTO competencia;
	private FixtureDTO fixture;
	
	public CompetenciaPartidosDTO(CompetenciaDTO comp, FixtureDTO fixture) {
		this.competencia = comp;
		this.fixture = fixture;
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
	
	public Integer getDeporte() {
		return competencia.getId_deporte();
	}
	
	public EstadoCompetencia getEstado() {
		return competencia.getEstado();
	}
	
	public Integer getId_fixture() {
		return fixture.getId_fixture();
	}
	
	public List<Fecha> getListaFechas() {
		return fixture.getListaFechas();
	}


	public boolean isCreated() {
		return (fixture!=null);
	}
	
}
