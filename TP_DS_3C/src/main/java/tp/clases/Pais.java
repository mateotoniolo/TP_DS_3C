package tp.clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pais")
public class Pais {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_pais;
	
	@Column
	private String nombre;
	

	public Pais() {
		super();
	}
	
	public Pais(Integer idPais, String nombre){
		this.setIdPais(idPais);
		this.setNombre(nombre);
	}

	// Getters y Setters
	public Integer getIdPais() {
		return id_pais;
	}

	public void setIdPais(Integer idPais) {
		this.id_pais = idPais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
