package Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Negocio.CuentaNegocio;

@Controller
public class CuentaController {

	private CuentaNegocio cuentaN;

	@RequestMapping(value="redirecNavBar.html", params = { "inicio" })
	public ModelAndView cuentasUsuario(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		cuentaN = new CuentaNegocio();
		String IDUsuario = request.getSession().getAttribute("IDUsuario").toString();
		MV.addObject("listadoCuentasUsuario", cuentaN.datosCuentaBasic(IDUsuario));		
		MV.setViewName("index");
		return MV;
	}

}
