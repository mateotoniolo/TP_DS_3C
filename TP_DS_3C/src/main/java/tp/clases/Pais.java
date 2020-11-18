package tp.clases;

public class Pais {
	private Integer id_Pais;
	private String nombre;
	
	// constructor sin params
	public Pais() {
		super();
	}
	
	public Pais(Integer idPais, String nombre){
		this.setIdPais(idPais);
		this.setNombre(nombre);
	}

	// Getters y Setters
	public Integer getIdPais() {
		return id_Pais;
	}

	public void setIdPais(Integer idPais) {
		this.id_Pais = idPais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
