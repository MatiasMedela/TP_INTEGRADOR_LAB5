package AccesoDatos;

import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.EstadoPrestamo;
import Dominio.Movimiento;
import Dominio.Prestamo;

@SuppressWarnings("unchecked")
public class MovimientoDao {
	
	private ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
    HttpServletRequest request;
	
	@Autowired
	private PrestamoDao pDao;
	
	@Autowired
	private TipoMovimientoDao tmDao;
	
    
	public List<Movimiento> movimientosxUsuario(String legajoUsuario) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Movimiento> listado = (List<Movimiento>) session.createQuery("SELECT m FROM Movimiento m "
																		+ "INNER JOIN m.cuentaOrigen as c "
																		+ "INNER JOIN c.usuario as u "
																		+ "where u.IdUsu = " + legajoUsuario).list();
    	ch.cerrarSession();
	    return listado;		
	}	

	public List<Movimiento> movimientosxCuenta(int idCuenta) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Movimiento> listado = (List<Movimiento>) session.createQuery("SELECT m FROM Movimiento as m "
																		+ "LEFT JOIN m.cuentaOrigen as co "
																		+ "LEFT JOIN m.cuentaDestino as cd "
																		+ "WHERE co.idCuenta = :IDCuenta OR cd.idCuenta = :IDCuenta "
																		+ "order by m.fecha desc").setParameter("IDCuenta", idCuenta).list();
    	ch.cerrarSession();
	    return listado;		
	}
	
	
	public void agregarTransferencia(Movimiento mov) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		session.save(mov);
		session.getTransaction().commit();
		ch.cerrarSession();
	}
	
	public Movimiento generarMovPorPrestamo (int idPrestamo)
	{
		Movimiento m = (Movimiento) appContext.getBean("BMovimiento");
		Prestamo p = pDao.buscarPrestamo(idPrestamo);
		m.setCuentaDestino(p.getCbu());
		m.setCuentaOrigen(null);
		m.setFecha(new Date());
		m.setImporte(p.getImporteTotal());
		m.setMotivo("Prestamo nº"+p.getIdPrestamo()+" aprobado.");
		m.setTipoMovimiento(tmDao.buscarMovimiento(2));
		return m;
	}
	
	
	public ArrayList<Object[]> transferenciasxMes(int yearSelect) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		ArrayList<Object[]> listado = null;
		try {	
			listado = (ArrayList<Object[]>) session.createQuery("SELECT month(m.fecha), count(m.idMovimiento) FROM Movimiento m "
																+ "where m.cuentaDestino is not null AND year(m.fecha) = :añoSelect "
																+ "group by month(m.fecha) "
																+ "order by month(m.fecha) asc")
																.setInteger("añoSelect", yearSelect).list();
		}catch(Exception e){
			System.out.println(e.toString());
			return listado;
		}finally {
			ch.cerrarSession();			
		}
		
	    return listado;		
	}	
	
	public ArrayList<Object[]> transferenciasxUsuario(int IDUsuario) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		ArrayList<Object[]> listado = null;
		try {	
			listado = (ArrayList<Object[]>) session.createQuery("SELECT m.fecha, concat(uOrigen.Apellido, ' ', uOrigen.Nombre), co.cbu, concat(uDestino.Apellido, ' ', uDestino.Nombre), cd.cbu, m.importe FROM Movimiento m "
																		+ "INNER JOIN m.cuentaOrigen as co "
																		+ "INNER JOIN m.cuentaDestino as cd "
																		+ "INNER JOIN co.usuario as uOrigen "
																		+ "INNER JOIN cd.usuario as uDestino "
																		+ "where m.cuentaOrigen in (FROM Cuenta c where c.usuario = :IDUser) "
																		+ "OR m.cuentaDestino in (FROM Cuenta c where c.usuario = :IDUser) "
																		+ "ORDER BY m.fecha DESC")
																		.setInteger("IDUser", IDUsuario).list();
		}catch(Exception e){
			System.out.println(e.toString());
			return listado;
		}finally {
			ch.cerrarSession();			
		}
		
	    return listado;		
	}
}
