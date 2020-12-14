package tp.auditorias;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="Auditoria_Modificacion_Participante")
public class AuditoriaModificacionParticipante {
	@Embeddable
	class AuditoriaId implements Serializable{
		@Column
		private Date fechaModificacion;
		@Column
		private Time horaModificacion;
		
		public Date getFecha() {
			return fechaModificacion;
		}
		public void setFecha(Date fecha) {
			this.fechaModificacion = fecha;
		}
		public Time getHora() {
			return horaModificacion;
		}
		public void setHora(Time hora) {
			this.horaModificacion = hora;
		}
	}
	
	@EmbeddedId
	private AuditoriaId id_auditoria;
	@Column
	private Integer id_Anterior;
	@Column
	private String nombre_Anterior;
	@Column
	private String correo_Anterior;
	
	
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
		return getFechaModificacion();
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.id_auditoria.setFecha(fechaModificacion); 
	}

	public Time getHoraModificacion() {
		return getHoraModificacion();
	}

	public void setHoraModificacion(Time horaModificacion) {
		this.id_auditoria.setHora(horaModificacion);
	}
	
	
}
