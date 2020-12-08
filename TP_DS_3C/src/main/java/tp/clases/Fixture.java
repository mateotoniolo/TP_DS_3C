package tp.clases;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Fixture")
public class Fixture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_fixture;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Fecha> Fechas;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_competencia",referencedColumnName = "id_competencia")
	private Competencia competencia;
	
	public Fixture() {
		
	}

	public Fixture(List<Fecha> fechas,Competencia competencia) {
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
