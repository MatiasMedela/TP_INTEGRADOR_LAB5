package Negocio;

import AccesoDatos.LogueoDao;

public class LogueoNegocio {

	public boolean validarLogin(String user, String pass) {
		try {
			LogueoDao LogDao=new LogueoDao();
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
			LogueoDao LogDao=new LogueoDao();
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
}
