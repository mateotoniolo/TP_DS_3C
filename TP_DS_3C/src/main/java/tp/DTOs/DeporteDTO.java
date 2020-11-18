package tp.DTOs;

public class DeporteDTO {
	
	Integer id_deporte;
	String nombre;
	
	public DeporteDTO(Integer id, String nombre) {
		this.id_deporte= id;
		this.nombre = nombre;
	}

	public Integer getId_deporte() {
		return id_deporte;
	}

	public void setId_deporte(Integer id_deporte) {
		this.id_deporte = id_deporte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
