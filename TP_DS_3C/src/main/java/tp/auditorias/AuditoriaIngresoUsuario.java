package tp.auditorias;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import tp.auditorias.AuditoriaDeBajaDeCompetencia.AuditoriaId;
@Entity
@Table(name="Auditoria_Ingreso_Usuario")
public class AuditoriaIngresoUsuario {
	@Embeddable
	class AuditoriaId implements Serializable{
		@Column
		private Date fecha;
		@Column
		private Time hora;
		
		public Date getFecha() {
			return fecha;
		}
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		public Time getHora() {
			return hora;
		}
		public void setHora(Time hora) {
			this.hora = hora;
		}
	}
	@EmbeddedId
	private AuditoriaId id_auditoria;
	
	public AuditoriaIngresoUsuario() {
		super();
	}

	public Date getFecha() {
		return this.id_auditoria.getFecha();
	}

	public void setFecha(Date fecha) {
		this.id_auditoria.setFecha(fecha);
	}

	public Time getHora() {
		return this.id_auditoria.getHora();
	}

	public void setHora(Time hora) {
		this.id_auditoria.setHora(hora); 
	}
}
