package Negocio;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import AccesoDatos.ConfigHibernate;
import Dominio.Provincia;

@SuppressWarnings("unchecked")
public class ProvinciaNegocio {

	@Autowired
	private ConfigHibernate ch;
	
	public List<Provincia> listar() {
		
		Session session = ch.abrirConexion();
		List<Provincia> listado = (List<Provincia>) session.createQuery("FROM Provincia").list();
		
    	session.close();
	    return listado;		
	}
	
}
