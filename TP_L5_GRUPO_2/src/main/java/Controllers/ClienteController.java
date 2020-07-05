package Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"ClienteNuevo"})
	public ModelAndView redirecAltaCliente() {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		MV.addObject("LocalidadesList", locdao.ListLocalidades());
		MV.setViewName("AltaCliente");
		return MV;
	}
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"ListarClientes"})
	public ModelAndView redirecListarClientes() {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		MV.addObject("ClientesList", Clidao.ListarClientes());
		MV.setViewName("ListarClientes");
		return MV;
	}
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"EliminarCliente"})
	public ModelAndView redirecEliminarCliente() {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		MV.addObject("LocalidadesList", locdao.ListLocalidades());
		MV.addObject("ClientesList", Clidao.ListarClientes());
		MV.setViewName("ModBajaCliente");
		return MV;
	}

	
	@RequestMapping("CargarCliente.html")
	public ModelAndView CargarCliente(String DniName,String NombreName,String ApeName,String NacName,
	String EmailName,String CmbProv,String DirName,String FechaNac,Integer CmbGen,String LocName,String CliTel) {
		ModelAndView MV=(ModelAndView) appContext.getBean("ModelView");
		try {
			Usuario Clie = (Usuario) appContext.getBean("BUsuario");
		
		//Validaciones
			//if(true) {
			Clie.setDni(DniName);
			Clie.setNombre(NombreName);
			Clie.setApellido(ApeName);
			Clie.setEmail(EmailName);
			Clie.setDireccion(DirName);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dateStr = null;
			try {dateStr = formatter.parse(FechaNac);} 
			catch (ParseException e) {e.printStackTrace();}
			java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
			Clie.setFechaNac(dateDB);
			Clie.setNacionalidad(NacName);
			Clie.setGen(Gdao.BuscarGeneroXId(CmbGen));
			String[] parts = LocName.split(",");
			Clie.setLoc(locdao.BuscarLocalidad(Integer.valueOf(parts[0])));
			Clie.setTel(CliTel);
			Clie.setTipoUsu(TusuDao.UserCliente());
			Clie.setEstado(true);
			if(Clidao.AltaCliente(Clie)==true) {
				LogueoDao ld=new LogueoDao();
				Logueo l=new Logueo();
				l.setUsuario(Clie);
				l.setContrasenia(DniName);
				l.setNUsuario(EmailName);
				ld.NuevoLog(l);
				MV.setViewName("AltaCliente");
			}
			else {
					//Error al dar de alta
					MV.setViewName("AltaCliente");
					System.out.println("error al dar de alta cliente");
			}
			//}
			return MV;
		} catch (Exception e) {
			e.printStackTrace();
			MV.setViewName("ListarClientes");
			return MV;
		}
	}
	@RequestMapping("ModificarCliente.html")
	public ModelAndView ModificarCliente(String DniEditName,String OldDniName,String NomEditName,String ApeEditName,String NacEditName,
			String EmailEditName,String ProvEditName,String DirEditName,String FnacEditName,Integer GenEditName,Integer LocEditName,String TelEditName) {
		ModelAndView MV=(ModelAndView) appContext.getBean("ModelView");
		try {
			Usuario Clie = (Usuario) appContext.getBean("BUsuario");
		//Validaciones
			//if(true) {
			Clie.setDni(DniEditName);
			Clie.setNombre(NomEditName);
			Clie.setApellido(ApeEditName);
			Clie.setEmail(EmailEditName);
			Clie.setDireccion(DirEditName);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dateStr = null;
			try {dateStr = formatter.parse(FnacEditName);} 
			catch (ParseException e) {e.printStackTrace();}
			java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
			Clie.setFechaNac(dateDB);
			Clie.setNacionalidad(NacEditName);
			Clie.setGen(Gdao.BuscarGeneroXId( GenEditName));
			Clie.setLoc(locdao.BuscarLocalidad(LocEditName));
			Clie.setTel(TelEditName);
			Clie.setTipoUsu(TusuDao.UserCliente());
			Clie.setEstado(true);
			if(Clidao.ModificarCliente(Clie,OldDniName) == true) {
				System.out.println("UPDATE EJECUTADO EXITOSAMENTE");
				MV.addObject("LocalidadesList", locdao.ListLocalidades());
				MV.addObject("ClientesList", Clidao.ListarClientes());
				MV.setViewName("ModBajaCliente");
			}
			else {
				//error al modificar cliente
				System.out.println("error al modificar cliente");
				MV.addObject("LocalidadesList", locdao.ListLocalidades());
				MV.addObject("ClientesList", Clidao.ListarClientes());
				MV.setViewName("ModBajaCliente");	
			}
			//}
			return MV;
		} catch (Exception e) {
			System.out.println("error al modificar cliente");
			e.printStackTrace();
			MV.addObject("ClientesList", Clidao.ListarClientes());
			MV.setViewName("ListarClientes");
			return MV;
		}
	}
	@RequestMapping("RedireccionarDarDeAltaCliente.html")
	public ModelAndView DarDeAltaCliente(String TxtAltaClientName) {
		ModelAndView MV=(ModelAndView) appContext.getBean("ModelView");
		try {
			if(Clidao.ModAltaCliente(TxtAltaClientName)==true) {
				MV.addObject("LocalidadesList", locdao.ListLocalidades());
				MV.addObject("ClientesList", Clidao.ListarClientes());
				MV.setViewName("ModBajaCliente");
			}
			else {
				//Error al dar de baja cliente
				System.out.println("error al dar de alta al cliente");
				MV.addObject("LocalidadesList", locdao.ListLocalidades());
				MV.addObject("ClientesList", Clidao.ListarClientes());
				MV.setViewName("ModBajaCliente");
			}
		} catch (Exception e) {
			e.printStackTrace();
			MV.addObject("LocalidadesList", locdao.ListLocalidades());
			MV.addObject("ClientesList", Clidao.ListarClientes());
			MV.setViewName("ModBajaCliente");
		}
		return MV;
	}
	@RequestMapping("RedireccionarDarDeBajaCliente.html")
	public ModelAndView DarDeBajaCliente(String TxtBajaClientName) {
		ModelAndView MV=(ModelAndView) appContext.getBean("ModelView");
		try {
			if(Clidao.BajaCliente(TxtBajaClientName)==true) {
				MV.addObject("LocalidadesList", locdao.ListLocalidades());
				MV.addObject("ClientesList", Clidao.ListarClientes());
				MV.setViewName("ModBajaCliente");
			}
			else {
				//Error al dar de baja cliente
				System.out.println("error al dar de baja al cliente");
				MV.addObject("LocalidadesList", locdao.ListLocalidades());
				MV.addObject("ClientesList",Clidao.ListarClientes());
				MV.setViewName("ModBajaCliente");
			}
		} catch (Exception e) {
			e.printStackTrace();
			MV.addObject("LocalidadesList", locdao.ListLocalidades());
			MV.addObject("ClientesList", Clidao.ListarClientes());
			MV.setViewName("ModBajaCliente");
		}
		return MV;
	}
}
