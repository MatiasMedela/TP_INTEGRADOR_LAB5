package Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import AccesoDatos.CuentaDao;
import AccesoDatos.MovimientoDao;
import Negocio.CuentaNegocio;

@Controller
public class MovimientoController {

	@Autowired
	private MovimientoDao movN;
	
	@Autowired
	private CuentaDao cuentaDao;
	
	@RequestMapping("listarMovimientosCuenta.html")
	public ModelAndView redirecMovimientosCuenta(String CbuCuenta, String AliasCuenta) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("listadoMovimientos", movN.movimientosxCuenta(cuentaDao.buscarCuentaCBU(Double.parseDouble(CbuCuenta)).getIdCuenta()));
		MV.addObject("CBU", CbuCuenta);
		MV.addObject("Alias", AliasCuenta);
		MV.addObject("Tipo", cuentaDao.buscarCuentaCBU(Double.parseDouble(CbuCuenta)).getTipoCuenta().getDescripcion());
		MV.setViewName("ListarMovimientos");
		return MV;
	}

}
