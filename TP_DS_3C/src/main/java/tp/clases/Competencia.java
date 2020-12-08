package tp.clases;

import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;
import tp.enums.ModalidadDePuntuacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_fixture",referencedColumnName = "id_fixture")
	private Fixture fixture;
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
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_usuario",referencedColumnName = "id_usuario")
	private Usuario usuario;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_deporte",referencedColumnName = "id_deporte")
	private Deporte deporte;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemLugar> Lugares;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Participante> Participantes;
	@Transient
	private List<AuditoriaDeBajaDeCompetencia> historialBaja;

	
	
	// constructor sin params
	public Competencia() {
		super();
	}
		
	// constructor
	public Competencia( String nombre, Modalidad modalidad, List<Participante> listaParticipantes, 
			Fixture fixture, Integer cantSets, String reglamento, EstadoCompetencia estado, ModalidadDePuntuacion modalidadDePuntuacion, 
			Double tantosXAusencia, Usuario usuario, Deporte deporte) {
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
		this.usuario = usuario;
		this.deporte = deporte;
		this.Lugares = new ArrayList<>();
		this.Participantes = new ArrayList<>();
	}
	
	// Getters y Setters	

	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}
	
	public Fixture getFixture(){
		return fixture;
	}	
	

	public void setIdCompetencia(Integer id) {
		this.id_competencia = id;
	}


	public EstadoCompetencia getEstado() {
		return EstadoCompetencia.valueOf(estado);
	}

	public void setEstado(String creada) {
		this.estado = creada;
	}
	

	public ModalidadDePuntuacion getModalidadDePuntuacion() {
		return puntuacion;
	}

	
	public void setModalidadDePuntuacion(ModalidadDePuntuacion puntuacion) {
		this.puntuacion = puntuacion;
	}



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
	
	public Double getTantosXAusencia() {
		return tantosXAusencia;
	}

	
	public void setTantosXAusencia(Double tantosXAusencia2) {
		this.tantosXAusencia = tantosXAusencia2;
	}

	public Integer getCantSets() {
		return cant_sets;
	}

	public void setCantSets(Integer cantSets2) {
		this.cant_sets = cantSets2;
	}

	public List<ItemLugar> getLugares() {
		return Lugares;
	}
	
	public void addLugar(ItemLugar item) {
		this.Lugares.add(item);
	}

	public void setLugares(List<ItemLugar> lugares) {
		Lugares = lugares;
	}
	
	public void addItem(ItemLugar lugar) {
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


	public void setId_Competencia(Integer id_Competencia) {
		this.id_competencia = id_Competencia;
	}


	public ModalidadDePuntuacion getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(ModalidadDePuntuacion puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Integer getId_competencia() {
		return id_competencia;
	}

	public void setId_competencia(Integer id_competencia) {
		this.id_competencia = id_competencia;
	}

	public Integer getCant_sets() {
		return cant_sets;
	}

	public void setCant_sets(Integer cant_sets) {
		this.cant_sets = cant_sets;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Participante> getParticipantes() {
		return Participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		Participantes = participantes;
	}
	public void addParticipante(Participante p) {
		this.Participantes.add(p);
	}
}
