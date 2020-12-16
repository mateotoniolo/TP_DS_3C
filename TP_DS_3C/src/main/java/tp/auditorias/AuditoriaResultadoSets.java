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

}
