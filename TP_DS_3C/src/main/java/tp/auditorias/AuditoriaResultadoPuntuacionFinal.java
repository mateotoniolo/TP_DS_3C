package tp.auditorias;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id_auditoria")
@Table(name="Auditoria_Resultado_Puntuacion_Final")
public class AuditoriaResultadoPuntuacionFinal extends AuditoriaModificacionResultado {
	@Column
	private Boolean ganaA;
	@Column
	private Boolean ganaB;
	@Column
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
