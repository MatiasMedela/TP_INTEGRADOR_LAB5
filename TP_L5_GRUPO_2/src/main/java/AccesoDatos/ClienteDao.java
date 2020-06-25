package AccesoDatos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Logueo;
import Dominio.Usuario;



public class ClienteDao {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	//ABML
		public boolean AltaCliente(Usuario Usu ) {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			Usuario Cliente = (Usuario) appContext.getBean("BUsuario");
			 return true;
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
