package tp.DTOs;

import java.util.List;

import tp.clases.ItemLugar;
import tp.enums.Modalidad;
import tp.enums.ModalidadDePuntuacion;

public class CompetenciaDTO {

	Integer id_competencia;
	String nombre;
	Modalidad modalidad;
	String reglamento;
	Integer cantSets;
	ModalidadDePuntuacion puntuacion;
	Double tantosXAusencia;
	Boolean empate;
	Double puntosXPresentarse;
	Double puntosXEmpate;
	Double puntosXGanado;
	Integer id_deporte;
	List<ItemLugarDTO> Lugares;
	Integer id_usuario;
	
	
	public CompetenciaDTO( String name, Modalidad modalidad, String reglamento, Integer cantSets, ModalidadDePuntuacion Puntuacion
			,Double tantosXAusencia,Boolean empate,Double puntosXPresentarse, Double puntosXEmpate, Double puntosXGanado, Integer id_deporte, List<ItemLugarDTO> Lugares,
			Integer id_usuario) {
		this.nombre = name;
		this.modalidad = modalidad;
		this.reglamento = reglamento;
		this.cantSets = cantSets;
		this.puntuacion = Puntuacion;
		this.tantosXAusencia = tantosXAusencia;
		this.empate = empate;
		this.puntosXPresentarse = puntosXPresentarse;
		this.puntosXEmpate = puntosXEmpate;
		this.puntosXGanado = puntosXGanado;
		this.id_deporte = id_deporte;
		this.Lugares = Lugares;
		this.id_usuario = id_usuario;
	}
	
	
	public Integer getId_competencia() {
		return id_competencia;
	}
	public void setId_competencia(Integer id_competencia) {
		this.id_competencia = id_competencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Modalidad getModalidad() {
		return modalidad;
	}
	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}
	public String getReglamento() {
		return reglamento;
	}
	public void setReglamento(String reglamento) {
		this.reglamento = reglamento;
	}
	public Integer getCantSets() {
		return cantSets;
	}
	public void setCantSets(Integer cantSets) {
		this.cantSets = cantSets;
	}
	public ModalidadDePuntuacion getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(ModalidadDePuntuacion puntuacion) {
		this.puntuacion = puntuacion;
	}
	public Double getTantosXAusencia() {
		return tantosXAusencia;
	}
	public void setTantosXAusencia(Double tantosXAusencia) {
		this.tantosXAusencia = tantosXAusencia;
	}
	public Boolean getEmpate() {
		return empate;
	}
	public void setEmpate(Boolean empate) {
		this.empate = empate;
	}
	public Double getPuntosXPresentarse() {
		return puntosXPresentarse;
	}
	public void setPuntosXPresentarse(Double puntosXPresentarse) {
		this.puntosXPresentarse = puntosXPresentarse;
	}
	public Double getPuntosXEmpate() {
		return puntosXEmpate;
	}
	public void setPuntosXEmpate(Double puntosXEmpate) {
		this.puntosXEmpate = puntosXEmpate;
	}
	public Double getPuntosXGanado() {
		return puntosXGanado;
	}
	public void setPuntosXGanado(Double puntosXGanado) {
		this.puntosXGanado = puntosXGanado;
	}
	public Integer getId_deporte() {
		return id_deporte;
	}
	public void setId_deporte(Integer id_deporte) {
		this.id_deporte = id_deporte;
	}
	public List<ItemLugarDTO> getLugares() {
		return Lugares;
	}
	public void setLugares(List<ItemLugarDTO> lugares) {
		Lugares = lugares;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	
}
