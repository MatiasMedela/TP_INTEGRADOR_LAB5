package AccesoDatos;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.EstadoPrestamo;
import Dominio.Movimiento;
import Dominio.Prestamo;
import Dominio.Usuario;

public class PrestamoDao {
	private ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
    HttpServletRequest request;
	public boolean cargarPrestamo(float importeTotal, int meses, float montoPagar, int idCuenta) {
		ConfigHibernate ch = new ConfigHibernate();
		UsuarioDao userDao = new UsuarioDao();
		Session session = ch.abrirConexion();
		CuentaDao cuentaDao = new CuentaDao(); 

		Usuario user = (Usuario) appContext.getBean("BUsuario");
		int IDUsuario = cuentaDao.buscarCuenta(idCuenta).getUsuario().getIdUsu();
		user = userDao.buscarUsuario(IDUsuario);
		
		EstadoPrestamo estado = (EstadoPrestamo) appContext.getBean("BEstadoPrestamo");
		estado.setId(0);
		estado.setDescripcion("No autorizado");
		
		Prestamo nuevo = (Prestamo) appContext.getBean("BPrestamo");
		nuevo.setImporteTotal(importeTotal);
		nuevo.setMontoPagar(montoPagar);
		nuevo.setCantidadMeses(meses);
		nuevo.setEstado(estado);
		nuevo.setUsuario(user);
		nuevo.setCbu(cuentaDao.buscarCuenta(idCuenta).getCbu());
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
