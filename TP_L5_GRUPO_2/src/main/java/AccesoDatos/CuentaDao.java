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
	
	@Autowired
	private ConfigHibernate ch;
	
	public List<Cuenta> listarCuentas() {
		Session session = ch.abrirConexion();
		List<Cuenta> listado = (List<Cuenta>) session.createQuery("FROM Cuenta").list();
    	session.close();
	    return listado;		
	}	
	
	public boolean crearCuenta(int idTipoCN, int DNIUser, String alias)
	{		
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
			session.close();	
			
		}
    	return true;
	}
	
	public Cuenta buscarCuenta(int idCuenta) {
		Session session = ch.abrirConexion();
		Cuenta c = (Cuenta) session.createQuery("FROM Cuenta as cu WHERE cu.idCuenta = '"+idCuenta+"'").uniqueResult();
		session.close();
	    return c;		
	}	
	
	public Cuenta buscarCuentaCBU(Double cbu) {
		Session session = ch.abrirConexion();
		Cuenta c = (Cuenta) session.createQuery("FROM Cuenta as cu WHERE cu.cbu = " + cbu).uniqueResult();
		session.close();
	    return c;		
	}	
	
	
	public Cuenta buscarCuentaString(String idCuenta) {
		Session session = ch.abrirConexion();
		Cuenta c = (Cuenta) session.createQuery("FROM Cuenta as cu WHERE cu.idCuenta = '"+idCuenta+"'").uniqueResult();
		session.close();
	    return c;		
	}	
	
	public boolean modificarCuenta(String idCuentaM, int idTipoCM, float saldoM, int DNIUser)
	{
		Session session = ch.abrirConexion();
		try {
			session.beginTransaction();
			Cuenta c = buscarCuentaString(idCuentaM);
			Tipo_Cuenta tpc = tcDao.buscarTipoCuenta(idTipoCM);
			Usuario user = userDao.buscarUsuario(DNIUser);
			c.setUsuario(user);
			c.setTipoCuenta(tpc);
			c.setSaldo(saldoM);	
			session.saveOrUpdate(c);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {			
			session.close();
		}
	}
	
	public boolean cerrarCuenta(String idCuenta)
	{
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
			session.close();			
		}
		return true;
	}
	
	public boolean abrirCuenta(String idCuenta)
	{
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
			session.close();
		}
		return true;
	}
	
	public String proximoCBU()
	{
		Formatter fmt = new Formatter();
		String fn = "";
		Integer res = null;
		
		Session session = ch.abrirConexion();
		session.beginTransaction();
		String c = (String) session.createQuery("Select MAX(c.cbu) FROM Cuenta as c").uniqueResult().toString();
		c = c.substring(0,c.length()-2);
		res = Integer.parseInt(c) +1;
		fmt.format("%022d",res);
		fn = fmt.toString();
    	session.close();
    	return fn;
	}
	
	public double proximoCBUDouble()
	{
		double res = 0;
		String traer = "";
		Session session = ch.abrirConexion();
		session.beginTransaction();
		traer = (String) session.createQuery("Select MAX(c.cbu) FROM Cuenta as c").uniqueResult().toString();
		traer = traer.substring(0,traer.length()-2);
		res = Double.parseDouble(traer) +1;
    	session.close();
    	return res;
	}
	
	public List<Cuenta> CuentaUsuario(String legajo) {
		Session session = ch.abrirConexion();
		List<Cuenta> listado = null;
		try {			
			listado = (List<Cuenta>) session.createQuery("SELECT c FROM Cuenta c WHERE c.usuario = " + legajo + " AND c.estado=1").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();		
		}
	    return listado;		
	}
	
	public List<Cuenta> CuentaUsuario(String legajo, String moneda) {
		Session session = ch.abrirConexion();
		List<Cuenta> listado = null;
		try {			
			listado = (List<Cuenta>) session.createQuery("SELECT c FROM Cuenta as c "
														+ "INNER JOIN c.tipoCuenta as tc "
														+ "WHERE c.usuario = " + legajo + " AND c.estado=1 AND tc.moneda = :Moneda")
														.setParameter("Moneda", moneda).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();		
		}
	    return listado;		
	}


	public void modificarSaldo(Cuenta cuenta, float importe) {
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
			session.close();	
		}
	    return;	
	}
	
	public String generarAlias()
	{
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


	public Cuenta buscarCuentaAlias(String alias) {
		Session session = ch.abrirConexion();
		Cuenta c = (Cuenta) session.createQuery("FROM Cuenta as cu WHERE cu.alias = '"+alias+"'").uniqueResult();
		session.close();
	    return c;
	}
}
