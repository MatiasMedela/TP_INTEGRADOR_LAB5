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
}
