package tp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.Query;
import javax.swing.JComboBox;

import org.hibernate.mapping.Collection;

import tp.DTOs.ItemLugarDTO;
import tp.app.App;
import tp.clases.Deporte;
import tp.clases.Lugar;


public class LugarDAO {
	
	public static List<String> getLugaresDisponibles(Integer usuario, Integer deporte) {
		
		Query query=App.entity.createQuery("SELECT l FROM Lugar l WHERE id_usuario = "+usuario+"");
		List<Lugar> lugares = (List<Lugar>)query.getResultList();
		List<String> nombres = new ArrayList<>();
		for(Lugar l : lugares) {
			for(Deporte d : l.getDeportes()) {
				if(d.getIdDeporte() == deporte) {
					nombres.add(l.getNombre());
					break;
				}
			}
		}
	
		return nombres;
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
	


