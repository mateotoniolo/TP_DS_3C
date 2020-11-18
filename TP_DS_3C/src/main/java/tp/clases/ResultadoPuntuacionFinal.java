package tp.clases;

public class ResultadoPuntuacionFinal extends Resultado {
	private Boolean ganaA;
	private Boolean ganaB;
	private Boolean empate;
	
	// constructor sin params
	public ResultadoPuntuacionFinal() {
		super();
	}
	
	public ResultadoPuntuacionFinal(Boolean aPresente, Boolean bPresente, Boolean ganaA, Boolean ganaB, Boolean empate) {
		super(aPresente, bPresente);
		
		this.setGanaA(ganaA);
		this.setGanaB(ganaB);
		this.setEmpate(empate);
	}

	public Boolean getGanaA() {
		return ganaA;
	}

	public void setGanaA(Boolean ganaA) {
		this.ganaA = ganaA;
	}

	public Boolean getGanaB() {
		return ganaB;
	}

	public void setGanaB(Boolean ganaB) {
		this.ganaB = ganaB;
	}

	public Boolean getEmpate() {
		return empate;
	}

	public void setEmpate(Boolean empate) {
		this.empate = empate;
	}

}
