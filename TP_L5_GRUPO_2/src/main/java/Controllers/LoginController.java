package Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import AccesoDatos.ClienteDao;
import AccesoDatos.GeneroDao;
import AccesoDatos.LocalidadDao;
import AccesoDatos.LogueoDao;
import AccesoDatos.TipoUsuarioDao;
import Dominio.Logueo;
import Dominio.Usuario;
import Negocio.LogueoNegocio;

@Controller
@Scope("session")
public class LoginController {
	@RequestMapping("VerificarLog.html")
	public ModelAndView RedireccionarLog(String LoginUser,String LoginKey, HttpServletRequest request , ServletRequest session) {
		ModelAndView MV = new ModelAndView();
		LogueoNegocio LN =new LogueoNegocio();
		try {
			if (LN.validarLogin(LoginUser, LoginKey)==true) {
				ClienteDao CLDao=new ClienteDao();
				LogueoDao LogDao=new LogueoDao();
				Logueo User =  LogDao.BuscarLog(LoginUser, LoginKey);
				request.getSession().setAttribute("IDUsuario", User.getUsuario().getIdUsu()); 
	            session.setAttribute("NomApeUser",CLDao.BuscarUsuarioXIdLog(User).getNombre()+", "+CLDao.BuscarUsuarioXIdLog(User).getApellido());
	            session.setAttribute("NameUser", LoginUser);
	            session.setAttribute("Key", LoginKey);
				if (CLDao.BuscarUsuarioXId(LogDao.BuscarLog(LoginUser, LoginKey).getUsuario().getIdUsu()).getTipoUsu().getIdTipoUsuario()== 1){	
					MV.addObject("ClientesList", CLDao.ListarClientes());
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
			MV.setViewName("ErrorCompilacion");
		}
		return MV;
	}
	
	@RequestMapping("ModificarLog.html")
	public ModelAndView ModificarLog(String ModUserName,String ModKey,String UserNameOld,String KeyOld) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
		ModelAndView MV=new ModelAndView();
		LogueoDao Ldao= new LogueoDao();
		LogueoNegocio LN =new LogueoNegocio();
		try {
		Logueo Log = (Logueo) appContext.getBean("BLogueo");
	//Validaciones
		if(LN.UserName(ModUserName,UserNameOld)==true) {
			Log.setIdLogueo(Ldao.BuscarLog(UserNameOld, KeyOld).getIdLogueo());
			Log.setNUsuario(ModUserName);
			Log.setContrasenia(ModKey);
			Log.setUsuario(Ldao.BuscarLog(UserNameOld, KeyOld).getUsuario());
			if(Ldao.ModLogueo(Log) == true) {
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
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Login");
		return MV;
	}
	
}
