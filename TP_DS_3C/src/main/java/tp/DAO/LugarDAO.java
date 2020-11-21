package tp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.swing.JComboBox;

import org.hibernate.mapping.Collection;

import tp.DTOs.ItemLugarDTO;
import tp.app.App;
import tp.clases.Lugar;


public class LugarDAO {
	
	public static List<String> getLugaresDisponibles(Integer usuario, Integer deporte) {
		
		Query query=App.entity.createQuery("SELECT l.nombre FROM Lugar l , Relacion_Lugar_Deporte rld WHERE l.codigo = rld.codigo AND l.id_usuario = "+usuario+" AND rld.id_deporte = "+deporte );
		List<String> lugares = (List<String>)query.getResultList();
	
		return lugares;
	}
	
	public static List<ItemLugarDTO> getLugarByDeporteUsuario(Integer id_deporte, Integer id_usuario) {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<ItemLugarDTO> places = new ArrayList<ItemLugarDTO>();
		LugarDAO lugarDao = new LugarDAO();
		try {
			pstm = con.prepareStatement(
					"SELECT * FROM dsi20203c.Lugar l INNER JOIN dsi20203c.Relacion_Lugar_Deporte rld ON l.codigo = rld.codigo WHERE l.id_usuario = ? AND rld.id_deporte = ? ");
			pstm.setInt(1, id_usuario);
			pstm.setInt(2, id_deporte);
			rs = pstm.executeQuery();
			while(rs.next()) {
				places.add(new ItemLugarDTO(Integer.valueOf(rs.getInt(1)),
						rs.getString(2)));
			}
			return places;
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		finally {
			DataBase.cerrarRs(rs);
			DataBase.cerrarPstm(pstm);
			DataBase.cerrarConexion(con);
		}
		return null;
	}
	
	public static Lugar getLugarByNombre(String nombre) {
		Query query=App.entity.createQuery("SELECT l FROM Lugar l  WHERE l.nombre = '"+ nombre+"'" );
		List<Lugar> lugares = (List<Lugar>)query.getResultList();
		return lugares.get(0);
	}
}
	


