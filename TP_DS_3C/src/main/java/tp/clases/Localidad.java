package tp.clases;

public class Localidad {

	private Integer id_Localidad;
	private String nombre;
	private Provincia provincia;
	
	// constructor sin params
	public Localidad() {
		super();
	}
	
	public Localidad(Integer idLocalidad, String nombre, Provincia provincia){
		this.setIdLocalidad(idLocalidad);
		this.setNombre(nombre);
		this.setProvincia(provincia);
	}
	
	// Getters y Setters
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdLocalidad() {
		return id_Localidad;
	}

	public void setIdLocalidad(Integer idLocalidad) {
		this.id_Localidad = idLocalidad;
	}
}
