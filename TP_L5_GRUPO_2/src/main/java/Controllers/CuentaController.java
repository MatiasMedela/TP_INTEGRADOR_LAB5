package Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
			MV.addObject("movimientosCuentas", movN.movimientosCuenta(IDUsuario));
			
			List<Movimiento> listado = movN.movimientosCuenta(IDUsuario);
			for (Movimiento movimiento : listado) {
				movimiento.toString();
			}
			
			MV.setViewName("index");
		} else {
			MV.setViewName("Login");
		}
		return MV;
	}

}
