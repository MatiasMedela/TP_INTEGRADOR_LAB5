package Negocio;

import org.springframework.beans.factory.annotation.Autowired;

import AccesoDatos.LogueoDao;

public class LogueoNegocio {
	@Autowired
	private LogueoDao LogDao;
	
	public boolean validarLogin(String user, String pass) {
		try {
			if (LogDao.BuscarLog(user,pass).getNUsuario().equals("Default")) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean UserName(String modUserName, String userNameOld) {
		try {
			if (LogDao.BuscarLog(modUserName).getNUsuario().equals("Default") || LogDao.BuscarLog(modUserName).getNUsuario().equals(userNameOld) ) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean ValidaUserName(String usuername) {
		try {
			if(usuername!="") {
				if (LogDao.BuscarLog(usuername).getNUsuario().equals("Default")) {
					return false;
				} else {
					return true;
				}
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
