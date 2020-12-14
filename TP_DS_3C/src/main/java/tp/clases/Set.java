package tp.clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="SetJuego")
public class Set {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private Integer tantosA;
	@Column
	private Integer tantosB;
	

	public Set() {
		super();
	}
	
	public Set(Integer tantosA, Integer tantosB) {
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
