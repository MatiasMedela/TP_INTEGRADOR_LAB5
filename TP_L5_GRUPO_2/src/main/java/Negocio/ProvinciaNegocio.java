package Negocio;

import java.util.List;

import org.hibernate.Session;

import AccesoDatos.ConfigHibernate;
import Dominio.Provincia;

public class ProvinciaNegocio {

	public List<Provincia> listar() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		List<Provincia> listado = (List<Provincia>) session.createQuery("FROM Provincia").list();
		
    	ch.cerrarSession();
	    return listado;		
	}
	
}
