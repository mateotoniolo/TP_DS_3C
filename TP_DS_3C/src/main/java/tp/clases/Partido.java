package tp.clases;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="Partido")

public class Partido implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idpartido", unique=true)
	private Integer idpartido;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="fecha",referencedColumnName = "idfecha")
	private Fecha fecha;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_Local",referencedColumnName = "id_participante")
	private Participante participanteA;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_visitante",referencedColumnName = "id_participante")
	private Participante participanteB;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_lugar",referencedColumnName = "codigo")
	private Lugar lugarDeRealizacion;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_resultado",referencedColumnName = "id_resultado")
	private Resultado resultado;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="eliminacionGanadores",referencedColumnName = "id_partido")
	private Partido eliminacionGanadores;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="eliminacionPerdedores",referencedColumnName = "id_partido")
	private Partido eliminacionPerdedores;
	
	

	public Partido() {
		super();
	}
	

	public Partido(Participante pA, Participante pB) {
		this.setParticipanteA(pA);
		this.setParticipanteB(pB);
		this.lugarDeRealizacion = null;
		this.resultado = null;
	}
	
	public Partido(Participante pA, Participante pB, Lugar lugarDeRealizacion, Resultado resultado) {
		this.setParticipanteA(pA);
		this.setParticipanteB(pB);
		this.setLugarDeRealizacion(lugarDeRealizacion);
		this.setResultado(resultado);
	}

	public Partido(Participante A, Participante B, Lugar lugar) {
		this.participanteA = A;
		this.participanteB = B;
		this.lugarDeRealizacion = lugar;
		this.resultado = null;
	}

	public Participante getParticipanteA() {
		return participanteA;
	}

	public void setParticipanteA(Participante participanteA) {
		this.participanteA = participanteA;
	}

	public Participante getParticipanteB() {
		return participanteB;
	}

	public void setParticipanteB(Participante participanteB) {
		this.participanteB = participanteB;
	}

	public Lugar getLugarDeRealizacion() {
		return lugarDeRealizacion;
	}

	public void setLugarDeRealizacion(Lugar lugarDeRealizacion) {
		this.lugarDeRealizacion = lugarDeRealizacion;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}


	public Fecha getFecha() {
		return fecha;
	}


	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

}
