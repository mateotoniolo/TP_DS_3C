package tp.auditorias;

public class AuditoriaResultadoPuntuacionFinal extends AuditoriaModificacionResultado {
	private Boolean ganaA;
	private Boolean ganaB;
	private Boolean empate;
	
	public AuditoriaResultadoPuntuacionFinal() {
		super();
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
