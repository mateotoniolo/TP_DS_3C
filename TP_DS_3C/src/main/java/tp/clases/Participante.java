package tp.clases;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import tp.auditorias.AuditoriaModificacionParticipante;
@Entity
@Table(name="Participante")
public final class Participante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Participante;
	@Column
	private String email;
	@Column
	private String nombre;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_competencia",referencedColumnName = "id_competencia")
	private Competencia competencia;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_participante")
	private List<AuditoriaModificacionParticipante> auditoria;

	public Participante() {
		super();
	}
	
	public Participante( String nombre, String email, Competencia comp) {
	
		this.setEmail(email);
		this.setNombre(nombre);
		this.competencia = comp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdParticipante() {
		return id_Participante;
	}

	public void setIdParticipante(Integer idParticipante) {
		this.id_Participante = idParticipante;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
}
