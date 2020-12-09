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
	private Double puntos_por_presentarse;
	@Column
	private Double puntos_por_ganar;
	@Column
	private Double puntos_por_empate;
	@Transient
	private List<EstadisticaTabla> estadisticas;
	

	public CompetenciaLiga() {
		super();
	}
	
	public CompetenciaLiga( String nombre, Modalidad modalidad,
			List<Participante> listaParticipantes, Fixture fixture, Integer cantSets, String reglamento, EstadoCompetencia estado,
			ModalidadDePuntuacion modalidadDePuntuacion, Double tantosXAusencia, Usuario usuario,
			Deporte id_deporte, List<EstadisticaTabla> estadisticas, Boolean empate,Double puntos_por_presentarse, Double puntos_por_ganar,Double puntos_por_empate) {
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


	public Double getPuntosXPresentarse() {
		return puntos_por_presentarse;
	}


	public void setPuntosXPresentarse(Double puntosXPresentarse) {
		this.puntos_por_presentarse = puntosXPresentarse;
	}


	public Double getPuntosXEmpate() {
		return puntos_por_empate;
	}


	public void setPuntosXEmpate(Double puntosXEmpate) {
		this.puntos_por_empate = puntosXEmpate;
	}


	public Double getPuntosXGanado() {
		return puntos_por_ganar;
	}


	public void setPuntosXGanado(Double puntosXGanado) {
		this.puntos_por_ganar = puntosXGanado;
	}


	public List<EstadisticaTabla> getEstadisticas() {
		return estadisticas;
	}


	public void setEstadisticas(List<EstadisticaTabla> estadisticas) {
		this.estadisticas = estadisticas;
	}
}