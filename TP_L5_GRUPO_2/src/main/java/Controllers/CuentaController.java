package Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Negocio.CuentaNegocio;
import Dominio.Cuenta;

@Controller
@RequestMapping("/")
public class CuentaController {

	private CuentaNegocio cuentaN;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView cuentasUsuario(@RequestParam("legusuario") String usuario) {
		cuentaN = new CuentaNegocio();
		List<Cuenta> listadoCuentas = (List<Cuenta>)cuentaN.listar();
		ModelAndView modelo = new ModelAndView("index");
		modelo.addObject("listadoCuentasUsuario", listadoCuentas);
		return modelo;
	}
	
}
