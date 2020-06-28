package AccesoDatos;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Movimiento;
import Dominio.Prestamo;
import Dominio.Usuario;

public class PrestamoDao {
	private ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
    HttpServletRequest request;
	public boolean cargarPrestamo(float importeTotal, int meses, float montoPagar, int idCuenta) {
		ConfigHibernate ch = new ConfigHibernate();
		UsuarioDao userDao = new UsuarioDao();
		TipoMovimientoDao TipoMovDao = new TipoMovimientoDao();
		Session session = ch.abrirConexion();
		CuentaDao cuentaDao = new CuentaDao(); 
		Movimiento nuevoMov = (Movimiento) appContext.getBean("BMovimiento");
		nuevoMov.setTipoMovimiento(TipoMovDao.buscarMovimiento(2));
		nuevoMov.setCbuOrigen(cuentaDao.buscarCuenta(idCuenta).getCbu());
		nuevoMov.setImporte(importeTotal);
		Usuario user = (Usuario) appContext.getBean("BUsuario");
		int IDUsuario = cuentaDao.buscarCuenta(idCuenta).getUsuario().getIdUsu();
		user = userDao.buscarUsuario(IDUsuario);
		
		Prestamo nuevo = (Prestamo) appContext.getBean("BPrestamo");
		nuevo.setImporteTotal(importeTotal);
		nuevo.setMontoPagar(montoPagar);
		nuevo.setCantidadMeses(meses);
		nuevo.setAutorizado(false);
		nuevo.setMovimiento(nuevoMov);
		nuevo.setUsuario(user);
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
	
}
