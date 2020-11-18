package tp.auditorias;

import java.util.List;

public class AuditoriaResultadoSets extends AuditoriaModificacionResultado {
	private Integer setsA;
	private Integer setsB;
	private List<AuditoriaSet> listaSets;
	
	public AuditoriaResultadoSets() {
		super();
	}
	
	public AuditoriaResultadoSets(Integer setsA, Integer setsB) {
		super();
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

	public List<AuditoriaSet> getListaSets() {
		return listaSets;
	}

	public void setListaSets(List<AuditoriaSet> listaSets) {
		this.listaSets = listaSets;
	}
	
	public void addSet(AuditoriaSet set) {
		this.listaSets.add(set);
	}
}
