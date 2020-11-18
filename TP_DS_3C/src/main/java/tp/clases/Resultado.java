package tp.clases;

import tp.auditorias.AuditoriaModificacionResultado;
import java.util.List;

public class Resultado {
	private Boolean aPresente;
	private Boolean bPresente;
	private List<AuditoriaModificacionResultado> historialCambios;
	
	
	// constructor sin params
	public Resultado() {
		super();
	}
	
	public Resultado(Boolean aPresente, Boolean bPresente) {
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

	public List<AuditoriaModificacionResultado> getHistorialCambios() {
		return historialCambios;
	}

	public void setHistorialCambios(List<AuditoriaModificacionResultado> historialCambios) {
		this.historialCambios = historialCambios;
	}

	public void addCambio(AuditoriaModificacionResultado cambio) {
		this.historialCambios.add(cambio);
	}
}
