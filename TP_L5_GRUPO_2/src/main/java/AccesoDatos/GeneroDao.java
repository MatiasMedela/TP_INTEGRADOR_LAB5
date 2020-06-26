package AccesoDatos;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Genero;

public class GeneroDao {

	public Genero BuscarGeneroXId(int id) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			Genero Gen = (Genero) appContext.getBean("BGenero");
			if ((Genero) session.createQuery(" FROM Genero u WHERE u.idGenero = "+id).uniqueResult()!=null) {
				Gen =(Genero) session.createQuery(" FROM Genero u WHERE u.idGenero = "+id).uniqueResult();
			} 
		    session.close();
		    return Gen;
		} finally {
			((ConfigurableApplicationContext)(appContext)).close();
		}
	}
}
