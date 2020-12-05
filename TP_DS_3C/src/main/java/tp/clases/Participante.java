package tp.clases;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import tp.auditorias.AuditoriaModificacionParticipante;
@Entity
@Table(name="Participante")
public final class Participante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Participante;
	@Column
	private String email;
	@Column
	private String nombre;
	@Transient
	private List<AuditoriaModificacionParticipante> historialCambios;

	// constructor sin params
	public Participante() {
		super();
	}
	
	public Participante( String email, String nombre) {
	
		this.setEmail(email);
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdParticipante() {
		return id_Participante;
	}

	public void setIdParticipante(Integer idParticipante) {
		this.id_Participante = idParticipante;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AuditoriaModificacionParticipante> getHistorialCambios() {
		return historialCambios;
	}

	public void setHistorialCambios(List<AuditoriaModificacionParticipante> historialCambios) {
		this.historialCambios = historialCambios;
	}
	
	public void addCambio(AuditoriaModificacionParticipante cambio) {
		this.historialCambios.add(cambio);
	}
	
}
