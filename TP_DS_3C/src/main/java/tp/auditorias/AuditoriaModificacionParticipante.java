package tp.auditorias;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import tp.clases.Competencia;
import tp.clases.Participante;
@Entity
@Table(name="Auditoria_Modificacion_Participante")
public class AuditoriaModificacionParticipante implements Serializable{
	
	@Id
	@ManyToOne(cascade=CascadeType.ALL)  
	@PrimaryKeyJoinColumn(referencedColumnName = "id_participante")  
	private Participante participante;
	@Column
	private Date fechaModificacion;
	@Column
	private Time horaModificacion;
	@Column
	private Integer id_Anterior;
	@Column
	private String nombre_Anterior;
	@Column
	private String correo_Anterior;
	
	
	public AuditoriaModificacionParticipante() {
		super();
	}

	public Integer getId_Anterior() {
		return id_Anterior;
	}

	public void setId_Anterior(Integer id_Anterior) {
		this.id_Anterior = id_Anterior;
	}

	public String getNombre_Anterior() {
		return nombre_Anterior;
	}

	public void setNombre_Anterior(String nombre_Anterior) {
		this.nombre_Anterior = nombre_Anterior;
	}

	public String getCorreo_Anterior() {
		return correo_Anterior;
	}

	public void setCorreo_Anterior(String correo_Anterior) {
		this.correo_Anterior = correo_Anterior;
	}

	public Date getFechaModificacion() {
		return getFechaModificacion();
	}


	
	
}
