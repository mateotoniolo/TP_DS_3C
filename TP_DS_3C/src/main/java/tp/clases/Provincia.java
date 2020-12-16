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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;





@Entity
@Table(name="Provincia")
public class Provincia implements Serializable{
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column( unique = true)
		private Integer id_provincia;
		
		
		@ManyToOne
		@JoinColumn(name="id_pais",referencedColumnName = "id_pais")
		private Pais pais;

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

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		

}
