package tp.clases;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FechaPK implements Serializable{
		private Integer idfecha;
		private Fixture fixture;
		
		public FechaPK() {
			
		}

		public FechaPK(Integer idFecha, Fixture fixture) {
			super();
			this.idfecha = idFecha;
			this.fixture = fixture;
		}

		public Integer getId_fecha() {
			return idfecha;
		}

		public void setId_fecha(Integer id_fecha) {
			this.idfecha = id_fecha;
		}

		public Fixture getFixture() {
			return fixture;
		}

		public void setFixture(Fixture fixture) {
			this.fixture = fixture;
		}
		
}
