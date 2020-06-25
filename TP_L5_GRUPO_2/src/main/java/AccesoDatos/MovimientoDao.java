package AccesoDatos;

import java.util.List;

import org.hibernate.Session;

public class MovimientoDao {
	
	public List<Object[]> movimientosxUsuario(String legajoUsuario) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

//		List<Movimiento> listado = (List<Movimiento>) session.createQuery("SELECT m FROM Movimiento m, Cuenta c WHERE c.cbu = m.cbuOrigen AND c.usuario = " + legajoUsuario).list();
		List<Object[]> listado = (List<Object[]>) session.createQuery("SELECT m, t.cbuDestino FROM Movimiento m, Cuenta c, Transferencia t "
		+ "WHERE (c.usuario = " + legajoUsuario + " and (c.cbu = m.cbuOrigen OR t.movimiento = m.idMovimiento)) AND "
		+ "(c.usuario = " + legajoUsuario + " AND t.cbuDestino in (SELECT c.cbu from Cuenta c where c.usuario = "+legajoUsuario+") AND "
		+ "m.cbuOrigen <> t.cbuDestino) "
		+ "group by m.idMovimiento").list();
		
    	ch.cerrarSession();
	    return listado;		
	}
}
