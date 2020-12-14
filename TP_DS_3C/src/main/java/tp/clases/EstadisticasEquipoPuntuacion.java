package tp.clases;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id_estadistica")
@Table(name="Estadisitica_Equipo_Puntuacion")
public class EstadisticasEquipoPuntuacion extends EstadisticaTabla {
	@Column
	private Double tantosAFavor;
	@Column
	private Double tantosEnContra;
	@Column
	private Double diferencia;
	

	public EstadisticasEquipoPuntuacion() {
		super();
	}
	
	public EstadisticasEquipoPuntuacion(Integer posicion, String nombre, Integer pG, Integer pP, Integer pE, Double tFavor, Double tEnContra, Double dif,CompetenciaLiga comp,List<Participante> jugadores) {
		super(posicion, nombre, pG, pP, pE,comp,jugadores);
		
		this.setTantosAFavor(tFavor);
		this.setTantosEnContra(tEnContra);
		this.setDiferencia(dif);
	}


	public Double getTantosAFavor() {
		return tantosAFavor;
	}


	public void setTantosAFavor(Double tantosAFavor) {
		this.tantosAFavor = tantosAFavor;
	}


	public Double getTantosEnContra() {
		return tantosEnContra;
	}


	public void setTantosEnContra(Double tantosEnContra) {
		this.tantosEnContra = tantosEnContra;
	}


	public Double getDiferencia() {
		return diferencia;
	}


	public void setDiferencia(Double diferencia) {
		this.diferencia = diferencia;
	}

}
