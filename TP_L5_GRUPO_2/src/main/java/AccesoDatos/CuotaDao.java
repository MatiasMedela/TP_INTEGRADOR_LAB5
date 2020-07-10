package AccesoDatos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;
import java.time.Month;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Cuota;
import Dominio.Movimiento;
import Dominio.Prestamo;

@SuppressWarnings("unchecked")
public class CuotaDao {
	
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	
	@Autowired
	private PrestamoDao pDao;
	
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
	
	public void crearCuotas (int idPrestamo)
	{
		try
		{
		Date d = new Date();
		Calendar c = new GregorianCalendar(); 
		c.setTime(d);
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		Prestamo p = pDao.buscarPrestamo(idPrestamo);
		int dia = c.get(Calendar.DAY_OF_MONTH);
		int anio = c.get(Calendar.YEAR);
		
		
    	for(int x = c.get(Calendar.MONTH)+1 ; x<(c.get(Calendar.MONTH)+1+p.getCantidadMeses()); x++) {
    		
    		Cuota cuota = (Cuota) appContext.getBean("BCuota");
    		cuota.setPrestamo(p);
    		
    		if (x+1 < 12)
    		{
    		
    		if (dia > 28 && ((x+1)==2))
    		{
    		cuota.setFechaVencimiento(format.parse(anio+"-0" + (x+1) + "-"+ 28 +" 00:00:00"));    			
    		}
    		else if (dia > 30 && ((x+1)==4 ||(x+1)==6 ||(x+1)==9 ||(x+1)==11))
    		{
        		cuota.setFechaVencimiento(format.parse(anio+"-0" + (x+1) + "-"+ 30 +" 00:00:00"));	
    		}
    		else
    		{
    		cuota.setFechaVencimiento(format.parse(anio+"-0" + (x+1) + "-"+ dia +" 00:00:00"));
    		}
    		
    		}
    		
    		else
    		
    		{
    			int cant=0;
    			int y=0;
    			cant = (x+1) / 12; 
    			y = x - (cant * 12);
    			
        		if (dia > 28 && ((x+1)==2))
        		{
        		cuota.setFechaVencimiento(format.parse((anio+cant)+"-0" + (y+1) + "-"+ 28 +" 00:00:00"));    			
        		}
        		else if (dia > 30 && ((x+1)==4 ||(x+1)==6 ||(x+1)==9 ||(y+1)==11))
        		{
            		cuota.setFechaVencimiento(format.parse((anio+cant)+"-0" + (y+1) + "-"+ 30 +" 00:00:00"));	
        		}
        		else
        		{
        		cuota.setFechaVencimiento(format.parse((anio+cant)+"-0" + (y+1) + "-"+ dia +" 00:00:00"));
        		}
    			
    		}
    		
    		cuota.setPagada(false);
    		cuota.setMovimiento(null);
    		session.save(cuota);

    	
    	}
    	
		session.getTransaction().commit();
		ch.cerrarSession();
	}
		catch(ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
	
}
}
