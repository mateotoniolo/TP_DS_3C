package tp.clases;

public class EstadisticaTabla {
	private Integer posicion;
	private String nombre;
	private Integer partidosGanados;
	private Integer partidosPerdidos;
	private Integer partidosEmpatados;
	
	// constructor sin params
	public EstadisticaTabla() {
		super();
	}
	
	// constructor
	public EstadisticaTabla(Integer posicion, String nombre, Integer pG, Integer pP, Integer pE) {
		this.setPosicion(posicion);
		this.setNombre(nombre);
		this.setPartidosGanados(pG);
		this.setPartidosPerdidos(pP);
		this.setPartidosEmpatados(pE);
	}
	
	// Getters y Setters
	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(Integer partidosGanados) {
		this.partidosGanados = partidosGanados;
	}

	public Integer getPartidosPerdidos() {
		return partidosPerdidos;
	}

	public void setPartidosPerdidos(Integer partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}

	public Integer getPartidosEmpatados() {
		return partidosEmpatados;
	}

	public void setPartidosEmpatados(Integer partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}
}
