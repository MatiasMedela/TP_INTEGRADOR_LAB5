package Negocio;

import java.util.List;

import org.hibernate.Session;

import AccesoDatos.ConfigHibernate;
import Dominio.Cuenta;

public class CuentaNegocio {

	public List<Cuenta> listar() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		List<Cuenta> listado = (List<Cuenta>) session.createQuery("SELECT c FROM Cuenta as c").list();
		
    	ch.cerrarSession();
	    return listado;		
	}
	
	public List<Cuenta> datosCuentaBasic(String legajo) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

//		List<Object[]> listado = (List<Object[]>) session.createQuery("SELECT c.saldo, c.alias, tc.moneda, tc.descripcion, c.cbu, c.idCuenta FROM Cuenta as c inner join c.tipoCuenta as tc WHERE c.usuario = " + legajo).list();
		List<Cuenta> listado = (List<Cuenta>) session.createQuery("SELECT c FROM Cuenta as c inner join c.tipoCuenta as tc WHERE c.usuario = " + legajo).list();
    	ch.cerrarSession();
	    return listado;		
	}
	
	public List<Cuenta> CuentaUsuario(String legajo) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		List<Cuenta> listado = (List<Cuenta>) session.createQuery("SELECT c FROM Cuenta c WHERE c.usuario = " + legajo).list();
		
    	ch.cerrarSession();
	    return listado;		
	}
	
}

