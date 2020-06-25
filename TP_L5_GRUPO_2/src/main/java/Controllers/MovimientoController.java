package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import AccesoDatos.MovimientoDao;
import Negocio.CuentaNegocio;

@Controller
public class MovimientoController {

	private MovimientoDao movN;
	
	@RequestMapping("listarMovimientosCuenta.html")
	public ModelAndView redirecMovimientosCuenta(String CbuCuenta, String AliasCuenta) {
		ModelAndView MV = new ModelAndView();
		movN = new MovimientoDao();
		MV.addObject("listadoMovimientos", movN.movimientosxCuenta(CbuCuenta));
		MV.addObject("CBU", CbuCuenta);
		MV.addObject("Alias", AliasCuenta);
		MV.setViewName("ListarMovimientos");
		return MV;
	}

}
