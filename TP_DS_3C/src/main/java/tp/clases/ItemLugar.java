package tp.clases;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class ItemLugar implements Serializable{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer idItem = null;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="competencia")
	private Competencia competencia;
	@Column
	private Integer disponibilidad;
	
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="codigo_lugar",referencedColumnName = "codigo",unique = false)
	private Lugar Lugar; 
	
	
	

	public ItemLugar() {
		
	}
	
	public ItemLugar( Competencia competencia,Lugar lugar, Integer disponibilidad) {
		this.setCompetencia(competencia);
		this.Lugar = lugar;
		this.disponibilidad = disponibilidad;
	}

	// Getters y Setters
	public tp.clases.Lugar getLugar() {
		return Lugar;
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

//	public Integer getId_item() {
//		return idItem;
//	}
//
//	public void setId_item(Integer id_item) {
//		this.idItem = id_item;
//	}


}
