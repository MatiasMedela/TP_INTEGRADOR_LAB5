package AccesoDatos;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import Dominio.Cuenta;
import Dominio.Tipo_Cuenta;

public class TipoCuentaDao {
	
	@Autowired
	private ConfigHibernate ch;
	
	public Tipo_Cuenta buscarTipoCuenta(int idCuenta) {
		
		Session session = ch.abrirConexion();
		Tipo_Cuenta tc = (Tipo_Cuenta) session.createQuery("FROM Tipo_Cuenta as cu WHERE cu.idTipoCuenta = '"+idCuenta+"'").uniqueResult();
		session.close();
	    return tc;		
	}	
	
	
	public List<Tipo_Cuenta> listarTipos() {
		
		Session session = ch.abrirConexion();
		List<Tipo_Cuenta> listado = (List<Tipo_Cuenta>) session.createQuery("FROM Tipo_Cuenta").list();
		
    	session.close();
	    return listado;		
	}	
	
	

}


