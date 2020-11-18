package tp.clases;

public class Provincia {
	private Integer id_Provincia;
	private String nombre;
	private Pais pais;
	
	// constructor sin params
	public Provincia() {
		super();
	}
	
	public Provincia(Integer idProvincia, String nombre, Pais pais){
		this.setIdProvincia(idProvincia);
		this.setNombre(nombre);
		this.setPais(pais);
	}

	// Getters y Setters
	public Integer getIdProvincia() {
		return id_Provincia;
	}

	public void setIdProvincia(Integer idProvincia) {
		this.id_Provincia = idProvincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
}
