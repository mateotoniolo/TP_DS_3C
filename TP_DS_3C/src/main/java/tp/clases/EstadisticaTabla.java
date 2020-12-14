package tp.clases;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED )
@Table(name="EstadisticaTabla")
public class EstadisticaTabla {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_estadistica;
	@Column
	private Integer posicion;
	@Column
	private String nombre;
	@Column
	private Integer partidosGanados;
	@Column
	private Integer partidosPerdidos;
	@Column
	private Integer partidosEmpatados;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_competencia",referencedColumnName = "id_competencia")
	private CompetenciaLiga competencia;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	List<Participante> participantes = null;
	

	public EstadisticaTabla() {
		super();
	}
	

	public EstadisticaTabla(Integer posicion, String nombre, Integer pG, Integer pP, Integer pE,CompetenciaLiga comp,List<Participante> jugadores) {
		this.setPosicion(posicion);
		this.setNombre(nombre);
		this.setPartidosGanados(pG);
		this.setPartidosPerdidos(pP);
		this.setPartidosEmpatados(pE);
		this.competencia = comp;
		this.participantes = jugadores;
	}
	
	// Getters y Setters
	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(Integer partidosGanados) {
		this.partidosGanados = partidosGanados;
	}

	public Integer getPartidosPerdidos() {
		return partidosPerdidos;
	}

	public void setPartidosPerdidos(Integer partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}

	public Integer getPartidosEmpatados() {
		return partidosEmpatados;
	}

	public void setPartidosEmpatados(Integer partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}
}
