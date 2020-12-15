package tp.clases;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import PKs.FechaPK;
import PKs.LocalidadPK;
@Entity
@Table(name="Fecha")
@IdClass(FechaPK.class)
public class Fecha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_fecha;
	@Id
	@ManyToOne
	@JoinColumn(name="id_fixture",referencedColumnName = "id_fixture")
	private Fixture id_fixture;
	@Column
	private Integer numero;
	@Column
	private Boolean rondaPerdedores;
	@Column
	private Boolean rondaGanadores;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Partido> listaPartidos;
	

	public Fecha() {
		super();
		this.numero = null;
		this.rondaGanadores = false;
		this.rondaPerdedores = false;
		this.listaPartidos = new ArrayList<>();
	}
	

	public Fecha(Integer numero, Boolean rPerdedores, Boolean rGanadores) {
		this.setNumero(numero);
		this.setRondaPerdedores(rPerdedores);
		this.setRondaGanadores(rGanadores);
		this.listaPartidos = new ArrayList<>();
	}


	public Fecha(int contFechas, List<Partido> partidos) {
		this.numero = contFechas;
		this.listaPartidos = partidos;
	}

	// Getters y Setters
	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public Boolean getRondaPerdedores() {
		return rondaPerdedores;
	}


	public void setRondaPerdedores(Boolean rondaPerdedores) {
		this.rondaPerdedores = rondaPerdedores;
	}


	public Boolean getRondaGanadores() {
		return rondaGanadores;
	}


	public void setRondaGanadores(Boolean rondaGanadores) {
		this.rondaGanadores = rondaGanadores;
	}


	public List<Partido> getListaPartidos() {
		return listaPartidos;
	}


	public void setListaPartidos(List<Partido> listaPartidos) {
		this.listaPartidos = listaPartidos;
	}
	
	public void addPartido(Partido partido) {
		this.listaPartidos.add(partido);
	}
}
