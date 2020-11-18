package tp.clases;

import java.util.List;

import tp.auditorias.AuditoriaModificacionParticipante;

public final class Participante {

	private Integer id_Participante;
	private String email;
	private String nombre;
	private List<AuditoriaModificacionParticipante> historialCambios;

	// constructor sin params
	public Participante() {
		super();
	}
	
	public Participante(Integer idParticipante, String email, String nombre) {
		this.setIdParticipante(idParticipante);
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
