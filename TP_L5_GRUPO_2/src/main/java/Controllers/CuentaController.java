package Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Negocio.CuentaNegocio;
import Dominio.Cuenta;

@Controller
@RequestMapping("/")
public class CuentaController {

	private CuentaNegocio cuentaN;
	
	@RequestMapping(method=RequestMethod.GET)
	public String cuentasUsuario(@RequestParam("legusuario") String usuario, ModelMap modelo) {
		cuentaN = new CuentaNegocio();
		List<Cuenta> listadoCuentas = (List<Cuenta>)cuentaN.listar();
		modelo.addAttribute("testmvc", "Prueba paso de datos");
		modelo.addAttribute("listadoCuentasUsuario", listadoCuentas);
		return "TP_L5_GRUPO_2/index";
	}
	
}
