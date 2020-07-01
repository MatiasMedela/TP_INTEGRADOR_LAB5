package Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.org.apache.bcel.internal.generic.NEW;

import AccesoDatos.ClienteDao;
import AccesoDatos.GeneroDao;
import AccesoDatos.LocalidadDao;
import AccesoDatos.TipoUsuarioDao;
import Dominio.Localidad;
import Dominio.Usuario;


@Controller
public class ClienteController {
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"ClienteNuevo"})
	public ModelAndView redirecAltaCliente() {
		ModelAndView MV = new ModelAndView();
		LocalidadDao locdao= new LocalidadDao();
		MV.addObject("LocalidadesList", locdao.ListLocalidades());
		MV.setViewName("AltaCliente");
		return MV;
	}
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"ListarClientes"})
	public ModelAndView redirecListarClientes() {
		ModelAndView MV = new ModelAndView();
		ClienteDao Clidao= new ClienteDao();
		MV.addObject("ClientesList", Clidao.ListarClientes());
		MV.setViewName("ListarClientes");
		return MV;
	}
	
	@RequestMapping(value="redireccListarClientes.html")
	public ModelAndView redireccListarClientes() {
		ModelAndView MV = new ModelAndView();
		ClienteDao Clidao= new ClienteDao();
		MV.addObject("ClientesList", Clidao.ListarClientes());
		MV.setViewName("ListarClientes");
		return MV;
	}
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"EliminarCliente"})
	public ModelAndView redirecEliminarCliente() {
		ModelAndView MV = new ModelAndView();
		ClienteDao Clidao= new ClienteDao();
		LocalidadDao locdao= new LocalidadDao();
		MV.addObject("LocalidadesList", locdao.ListLocalidades());
		MV.addObject("ClientesList", Clidao.ListarClientes());
		MV.setViewName("ModBajaCliente");
		return MV;
	}

	
	@RequestMapping("CargarCliente.html")
	public ModelAndView CargarCliente(String DniName,String NombreName,String ApeName,String NacName,
	String EmailName,String CmbProv,String DirName,String FechaNac,Integer CmbGen,Integer LocName,String CliTel) {
		ModelAndView MV=new ModelAndView();
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
			ClienteDao cldao= new ClienteDao();
			Usuario Clie = (Usuario) appContext.getBean("BUsuario");
			GeneroDao Gdao= new GeneroDao();
			LocalidadDao LocDao= new LocalidadDao();
			TipoUsuarioDao TusuDao= new TipoUsuarioDao();
		
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
			Clie.setLoc(LocDao.BuscarLocalidad(LocName));
			Clie.setTel(CliTel);
			Clie.setTipoUsu(TusuDao.UserCliente());
			Clie.setEstado(true);
			if(cldao.AltaCliente(Clie)==true) {
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
		ModelAndView MV=new ModelAndView();
		ClienteDao cldao= new ClienteDao();
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
			Usuario Clie = (Usuario) appContext.getBean("BUsuario");
			GeneroDao Gdao= new GeneroDao();
			LocalidadDao LocDao= new LocalidadDao();
			TipoUsuarioDao TusuDao= new TipoUsuarioDao();
		System.out.println("llegue");
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
			Clie.setLoc(LocDao.BuscarLocalidad(LocEditName));
			Clie.setTel(TelEditName);
			Clie.setTipoUsu(TusuDao.UserCliente());
			Clie.setEstado(true);
			if(cldao.ModificarCliente(Clie,OldDniName) == true) {
				System.out.println("UPDATE EJECUTADO EXITOSAMENTE");
				MV.addObject("LocalidadesList", LocDao.ListLocalidades());
				MV.addObject("ClientesList", cldao.ListarClientes());
				MV.setViewName("ModBajaCliente");
			}
			else {
				//error al modificar cliente
				System.out.println("error al modificar cliente");
				MV.addObject("LocalidadesList", LocDao.ListLocalidades());
				MV.addObject("ClientesList", cldao.ListarClientes());
				MV.setViewName("ModBajaCliente");
				
			}
			//}
			return MV;
		} catch (Exception e) {
			System.out.println("error al modificar cliente");
			e.printStackTrace();
			MV.addObject("ClientesList", cldao.ListarClientes());
			MV.setViewName("ListarClientes");
			return MV;
		}
	}
	@RequestMapping("RedireccionarDarDeAltaCliente.html")
	public ModelAndView DarDeAltaCliente(String TxtAltaClientName) {
		ModelAndView MV=new ModelAndView();
		ClienteDao cldao= new ClienteDao();
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
			Usuario Clie = (Usuario) appContext.getBean("BUsuario");
			System.out.println(TxtAltaClientName);
			if(cldao.ModAltaCliente(TxtAltaClientName)==true) {
				LocalidadDao l =new LocalidadDao();
				MV.addObject("LocalidadesList", l.ListLocalidades());
				MV.addObject("ClientesList", cldao.ListarClientes());
				MV.setViewName("ModBajaCliente");
			}
			else {
				//Error al dar de baja cliente
				System.out.println("error al dar de alta al cliente");
				LocalidadDao l =new LocalidadDao();
				MV.addObject("LocalidadesList", l.ListLocalidades());
				MV.addObject("ClientesList", cldao.ListarClientes());
				MV.setViewName("ModBajaCliente");
			}
		} catch (Exception e) {
			e.printStackTrace();
			LocalidadDao l =new LocalidadDao();
			MV.addObject("LocalidadesList", l.ListLocalidades());
			MV.addObject("ClientesList", cldao.ListarClientes());
			MV.setViewName("ModBajaCliente");
		}
		return MV;
	}
	@RequestMapping("RedireccionarDarDeBajaCliente.html")
	public ModelAndView DarDeBajaCliente(String TxtBajaClientName) {
		ModelAndView MV=new ModelAndView();
		ClienteDao cldao= new ClienteDao();
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
			Usuario Clie = (Usuario) appContext.getBean("BUsuario");
			System.out.println(TxtBajaClientName);
			if(cldao.BajaCliente(TxtBajaClientName)==true) {
				LocalidadDao l =new LocalidadDao();
				MV.addObject("LocalidadesList", l.ListLocalidades());
				MV.addObject("ClientesList", cldao.ListarClientes());
				MV.setViewName("ModBajaCliente");
			}
			else {
				//Error al dar de baja cliente
				System.out.println("error al dar de baja al cliente");
				LocalidadDao l =new LocalidadDao();
				MV.addObject("LocalidadesList", l.ListLocalidades());
				MV.addObject("ClientesList", cldao.ListarClientes());
				MV.setViewName("ModBajaCliente");
			}
		} catch (Exception e) {
			e.printStackTrace();
			LocalidadDao l =new LocalidadDao();
			MV.addObject("LocalidadesList", l.ListLocalidades());
			MV.addObject("ClientesList", cldao.ListarClientes());
			MV.setViewName("ModBajaCliente");
		}
		return MV;
	}
}
