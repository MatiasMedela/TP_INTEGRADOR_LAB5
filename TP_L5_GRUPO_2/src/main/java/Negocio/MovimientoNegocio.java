package Negocio;

import java.util.List;

import org.hibernate.Session;

import AccesoDatos.ConfigHibernate;

public class MovimientoNegocio {
	
	public List<Object[]> movimientosxUsuario(String legajoUsuario) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Object[]> listado = (List<Object[]>) session.createQuery("SELECT m, t.cbuDestino FROM Movimiento m, Cuenta c, Transferencia t "
																		+ "WHERE (c.usuario = " + legajoUsuario + " and (c.cbu = m.cbuOrigen OR t.movimiento = m.idMovimiento)) AND "
																		+ "(c.usuario = " + legajoUsuario + " AND t.cbuDestino in (SELECT c.cbu from Cuenta c where c.usuario = "+legajoUsuario+") AND "
																		+ "m.cbuOrigen <> t.cbuDestino) "
																		+ "group by m.idMovimiento").list();
		
    	ch.cerrarSession();
	    return listado;		
	}	

	public List<Object[]> movimientosxCuenta(String Cbu) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Object[]> listado = (List<Object[]>) session.createQuery("SELECT m, t.cbuDestino FROM Transferencia as t "
																	+ "RIGHT JOIN t.movimiento as m "
																	+ "WHERE m.cbuOrigen = '"+Cbu+"' OR t.cbuDestino = '"+Cbu+"' "
																	+ "order by m.Fecha desc").list();
		
    	ch.cerrarSession();
	    return listado;		
	}	

}
