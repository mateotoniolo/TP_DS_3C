package tp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import tp.DTOs.ItemLugarDTO;
import tp.clases.Lugar;


public class LugarDAO {
	
	public static List<String> getLugares() {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<String> places = new ArrayList<String>();
		try {
			pstm = con.prepareStatement(
					"SELECT nombre FROM dsi20203c.Lugar");
			rs = pstm.executeQuery();
			while(rs.next()) {
				places.add(rs.getString(1)) ;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		finally {
			DataBase.cerrarRs(rs);
			DataBase.cerrarPstm(pstm);
			DataBase.cerrarConexion(con);
		}
		return places;
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
	
	public static Lugar getLugarByID(Integer id_Lugar) {
		Connection con = DataBase.getConexion();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Lugar l = null;
		
		try {
			pstm = con.prepareStatement(
					"SELECT * FROM dsi20203c.Lugar WHERE codigo = ?");
			pstm.setInt(1, id_Lugar);
			rs = pstm.executeQuery();
			while(rs.next()) {
				l=parsearRS(rs);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		finally {
			DataBase.cerrarRs(rs);
			DataBase.cerrarPstm(pstm);
			DataBase.cerrarConexion(con);
		}
		return l;
	}
	
	public static List<ItemLugarDTO> cargar(JComboBox<String> b, Integer id_usuario, String deporte) {
		DeporteDAO deporteDao = new DeporteDAO();
		 //LugarDAO.getLugarByDeporteUsuario(b,deporteDao.getIDbyNombre(deporte), id_usuario);
		List<ItemLugarDTO> list =LugarDAO.getLugarByDeporteUsuario(deporteDao.getIDbyNombre(deporte), id_usuario);
		for(ItemLugarDTO lugar : list ) {
			b.addItem(lugar.getNombre());
		}
		return list;
	}
	
	static Lugar parsearRS(ResultSet rs) throws SQLException {
		
		return new Lugar(Integer.valueOf(rs.getInt(1)),
				rs.getString(2),
				rs.getString(3));
	}
	
}
