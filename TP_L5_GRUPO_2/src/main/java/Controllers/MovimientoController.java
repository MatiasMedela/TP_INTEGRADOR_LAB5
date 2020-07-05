package Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import AccesoDatos.CuentaDao;
import AccesoDatos.MovimientoDao;
import AccesoDatos.UsuarioDao;
import Dominio.Usuario;
import Negocio.CuentaNegocio;

@Controller
public class MovimientoController {

	@Autowired
	private MovimientoDao movN;
	
	@Autowired
	private CuentaDao cuentaDao;
	
	@Autowired
	private UsuarioDao userDao;
	
	@RequestMapping("listarMovimientosCuenta.html")
	public ModelAndView redirecMovimientosCuenta(String CbuCuenta, String AliasCuenta, HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		if(request.getSession().getAttribute("IDUsuario") !=null) {			
			String IDUsuario = request.getSession().getAttribute("IDUsuario").toString();
			Usuario user = userDao.buscarUsuario(IDUsuario);
			MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
			MV.addObject("listadoMovimientos", movN.movimientosxCuenta(cuentaDao.buscarCuentaCBU(Double.parseDouble(CbuCuenta)).getIdCuenta()));
			MV.addObject("CBU", CbuCuenta);
			MV.addObject("Alias", AliasCuenta);
			MV.addObject("Tipo", cuentaDao.buscarCuentaCBU(Double.parseDouble(CbuCuenta)).getTipoCuenta().getDescripcion());
			MV.setViewName("ListarMovimientos");
		}
		else {
			MV.setViewName("Login");
		}
		return MV;
	}

}
