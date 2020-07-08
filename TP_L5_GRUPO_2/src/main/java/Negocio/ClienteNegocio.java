package Negocio;

import org.springframework.beans.factory.annotation.Autowired;

import AccesoDatos.ClienteDao;

public class ClienteNegocio {
	@Autowired
	private ClienteDao Clidao;
	
	//dni no repetido
	public boolean ValidarDNI(String dni) {
		if(Clidao.BuscarUsuarioXDni(dni).getDni().equals("default")) {
			return true;
		}else {
			return false;
		}
	}
}
