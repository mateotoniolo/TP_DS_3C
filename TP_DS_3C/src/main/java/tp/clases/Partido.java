package tp.clases;

public class Partido {

	private Participante participanteA;
	private Participante participanteB;
	private Lugar lugarDeRealizacion;
	private Resultado resultado;
	
	// falta Partido eliminacionGanador
	// falta Partido eliminacionPerdedor
	
	// constructores
	// constructor sin params
	public Partido() {
		super();
	}
	
	// lugar y resultado no definido
	public Partido(Participante pA, Participante pB) {
		this.setParticipanteA(pA);
		this.setParticipanteB(pB);
	}
	
	public Partido(Participante pA, Participante pB, Lugar lugarDeRealizacion, Resultado resultado) {
		this.setParticipanteA(pA);
		this.setParticipanteB(pB);
		this.setLugarDeRealizacion(lugarDeRealizacion);
		this.setResultado(resultado);
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

}
