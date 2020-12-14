package tp.clases;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import PKs.LocalidadPK;
import PKs.ProvinciaPK;



@Entity
@Table(name="Provincia")
@IdClass(ProvinciaPK.class)
public class Provincia {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id_provincia;
		
		@Id
		@ManyToOne
		@JoinColumn(name="id_pais",referencedColumnName = "id_pais")
		private Pais id_pais;

		@Column
		private String nombre;
	
		public Provincia() {
			super();
		}

		public Integer getId_provincia() {
			return id_provincia;
		}

		public void setId_provincia(Integer id_provincia) {
			this.id_provincia = id_provincia;
		}

		public Pais getId_pais() {
			return id_pais;
		}

		public void setId_pais(Pais id_pais) {
			this.id_pais = id_pais;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		

}
