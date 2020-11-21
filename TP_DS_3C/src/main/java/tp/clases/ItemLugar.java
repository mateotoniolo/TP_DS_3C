package tp.clases;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class ItemLugar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_item;
	
	@Column
	private Integer disponibilidad;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="codigo_lugar",referencedColumnName = "codigo")
	private Lugar Lugar; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_competencia",referencedColumnName = "id_competencia")
	private Competencia competencia; 
	
	
	
	// constructor sin params
	public ItemLugar() {
		super();
	}
	
	// constructor
	public ItemLugar( Competencia competencia,Lugar lugar, Integer disponibilidad) {
		this.setCompetencia(competencia);
		this.Lugar = lugar;
		this.disponibilidad = disponibilidad;
	}

	// Getters y Setters
	public String getLugar() {
		return Lugar.getNombre();
	}

	public void setLugar(Lugar lugar) {
		this.Lugar = lugar;
	}
	public Integer getCodigo() {
		return this.Lugar.getId();
	}

	public Competencia getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	public Integer getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Integer disponibilidad2) {
		this.disponibilidad = disponibilidad2;
	}
}
