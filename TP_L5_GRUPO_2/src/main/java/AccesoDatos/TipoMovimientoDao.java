package AccesoDatos;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dominio.Tipo_Movimiento;
import Dominio.Tipo_Usuario;

public class TipoMovimientoDao {

	public Tipo_Movimiento buscarMovimiento(int idMovimiento) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		Tipo_Movimiento mov = (Tipo_Movimiento) appContext.getBean("BTipo_Movimiento");
		try {
			mov = (Tipo_Movimiento) session.createQuery("FROM Tipo_Movimiento as tc where tc.idTipoMovimiento = " + idMovimiento).uniqueResult();		
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			session.close();				
		}
	    return mov;
	}
}
