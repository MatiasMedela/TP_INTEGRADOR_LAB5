package AccesoDatos;

import java.util.List;

import org.hibernate.Query;
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
import Dominio.Usuario;

public class ClienteDao {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	//ABML
	
	@Autowired
	private ConfigHibernate ch;
	
	@Autowired
	private UsuarioDao usuDao;
	
		public boolean AltaCliente(Usuario Usu ) {
			try {
				((ConfigurableApplicationContext)(appContext)).refresh();
		    	Configuration configuration = (Configuration) appContext.getBean("BConfiguration");
		    	configuration.configure();	
		    	Session session = ch.abrirConexion();
		    	session.beginTransaction();
				session.save(Usu);
				session.getTransaction().commit();
				session.close();
				 return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		 
		public boolean BajaCliente(String dni) {
				try {
					((ConfigurableApplicationContext)(appContext)).refresh();
					Configuration configuration = (Configuration) appContext.getBean("BConfiguration");
			    	configuration.configure();	
			    	Session session = ch.abrirConexion();
			    	session.getTransaction().begin();
			    	Query query=session.createQuery("UPDATE Usuario L set L.Estado=0 where L.Dni="+dni);
					int result = query.executeUpdate();
					session.getTransaction().commit();
					session.close();
			    	if (result==1) {
						return true;
					} else {
						return false;
					}
			    	
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}	
		}
		public boolean ModAltaCliente(String dni) {
			try {
				((ConfigurableApplicationContext)(appContext)).refresh();
				Configuration configuration = (Configuration) appContext.getBean("BConfiguration");
		    	configuration.configure();	
		    	Session session = ch.abrirConexion();
		    	session.beginTransaction();
		    	Query query=session.createQuery("UPDATE Usuario L set L.Estado=1 where L.Dni="+dni);
				int result = query.executeUpdate();
				session.getTransaction().commit();
				session.close();
		    	if (result==1) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		public boolean ModificarCliente(Usuario Usu, String oldDniName) {
			try {
				((ConfigurableApplicationContext)(appContext)).refresh();
		    	Configuration configuration = (Configuration) appContext.getBean("BConfiguration");
		    	configuration.configure();	
		    	Session session = ch.abrirConexion();
		    	session.getTransaction().begin();
		    	Usu.setIdUsu(usuDao.buscarUsuario(Integer.valueOf(oldDniName)).getIdUsu());
				session.update(Usu);
				session.getTransaction().commit();
				session.close();
				 return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		@SuppressWarnings("unchecked")
		public List<Usuario> ListarClientes() {
			List<Usuario> ListLoc = null;
			Session session = ch.abrirConexion();
			try {
				ListLoc	= (List<Usuario>) session.createQuery("FROM Usuario").list();
			    return ListLoc;	
			} catch (Exception e) {
				e.printStackTrace();
				return ListLoc;
			}
			finally {
				session.close();				
			}
		}
		
		public Usuario BuscarUsuarioXIdLog(Logueo l ) {
			try {
				((ConfigurableApplicationContext)(appContext)).refresh();
				
				Session session = ch.abrirConexion();
				Usuario Usu = (Usuario) appContext.getBean("BUsuario");
				if ((Usuario) session.createQuery(" FROM Usuario u WHERE u.IdUsu = "+l.getUsuario().getIdUsu()).uniqueResult()!=null) {
					Usu =(Usuario) session.createQuery(" FROM Usuario u WHERE u.IdUsu = "+l.getUsuario().getIdUsu()).uniqueResult();
				} 
			    session.close();
			    return Usu;
			} finally {
				((ConfigurableApplicationContext)(appContext)).close();
			}
		}

		public Usuario BuscarUsuarioXId(int idUsu) {
			try {
				((ConfigurableApplicationContext)(appContext)).refresh();
				
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
		
		public Usuario BuscarUsuarioXDni(String dni) {
			try {
				((ConfigurableApplicationContext)(appContext)).refresh();
				
				Session session = ch.abrirConexion();
				Usuario Usu = (Usuario) appContext.getBean("BUsuario");
				if ((Usuario) session.createQuery(" FROM Usuario u WHERE u.Dni = "+dni).uniqueResult()!=null) {
					Usu =(Usuario) session.createQuery(" FROM Usuario u WHERE u.Dni = "+dni).uniqueResult();
				} 
			    session.close();
			    return Usu;
			} finally {
				((ConfigurableApplicationContext)(appContext)).close();
			}
		}	
}
