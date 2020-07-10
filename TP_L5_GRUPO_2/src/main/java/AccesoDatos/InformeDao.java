package AccesoDatos;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InformeDao {
	private ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	
	@Autowired
	private ConfigHibernate ch;
	
		public ArrayList<String> informePrestamos(Date FechaInicio, Date FechaFinal) {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();				
			ArrayList<String> informe = (ArrayList<String>) appContext.getBean("ArrayList");
			String PresAutorizados = (String) session.createQuery("SELECT count(p) FROM Prestamo as p "
														+ "WHERE p.estado = 1 AND p.fechaResolucion between :stFecha AND :edFecha ")
														.setDate("stFecha", FechaInicio)
														.setDate("edFecha", FechaFinal).uniqueResult().toString();
			
			String PresNoAutorizados = (String) session.createQuery("SELECT count(p) FROM Prestamo as p "
																  + "WHERE p.estado = 2 AND p.fechaResolucion between :stFecha AND :edFecha ")
																  .setDate("stFecha", FechaInicio)
																  .setDate("edFecha", FechaFinal).uniqueResult().toString();
			informe.add(PresAutorizados);
			informe.add(PresNoAutorizados);
			session.close();
		 return informe;
		}
}
