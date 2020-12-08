package tp.clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id_resultado")
@Table(name="Resultado_Puntuacion_Final")
public class ResultadoPuntuacionFinal extends Resultado {
	@Column
	private Boolean ganaA;
	@Column
	private Boolean ganaB;
	@Column
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
