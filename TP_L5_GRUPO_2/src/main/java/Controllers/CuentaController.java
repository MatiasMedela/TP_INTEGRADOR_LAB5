package Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Negocio.CuentaNegocio;
import Dominio.Cuenta;

@Controller
public class CuentaController {

	private CuentaNegocio cuentaN;
	
	@RequestMapping("paginaCuentas.html")
	public ModelAndView cuentasUsuario() {
		ModelAndView MV = new ModelAndView();
		cuentaN = new CuentaNegocio();
		MV.addObject("listadoCuentasUsuario", cuentaN.datosCuentaBasic());
		MV.setViewName("index");
		return MV;
	}
	
}
