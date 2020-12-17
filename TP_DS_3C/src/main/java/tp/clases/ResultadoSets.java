package tp.clases;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id_resultado")
@Table(name="Resultado_Sets")
public class ResultadoSets extends Resultado {
	@Column
	private Integer setsA;
	@Column
	private Integer setsB;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ResultadoSets")
	private List<Set> listaSets;
	

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
