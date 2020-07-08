package AccesoDatos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Cuenta;
import Dominio.EstadoPrestamo;
import Dominio.Prestamo;
import Dominio.Usuario;

@SuppressWarnings("unchecked")
public class PrestamoDao {
	
	private ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
    HttpServletRequest request;
	
	@Autowired
	private CuentaDao cDao;
	
	public boolean cargarPrestamo(float importeTotal, int meses, float montoPagar, int idCuenta) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		Usuario user = cDao.buscarCuenta(idCuenta).getUsuario();
		
		EstadoPrestamo estado = (EstadoPrestamo) appContext.getBean("BEstadoPrestamo");
		estado.setId(0);
		estado.setDescripcion("No autorizado");
		
		Prestamo nuevo = (Prestamo) appContext.getBean("BPrestamo");
		nuevo.setImporteTotal(importeTotal);
		nuevo.setMontoPagar(montoPagar);
		nuevo.setCantidadMeses(meses);
		nuevo.setFechaSolicitud(new Date());
		nuevo.setEstado(estado);
		nuevo.setUsuario(user);
		nuevo.setCbu(cDao.buscarCuenta(idCuenta));
		try {
			session.getTransaction().begin();
			session.save(nuevo);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	ch.cerrarSession();
	    return true;		
	}
	
	
	public List<Object[]> listarPrestamosUsuario(int IDUsuario) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		ArrayList<Object[]> listado = new ArrayList<Object[]>();
		try {
			listado = (ArrayList<Object[]>) session.createQuery("SELECT c.alias, p.importeTotal, p.montoPagar, concat(count(cu.numeroCuota),'/',p.cantidadMeses), (p.montoPagar - (count(cu.numeroCuota)*(p.montoPagar/p.cantidadMeses))) "
															  + "FROM Cuota cu RIGHT JOIN cu.prestamo as p LEFT JOIN p.cbu as c "
															  + "where p.usuario = :IDUser "
															  + "group by cu.numeroCuota").setInteger("IDUser", IDUsuario).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			ch.cerrarSession();
		}
	    return listado;	
	}	
	
	public List<Prestamo> listarPrestamosPorEstado(int estado) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Prestamo> listado = (List<Prestamo>) session.createQuery("FROM Prestamo where estado="+estado).list();
		
    	ch.cerrarSession();
	    return listado;		
	}	
	
	public EstadoPrestamo buscarEstadoPrestamo(int estado)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		EstadoPrestamo ep = (EstadoPrestamo) session.createQuery("FROM EstadoPrestamo as ep WHERE ep.id = '"+estado+"'").uniqueResult();
		ch.cerrarSession();
	    return ep;			

	}
	
	public Prestamo buscarPrestamo(int idPrestamo)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		Prestamo p = (Prestamo) session.createQuery("FROM Prestamo as p WHERE p.idPrestamo = '"+idPrestamo+"'").uniqueResult();
		ch.cerrarSession();
	    return p;			

	}
	
	public boolean cambiarEstadoPrestamo(int idPrestamo, int estado)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		try {
			session.beginTransaction();
			Prestamo p = (Prestamo) session.createQuery("FROM Prestamo as p WHERE p.idPrestamo = '"+idPrestamo+"'").uniqueResult();
			p.setEstado(buscarEstadoPrestamo(estado));
			p.setFechaResolucion(new Date());
			if (estado==1)
			{
				cargarCapitalPrestamo(idPrestamo);
			}
			session.save(p);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ch.cerrarSession();			
		}
		return true;
	}
	
	public boolean cargarCapitalPrestamo(int idPrestamo)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		try {
			session.beginTransaction();
			Prestamo p = buscarPrestamo(idPrestamo);
			Cuenta cu = (Cuenta) session.createQuery("FROM Cuenta as c WHERE c.idCuenta = '"+p.getCbu().getIdCuenta()+"'").uniqueResult();
			cu.setSaldo(cu.getSaldo()+p.getImporteTotal());
			session.saveOrUpdate(cu);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ch.cerrarSession();			
		}
		return true;
	}
	
	public boolean modificarPrestamo(int idPrestamo, int idCuenta, float importeSolicitado, float importeTotal, int cuotas)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		try {
			session.beginTransaction();
			Prestamo p = buscarPrestamo(idPrestamo);
			Cuenta c = cDao.buscarCuenta(idCuenta);
			p.setCbu(c);
			p.setImporteTotal(importeSolicitado);
			p.setMontoPagar(importeTotal);
			p.setCantidadMeses(cuotas);
			session.saveOrUpdate(p);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ch.cerrarSession();			
		}
		return true;
	}
	
	

}
