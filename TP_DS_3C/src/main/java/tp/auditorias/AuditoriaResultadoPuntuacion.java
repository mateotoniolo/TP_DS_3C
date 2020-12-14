package tp.auditorias;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id_auditoria")
@Table(name="Auditoria_Resultado_Puntuacion")
public class AuditoriaResultadoPuntuacion extends AuditoriaModificacionResultado {
	@Column
	private Integer tantosA;
	@Column
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
