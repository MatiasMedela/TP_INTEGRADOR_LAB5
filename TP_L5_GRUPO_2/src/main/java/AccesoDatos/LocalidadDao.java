package AccesoDatos;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Cuenta;
import Dominio.Localidad;

public class LocalidadDao {

	public Localidad BuscarLocalidad(String id) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			Localidad Loc = (Localidad) appContext.getBean("BLocalidad");
			if ((Localidad) session.createQuery(" FROM Localidad u WHERE u.IdLocalidad = "+id).uniqueResult()!=null) {
				Loc =(Localidad) session.createQuery(" FROM Localidad u WHERE u.IdLocalidad = "+id).uniqueResult();
			} 
		    session.close();
		    return Loc;
		} finally {
			((ConfigurableApplicationContext)(appContext)).close();
		}
	}

	public List<Localidad> ListLocalidades() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Localidad> listado = (List<Localidad>) session.createQuery("FROM Localidad").list();
    	ch.cerrarSession();
	    return listado;		
	}
	

}
