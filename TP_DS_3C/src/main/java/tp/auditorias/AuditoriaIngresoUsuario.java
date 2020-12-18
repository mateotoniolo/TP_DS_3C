package tp.auditorias;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import tp.clases.Competencia;
import tp.clases.Usuario;


@Entity
@Table(name="Auditoria_Ingreso_Usuario")
public class AuditoriaIngresoUsuario implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_auditoria;
	@Column
	private Date fecha;
	@Column
	private Time hora;
	
	public AuditoriaIngresoUsuario() {
		super();
	}

	
}
