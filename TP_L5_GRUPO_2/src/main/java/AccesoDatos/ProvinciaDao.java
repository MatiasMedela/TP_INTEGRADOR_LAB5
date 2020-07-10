package AccesoDatos;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import Dominio.Provincia;

public class ProvinciaDao {
	
	@Autowired
	private ConfigHibernate ch;
	
	@SuppressWarnings("unchecked")
	public List<Provincia> ListProvincias() {
		List<Provincia> ListLoc = null;
		Session session = ch.abrirConexion();
		try {	
			ListLoc = (List<Provincia>) session.createQuery(" FROM Provincia").list();
		    return ListLoc;	
		} catch (Exception e) {
			e.printStackTrace();
			return ListLoc;
		} finally {
			session.close();			
		}
	}
}
