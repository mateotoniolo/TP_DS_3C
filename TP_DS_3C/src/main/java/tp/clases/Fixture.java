package tp.clases;

import java.util.List;

public class Fixture {
	private List<Fecha> listaFechas;
	private Integer id_fixture;
	
	// constructor sin params
	public Fixture() {
		
	}

	public List<Fecha> getListaFechas() {
		return listaFechas;
	}

	public void setListaFechas(List<Fecha> listaFechas) {
		this.listaFechas = listaFechas;
	}
	
	public void addFecha(Fecha fecha) {
		this.listaFechas.add(fecha);
	}

	public Integer getId_fixture() {
		return id_fixture;
	}

	public void setId_fixture(Integer id_fixture) {
		this.id_fixture = id_fixture;
	}
}
