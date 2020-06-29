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
		ModelAndView MV = new ModelAndView();
		LogueoNegocio LN =new LogueoNegocio();
		try {
			if (LN.validarLogin(LoginUser, LoginKey)==true) {
				ClienteDao CLDao=new ClienteDao();
				LogueoDao LogDao=new LogueoDao();
				Logueo User =  LogDao.BuscarLog(LoginUser, LoginKey);
				request.getSession().setAttribute("IDUsuario", User.getUsuario().getIdUsu());
				if (CLDao.BuscarUsuarioXId(LogDao.BuscarLog(LoginUser, LoginKey).getUsuario().getIdUsu()).getTipoUsu().getIdTipoUsuario()== 1){	
					ClienteDao Clidao= new ClienteDao();
					MV.addObject("ClientesList", Clidao.ListarClientes());
					MV.setViewName("ListarClientes");
				} else {
					MV.addObject("NombreDelUsuario", User.getUsuario().getApellido());
					MV.setViewName("redirect:/redirecNavBar.html?inicio");
				}
			} else {
				MV.setViewName("Login");
			}
			return MV;
		} catch (Exception e) {
			e.printStackTrace();
			MV.setViewName("ErrorCompilacion");
		}
		return MV;
	}
}
