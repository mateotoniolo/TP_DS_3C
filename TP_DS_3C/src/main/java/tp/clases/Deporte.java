package tp.clases;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Deporte")
public class Deporte {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_deporte;
	@Column
	private String nombre;
	
	// constructor sin params
	public Deporte() {
		super();
	}

	public Deporte(Integer id_deporte, String nombre) {
		this.setIdDeporte(id_deporte);
		this.setNombre(nombre);
	}

	// Getters y Setters
	public Integer getIdDeporte() {
		return id_deporte;
	}

	public void setIdDeporte(Integer id_deporte) {
		this.id_deporte = id_deporte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}