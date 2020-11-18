package tp.auditorias;

public class AuditoriaResultadoPuntuacion extends AuditoriaModificacionResultado {
	private Integer tantosA;
	private Integer tantosB;
	
	public AuditoriaResultadoPuntuacion() {
		super();
	}
	
	public AuditoriaResultadoPuntuacion(Integer tantosA, Integer tantosB) {
		super();
		this.setTantosA(tantosA);
		this.setTantosB(tantosB);
	}

	public Integer getTantosA() {
		return tantosA;
	}

	public void setTantosA(Integer tantosA) {
		this.tantosA = tantosA;
	}

	public Integer getTantosB() {
		return tantosB;
	}

	public void setTantosB(Integer tantosB) {
		this.tantosB = tantosB;
	}
}
