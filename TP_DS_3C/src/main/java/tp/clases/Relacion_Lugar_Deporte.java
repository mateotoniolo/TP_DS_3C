package tp.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Relacion_Lugar_Deporte")
public class Relacion_Lugar_Deporte implements Serializable{ 
	@Id
	@Column
	private Integer id_deporte;
	
	@Id
	@Column
	private Integer codigo;
	
	
}
