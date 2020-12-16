package tp.clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="Fixture")
public class Fixture implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_fixture")
	private Integer id_fixture;
	
	@OneToMany(mappedBy = "fixture")
	private List<Fecha> Fechas;
	
	@Transient
	private Competencia competencia;
	
	public Fixture() {
		this.competencia = null;
		this.Fechas = new ArrayList<>();
	}

	public Fixture(List<Fecha> fechas,Competencia competencia) {
		for(Fecha fecha : fechas) {
			fecha.setFixture(this);
		}
		this.Fechas = fechas;
		this.competencia = competencia;
	}

	public List<Fecha> getListaFechas() {
		return Fechas;
	}

	public void setListaFechas(List<Fecha> listaFechas) {
		this.Fechas = listaFechas;
	}
	
	public void addFecha(Fecha fecha) {
		this.Fechas.add(fecha);
	}

	public Integer getId_fixture() {
		return id_fixture;
	}

	public void setId_fixture(Integer id_fixture) {
		this.id_fixture = id_fixture;
	}
}
