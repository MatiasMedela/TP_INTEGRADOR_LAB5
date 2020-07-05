package AccesoDatos;

import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Cuenta;
import Dominio.Tipo_Cuenta;
import Dominio.Usuario;

public class CuentaDao {

	private ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	@Autowired
	private UsuarioDao userDao;

	@Autowired
	private TipoCuentaDao tcDao;
	
	public List<Cuenta> listarCuentas() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Cuenta> listado = (List<Cuenta>) session.createQuery("FROM Cuenta").list();
		
    	ch.cerrarSession();
	    return listado;		
	}	
	
	
	public boolean crearCuenta(int idTipoCN, int DNIUser, String alias)
	{		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		Cuenta c = (Cuenta) appContext.getBean("BCuenta");
		Tipo_Cuenta tpc = tcDao.buscarTipoCuenta(idTipoCN);
		Usuario user = userDao.buscarUsuario(DNIUser);
		c.setTipoCuenta(tpc);
		c.setfechaCreacion(new Date());
		c.setCbu(proximoCBUDouble()); 
		c.setAlias("Prueba");
		c.setUsuario(user);
		c.setAlias(alias);
		c.setSaldo(10000);	
		c.setEstado(true);
		try {
			session.save(c);
			session.getTransaction().commit();			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			ch.cerrarSession();	
			
		}
    	return true;
	}
	
	public Cuenta buscarCuenta(int idCuenta) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		Cuenta c = (Cuenta) session.createQuery("FROM Cuenta as cu WHERE cu.idCuenta = '"+idCuenta+"'").uniqueResult();
		ch.cerrarSession();
	    return c;		
	}	
	
	public Cuenta buscarCuentaCBU(Double cbu) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		Cuenta c = (Cuenta) session.createQuery("FROM Cuenta as cu WHERE cu.cbu = " + cbu).uniqueResult();
		ch.cerrarSession();
	    return c;		
	}	
	
	
	public Cuenta buscarCuentaString(String idCuenta) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		Cuenta c = (Cuenta) session.createQuery("FROM Cuenta as cu WHERE cu.idCuenta = '"+idCuenta+"'").uniqueResult();
		ch.cerrarSession();
	    return c;		
	}	
	
	public void modificarCuenta(String idCuentaM, int idTipoCM, float saldoM, int DNIUser)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		Cuenta c = buscarCuentaString(idCuentaM);
		Tipo_Cuenta tpc = tcDao.buscarTipoCuenta(idTipoCM);
		Usuario user = userDao.buscarUsuario(DNIUser);
		c.setUsuario(user);
		c.setTipoCuenta(tpc);
		c.setSaldo(saldoM);	
		session.saveOrUpdate(c);
		session.getTransaction().commit();
    	ch.cerrarSession();
    	
		//Tipo_Cuenta tc = c.getTipoCuenta();
		//tc.setIdTipoCuenta(idModificado);
		//c.setTipoCuenta(tc);
	}
	
	public boolean cerrarCuenta(String idCuenta)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		try {
			session.beginTransaction();
			Cuenta c = (Cuenta) session.createQuery("FROM Cuenta as cu WHERE cu.idCuenta = '"+idCuenta+"'").uniqueResult();
			c.setEstado(false);
			session.save(c);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ch.cerrarSession();			
		}
		return true;
	}
	
	public boolean abrirCuenta(String idCuenta)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		try {
			session.beginTransaction();
			Cuenta c = (Cuenta) session.createQuery("FROM Cuenta as cu WHERE cu.idCuenta = '"+idCuenta+"'").uniqueResult();
			c.setEstado(true);
			session.save(c);			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			session.getTransaction().commit();
			ch.cerrarSession();
		}
		return true;
	}
	
	public String proximoCBU()
	{
		Formatter fmt = new Formatter();
		String fn = "";
		Integer res = null;
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		String c = (String) session.createQuery("Select MAX(c.cbu) FROM Cuenta as c").uniqueResult().toString();
		c = c.substring(0,c.length()-2);
		res = Integer.parseInt(c) +1;
		fmt.format("%022d",res);
		fn = fmt.toString();
    	ch.cerrarSession();
    	return fn;
	}
	
	public double proximoCBUDouble()
	{
		double res = 0;
		String traer = "";
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		traer = (String) session.createQuery("Select MAX(c.cbu) FROM Cuenta as c").uniqueResult().toString();
		traer = traer.substring(0,traer.length()-2);
		res = Double.parseDouble(traer) +1;
    	ch.cerrarSession();
    	return res;
	}
	
	public List<Cuenta> CuentaUsuario(String legajo) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Cuenta> listado = null;
		try {			
			listado = (List<Cuenta>) session.createQuery("SELECT c FROM Cuenta c WHERE c.usuario = " + legajo + " AND c.estado=1").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ch.cerrarSession();		
		}
	    return listado;		
	}


	public void modificarSaldo(Cuenta cuenta, float importe) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		try {
			session.getTransaction().begin();
			cuenta.setSaldo(cuenta.getSaldo() + importe);
			session.saveOrUpdate(cuenta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.getTransaction().commit();
			ch.cerrarSession();	
		}
	    return;	
	}
	
	public String generarAlias()
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		boolean disponible = false;
		String res = "";
		while(!disponible) {
			int n = 0;
			String[] x = {"PERRO", "GATO", "VACA", "RATON", "OVEJA", "ARGENTINA", "PERU", "PARAGUAY", "COREA", "JAPON", 
						"ARBOL", "PLANTA", "ARBUSTO", "TORRE", "MIMO", "POSTE", "MANZANA", "BANANA", "MANDARINA", "PERA", 
						"AUTO", "MOTO", "RELOJ", "CAMION", "LUZ", "CEJAS", "FRUTA", "CLAVO", "PIE", "AZUL", "ROJO", "AMARILLO", 
						"VERDE", "PINTOR", "PAPEL", "BOTA", "RAYO", "CINE", "PLAYA", "MANO", "CAMA", "MOSCA", "HOJA", "OREJA", 
						"JUGO", "ARROZ", "CAMPANA", "AGUA", "PERCHA", "ESCOBA", "GORRA", "MESA", "PIEDRA", "ABAJO", "BOTELLA",
						"RODILLA", "PIERNA", "BRAZO", "ANILLO", "CARTERA", "PALA", "CUARTO", "VENTANA", "BIGOTE", "JARRA", "KIWI",
						"PELO", "PELOTA", "OJOS", "PASTO", "CONEJO", "SACO", "CUERDA", "CALLE", "FLORES", "GORRO", "FOCA", "PARED"};
			Random r = new Random();
			for (int v = 0; v<3; v++)
			{
				n = r.nextInt(14);
				if (v==0){
					res = x[n];	
				}
				else{
			    	res = res + "." + x[n];
			    }		
			}
			Long alias = (Long) session.createQuery("SELECT count(c) FROM Cuenta c "
													  + "WHERE c.alias = :AliasGenerado")
													    .setParameter("AliasGenerado", res).uniqueResult();
			if(alias == 0) {
				disponible = true;
			}
		}
		return res;		
	}
}
