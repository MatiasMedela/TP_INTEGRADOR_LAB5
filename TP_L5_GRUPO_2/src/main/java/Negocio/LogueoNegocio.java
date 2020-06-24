package Negocio;

import java.util.List;

import org.hibernate.Session;

import AccesoDatos.ConfigHibernate;

public class LogueoNegocio {

	public String validarLogin(String user, String pass) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		String IDUsuario = (String) session.createQuery("SELECT l.usuario.IdUsu FROM Logueo as l WHERE l.nUsuario = '" + user + "' AND l.contrasenia = '" + pass + "'").uniqueResult();
		if (IDUsuario != "") {
			session.close();
			return IDUsuario;
		} else {
			session.close();
			return "-1";
		}
	}

}
