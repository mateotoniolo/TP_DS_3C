package tp.clases;

public class Set {
	private Integer tantosA;
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
