package Negocio;

import java.util.List;

import org.hibernate.Session;

import AccesoDatos.ConfigHibernate;
import Dominio.Cuenta;

public class CuentaNegocio {

	public List<Cuenta> listar() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		List<Cuenta> listado = (List<Cuenta>) session.createQuery("FROM Cuenta").list();
		
    	ch.cerrarSession();
	    return listado;		
	}
	
	public List<Cuenta> CuentaUsuario(String legajo) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		List<Cuenta> listado = (List<Cuenta>) session.createQuery("SELECT c FROM Cuenta c WHERE c.usuario = " + legajo).list();
		
    	ch.cerrarSession();
	    return listado;		
	}
	
}

