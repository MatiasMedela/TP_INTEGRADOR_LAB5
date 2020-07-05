package AccesoDatos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Logueo;
	
public class LogueoDao {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	
	public Logueo BuscarLog(String UserName,String Key) {
		((ConfigurableApplicationContext)(appContext)).refresh();
		ConfigHibernate ch = new ConfigHibernate();
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
		ConfigHibernate ch = new ConfigHibernate();
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
		Configuration configuration = new Configuration();
		configuration.configure();	
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
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
			sessionFactory.close();			
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
