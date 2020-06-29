package AccesoDatos;

import java.util.List;

import org.hibernate.Session;

import Dominio.Cuenta;
import Dominio.Usuario;

public class UsuarioDao {

	
	public Usuario buscarUsuario(int idUsuario) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		Usuario user = (Usuario) session.createQuery("FROM Usuario as us WHERE us.IdUsu = '"+idUsuario+"'").uniqueResult();
		ch.cerrarSession();
	    return user;	
	}
	
	
	public List<Usuario> listarUsuarios() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Usuario> listado = (List<Usuario>) session.createQuery("FROM Usuario as us WHERE us.Estado=1").list();
		
    	ch.cerrarSession();
	    return listado;		
	}	
}
