package tp.Gestores;

import java.util.List;

import javax.swing.JComboBox;

import tp.DAO.LugarDAO;
import tp.DTOs.ItemLugarDTO;
import tp.clases.Lugar;

public class GestorUsuario {
	
	public static List<String> getLugaresDisponibles(Integer usuario, Integer deporte){
		return LugarDAO.getLugaresDisponibles(usuario, deporte);
	}
	
	public static Lugar getLugarByNombre(String nombre){
		return LugarDAO.getLugarByNombre(nombre);
	}
}
