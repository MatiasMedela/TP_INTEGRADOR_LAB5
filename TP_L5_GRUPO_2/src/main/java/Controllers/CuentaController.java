package Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import AccesoDatos.CuentaDao;
import AccesoDatos.TipoCuentaDao;
import AccesoDatos.UsuarioDao;
import Negocio.CuentaNegocio;

@Controller
public class CuentaController {

	private CuentaNegocio cuentaN;
	private CuentaDao cuentaD;

	@RequestMapping(value="redirecNavBar.html", params = { "inicio" })
	public ModelAndView cuentasUsuario(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		cuentaN = new CuentaNegocio();
		String IDUsuario = request.getSession().getAttribute("IDUsuario").toString();
		MV.addObject("listadoCuentasUsuario", cuentaN.datosCuentaBasic(IDUsuario));		
		MV.setViewName("index");
		return MV;
	}
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"CuentaNueva"})
	public ModelAndView redirecCuentaNuevaAdmin() {
		ModelAndView MV = new ModelAndView();
		UsuarioDao user = new UsuarioDao();
		TipoCuentaDao tc = new TipoCuentaDao();
		cuentaD = new CuentaDao();
		MV.addObject("listadoUsuarios", user.listarUsuarios());
		MV.addObject("listadoTipos", tc.listarTipos());
		MV.addObject("proxCBU", cuentaD.proximoCBU());
		MV.setViewName("AltaCuenta");
		return MV;
	}
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"ListarCuentas"})
	public ModelAndView redirecListarCuentasAdmin() {
		ModelAndView MV = new ModelAndView();
		cuentaD = new CuentaDao();
		MV.addObject("listadoCuentas", cuentaD.listarCuentas());
		MV.setViewName("ListarCuentas");
		return MV;
	}
	
	@RequestMapping(value="borrarCuenta.html")
	public ModelAndView BorrarCuenta(String idCuenta) {
		ModelAndView MV = new ModelAndView();
		cuentaD = new CuentaDao();
		cuentaD.cerrarCuenta(idCuenta);
		MV.setViewName("redirect:/redirecNavBarAdmin.html?ListarCuentas");
		return MV;
	}
	

}
