package tp.DTOs;

import tp.clases.Participante;

public class PartidoDTO {
	
	Participante local;
	Participante visistante;
	Integer nro_fecha;
	
	
	public PartidoDTO(Participante local, Participante visistante) {
		super();
		this.local = local;
		this.visistante = visistante;
	}
	public PartidoDTO(Participante local, Participante visistante, Integer fecha) {
		super();
		this.local = local;
		this.visistante = visistante;
		this.nro_fecha = fecha;
	}
	public Participante getLocal() {
		return local;
	}
	public void setLocal(Participante local) {
		this.local = local;
	}
	public Participante getVisistante() {
		return visistante;
	}
	public void setVisistante(Participante visistante) {
		this.visistante = visistante;
	}
	public Integer getNro_fecha() {
		return nro_fecha;
	}
	public void setNro_fecha(Integer nro_fecha) {
		this.nro_fecha = nro_fecha;
	}
}
