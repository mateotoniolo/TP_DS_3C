package tp.clases;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_usuario",referencedColumnName = "id_usuario")
	private Usuario usuario;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Deporte> deportes;
	
	public Lugar() {
		super();
	}
	
	public Lugar(Integer codigo, String nombre, String descripcion, Usuario user,List<Deporte> d) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuario = user;
		this.deportes = d;
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
