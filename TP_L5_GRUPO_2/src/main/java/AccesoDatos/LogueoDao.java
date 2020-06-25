package AccesoDatos;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Logueo;
	
public class LogueoDao {
	
	 
	public Logueo BuscarLog(String UserName,String Key) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
		try {
			
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			Logueo log = (Logueo) appContext.getBean("BLogueo");
			if ((Logueo) session.createQuery(" FROM Logueo L WHERE L.nUsuario = '" + UserName + "' AND L.contrasenia = '" + Key + "'").uniqueResult()!=null) {
				log =(Logueo) session.createQuery("FROM Logueo L  WHERE L.nUsuario = '" + UserName + "' AND L.contrasenia = '" + Key + "'").uniqueResult();
			} 
		    session.close();
		    return log;
		} finally {
			((ConfigurableApplicationContext)(appContext)).close();
		}
	}

}
