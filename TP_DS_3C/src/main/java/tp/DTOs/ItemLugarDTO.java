package tp.DTOs;

public class ItemLugarDTO {

	Integer codigo;
	String nombre;
	Integer disponibilidad;
	
	public ItemLugarDTO(Integer c, String n) {
		this.codigo =c;
		this.nombre =n;
	}
	public ItemLugarDTO(Integer c, String n,Integer d) {
		this.codigo =c;
		this.nombre =n;
		this.disponibilidad =d;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Integer disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
}
