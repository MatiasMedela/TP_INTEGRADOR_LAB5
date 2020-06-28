package AccesoDatos;

import org.hibernate.Session;

import Dominio.Usuario;

public class UsuarioDao {

	
	public Usuario buscarUsuario(int idUsuario) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		Usuario user = (Usuario) session.createQuery("FROM Usuario as us WHERE us.IdUsu = '"+idUsuario+"'").uniqueResult();
		ch.cerrarSession();
	    return user;	
	}
}
