package AccesoDatos;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;

public class InformeDao {
	
		public ArrayList<String> informePrestamos(Date FechaInicio, Date FechaFinal) {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();				
			ArrayList<String> informe = new ArrayList<String>();
			String PresAutorizados = (String) session.createQuery("SELECT count(p) FROM Prestamo as p "
														+ "INNER JOIN p.movimiento as m "
														+ "WHERE p.autorizado = 1 AND m.Fecha between :stFecha AND :edFecha ")
														.setDate("stFecha", FechaInicio)
														.setDate("edFecha", FechaFinal).uniqueResult().toString();
			
			String PresNoAutorizados = (String) session.createQuery("SELECT count(p) FROM Prestamo as p "
																  + "INNER JOIN p.movimiento as m "
																  + "WHERE p.autorizado = 0 AND m.Fecha between :stFecha AND :edFecha ")
																  .setDate("stFecha", FechaInicio)
																  .setDate("edFecha", FechaFinal).uniqueResult().toString();
			informe.add(PresAutorizados);
			informe.add(PresNoAutorizados);
			ch.cerrarSession();
		 return informe;
		}
}
