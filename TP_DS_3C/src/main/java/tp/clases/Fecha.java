package tp.clases;

import java.io.Serializable;
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

@Entity
@Table(name="Fecha")
public class Fecha implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_fecha", unique = true)
	private Integer id_fecha;
	
	@Column
	private Integer numero;
	@Column
	private Boolean rondaPerdedores;
	@Column
	private Boolean rondaGanadores;
	@ManyToOne
    @JoinColumn(name="id_fixture")
	private Fixture fixture;
	@OneToMany(mappedBy = "fecha")
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
		for(Partido partido: partidos) {
			partido.setFecha(this);
		}
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


	public Fixture getFixture() {
		return fixture;
	}


	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}
}
