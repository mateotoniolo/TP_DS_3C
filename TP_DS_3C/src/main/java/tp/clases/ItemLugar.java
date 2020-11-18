package tp.clases;

public class ItemLugar {
	private Lugar Lugar; // id_lugar o Objeto Lugar?
	private Integer competencia; // id_competencia o Objeto Competencia?
	private Integer cantidadEncuentros;
	private Boolean disponibilidad;
	
	// constructor sin params
	public ItemLugar() {
		super();
	}
	
	// constructor
	public ItemLugar(Lugar lugar, Integer competencia, Integer cantidadEncuentros, Boolean disponibilidad) {
		this.setLugar(lugar);
		this.setCompetencia(competencia);
		this.setCantidadEncuentros(cantidadEncuentros);
		this.setDisponibilidad(disponibilidad);
	}

	// Getters y Setters
	public String getLugar() {
		return Lugar.getNombre();
	}

	public void setLugar(Lugar lugar) {
		this.Lugar = lugar;
	}
	public Integer getCodigo() {
		return this.Lugar.getId();
	}

	public Integer getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Integer competencia) {
		this.competencia = competencia;
	}

	public Integer getCantidadEncuentros() {
		return cantidadEncuentros;
	}

	public void setCantidadEncuentros(Integer cantidadEncuentros) {
		this.cantidadEncuentros = cantidadEncuentros;
	}

	public Boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
}
