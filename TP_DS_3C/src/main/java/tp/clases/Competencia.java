package tp.clases;

import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;
import tp.enums.ModalidadDePuntuacion;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import tp.DTOs.ItemLugarDTO;
import tp.auditorias.AuditoriaDeBajaDeCompetencia;

@Entity
@Inheritance(strategy = InheritanceType.JOINED )
@Table(name="Competencia")
public class Competencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_competencia;
	@Column
	private String nombre;
	@Column
	private String modalidad;
	@Column
	private Integer id_fixture;
	@Column
	private String reglamento;
	@Column
	private String estado;
	@Column
	private Integer cant_sets;
	@Column
	private ModalidadDePuntuacion puntuacion;
	@Column
	private Double tantosXAusencia;
	@Column
	private Integer id_usuario;
	@Column
	private Integer id_deporte;	
	@Transient
	private List<ItemLugarDTO> Lugares;
	@Transient
	private List<AuditoriaDeBajaDeCompetencia> historialBaja;
	@Column
	private Boolean empate;
	
	
	// constructor sin params
	public Competencia() {
		super();
	}
		
	// constructor
	public Competencia( String nombre, Modalidad modalidad, List<Participante> listaParticipantes, Integer fixture, Integer cantSets, String reglamento, EstadoCompetencia estado, ModalidadDePuntuacion modalidadDePuntuacion, Double tantosXAusencia, Integer idAdministrador, Integer id_deporte,List<ItemLugarDTO> list,Boolean empate) {
		//this.setIdCompetencia(id);
		this.setNombre(nombre);
		this.setModalidad(modalidad.toString());
//		this.setParticipantes(listaParticipantes);
		this.setFixture(fixture);
		this.setReglamento(reglamento);
		this.setEstado(estado.toString());
		this.setCantSets(cantSets);
		this.setModalidadDePuntuacion(modalidadDePuntuacion);
		this.setTantosXAusencia(tantosXAusencia);		
		this.setIdAdministrador(idAdministrador);
		this.setIdDeporte(id_deporte);
		this.Lugares = list;
		this.empate = empate;
		this.Lugares = list;
	}
	
	// Getters y Setters	
	public Integer getIdDeporte(){
		return id_deporte;
	}
	
	public void setIdDeporte(Integer id_deporte){
		this.id_deporte = id_deporte;
	}

	public void setFixture(Integer fixture) {
		this.id_fixture = fixture;
	}
	
	public Integer getFixtureID(){
		return id_fixture;
	}	
	
	public Integer getIdCompetencia() {
		return id_competencia;
	}
	

	public void setIdCompetencia(Integer id) {
		this.id_competencia = id;
	}


	public String getEstado() {
		return estado;
	}
	

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

	public ModalidadDePuntuacion getModalidadDePuntuacion() {
		return puntuacion;
	}

	
	public void setModalidadDePuntuacion(ModalidadDePuntuacion puntuacion) {
		this.puntuacion = puntuacion;
	}


//	public List<Participante> getParticipantes() {
//		return listaParticipantes;
//	}
//
//
//	public void setParticipantes(List<Participante> listaParticipantes) {
//		this.listaParticipantes = listaParticipantes;
//	}


	public String getModalidad() {
		return modalidad;
	}


	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getReglamento() {
		return reglamento;
	}


	public void setReglamento(String reglamento) {
		this.reglamento = reglamento;
	}


	public Integer getIdAdministrador() {
		return id_usuario;
	}
	
	
	public Double getTantosXAusencia() {
		return tantosXAusencia;
	}

	
	public void setTantosXAusencia(Double tantosXAusencia2) {
		this.tantosXAusencia = tantosXAusencia2;
	}

	public void setIdAdministrador(Integer id) {
		this.id_usuario = id;
	}

	public Integer getCantSets() {
		return cant_sets;
	}

	public void setCantSets(Integer cantSets2) {
		this.cant_sets = cantSets2;
	}

	public List<ItemLugarDTO> getLugares() {
		return Lugares;
	}

	public void setLugares(List<ItemLugarDTO> lugares) {
		Lugares = lugares;
	}
	
	public void addItem(ItemLugarDTO lugar) {
		this.Lugares.add(lugar);
	}

	public List<AuditoriaDeBajaDeCompetencia> getHistorialBaja() {
		return historialBaja;
	}

	public void setHistorialBaja(List<AuditoriaDeBajaDeCompetencia> historialBaja) {
		this.historialBaja = historialBaja;
	}
	
	public void addBajaDeCompetencia(AuditoriaDeBajaDeCompetencia baja) {
		this.historialBaja.add(baja);
	}

	public Integer getId_Competencia() {
		return id_competencia;
	}

	public void setId_Competencia(Integer id_Competencia) {
		this.id_competencia = id_Competencia;
	}

//	public List<Participante> getListaParticipantes() {
//		return listaParticipantes;
//	}
//
//	public void setListaParticipantes(List<Participante> listaParticipantes) {
//		this.listaParticipantes = listaParticipantes;
//	}

	public ModalidadDePuntuacion getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(ModalidadDePuntuacion puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Integer getId_administrador() {
		return id_usuario;
	}

	public void setId_administrador(Integer id_administrador) {
		this.id_usuario = id_administrador;
	}

	public Integer getId_deporte() {
		return id_deporte;
	}

	public void setId_deporte(Integer id_deporte) {
		this.id_deporte = id_deporte;
	}

	public Boolean getEmpate() {
		return empate;
	}

	public void setEmpate(Boolean empate) {
		this.empate = empate;
	}

	public Integer getFixture() {
		return id_fixture;
	}
}
