package tp.clases;

import java.util.List;

public class ResultadoSets extends Resultado {
	private Integer setsA;
	private Integer setsB;
	private List<Set> listaSets;
	
	// constructor sin params
	public ResultadoSets() {
		super();
	}
	
	public ResultadoSets(Boolean aPresente, Boolean bPresente, Integer setsA, Integer setsB) {
		super(aPresente, bPresente);
		this.setSetsA(setsA);
		this.setSetsB(setsB);
	}

	public Integer getSetsA() {
		return setsA;
	}

	public void setSetsA(Integer setsA) {
		this.setsA = setsA;
	}

	public Integer getSetsB() {
		return setsB;
	}

	public void setSetsB(Integer setsB) {
		this.setsB = setsB;
	}

	public void addSet(Set set) {
		this.listaSets.add(set);
	}
}
