package tp.DAO;

import java.util.List;

import javax.persistence.Query;

import tp.app.App;
import tp.clases.Deporte;
import tp.clases.Usuario;

public class UsuarioDAO {

	public static Usuario getUsuarioById(Integer id_usuario) {
		Query query=App.entity.createQuery("SELECT u FROM Usuario u WHERE u.id_usuario = "+id_usuario);
		List<Usuario> usuario = (List<Usuario>)query.getResultList();
		return usuario.get(0);
	}

}
