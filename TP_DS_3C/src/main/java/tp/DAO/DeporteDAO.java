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
	
	public Integer getIDbyNombre(String nombre) {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Integer m = null;
		try {
			pstm = con.prepareStatement(
					"SELECT id_deporte FROM dsi20203c.Deporte WHERE nombre = ?");
			pstm.setString(1,nombre);
			rs = pstm.executeQuery();
			if(rs.next()) {
				return  Integer.valueOf(rs.getInt(1));
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		finally {
			DataBase.cerrarRs(rs);
			DataBase.cerrarPstm(pstm);
			DataBase.cerrarConexion(con);
		}
		return m;
	}
	
	
	
}
