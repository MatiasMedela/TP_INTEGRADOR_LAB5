package AccesoDatos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
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
		try {
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
	
	public Logueo BuscarLog(String modUserName) {
		try {
			Session session = ch.abrirConexion();
			Logueo log = (Logueo) appContext.getBean("BLogueo");
			if ((Logueo) session.createQuery(" FROM Logueo L WHERE L.nUsuario = '" + modUserName + "'").uniqueResult()!=null) {
				log =(Logueo) session.createQuery("FROM Logueo L  WHERE L.nUsuario = '" + modUserName + "'").uniqueResult();
			} 
		    session.close();
		    return log;
		} finally {
			((ConfigurableApplicationContext)(appContext)).close();
		}
	}
	
	public boolean ModLogueo(Logueo newlog) {
		try {
	    	Configuration configuration = new Configuration();
	    	configuration.configure();	
	    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    	Session session = sessionFactory.openSession();
	    	session.beginTransaction();
			session.update(newlog);
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			 return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void NuevoLog(Logueo l) {
		try {
	    	Configuration configuration = new Configuration();
	    	configuration.configure();	
	    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    	Session session = sessionFactory.openSession();
	    	session.beginTransaction();
			session.save(l);
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
