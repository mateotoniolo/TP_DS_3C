package tp.clases;

import tp.enums.TipoDni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import tp.auditorias.AuditoriaIngresoUsuario;
@Entity
@Table(name="Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_usuario;
	@Column
	private String correoElectronico;
	@Column
	private String contrasenia;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private TipoDni tipoDni;
	@Column
	private Double dni;
	@OneToMany
	@JoinColumn(name="id_usuario")
	private List<Competencia> competencias;
	@OneToMany
	@JoinColumn(name="id_usuario")
	private List<Lugar> lugares;
	@OneToOne
	@JoinColumn(name="id_localidad",referencedColumnName = "id_localidad")
	private Localidad Localidad;
	
	@Transient
	private List<AuditoriaIngresoUsuario> historialIngresos;

	
	public Usuario() {
		super();
	}
	
	public Usuario(Integer idUsuario, String correoElectronico, String contrasenia, String nombre, String apellido, TipoDni tipoDni, Double documento, Localidad localidad){
		this.setIdUsuario(idUsuario);
		this.setCcorreoElectronico(correoElectronico);
		this.setContrasenia(contrasenia);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setTipoDocumento(tipoDni);
		this.setNroDocumento(documento);
		this.setLocalidad(localidad);
		this.competencias = new ArrayList<>();
	}

	private void setLocalidad(Localidad localidad) {
		
		
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


	public Double getNroDocumento() {
		return dni;
	}

	public void setNroDocumento(Double documento) {
		this.dni = documento;
	}

	public TipoDni getTipoDocumento() {
		return tipoDni;
	}

	public void setTipoDocumento(TipoDni tipoDni) {
		this.tipoDni = tipoDni;
	}

	public Integer getIdUsuario() {
		return id_usuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.id_usuario = idUsuario;
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

	public List<Competencia> getCompetencias() {
		return competencias;
	}

	public void addCompetencia(Competencia competencias) {
		this.competencias.add(competencias);
	}
}
