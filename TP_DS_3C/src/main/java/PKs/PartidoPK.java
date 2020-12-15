package PKs;

import java.io.Serializable;

public class PartidoPK implements Serializable{
	Integer id_partido;
	FechaPK fecha;
	public PartidoPK(Integer id_partido, FechaPK fecha) {
		super();
		this.id_partido = id_partido;
		this.fecha = fecha;
	}
	
	
	
	
}
