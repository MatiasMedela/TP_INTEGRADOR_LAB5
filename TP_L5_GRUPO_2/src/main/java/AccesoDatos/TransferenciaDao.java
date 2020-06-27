package AccesoDatos;

import java.util.ArrayList;

import org.hibernate.Session;

@SuppressWarnings("unchecked")
public class TransferenciaDao {
	public ArrayList<Object[]> transferenciasxMes(int yearSelect) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		ArrayList<Object[]> listado = null;
		try {	
			listado = (ArrayList<Object[]>) session.createQuery("SELECT month(m.Fecha), count(t.idTransferencia) FROM Transferencia t "
																		+ "inner join t.movimiento m "
																		+ "where year(m.Fecha) = :añoSelect "
																		+ "group by month(m.Fecha) "
																		+ "order by month(m.Fecha) asc")
																		.setInteger("añoSelect", yearSelect).list();
		}catch(Exception e){
			System.out.println(e.toString());
			return listado;
		}finally {
			ch.cerrarSession();			
		}
		
	    return listado;		
	}	
}
