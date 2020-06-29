package AccesoDatos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Cuenta;
import Dominio.Localidad;

public class LocalidadDao {

	public Localidad BuscarLocalidad(Integer locName) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
		try {
			ConfigHibernate ch = new ConfigHibernate();
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

	public List<Localidad> ListLocalidades() {
		List<Localidad> ListLoc = null;
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			Query query=session.createQuery("SELECT L FROM Localidad L");
			ListLoc = query.list();
			
			if (ListLoc.isEmpty()) {
				System.out.println("ListaVacia");
			}else {
				for (Localidad loc : ListLoc) {
					System.out.println(loc.toString());
				}
			}
	    	ch.cerrarSession();
		    return ListLoc;	
		} catch (Exception e) {
			return ListLoc;
		}	
	}
}
