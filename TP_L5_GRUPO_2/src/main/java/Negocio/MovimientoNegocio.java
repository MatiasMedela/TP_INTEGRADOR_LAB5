package Negocio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import AccesoDatos.CuentaDao;
import AccesoDatos.MovimientoDao;
import AccesoDatos.TipoMovimientoDao;
import Dominio.Cuenta;
import Dominio.Movimiento;

public class MovimientoNegocio {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");

	@Autowired
	private MovimientoDao movDao;
	
	@Autowired
	private CuentaDao cuentaDao;
	
	@Autowired
	private TipoMovimientoDao tipoMovDao;
	
	public boolean nuevaTransferencia(int cuentaDestino, int cuentaOrigen, String importe, String motivo) {
		Movimiento nuevo = (Movimiento) appContext.getBean("BMovimiento");
		Cuenta cuentaO = cuentaDao.buscarCuenta(cuentaOrigen);
		Cuenta cuentaD = cuentaDao.buscarCuenta(cuentaDestino);
		nuevo.setCuentaOrigen(cuentaO);
		nuevo.setCuentaDestino(cuentaD);
		nuevo.setFecha(new Date());
		nuevo.setImporte(Float.parseFloat(importe));
		nuevo.setMotivo(motivo);
		nuevo.setTipoMovimiento(tipoMovDao.buscarMovimiento(4));
		try {
			movDao.agregarTransferencia(nuevo);
			cuentaDao.modificarSaldo(cuentaO, Float.parseFloat(importe)*-1);
			cuentaDao.modificarSaldo(cuentaD, Float.parseFloat(importe));
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
}
