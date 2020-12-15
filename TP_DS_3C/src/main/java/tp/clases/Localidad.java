package tp.clases;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import PKs.LocalidadPK;

@Entity
@Table(name="Localidad")

public class Localidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_localidad;
	
	
	@ManyToOne
	@JoinColumn(name="id_provincia",referencedColumnName = "id_provincia")
	private Provincia id_provincia;
	
	@Column
	private String nombre;
	
	

	public Localidad() {
		super();
	}


	

}
