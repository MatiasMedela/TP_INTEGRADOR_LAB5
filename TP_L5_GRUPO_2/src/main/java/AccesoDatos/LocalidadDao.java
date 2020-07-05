package AccesoDatos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Localidad;

public class LocalidadDao {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	
	@Autowired
	private ConfigHibernate ch;
	
	public Localidad BuscarLocalidad(Integer locName) {
		try {
			Session session = ch.abrirConexion();
			Localidad Loc = (Localidad) appContext.getBean("BLocalidad");
			if ((Localidad) session.createQuery(" FROM Localidad u WHERE u.IdLocalidad = "+locName).uniqueResult()!=null) {
				Loc =(Localidad) session.createQuery(" FROM Localidad u WHERE u.IdLocalidad = "+locName).uniqueResult();
			} 
		    session.close();
		    return Loc;
		} finally {
			((ConfigurableApplicationContext)(appContext)).close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Localidad> ListLocalidades() {
		List<Localidad> ListLoc = null;
		try {
			Session session = ch.abrirConexion();
			Query query=session.createQuery(" FROM Localidad ");
			ListLoc = query.list();
	    	ch.cerrarSession();
		    return ListLoc;	
		} catch (Exception e) {
			return ListLoc;
		}	
	}
}
