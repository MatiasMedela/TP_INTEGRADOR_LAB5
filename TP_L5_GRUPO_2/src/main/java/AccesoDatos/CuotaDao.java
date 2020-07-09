package AccesoDatos;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Cuota;
import Dominio.Movimiento;

@SuppressWarnings("unchecked")
public class CuotaDao {
	
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	
	@Autowired
	private TipoMovimientoDao tipoDao;
	
	@Autowired
	private CuentaDao cuentaDao;
	
	public List<Cuota> listarCuotas(int idPrestamo) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Cuota> listado = (List<Cuota>) session.createQuery("FROM Cuota as c where c.prestamo = " + idPrestamo).list();
    	ch.cerrarSession();
	    return listado;		
	}

	public boolean pagarCuota(int idCuota, int idCuenta) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		try {
			session.getTransaction().begin();
			Movimiento pagoCuota = (Movimiento) appContext.getBean("BMovimiento");
			
			Cuota cuota = (Cuota) session.createQuery("FROM Cuota c where c.numeroCuota = " + idCuota).uniqueResult();
			cuota.setPagada(true);
			cuota.setFechaPago(new Date());
			if(cuota.getPrestamo().getCbu().getIdCuenta() == idCuenta) {
				pagoCuota.setCuentaOrigen(cuota.getPrestamo().getCbu());				
			}
			else {
				pagoCuota.setCuentaOrigen((cuentaDao.buscarCuenta(idCuenta)));
			}
			pagoCuota.setFecha(new Date());
			pagoCuota.setImporte(cuota.getPrestamo().getMontoPagar()/cuota.getPrestamo().getCantidadMeses());
			pagoCuota.setMotivo("Pago de cuota - Prestamo N°" + cuota.getPrestamo().getIdPrestamo());
			pagoCuota.setTipoMovimiento(tipoDao.buscarMovimiento(3));
			session.save(pagoCuota);
			cuota.setMovimiento(pagoCuota);
			session.save(cuota);
			session.getTransaction().commit();
			cuentaDao.modificarSaldo(pagoCuota.getCuentaOrigen(), pagoCuota.getImporte()*-1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ch.cerrarSession();
		}
		return false;
	}	
}
