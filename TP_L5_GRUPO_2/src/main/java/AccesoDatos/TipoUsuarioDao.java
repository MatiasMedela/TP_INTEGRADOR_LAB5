package AccesoDatos;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Tipo_Usuario;

public class TipoUsuarioDao {

	public Tipo_Usuario UserCliente() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
		try {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			Tipo_Usuario Loc = (Tipo_Usuario) appContext.getBean("BLocalidad");
			if ((Tipo_Usuario) session.createQuery(" FROM Tipo_Usuario u WHERE u.idTipoUsuario = 2").uniqueResult()!=null) {
				Loc =(Tipo_Usuario) session.createQuery(" FROM Tipo_Usuario u WHERE u.idTipoUsuario = 2 ").uniqueResult();
			} 
		    session.close();
		    return Loc;
		} finally {
			((ConfigurableApplicationContext)(appContext)).close();
		}
	}

}
