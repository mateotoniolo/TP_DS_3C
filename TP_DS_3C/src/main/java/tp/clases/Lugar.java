package tp.clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Lugar")
public class Lugar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private Integer id_usuario;
	
	// constructor sin params
	public Lugar() {
		super();
	}
	
	public Lugar(Integer codigo, String nombre, String descripcion, Integer id_user) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.id_usuario = id_user;
	}

	// Getters y Setters
	public Integer getId() {
		return codigo;
	}

	public void setId(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
