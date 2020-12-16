package tp.auditorias;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Auditoria_Set")
public class AuditoriaSet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_auditoriaSet;
	@Column
	private Integer tantosA;
	@Column
	private Integer tantosB;
	@ManyToOne
	@JoinColumn(name="Auditoria_Resultado")
	private AuditoriaResultadoSets auditoria;
	
	public AuditoriaSet() {
		super();
	}
	
	public AuditoriaSet(Integer tantosA, Integer tantosB) {
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
