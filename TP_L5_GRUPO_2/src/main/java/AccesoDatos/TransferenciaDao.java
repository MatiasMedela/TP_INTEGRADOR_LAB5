package AccesoDatos;

import java.util.ArrayList;
import java.util.Formatter;

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
	
	public ArrayList<Object[]> transferenciasxUsuario(int IDUsuario) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		ArrayList<Object[]> listado = null;
		try {	
			listado = (ArrayList<Object[]>) session.createQuery("SELECT DATE_FORMAT(m.Fecha,'%d/%c/%Y'), m.cbuOrigen, t.cbuDestino, m.importe FROM Transferencia t "
																		+ "inner join t.movimiento m "
																		+ "where m.cbuOrigen in (FROM Cuenta c where c.usuario = :IDUser) "
																		+ "OR t.cbuDestino in (FROM Cuenta c where c.usuario = :IDUser)")
																		.setInteger("IDUser", IDUsuario).list();
			for (Object[] transf : listado) {
				Formatter fmt = new Formatter();
				transf[1] = transf[1].toString().substring(0,transf[1].toString().length()-2);
				transf[2] = transf[2].toString().substring(0,transf[2].toString().length()-2);
				fmt.format("%022d", Integer.parseInt( transf[1].toString()));	
				transf[1] = fmt;
				fmt = new Formatter();
				fmt.format("%022d", Integer.parseInt(transf[2].toString()));	
				transf[2] = fmt;
			}
		}catch(Exception e){
			System.out.println(e.toString());
			return listado;
		}finally {
			ch.cerrarSession();			
		}
		
	    return listado;		
	}
}
