package tp.auditorias;

import java.sql.Date;
import java.sql.Time;

public class AuditoriaModificacionParticipante {
	private Integer id_Anterior;
	private String nombre_Anterior;
	private String correo_Anterior;
	private Date fechaModificacion;
	private Time horaModificacion;
	
	public AuditoriaModificacionParticipante() {
		super();
	}

	public Integer getId_Anterior() {
		return id_Anterior;
	}

	public void setId_Anterior(Integer id_Anterior) {
		this.id_Anterior = id_Anterior;
	}

	public String getNombre_Anterior() {
		return nombre_Anterior;
	}

	public void setNombre_Anterior(String nombre_Anterior) {
		this.nombre_Anterior = nombre_Anterior;
	}

	public String getCorreo_Anterior() {
		return correo_Anterior;
	}

	public void setCorreo_Anterior(String correo_Anterior) {
		this.correo_Anterior = correo_Anterior;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Time getHoraModificacion() {
		return horaModificacion;
	}

	public void setHoraModificacion(Time horaModificacion) {
		this.horaModificacion = horaModificacion;
	}
	
	
}
