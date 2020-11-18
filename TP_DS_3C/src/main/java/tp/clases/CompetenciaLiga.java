package tp.clases;

import java.util.List;
import java.util.Optional;

import tp.DTOs.ItemLugarDTO;
import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;
import tp.enums.ModalidadDePuntuacion;

public class CompetenciaLiga extends Competencia {
	
	private Boolean empate;
	private Integer puntosXPresentarse;
	private Integer puntosXGanado;
	private Integer puntosXEmpate;
	private List<EstadisticaTabla> estadisticas;
	
	// constructor sin params
	public CompetenciaLiga() {
		super();
	}
	
	public CompetenciaLiga( String nombre, Modalidad modalidad,
			List<Participante> listaParticipantes, Integer fixture, Integer cantSets, String reglamento, EstadoCompetencia estado,
			ModalidadDePuntuacion modalidadDePuntuacion, Double tantosXAusencia, Integer idAdministrador,
			Integer id_deporte, List<EstadisticaTabla> estadisticas, List<ItemLugarDTO> list,Boolean empate) {
		super( nombre, modalidad, listaParticipantes, fixture, cantSets, reglamento, estado , modalidadDePuntuacion, tantosXAusencia,
				idAdministrador, id_deporte,list,empate);
		
		this.setEmpate(empate);
		this.setPuntosXPresentarse(puntosXPresentarse);
		this.setPuntosXGanado(puntosXGanado);
		this.setPuntosXEmpate(puntosXEmpate);
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
		return puntosXPresentarse;
	}


	public void setPuntosXPresentarse(Integer puntosXPresentarse) {
		this.puntosXPresentarse = puntosXPresentarse;
	}


	public Integer getPuntosXEmpate() {
		return puntosXEmpate;
	}


	public void setPuntosXEmpate(Integer puntosXEmpate) {
		this.puntosXEmpate = puntosXEmpate;
	}


	public Integer getPuntosXGanado() {
		return puntosXGanado;
	}


	public void setPuntosXGanado(Integer puntosXGanado) {
		this.puntosXGanado = puntosXGanado;
	}


	public List<EstadisticaTabla> getEstadisticas() {
		return estadisticas;
	}


	public void setEstadisticas(List<EstadisticaTabla> estadisticas) {
		this.estadisticas = estadisticas;
	}
}