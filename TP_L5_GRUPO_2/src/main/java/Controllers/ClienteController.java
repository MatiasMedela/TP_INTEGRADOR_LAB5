package Controllers;

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
	public ModelAndView RedireccionarLogin() {
		ModelAndView MV = new ModelAndView();
		LocalidadDao locdao= new LocalidadDao();
		MV.addObject("LocalidadesList", locdao.ListLocalidades());
		MV.setViewName("AltaCliente");
		return MV;
	}
	
	@RequestMapping(value="FormCagarCliente")
	public ModelAndView CargarCliente(String DniName,String NombreName,String ApeName,String NacName,
	String EmailName,String CmbProv,String DirName,Date FechaNac,Integer CmbGen,String LocName,String CliTel) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
		
		ModelAndView MV=new ModelAndView();
		ClienteDao cldao= new ClienteDao();
		Usuario Clie = (Usuario) appContext.getBean("BUsuario");
		GeneroDao Gdao= new GeneroDao();
		LocalidadDao LocDao= new LocalidadDao();
		TipoUsuarioDao TusuDao= new TipoUsuarioDao();
	
		//Validaciones
		//if(true) {
			if(cldao.AltaCliente(Clie)==true) {
				Clie.setDni(DniName);
				Clie.setNombre(NombreName);
				Clie.setApellido(ApeName);
				Clie.setEmail(EmailName);
				Clie.setDireccion(DirName);
				Clie.setFechaNac(FechaNac);
				Clie.setNacionalidad(NacName);
				Clie.setGen(Gdao.BuscarGeneroXId(CmbGen));
				Clie.setLoc(LocDao.BuscarLocalidad(LocName));
				Clie.setTel(CliTel);
				Clie.setTipoUsu(TusuDao.UserCliente());
				Clie.setEstado(true);
			}
			else {
				//Error al dar de alta
				System.out.println("error al dar de alta cliente");
			}
		//}
		MV.setViewName("Login");
		return MV;
	}
}
