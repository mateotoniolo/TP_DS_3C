package tp.clases;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import tp.DTOs.ItemLugarDTO;
import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;
import tp.enums.ModalidadDePuntuacion;
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id_competencia")
@Table(name="Competencia_Liga")
public class CompetenciaLiga extends Competencia {
	@Column
	private Boolean empate;
	@Column
	private Integer puntos_por_presentarse;
	@Column
	private Integer puntos_por_ganar;
	@Column
	private Integer puntos_por_empate;
	@Transient
	private List<EstadisticaTabla> estadisticas;
	
	// constructor sin params
	public CompetenciaLiga() {
		super();
	}
	
	public CompetenciaLiga( String nombre, Modalidad modalidad,
			List<Participante> listaParticipantes, Fixture fixture, Integer cantSets, String reglamento, EstadoCompetencia estado,
			ModalidadDePuntuacion modalidadDePuntuacion, Double tantosXAusencia, Usuario usuario,
			Deporte id_deporte, List<EstadisticaTabla> estadisticas, Boolean empate) {
		super( nombre, modalidad, listaParticipantes, fixture, cantSets, reglamento, estado , modalidadDePuntuacion, tantosXAusencia,
				usuario, id_deporte);
		
		this.setEmpate(empate);
		this.setPuntosXPresentarse(puntos_por_presentarse);
		this.setPuntosXGanado(puntos_por_ganar);
		this.setPuntosXEmpate(puntos_por_empate);
		this.setEstadisticas(estadisticas);
	}

	
	// Getters and Setters

	public Boolean getEmpate() {
		return empate;
	}


	public void setEmpate(Boolean empate) {
		this.empate = empate;
	}


	public Integer getPuntosXPresentarse() {
		return puntos_por_presentarse;
	}


	public void setPuntosXPresentarse(Integer puntosXPresentarse) {
		this.puntos_por_presentarse = puntosXPresentarse;
	}


	public Integer getPuntosXEmpate() {
		return puntos_por_empate;
	}


	public void setPuntosXEmpate(Integer puntosXEmpate) {
		this.puntos_por_empate = puntosXEmpate;
	}


	public Integer getPuntosXGanado() {
		return puntos_por_ganar;
	}


	public void setPuntosXGanado(Integer puntosXGanado) {
		this.puntos_por_ganar = puntosXGanado;
	}


	public List<EstadisticaTabla> getEstadisticas() {
		return estadisticas;
	}


	public void setEstadisticas(List<EstadisticaTabla> estadisticas) {
		this.estadisticas = estadisticas;
	}
}