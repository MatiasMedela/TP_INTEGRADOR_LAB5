package AccesoDatos;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Tipo_Usuario;

public class TipoUsuarioDao {
	
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	
	@Autowired
	private ConfigHibernate ch;
	
	public Tipo_Usuario UserCliente() {
		((ConfigurableApplicationContext)(appContext)).refresh();
		try {
			
			Session session = ch.abrirConexion();
			Tipo_Usuario tipo = (Tipo_Usuario) appContext.getBean("BTipo_Usuario");
			if ((Tipo_Usuario) session.createQuery(" FROM Tipo_Usuario u WHERE u.idTipoUsuario = 2").uniqueResult()!=null) {
				tipo =(Tipo_Usuario) session.createQuery(" FROM Tipo_Usuario u WHERE u.idTipoUsuario = 2 ").uniqueResult();
			} 
		    session.close();
		    return tipo;
		} finally {
			((ConfigurableApplicationContext)(appContext)).close();
		}
	}

	public Tipo_Usuario UserBanco() {
		((ConfigurableApplicationContext)(appContext)).refresh();
		try {
			
			Session session = ch.abrirConexion();
			Tipo_Usuario tipo = (Tipo_Usuario) appContext.getBean("BTipo_Usuario");
			if ((Tipo_Usuario) session.createQuery(" FROM Tipo_Usuario u WHERE u.idTipoUsuario = 1").uniqueResult()!=null) {
				tipo =(Tipo_Usuario) session.createQuery(" FROM Tipo_Usuario u WHERE u.idTipoUsuario = 1 ").uniqueResult();
			} 
		    session.close();
		    return tipo;
		} finally {
			((ConfigurableApplicationContext)(appContext)).close();
		}
	}

}
