package Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Dominio.Movimiento;
import Negocio.CuentaNegocio;
import Negocio.LogueoNegocio;
import Negocio.MovimientoNegocio;

@Controller
public class CuentaController {

	private CuentaNegocio cuentaN;
	private LogueoNegocio loginN;
	private MovimientoNegocio movN;

	@RequestMapping("paginaCuentas.html")
	public ModelAndView cuentasUsuario(String LoginUser, String LoginKey) {
		ModelAndView MV = new ModelAndView();
		cuentaN = new CuentaNegocio();
		loginN = new LogueoNegocio();
		movN = new MovimientoNegocio();
		String IDUsuario = loginN.validarLogin(LoginUser, LoginKey);
		if (!IDUsuario.equals("-1")) {
			MV.addObject("listadoCuentasUsuario", cuentaN.datosCuentaBasic(IDUsuario));
			MV.addObject("movimientosUsuario", movN.movimientosxUsuario(IDUsuario));			
			MV.setViewName("index");
		} else {
			MV.setViewName("Login");
		}
		return MV;
	}
	
	@RequestMapping("listarMovimientosCuenta.html")
	public ModelAndView redirecMovimientosCuenta(String CbuCuenta) {
		ModelAndView MV = new ModelAndView();
		cuentaN = new CuentaNegocio();
		movN = new MovimientoNegocio();
		MV.addObject("listadoMovimientos", movN.movimientosxCuenta(CbuCuenta));
		MV.addObject("CBU", CbuCuenta);
		MV.addObject("Alias", "TestAlias");
		MV.setViewName("ListarMovimientos");
		return MV;
	}

}
