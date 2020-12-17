package tp.DTOs;

import java.util.ArrayList;
import java.util.List;

import tp.Gestores.GestorCompetencia;
import tp.clases.Deporte;
import tp.clases.ItemLugar;
import tp.enums.EstadoCompetencia;
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
	List<ItemLugarDTO> Lugares = new ArrayList<>();
	Integer id_usuario;
	EstadoCompetencia estado;
	Integer id_fixture;
	List<ParticipanteDTO> participantes = new ArrayList<>();
	
	public CompetenciaDTO( String name, Modalidad modalidad, String reglamento, Integer cantSets, ModalidadDePuntuacion Puntuacion
			,Double tantosXAusencia,Boolean empate,Double puntosXPresentarse, Double puntosXEmpate, Double puntosXGanado,
			Integer id_deporte, List<ItemLugarDTO> Lugares,
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
		this.estado = null;
	}
	
	public CompetenciaDTO( Integer id,String name, Modalidad modalidad, String reglamento, Integer cantSets, ModalidadDePuntuacion Puntuacion
			,Double tantosXAusencia,Boolean empate,Double puntosXPresentarse, Double puntosXEmpate, Double puntosXGanado,
			Integer id_deporte, List<ItemLugarDTO> Lugares,
			Integer id_usuario) {
		this.id_competencia = id;
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
		this.estado = null;
	}
	public CompetenciaDTO() {
		this.nombre = null;
		this.modalidad = null;
		this.id_deporte = null;
		this.estado = null;
	}
	
	
	public CompetenciaDTO(Integer id_competencia) {
		this.id_competencia = id_competencia;
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

	public EstadoCompetencia getEstado() {
		return estado;
	}

	public void setEstado(EstadoCompetencia estado) {
		this.estado = estado;
	}

	public Deporte getDeporte() {
		
		return GestorCompetencia.getDeporteByID(this.id_deporte);
	}

	public List<ParticipanteDTO> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<ParticipanteDTO> participantes) {
		this.participantes = participantes;
	}
	public void addParticipante(ParticipanteDTO dto) {
		this.participantes.add(dto);
	}
	public void addLugar(ItemLugarDTO dto) {
		this.Lugares.add(dto);
	}

	public Integer getId_fixture() {
		return id_fixture;
	}

	public void setId_fixture(Integer id_fixture) {
		this.id_fixture = id_fixture;
	}
	
}
