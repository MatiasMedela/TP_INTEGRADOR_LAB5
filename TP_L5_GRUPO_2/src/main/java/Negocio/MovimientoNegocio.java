package Negocio;

import java.util.List;

import org.hibernate.Session;

import AccesoDatos.ConfigHibernate;
import Dominio.Movimiento;

public class MovimientoNegocio {
	
	public List<Movimiento> movimientosCuenta(String legajoUsuario) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		List<Movimiento> listado = (List<Movimiento>) session.createQuery("SELECT m FROM Movimiento m, Cuenta c WHERE c.cbu = m.cbuOrigen AND c.usuario = " + legajoUsuario).list();
		
    	ch.cerrarSession();
	    return listado;		
	}	
}
