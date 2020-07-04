package Controllers;

import java.util.ArrayList;

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
import Dominio.Cuenta;
import Dominio.Usuario;
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
		ModelAndView MV = new ModelAndView();
		String IDUsuario = request.getSession().getAttribute("IDUsuario").toString();
		MV.addObject("listadoCuentasUsuario", cuentaN.datosCuentaBasic(IDUsuario));		
		MV.setViewName("index");
		return MV;
	}
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"CuentaNueva"})
	public ModelAndView redirecCuentaNuevaAdmin() {
		ModelAndView MV = new ModelAndView();
		MV.addObject("listadoUsuarios", userDao.listarUsuarios());
		MV.addObject("listadoTipos", tcDao.listarTipos());
		MV.addObject("proxCBU", cuentaDao.proximoCBU());
		MV.setViewName("AltaCuenta");
		return MV;
	}
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"ListarCuentas"})
	public ModelAndView redirecListarCuentasAdmin() {
		ModelAndView MV = new ModelAndView();
		MV.addObject("listadoUsuarios", userDao.listarUsuarios());
		MV.addObject("listadoTipos", tcDao.listarTipos());
		MV.addObject("listadoCuentas", cuentaDao.listarCuentas());
		MV.setViewName("ListarCuentas");
		return MV;
	}
	
	@RequestMapping(value="borrarCuenta.html")
	public ModelAndView BorrarCuenta(String idCuenta) {
		ModelAndView MV = new ModelAndView();
		cuentaDao.cerrarCuenta(idCuenta);
		MV.setViewName("redirect:/redirecNavBarAdmin.html?ListarCuentas");
		return MV;
	}
	
	@RequestMapping(value="abrirCuenta.html")
	public ModelAndView AbrirCuenta(String idCuenta) {
		ModelAndView MV = new ModelAndView();
		cuentaDao.abrirCuenta(idCuenta);
		MV.setViewName("redirect:/redirecNavBarAdmin.html?ListarCuentas");
		return MV;
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
	
	

	@RequestMapping(value="cargarCuenta.html")
	public ModelAndView cargarCuenta(int cbxTipo, int clienteSeleccionado) {
		ModelAndView MV = new ModelAndView();
		cuentaDao.crearCuenta(cbxTipo, clienteSeleccionado);
		MV.setViewName("redirect:/redirecNavBarAdmin.html?ListarCuentas");
		return MV;
	}
	
	@RequestMapping(value="modificarCuenta.html")
	public ModelAndView modificarCuenta(String idCuentaM, int cbxTipo, float saldoM, int clienteSeleccionado) {
		ModelAndView MV = new ModelAndView();
		cuentaDao.modificarCuenta(idCuentaM, cbxTipo, saldoM, clienteSeleccionado);
		MV.setViewName("redirect:/redirecNavBarAdmin.html?ListarCuentas");
		return MV;
	}
	
}
