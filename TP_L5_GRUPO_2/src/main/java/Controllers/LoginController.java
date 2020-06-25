package Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import AccesoDatos.ClienteDao;
import AccesoDatos.LogueoDao;
import Dominio.Logueo;
import Negocio.LogueoNegocio;

@Controller
@Scope("session")
public class LoginController {
	@RequestMapping("VerificarLog.html")
	public ModelAndView RedireccionarLog(String LoginUser,String LoginKey, HttpServletRequest request) {
		try {
			ModelAndView MV = new ModelAndView();
			LogueoNegocio LN =new LogueoNegocio();
			if (LN.validarLogin(LoginUser, LoginKey)==true) {
				ClienteDao CLDao=new ClienteDao();
				LogueoDao LogDao=new LogueoDao();
				Logueo User =  LogDao.BuscarLog(LoginUser, LoginKey);
				request.getSession().setAttribute("IDUsuario", User.getUsuario().getIdUsu());
				if (CLDao.BuscarUsuarioXId(LogDao.BuscarLog(LoginUser, LoginKey).getUsuario().getIdUsu()).getTipoUsu().getIdTipoUsuario()== 1){	
					MV.setViewName("ListarClientes");
				} else {
					MV.setViewName("redirect:/redirecNavBar.html?inicio");
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
