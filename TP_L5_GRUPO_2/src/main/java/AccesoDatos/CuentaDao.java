package AccesoDatos;

import java.util.List;

import org.hibernate.Session;

import Dominio.Cuenta;

public class CuentaDao {

	
	public List<Cuenta> listarCuentas() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Cuenta> listado = (List<Cuenta>) session.createQuery("FROM Cuenta").list();
		
    	ch.cerrarSession();
	    return listado;		
	}	
	
	
	public void crearCuenta()
	{
		
	}
	
	public Cuenta buscarCuenta(int idCuenta) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		Cuenta c = (Cuenta) session.createQuery("FROM Cuenta as cu WHERE cu.idCuenta = '"+idCuenta+"'").uniqueResult();
		ch.cerrarSession();
	    return c;		
	}	
	
	
	public void modificarCuenta(int idCuenta)
	{
		
	}
	
	public void cerrarCuenta(String idCuenta)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		Cuenta c = (Cuenta) session.createQuery("FROM Cuenta as cu WHERE cu.idCuenta = '"+idCuenta+"'").uniqueResult();
		c.setEstado(false);
		session.save(c);
		session.getTransaction().commit();
    	ch.cerrarSession();
	}
	
	
}
