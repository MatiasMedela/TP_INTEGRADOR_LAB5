package AccesoDatos;

import java.util.List;

import org.hibernate.Session;

import Dominio.Cuenta;
import Dominio.Usuario;

public class UsuarioDao {

	
	public Usuario buscarUsuario(int DNIUser) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		Usuario user = (Usuario) session.createQuery("FROM Usuario as us WHERE us.Dni = '"+DNIUser+"'").uniqueResult();
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
	
	public Long cantidadCuentas(String DNIUser) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		Long cantCuentas = (Long) session.createQuery("SELECT count(u) FROM Cuenta as c "
													  + "INNER JOIN c.usuario as u "
													  + "WHERE u.Dni = :DNI").setParameter("DNI", DNIUser).uniqueResult();
		ch.cerrarSession();
	    return cantCuentas;	
	}
}
