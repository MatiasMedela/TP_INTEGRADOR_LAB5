package AccesoDatos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import Dominio.Cuenta;
import Dominio.Usuario;



public class ClienteDao {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	//ABML
		public boolean AltaCliente(Usuario Usu ) {
			try {
		    	Configuration configuration = new Configuration();
		    	configuration.configure();	
		    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		    	Session session = sessionFactory.openSession();
		    	session.beginTransaction();
				session.save(Usu);
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();
				 return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		 
		public boolean BajaCliente() {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			Usuario Cliente = (Usuario) appContext.getBean("BUsuario");
			//actualizar estado
			((ConfigurableApplicationContext)(appContext)).close();
			 return true;
		}
		
		public boolean ModificarCliente(Usuario Usu) {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			Usuario Cliente = (Usuario) appContext.getBean("BUsuario");
			//Modfificar
			((ConfigurableApplicationContext)(appContext)).close();
			 return true;
		}
		
		public List ListarClientesXDni() {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			List<Usuario> LUsuarios = new ArrayList<Usuario>();
			Usuario Cliente = (Usuario) appContext.getBean("BUsuario");
			//for
			((ConfigurableApplicationContext)(appContext)).close();
			return LUsuarios;
			 
		}
		public List ListarClientesXNombreApellido() {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			List<Usuario> LUsuarios = new ArrayList<Usuario>();
			Usuario Cliente = (Usuario) appContext.getBean("BUsuario");
			//for
			((ConfigurableApplicationContext)(appContext)).close();
			return LUsuarios;
		}

		public Usuario BuscarUsuarioXId(int idUsu) {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
			try {
				ConfigHibernate ch = new ConfigHibernate();
				Session session = ch.abrirConexion();
				Usuario Usu = (Usuario) appContext.getBean("BUsuario");
				if ((Usuario) session.createQuery(" FROM Usuario u WHERE u.IdUsu = "+idUsu).uniqueResult()!=null) {
					Usu =(Usuario) session.createQuery(" FROM Usuario u WHERE u.IdUsu = "+idUsu).uniqueResult();
				} 
			    session.close();
			    return Usu;
			} finally {
				((ConfigurableApplicationContext)(appContext)).close();
			}
				
			
		}	
}
