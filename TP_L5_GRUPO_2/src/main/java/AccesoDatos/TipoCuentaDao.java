package AccesoDatos;

import org.hibernate.Session;


import Dominio.Tipo_Cuenta;

public class TipoCuentaDao {
	
	
	public Tipo_Cuenta buscarTipoCuenta(int idCuenta) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		Tipo_Cuenta tc = (Tipo_Cuenta) session.createQuery("FROM Tipo_Cuenta as cu WHERE cu.idTipoCuenta = '"+idCuenta+"'").uniqueResult();
		ch.cerrarSession();
	    return tc;		
	}	
	
	

}


