package tp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import tp.DTOs.CompetenciaDTO;
import tp.DTOs.DeporteDTO;
import tp.DTOs.ItemLugarDTO;
import tp.app.App;
import tp.clases.Competencia;
import tp.clases.CompetenciaEliminacionDoble;
import tp.clases.CompetenciaEliminacionSimple;
import tp.clases.CompetenciaLiga;
import tp.clases.Deporte;
import tp.clases.Fixture;
import tp.enums.Modalidad;
import tp.enums.ModalidadDePuntuacion;



public class FixtureDAO {

	public static Fixture getFixtureById(Integer id_fixture) {
		Fixture fix = App.entity.find(Fixture.class, id_fixture);
		return fix;
	}
	
	
	
	
}
