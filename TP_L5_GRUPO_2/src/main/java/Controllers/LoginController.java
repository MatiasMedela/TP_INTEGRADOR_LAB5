package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import AccesoDatos.ClienteDao;
import AccesoDatos.LogueoDao;
import Negocio.LogueoNegocio;



@Controller
public class LoginController {
	@RequestMapping("VerificarLog.html")
	public ModelAndView RedireccionarLog(String LoginUser,String LoginKey) {
		try {
			ModelAndView MV = new ModelAndView();
			LogueoNegocio LN =new LogueoNegocio();
			MV.addObject("UserName", LoginUser);
			MV.addObject("Key", LoginKey);
			if (LN.validarLogin(LoginUser, LoginKey)==true) {
				ClienteDao CLDao=new ClienteDao();
				LogueoDao LogDao=new LogueoDao();
				if (CLDao.BuscarUsuarioXId(LogDao.BuscarLog(LoginUser, LoginKey).getUsuario().getIdUsu()).getTipoUsu().getIdTipoUsuario()== 1){
						MV.setViewName("ListarClientes");
				} else {
					MV.setViewName("index");
				}
			} else {
				MV.setViewName("Login");
			}
			return MV;
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView MV = new ModelAndView();
			MV.setViewName("ErrorCompilacion");
			return MV;
		}
	}
}
