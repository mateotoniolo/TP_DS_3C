package tp.DTOs;

import tp.clases.Participante;

public class PartidoDTO {
	
	Participante local;
	Participante visistante;
	
	
	public PartidoDTO(Participante local, Participante visistante) {
		super();
		this.local = local;
		this.visistante = visistante;
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
}
