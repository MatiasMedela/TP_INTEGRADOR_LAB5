package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Negocio.CuentaNegocio;
import Negocio.MovimientoNegocio;

@Controller
public class CuentaController {

	private CuentaNegocio cuentaN;
	private MovimientoNegocio movN;

	@RequestMapping("paginaCuentas.html")
	public ModelAndView cuentasUsuario(String IDUsuario) {
		ModelAndView MV = new ModelAndView();
		cuentaN = new CuentaNegocio();
		MV.addObject("listadoCuentasUsuario", cuentaN.datosCuentaBasic(IDUsuario));		
		MV.setViewName("index");
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
