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
	
	public static Lugar getLugarByNombre(String nombre) {
		Query query=App.entity.createQuery("SELECT l FROM Lugar l  WHERE l.nombre = '"+ nombre+"'" );
		List<Lugar> lugares = (List<Lugar>)query.getResultList();
		return lugares.get(0);
	}
	
	public static Lugar getLugarByCodigo(Integer codigo) {
		Query query=App.entity.createQuery("SELECT l FROM Lugar l  WHERE l.codigo = '"+ codigo+"'" );
		List<Lugar> lugares = (List<Lugar>)query.getResultList();
		return lugares.get(0);
	}
}
	


