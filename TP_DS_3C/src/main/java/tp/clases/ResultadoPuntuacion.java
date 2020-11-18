package tp.clases;

public class ResultadoPuntuacion extends Resultado {

	private Integer tantosA;
	private Integer tantosB;
	
	// constructor sin params
	public ResultadoPuntuacion() {
		super();
	}
	
	public ResultadoPuntuacion(Boolean aPresente, Boolean bPresente, Integer tantosA, Integer tantosB) {
		super(aPresente, bPresente);
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
