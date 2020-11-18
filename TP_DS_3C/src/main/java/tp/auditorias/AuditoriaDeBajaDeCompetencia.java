package tp.auditorias;

import java.sql.Date;
import java.sql.Time;

public class AuditoriaDeBajaDeCompetencia {
	private Date fecha;
	private Time hora;
	
	public AuditoriaDeBajaDeCompetencia() {
		super();
	}

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
