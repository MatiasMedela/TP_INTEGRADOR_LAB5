package Negocio;

import java.util.List;

import org.hibernate.Session;

import AccesoDatos.ConfigHibernate;
import Dominio.Transferencia;

public class TransferenciaNegocio {

	public void add(Transferencia trans) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		session.save(trans);
		
		session.getTransaction().commit();
		ch.cerrarSession();
	}
	
	public List<Transferencia> listar() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		List<Transferencia> listado = (List<Transferencia>) session.createQuery("FROM Transferencia").list();
				
		ch.cerrarSession();
	    return listado;		
	}
	
	
}
