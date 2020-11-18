package tp.clases;

import tp.enums.TipoDni;

import java.util.List;

import tp.auditorias.AuditoriaIngresoUsuario;

public class Usuario {

	private String id_Usuario;
	private String correoElectronico;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private TipoDni tipoDni;
	private Double documento;
	private Localidad localidad;
	private List<AuditoriaIngresoUsuario> historialIngresos;

	// constructor sin params
	public Usuario() {
		super();
	}
	
	public Usuario(String idUsuario, String correoElectronico, String contrasenia, String nombre, String apellido, TipoDni tipoDni, Double documento, Localidad localidad){
		this.setIdUsuario(idUsuario);
		this.setCcorreoElectronico(correoElectronico);
		this.setContrasenia(contrasenia);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setTipoDocumento(tipoDni);
		this.setNroDocumento(documento);
		this.setLocalidad(localidad);
	}

	// Getters y Setters
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCcorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Double getNroDocumento() {
		return documento;
	}

	public void setNroDocumento(Double documento) {
		this.documento = documento;
	}

	public TipoDni getTipoDocumento() {
		return tipoDni;
	}

	public void setTipoDocumento(TipoDni tipoDni) {
		this.tipoDni = tipoDni;
	}

	public String getIdUsuario() {
		return id_Usuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.id_Usuario = idUsuario;
	}

	public List<AuditoriaIngresoUsuario> getHistorialIngresos() {
		return historialIngresos;
	}

	public void setHistorialIngresos(List<AuditoriaIngresoUsuario> historialIngresos) {
		this.historialIngresos = historialIngresos;
	}
	
	public void addIngreso(AuditoriaIngresoUsuario ingreso) {
		this.historialIngresos.add(ingreso);
	}
}
