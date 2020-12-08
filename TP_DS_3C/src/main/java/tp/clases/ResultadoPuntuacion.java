package tp.clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id_resultado")
@Table(name="Resultado_Puntuacion")
public class ResultadoPuntuacion extends Resultado {
	@Column
	private Integer tantosA;
	@Column
	private Integer tantosB;
	
	// constructor sin params
	public ResultadoPuntuacion() {
		super();
	}
	
	public ResultadoPuntuacion(Boolean aPresente, Boolean bPresente, Integer tantosA, Integer tantosB) {
		super(aPresente, bPresente);
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
