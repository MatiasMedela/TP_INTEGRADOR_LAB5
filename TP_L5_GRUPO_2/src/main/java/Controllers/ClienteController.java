package Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import AccesoDatos.ClienteDao;
import AccesoDatos.GeneroDao;
import AccesoDatos.LocalidadDao;
import AccesoDatos.LogueoDao;
import AccesoDatos.ProvinciaDao;
import AccesoDatos.TipoUsuarioDao;
import AccesoDatos.UsuarioDao;
import Dominio.Logueo;
import Dominio.Usuario;
import Negocio.ClienteNegocio;


@Controller
public class ClienteController {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	
	@Autowired
	private LocalidadDao locdao;
	@Autowired
	private ClienteDao Clidao;
	@Autowired
	private GeneroDao Gdao;
	@Autowired
	private TipoUsuarioDao TusuDao;
	@Autowired
	private UsuarioDao userDao;
	@Autowired
	private LogueoDao LogDao;
	@Autowired
	private ClienteNegocio CliNeg;
	@Autowired
	private ProvinciaDao provDao;
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"ClienteNuevo"})
	public ModelAndView redirecAltaCliente(HttpServletRequest request) {
		((ConfigurableApplicationContext)(appContext)).refresh();
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		try {
			if(request.getSession().getAttribute("IDUsuario") !=null) {
				String IDUsuario = request.getSession().getAttribute("IDUsuario").toString();
				Usuario user = userDao.buscarUsuario(IDUsuario);
				MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
				MV.addObject("ProvinciasList", provDao.ListProvincias());
				MV.addObject("LocalidadesList", locdao.ListLocalidades());
				MV.setViewName("AltaCliente");
			}
			else {
				MV.setViewName("Login");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			((ConfigurableApplicationContext)(appContext)).close();
		}
		return MV;
	}
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"ListarClientes"})
	public ModelAndView redirecListarClientes(HttpServletRequest request) {
		((ConfigurableApplicationContext)(appContext)).refresh();
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		try {
			if(request.getSession().getAttribute("IDUsuario") !=null) {			
				String IDUsuario = request.getSession().getAttribute("IDUsuario").toString();
				Usuario user = userDao.buscarUsuario(IDUsuario);
				MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
				MV.addObject("LocalidadesList", locdao.ListLocalidades());
				MV.addObject("ProvinciasList", provDao.ListProvincias());
				MV.addObject("ClientesList", Clidao.ListarClientes());
				MV.setViewName("ListarClientes");
			}
			else {
				MV.setViewName("Login");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			((ConfigurableApplicationContext)(appContext)).close();
		}
		return MV;
	}

	@RequestMapping(method = RequestMethod.POST, value="CargarClienteAsync.html")
	@ResponseBody
	public String CargarClienteAsync(String DniName,String NombreName,String ApeName,String NacName,
			String EmailName,String CmbProv,String DirName,String FechaNac,String CmbGen,String LocName,String CliTel) throws ParseException {
		try {
			((ConfigurableApplicationContext)(appContext)).refresh();
			if(DniName!="") {
				if (CliNeg.ValidarDNI(DniName)==true ) {
					Usuario Clie = (Usuario) appContext.getBean("BUsuario");
					Clie.setDni(DniName);
					Clie.setNombre(NombreName);
					Clie.setApellido(ApeName);
					Clie.setEmail(EmailName);
					Clie.setDireccion(DirName);
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Clie.setFechaNac(formatter.parse(FechaNac));
					Clie.setNacionalidad(NacName);
					Clie.setGen(Gdao.BuscarGeneroXId(Integer.valueOf(CmbGen)));
					String[] parts = LocName.split(",");
					Clie.setLoc(locdao.BuscarLocalidad(Integer.valueOf(parts[0])));
					Clie.setTel(CliTel);
					Clie.setTipoUsu(TusuDao.UserCliente());
					Clie.setEstado(true);
					if(Clidao.AltaCliente(Clie)==true) {
						Logueo l=(Logueo) appContext.getBean("BLogueo");
						l.setUsuario(Clie);
						l.setContrasenia(DniName);
						l.setNUsuario(EmailName);
						LogDao.NuevoLog(l);
						return new Gson().toJson("Valido");
						} else {
							return new Gson().toJson("Invalido");
							}
				} else {
					return new Gson().toJson("InvalidoDni");
				}
			}else {
				return new Gson().toJson("InvalidoDni");
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return new Gson().toJson("Invalido");
		}	
	}
	
	@RequestMapping(method = RequestMethod.POST, value="DarDeBajaClienteAsync.html")
	@ResponseBody
	public String DarDeBajaClienteAsync(String Dni) throws ParseException {
		if(Dni!="") {
			if (Clidao.BajaCliente(Dni)==true) {
				return new Gson().toJson("Valido");
			} else {
				return new Gson().toJson("Invalido");
			}
		}else {
			return new Gson().toJson("Invalido");
		}	
	}
	
	@RequestMapping(method = RequestMethod.POST, value="DarDeAltaClienteAsync.html")
	@ResponseBody
	public String DarDeAltaClienteAsync(String Dni) throws ParseException {
		if(Dni!="") {
			if (Clidao.ModAltaCliente(Dni)==true) {
				return new Gson().toJson("Valido");
			} else {
				return new Gson().toJson("Invalido");
			}
		}else {
			return new Gson().toJson("Invalido");
		}	
	}
	
	@RequestMapping(method = RequestMethod.POST, value="ModificarClienteAsync.html")
	@ResponseBody
	public String ModificarClienteAsync(String DniEditName,String OldDniName,String NomEditName,String ApeEditName,String NacEditName,
			String EmailEditName,String ProvEditName,String DirEditName,String FnacEditName,String GenEditName,String LocEditName,String TelEditName) throws ParseException {
		try {
			((ConfigurableApplicationContext)(appContext)).refresh();
			if(DniEditName!="") {
				if ((CliNeg.ValidarDNI(DniEditName) && !CliNeg.ValidarDNI(OldDniName)) || DniEditName.equals(OldDniName)) {
					Usuario Clie = Clidao.BuscarUsuarioXDni(OldDniName);
					Clie.setDni(DniEditName);
					Clie.setNombre(NomEditName);
					Clie.setApellido(ApeEditName);
					Clie.setEmail(EmailEditName);
					Clie.setDireccion(DirEditName);
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Clie.setFechaNac(formatter.parse(FnacEditName));
					Clie.setNacionalidad(NacEditName);
					Clie.setGen(Gdao.BuscarGeneroXId(Integer.valueOf(GenEditName)));
					String[] parts = LocEditName.split(",");
					Clie.setLoc(locdao.BuscarLocalidad(Integer.valueOf(parts[0])));
					Clie.setTel(TelEditName);
					if(Clie.getTipoUsu().getIdTipoUsuario() != 1) {
						Clie.setTipoUsu(TusuDao.UserCliente());						
					}
					Clie.setEstado(true);
					if(Clidao.ModificarCliente(Clie,OldDniName)==true) {
						//update de logueo?
						return new Gson().toJson("Valido");
						} else {
							return new Gson().toJson("Invalido");
							}
				} else {
					if((CliNeg.ValidarDNI(DniEditName)==true && CliNeg.ValidarDNI(OldDniName)==false)) {
						return new Gson().toJson("Valido");
					}else {
						return new Gson().toJson("InvalidoDni");
					}
				}
			}else {
				return new Gson().toJson("InvalidoDni");
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return new Gson().toJson("Invalido");
		}	
	}
}
