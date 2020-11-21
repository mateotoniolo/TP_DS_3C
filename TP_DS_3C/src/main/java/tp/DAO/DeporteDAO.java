package tp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import tp.DTOs.DeporteDTO;
import tp.app.App;
import tp.clases.Deporte;



public class DeporteDAO {
	
	public DeporteDAO() {
		super();
	}
	
	public static List<DeporteDTO> getDeportesDTO() {
		List<Deporte> listaDeportes= new ArrayList<>();
		List<DeporteDTO> listaDeportesDTO= new ArrayList<>();
		Query query=App.entity.createQuery("SELECT p FROM Deporte p");
		listaDeportes=(List<Deporte>)query.getResultList();
		for (Deporte p : listaDeportes) {
			listaDeportesDTO.add(new DeporteDTO(p.getIdDeporte(),p.getNombre()));
		}
		return listaDeportesDTO;
	}
	
	public static Deporte getDeporteById(Integer id_deporte) {
		
		Query query=App.entity.createQuery("SELECT d FROM Deporte d WHERE d.id_deporte = "+id_deporte);
		List<Deporte> deporte = (List<Deporte>)query.getResultList();
		return deporte.get(0);
	}
	
	
	
}
