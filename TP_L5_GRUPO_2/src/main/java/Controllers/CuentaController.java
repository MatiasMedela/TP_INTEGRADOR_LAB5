package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Negocio.CuentaNegocio;

@Controller
public class CuentaController {

	private CuentaNegocio cuentaN;

	@RequestMapping("paginaCuentas.html")
	public ModelAndView cuentasUsuario(String IDUsuario) {
		ModelAndView MV = new ModelAndView();
		cuentaN = new CuentaNegocio();
		MV.addObject("listadoCuentasUsuario", cuentaN.datosCuentaBasic(IDUsuario));		
		MV.setViewName("index");
		return MV;
	}

}
