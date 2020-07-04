package AccesoDatos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.EstadoPrestamo;
import Dominio.Prestamo;
import Dominio.Usuario;

@SuppressWarnings("unchecked")
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
		nuevo.setFechaSolicitud(new Date());
		nuevo.setEstado(estado);
		nuevo.setUsuario(user);
		nuevo.setCbu(cuentaDao.buscarCuenta(idCuenta));
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
	
}
