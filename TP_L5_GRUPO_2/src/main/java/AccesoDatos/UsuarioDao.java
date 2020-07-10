package AccesoDatos;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import Dominio.Cuenta;
import Dominio.Usuario;

public class UsuarioDao {

	@Autowired
	private ConfigHibernate ch;
	
	public Usuario buscarUsuario(int DNIUser) {
		
		Session session = ch.abrirConexion();
		Usuario user = (Usuario) session.createQuery("FROM Usuario as us WHERE us.Dni = '"+DNIUser+"'").uniqueResult();
		session.close();
	    return user;	
	}
	
	public Usuario buscarUsuario(String IDUsuario) {
		
		Session session = ch.abrirConexion();
		Usuario user = (Usuario) session.createQuery("FROM Usuario as us WHERE us.IdUsu = '"+IDUsuario+"'").uniqueResult();
		session.close();
	    return user;	
	}
	

	public List<Usuario> listarUsuarios() {
		
		Session session = ch.abrirConexion();
		List<Usuario> listado = (List<Usuario>) session.createQuery("FROM Usuario as us WHERE us.Estado=1").list();
		
    	session.close();
	    return listado;		
	}	
	
	public Long cantidadCuentas(String DNIUser) {
		
		Session session = ch.abrirConexion();
		Long cantCuentas = (Long) session.createQuery("SELECT count(u) FROM Cuenta as c "
													  + "INNER JOIN c.usuario as u "
													  + "WHERE u.Dni = :DNI").setParameter("DNI", DNIUser).uniqueResult();
		session.close();
	    return cantCuentas;	
	}
}
