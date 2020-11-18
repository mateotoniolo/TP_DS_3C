package tp.auditorias;

import java.sql.Date;
import java.sql.Time;

public class AuditoriaModificacionResultado {

	private Boolean aPresente;
	private Boolean bPresente;
	private Date fecha;
	private Time hora;
	
	public AuditoriaModificacionResultado() {
		super();
	}
	
	public AuditoriaModificacionResultado(Boolean aPresente, Boolean bPresente) {
		super();
		this.setaPresente(aPresente);
		this.setbPresente(bPresente);
	}

	public Boolean getaPresente() {
		return aPresente;
	}

	public void setaPresente(Boolean aPresente) {
		this.aPresente = aPresente;
	}

	public Boolean getbPresente() {
		return bPresente;
	}

	public void setbPresente(Boolean bPresente) {
		this.bPresente = bPresente;
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
