package tp.auditorias;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id_auditoria")
@Table(name="Auditoria_Resultado_Sets")
public class AuditoriaResultadoSets extends AuditoriaModificacionResultado {
	@Column
	private Integer setsA;
	@Column
	private Integer setsB;
	@OneToMany
	@JoinColumn(name="Auditoria_Sets")
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
