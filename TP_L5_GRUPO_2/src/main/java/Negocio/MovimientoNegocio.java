package Negocio;

import org.springframework.beans.factory.annotation.Autowired;

import AccesoDatos.MovimientoDao;

public class MovimientoNegocio {

	@Autowired
	private MovimientoDao movDao;
	
	public boolean nuevaTransferencia(int cuentaDestino, int cuentaOrigen, String importe, String motivo) {
	
		
		return true;
	}
	
}
