package tp.auditorias;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import tp.clases.Competencia;
@Entity
@Table(name="Auditoria_Baja_Competencia")
public class AuditoriaDeBajaDeCompetencia implements Serializable{
	@Id
	@OneToOne
    @JoinColumn(name = "id_competencia", referencedColumnName = "id_competencia")
	private Competencia competencia;
	
	@Column
	private Date fecha;
	@Column
	private Time hora;
	
	public AuditoriaDeBajaDeCompetencia() {
		super();
	}
	
}
