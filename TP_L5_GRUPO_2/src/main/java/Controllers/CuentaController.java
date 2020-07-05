package Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import AccesoDatos.CuentaDao;
import AccesoDatos.TipoCuentaDao;
import AccesoDatos.UsuarioDao;
import Negocio.CuentaNegocio;

@Controller
public class CuentaController {

	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	@Autowired
	private CuentaNegocio cuentaN;
	
	@Autowired
	private CuentaDao cuentaDao;
	
	@Autowired
	private UsuarioDao userDao;

	@Autowired
	private TipoCuentaDao tcDao;
	
	@RequestMapping(value="redirecNavBar.html", params = { "inicio" })
	public ModelAndView cuentasUsuario(HttpServletRequest request) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		String IDUsuario = request.getSession().getAttribute("IDUsuario").toString();
		MV.addObject("listadoCuentasUsuario", cuentaN.datosCuentaBasic(IDUsuario));		
		MV.setViewName("index");
		return MV;
	}
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"CuentaNueva"})
	public ModelAndView redirecCuentaNuevaAdmin() {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		MV.addObject("listadoUsuarios", userDao.listarUsuarios());
		MV.addObject("listadoTipos", tcDao.listarTipos());
		MV.addObject("proxCBU", cuentaDao.proximoCBU());
		MV.addObject("proxAlias", cuentaDao.generarAlias());
		MV.setViewName("AltaCuenta");
		return MV;
	}
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"ListarCuentas"})
	public ModelAndView redirecListarCuentasAdmin() {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		MV.addObject("listadoUsuarios", userDao.listarUsuarios());
		MV.addObject("listadoTipos", tcDao.listarTipos());
		MV.addObject("listadoCuentas", cuentaDao.listarCuentas());
		MV.setViewName("ListarCuentas");
		return MV;
	}
	
	@RequestMapping(value="borrarCuenta.html")
	public ModelAndView BorrarCuenta(String idCuenta) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		cuentaDao.cerrarCuenta(idCuenta);
		MV.setViewName("redirect:/redirecNavBarAdmin.html?ListarCuentas");
		return MV;
	}
	
	@RequestMapping(value="abrirCuenta.html")
	public ModelAndView AbrirCuenta(String idCuenta) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		cuentaDao.abrirCuenta(idCuenta);
		MV.setViewName("redirect:/redirecNavBarAdmin.html?ListarCuentas");
		return MV;
	}

	@RequestMapping(value="cargarCuenta.html")
	public ModelAndView cargarCuenta(int cbxTipo, int clienteSeleccionado, String aliasCuenta) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		cuentaDao.crearCuenta(cbxTipo, clienteSeleccionado, aliasCuenta);
		MV.setViewName("redirect:/redirecNavBarAdmin.html?ListarCuentas");
		return MV;
	}
	
	@RequestMapping(value="modificarCuenta.html")
	public ModelAndView modificarCuenta(String idCuentaM, int cbxTipo, float saldoM, int clienteSeleccionado) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		cuentaDao.modificarCuenta(idCuentaM, cbxTipo, saldoM, clienteSeleccionado);
		MV.setViewName("redirect:/redirecNavBarAdmin.html?ListarCuentas");
		return MV;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="cantidadCuentas.html")
	@ResponseBody
	public String cantidadCuentas(String dniCliente) {
		Long cantidad = userDao.cantidadCuentas(dniCliente);
		return new Gson().toJson(cantidad.toString());
	}
	
	@RequestMapping(method = RequestMethod.POST, value="abrirCuentaAsync.html")
	@ResponseBody
	public String abrirCuentaAsync(String idCuenta) {
		if(cuentaDao.abrirCuenta(idCuenta)) {
			return new Gson().toJson("Exitoso");			
		}
		else {
			return new Gson().toJson("Error");	
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value="cerrarCuentaAsync.html")
	@ResponseBody
	public String cerrarCuentaAsync(String idCuenta) {
		if(cuentaDao.cerrarCuenta(idCuenta)) {
			return new Gson().toJson("Exitoso");			
		}
		else {
			return new Gson().toJson("Error");	
		}
	}	
	
	@RequestMapping(method = RequestMethod.POST, value="crearCuentaAsync.html")
	@ResponseBody
	public String crearCuentaAsync(String tipoCuenta, String dniCliente, String alias) {
		if(cuentaDao.crearCuenta(Integer.parseInt(tipoCuenta), Integer.parseInt(dniCliente), alias)) {
			return new Gson().toJson("Exitoso");			
		}
		else {
			return new Gson().toJson("Error");	
		}
	}
}
