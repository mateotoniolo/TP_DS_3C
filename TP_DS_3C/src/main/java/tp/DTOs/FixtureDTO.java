package tp.DTOs;

import java.util.List;

import tp.clases.Fecha;
import tp.clases.ItemLugar;
import tp.enums.Modalidad;
import tp.enums.ModalidadDePuntuacion;

public class FixtureDTO {
	
	private Integer id_fixture;
	private List<Fecha> listaFechas;
	

	public FixtureDTO(Integer id_fixture, List<Fecha> fechas) {
		this.id_fixture = id_fixture;
		this.listaFechas = fechas;
	}
	
	
	public List<Fecha> getListaFechas() {
		return listaFechas;
	}
	
	public Integer getId_fixture() {
		return id_fixture;
	}
}
