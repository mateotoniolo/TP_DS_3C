package tp.Gestores;

import java.util.List;

import javax.swing.JComboBox;

import tp.DAO.LugarDAO;
import tp.DTOs.ItemLugarDTO;

public class GestorUsuario {
	
	public static List<ItemLugarDTO> cargarLugares(JComboBox<String> jcb, Integer id_usuario, String deporte) {
		return LugarDAO.cargar(jcb, id_usuario, deporte);
	}
	
}
