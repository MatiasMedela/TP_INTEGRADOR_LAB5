package AccesoDatos;

import java.util.Date;
import java.util.List;


import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Cuenta;
import Dominio.Tipo_Cuenta;
import Dominio.Usuario;

public class CuentaDao {

	private ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	
	
	public List<Cuenta> listarCuentas() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Cuenta> listado = (List<Cuenta>) session.createQuery("FROM Cuenta as c WHERE c.estado=1").list();
		
    	ch.cerrarSession();
	    return listado;		
	}	
	
	
	public void crearCuenta(int idTipoCN, int idUsuarioN, float saldoN, String CBUN)
	{
		
		ConfigHibernate ch = new ConfigHibernate();
		TipoCuentaDao tc = new TipoCuentaDao();
		UsuarioDao ud = new UsuarioDao();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		Cuenta c = (Cuenta) appContext.getBean("BCuenta");
		Tipo_Cuenta tpc = tc.buscarTipoCuenta(idTipoCN);
		Usuario user = ud.buscarUsuario(idUsuarioN);
		c.setTipoCuenta(tpc);
		c.setfechaCreacion(new Date());
		c.setCbu(CBUN); //cambiarlo a big int!
		c.setUsuario(user);
		c.setSaldo(saldoN);	
		c.setEstado(true);	
		session.save(c);
		session.getTransaction().commit();
    	ch.cerrarSession();
		
		
		
	}
	
	public Cuenta buscarCuenta(int idCuenta) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		Cuenta c = (Cuenta) session.createQuery("FROM Cuenta as cu WHERE cu.idCuenta = '"+idCuenta+"'").uniqueResult();
		ch.cerrarSession();
	    return c;		
	}	
	
	
	public void modificarCuenta(int idCuentaM, int idTipoCM, float saldoM, int idUsuarioM)
	{
		ConfigHibernate ch = new ConfigHibernate();
		TipoCuentaDao tc = new TipoCuentaDao();
		UsuarioDao ud = new UsuarioDao();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		Cuenta c = buscarCuenta(idCuentaM);
		Tipo_Cuenta tpc = tc.buscarTipoCuenta(idTipoCM);
		Usuario user = ud.buscarUsuario(idUsuarioM);
		c.setUsuario(user);
		c.setTipoCuenta(tpc);
		c.setSaldo(saldoM);		
		session.save(c);
		session.getTransaction().commit();
    	ch.cerrarSession();
    	
		//Tipo_Cuenta tc = c.getTipoCuenta();
		//tc.setIdTipoCuenta(idModificado);
		//c.setTipoCuenta(tc);
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
	
	
//	public List<Cuenta> datosCuentaBasic(String legajo) {
//		ConfigHibernate ch = new ConfigHibernate();
//		Session session = ch.abrirConexion();
//
//		List<Object[]> listado = (List<Object[]>) session.createQuery("SELECT c.saldo, c.alias, tc.moneda, tc.descripcion, c.cbu, c.idCuenta FROM Cuenta as c inner join c.tipoCuenta as tc WHERE c.usuario = " + legajo).list();
//		List<Cuenta> listado = (List<Cuenta>) session.createQuery("SELECT c FROM Cuenta as c inner join c.tipoCuenta as tc WHERE c.usuario = " + legajo).list();
//   	ch.cerrarSession();
//	    return listado;		
//	}
	
	public List<Cuenta> CuentaUsuario(String legajo) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		List<Cuenta> listado = (List<Cuenta>) session.createQuery("SELECT c FROM Cuenta c WHERE c.usuario = " + legajo + " AND c.estado=1").list();
		
    	ch.cerrarSession();
	    return listado;		
	}
	
}
