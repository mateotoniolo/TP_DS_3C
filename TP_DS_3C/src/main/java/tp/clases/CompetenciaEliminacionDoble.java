package tp.clases;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import tp.DTOs.ItemLugarDTO;
import tp.enums.EstadoCompetencia;
import tp.enums.Modalidad;
import tp.enums.ModalidadDePuntuacion;
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id_competencia")
@Table(name="Competencia_Eliminacion_Doble")
public class CompetenciaEliminacionDoble extends Competencia {

	// constructor sin params
	public CompetenciaEliminacionDoble() {
		super();
	}
		
	public CompetenciaEliminacionDoble( String nombre, Modalidad modalidad,
			List<Participante> listaParticipantes, Fixture fixture, Integer cantSets, String reglamento, EstadoCompetencia estado,
			ModalidadDePuntuacion modalidadDePuntuacion, Double tantosXAusencia, Usuario usuario,
			Deporte deporte) {
		super( nombre, modalidad, listaParticipantes, fixture, cantSets, reglamento, estado, modalidadDePuntuacion, tantosXAusencia,
				usuario, deporte);
		
		
	}

}
