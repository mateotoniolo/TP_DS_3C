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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import PKs.LocalidadPK;

@Entity
@Table(name="Localidad")
public class Localidad implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_localidad", unique = true)
	private Integer id_localidad;
	
	
	@ManyToOne
    @PrimaryKeyJoinColumn(name="id_provincia",referencedColumnName = "id_provincia")
	private Provincia provincia;
	
	@Column
	private String nombre;
	
	

	public Localidad() {
		super();
	}


	

}
