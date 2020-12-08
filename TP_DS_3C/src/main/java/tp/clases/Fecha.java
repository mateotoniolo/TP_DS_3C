package tp.clases;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Fecha")
public class Fecha {
	@Id
	private Integer id_fecha;
	@Column
	private Integer numero;
	@Column
	private Boolean rondaPerdedores;
	@Column
	private Boolean rondaGanadores;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Partido> listaPartidos;
	
	// constructor sin params
	public Fecha() {
		super();
	}
	
	// constructor
	public Fecha(Integer numero, Boolean rPerdedores, Boolean rGanadores) {
		this.setNumero(numero);
		this.setRondaPerdedores(rPerdedores);
		this.setRondaGanadores(rGanadores);
		
		// this.addPartido(Partido obj)
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
