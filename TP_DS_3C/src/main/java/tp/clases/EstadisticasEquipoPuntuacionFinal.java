package tp.clases;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id_estadistica")
@Table(name="Estadisitica_Equipo_Puntuacion_Final")
public class EstadisticasEquipoPuntuacionFinal extends EstadisticaTabla {


	public EstadisticasEquipoPuntuacionFinal() {
		super();
	}
	
	
	public EstadisticasEquipoPuntuacionFinal(Integer posicion, String nombre, Integer pG, Integer pP, Integer pE,CompetenciaLiga comp,List<Participante> jugadores) {
		super(posicion, nombre, pG, pP, pE,comp,jugadores);
	}

}
