package tp.clases;

import tp.auditorias.AuditoriaModificacionResultado;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Inheritance(strategy = InheritanceType.JOINED )
@Table(name="Resultado")
public class Resultado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_resultado;
	@Column
	private Boolean aPresente;
	@Column
	private Boolean bPresente;
	@Transient
	private List<AuditoriaModificacionResultado> historialCambios;
	
	

	public Resultado() {
		super();
	}
	
	public Resultado(Boolean aPresente, Boolean bPresente) {
		this.setaPresente(aPresente);
		this.setbPresente(bPresente);
	}

	public Boolean getaPresente() {
		return aPresente;
	}

	public void setaPresente(Boolean aPresente) {
		this.aPresente = aPresente;
	}

	public Boolean getbPresente() {
		return bPresente;
	}

	public void setbPresente(Boolean bPresente) {
		this.bPresente = bPresente;
	}

	public List<AuditoriaModificacionResultado> getHistorialCambios() {
		return historialCambios;
	}

	public void setHistorialCambios(List<AuditoriaModificacionResultado> historialCambios) {
		this.historialCambios = historialCambios;
	}

	public void addCambio(AuditoriaModificacionResultado cambio) {
		this.historialCambios.add(cambio);
	}
}
