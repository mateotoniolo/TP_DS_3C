package tp.clases;

public class EstadisticasEquipoPuntuacion extends EstadisticaTabla {
	private Integer tantosAFavor;
	private Integer tantosEnContra;
	private Integer diferencia;
	
	// constructor sin params
	public EstadisticasEquipoPuntuacion() {
		super();
	}
	
	public EstadisticasEquipoPuntuacion(Integer posicion, String nombre, Integer pG, Integer pP, Integer pE, Integer tFavor, Integer tEnContra, Integer dif) {
		super(posicion, nombre, pG, pP, pE);
		
		this.setTantosAFavor(tFavor);
		this.setTantosEnContra(tEnContra);
		this.setDiferencia(dif);
	}


	public Integer getTantosAFavor() {
		return tantosAFavor;
	}


	public void setTantosAFavor(Integer tantosAFavor) {
		this.tantosAFavor = tantosAFavor;
	}


	public Integer getTantosEnContra() {
		return tantosEnContra;
	}


	public void setTantosEnContra(Integer tantosEnContra) {
		this.tantosEnContra = tantosEnContra;
	}


	public Integer getDiferencia() {
		return diferencia;
	}


	public void setDiferencia(Integer diferencia) {
		this.diferencia = diferencia;
	}

}
