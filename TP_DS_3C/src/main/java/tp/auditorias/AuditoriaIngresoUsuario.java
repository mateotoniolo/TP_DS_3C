package tp.auditorias;

import java.sql.Date;
import java.sql.Time;

public class AuditoriaIngresoUsuario {
	private Date fechaInicio;
	private Time horaInicio;
	
	public AuditoriaIngresoUsuario() {
		super();
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
}
