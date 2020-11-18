package tp.clases;

import java.util.List;

public class Fecha {
	private Integer numero;
	private Boolean rondaPerdedores;
	private Boolean rondaGanadores;
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
