package Negocio;

import java.util.Formatter;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import AccesoDatos.ConfigHibernate;
import AccesoDatos.CuentaDao;
import Dominio.Cuenta;

@SuppressWarnings("unchecked")
public class CuentaNegocio {
	
	@Autowired
	private CuentaDao cuentaDao;

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
		List<Cuenta> listado = cuentaDao.CuentaUsuario(legajo);
	    return listado;		
	}
	
}

