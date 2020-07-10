package AccesoDatos;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Logueo;
	
public class LogueoDao {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	
	@Autowired
	private ConfigHibernate ch;
	
	public Logueo BuscarLog(String UserName,String Key) {
		((ConfigurableApplicationContext)(appContext)).refresh();
		Session session = ch.abrirConexion();
		Logueo log = (Logueo) appContext.getBean("BLogueo");
		try {
			log = (Logueo) session.createQuery("FROM Logueo L  WHERE L.nUsuario = '" + UserName + "' AND L.contrasenia = '" + Key + "'").uniqueResult();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			((ConfigurableApplicationContext)(appContext)).close();
		}
		return log;
	}
	
	public Logueo BuscarLog(String modUserName) {
		((ConfigurableApplicationContext)(appContext)).refresh();
		Session session = ch.abrirConexion();
		Logueo log = (Logueo) appContext.getBean("BLogueo");
		try {
			log =(Logueo) session.createQuery("FROM Logueo L  WHERE L.nUsuario = '" + modUserName + "'").uniqueResult(); 
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			((ConfigurableApplicationContext)(appContext)).close();
		}
		return log;
	}
	
	public boolean ModLogueo(Logueo newlog) {
		((ConfigurableApplicationContext)(appContext)).refresh();
		Configuration configuration = (Configuration) appContext.getBean("BConfiguration");
		configuration.configure();	
		Session session = ch.abrirConexion();
		try {
	    	session.beginTransaction();
			session.update(newlog);
			session.getTransaction().commit();
			 return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			session.close();		
		}
	}

	public void NuevoLog(Logueo l) {
		try {
			((ConfigurableApplicationContext)(appContext)).refresh();
	    	Configuration configuration = (Configuration) appContext.getBean("BConfiguration");
	    	configuration.configure();	
			Session session = ch.abrirConexion();
	    	session.beginTransaction();
			session.save(l);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
