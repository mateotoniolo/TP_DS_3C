package tp.auditorias;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import tp.clases.Resultado;
@Entity
@Inheritance(strategy = InheritanceType.JOINED )
@Table(name="Auditoria_Modificacion_Resultado")
public class AuditoriaModificacionResultado implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_auditoria;
	@Column
	private Boolean aPresente;
	@Column
	private Boolean bPresente;
	@Column
	private Date fecha;
	@Column
	private Time hora;
	
	@ManyToOne(cascade=CascadeType.ALL)  
	@PrimaryKeyJoinColumn(referencedColumnName = "id_resultado")  
	private Resultado resultado;
	public AuditoriaModificacionResultado() {
		super();
	}
	
	public AuditoriaModificacionResultado(Boolean aPresente, Boolean bPresente) {
		super();
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}
	
}
