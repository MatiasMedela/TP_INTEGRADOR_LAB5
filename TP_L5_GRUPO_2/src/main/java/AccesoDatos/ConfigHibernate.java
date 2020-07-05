package AccesoDatos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigHibernate {
	
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	private SessionFactory sessionFactory;
	private Session session;

	public ConfigHibernate()
	{
		Configuration configuration = (Configuration) appContext.getBean("BConfiguration");
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public Session abrirConexion()
	{
		session=sessionFactory.openSession();
		return session;
	}
	
	public void cerrarSession()
	{
		session.close();
		cerrarSessionFactory();
	}
	
	
	public void cerrarSessionFactory()
	{
		sessionFactory.close();
	}
	
}
