package Controllers;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
	
ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	
	@Autowired
	private ClienteDao Clidao;
	@Autowired
	private LogueoDao LogDao;
	@Autowired
	private LogueoNegocio LN;

	
	@RequestMapping("VerificarLog.html")
	public ModelAndView RedireccionarLog(String LoginUser,String LoginKey, HttpServletRequest request) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		try {
			if (LN.validarLogin(LoginUser, LoginKey)==true) {
				Logueo User =  LogDao.BuscarLog(LoginUser, LoginKey);
				request.getSession().setAttribute("IDUsuario", User.getUsuario().getIdUsu()); 
	            MV.addObject("NomApeUser",User.getUsuario().getNombre()+", "+User.getUsuario().getApellido());
	            request.getSession().setAttribute("NameUser", LoginUser);
	            request.getSession().setAttribute("Key", LoginKey);
				if (User.getUsuario().getTipoUsu().getIdTipoUsuario()== 1){	
					MV.addObject("ClientesList", Clidao.ListarClientes());
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
			MV.setViewName("ErrorCompilacion");
		}
		return MV;
	}
	
	@RequestMapping("ModificarLog.html")
	public ModelAndView ModificarLog(String ModUserName,String ModKey,String UserNameOld,String KeyOld) {
		ModelAndView MV=(ModelAndView) appContext.getBean("ModelView");
		try {
		Logueo Log = (Logueo) appContext.getBean("BLogueo");
	//Validaciones
		if(LN.UserName(ModUserName,UserNameOld)==true) {
			Log.setIdLogueo(LogDao.BuscarLog(UserNameOld, KeyOld).getIdLogueo());
			Log.setNUsuario(ModUserName);
			Log.setContrasenia(ModKey);
			Log.setUsuario(LogDao.BuscarLog(UserNameOld, KeyOld).getUsuario());
			if(LogDao.ModLogueo(Log) == true) {
				System.out.println("UPDATE EJECUTADO EXITOSAMENTE");
				MV.setViewName("Login");
			}
				else {
					//error al modificar cliente
					System.out.println("error al modificar cliente");
					MV.setViewName("ListarClientes");
					
				}
		}else {
			MV.setViewName("ListarClientes");
		}
		return MV;
		} catch (Exception e) {
			System.out.println("error al modificar excep  cliente");
			e.printStackTrace();
			return MV;
		}
	}
	@RequestMapping("CerrarSession.html")
	public ModelAndView CerrarSession(HttpServletRequest request , ServletRequest session) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		MV.setViewName("Login");
		return MV;
	}
	
}
