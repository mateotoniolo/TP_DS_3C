package tp.clases;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PartidoPK implements Serializable{
		private Integer idpartido;
		private Fecha fecha;
		
		public PartidoPK() {
		}

		public PartidoPK(Integer idpartido, Fecha fecha) {
			super();
			this.idpartido = idpartido;
			this.fecha = fecha;
		}

		public Integer getIdpartido() {
			return idpartido;
		}

		public void setIdpartido(Integer idpartido) {
			this.idpartido = idpartido;
		}

		public Fecha getFecha() {
			return fecha;
		}

		public void setFecha(Fecha fecha) {
			this.fecha = fecha;
		}
		
		
}
