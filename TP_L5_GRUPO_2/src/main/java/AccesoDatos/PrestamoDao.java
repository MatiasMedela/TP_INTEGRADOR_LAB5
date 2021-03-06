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
	
	@Autowired
	private MailDao mDao;
	
	@Autowired
	private MovimientoDao mvDao;
	
	@Autowired
	private CuotaDao ctDao;
	
	@Autowired
	private ConfigHibernate ch;
	
	public boolean cargarPrestamo(float importeTotal, int meses, float montoPagar, int idCuenta) {
		
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
    	session.close();
	    return true;		
	}
	
	
	public List<Object[]> listarPrestamosUsuario(int IDUsuario) {	
		Session session = ch.abrirConexion();
		ArrayList<Object[]> listado = (ArrayList<Object[]>) appContext.getBean("ArrayList");
		try {
			listado = (ArrayList<Object[]>) session.createQuery("SELECT c.alias, p.importeTotal, p.montoPagar, concat(sum(case when cu.pagada=true then 1 else 0 end),'/',p.cantidadMeses), (p.montoPagar - (sum(case when cu.pagada=true then 1 else 0 end)*(p.montoPagar/p.cantidadMeses))), p.idPrestamo "
															  + "FROM Cuota cu RIGHT JOIN cu.prestamo as p LEFT JOIN p.cbu as c "
															  + "where p.usuario = :IDUser AND p.estado = 1 "
															  + "group by p.idPrestamo").setInteger("IDUser", IDUsuario).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			session.close();
		}
	    return listado;	
	}	
	
	public List<Prestamo> listarPrestamosPorEstado(int estado) {
		
		Session session = ch.abrirConexion();
		List<Prestamo> listado = (List<Prestamo>) session.createQuery("FROM Prestamo where estado="+estado).list();
		
    	session.close();
	    return listado;		
	}	
	
	public EstadoPrestamo buscarEstadoPrestamo(int estado)
	{
		
		Session session = ch.abrirConexion();
		EstadoPrestamo ep = (EstadoPrestamo) session.createQuery("FROM EstadoPrestamo as ep WHERE ep.id = '"+estado+"'").uniqueResult();
		session.close();
	    return ep;			

	}
	
	public Prestamo buscarPrestamo(int idPrestamo)
	{
		
		Session session = ch.abrirConexion();
		Prestamo p = (Prestamo) session.createQuery("FROM Prestamo as p WHERE p.idPrestamo = '"+idPrestamo+"'").uniqueResult();
		session.close();
	    return p;			

	}
	
	public boolean cambiarEstadoPrestamo(int idPrestamo, int estado)
	{
		
		Session session = ch.abrirConexion();
		try {
			session.beginTransaction();
			Prestamo p = (Prestamo) session.createQuery("FROM Prestamo as p WHERE p.idPrestamo = '"+idPrestamo+"'").uniqueResult();
			p.setEstado(buscarEstadoPrestamo(estado));
			p.setFechaResolucion(new Date());
			if (estado==1)
			{
				mDao.enviarCorreo(idPrestamo, "aprobado");
				cargarCapitalPrestamo(idPrestamo);
				mvDao.agregarTransferencia(mvDao.generarMovPorPrestamo(idPrestamo));
				ctDao.crearCuotas(idPrestamo);
				
			}
			else
			{
				mDao.enviarCorreo(idPrestamo, "rechazado");
			}
			session.save(p);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();			
		}
		return true;
	}
	
	public boolean cargarCapitalPrestamo(int idPrestamo)
	{
		
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
			session.close();			
		}
		return true;
	}
	
	public boolean modificarPrestamo(int idPrestamo, int idCuenta, float importeSolicitado, float importeTotal, int cuotas)
	{
		
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
			session.close();			
		}
		return true;
	}
	
	

}
