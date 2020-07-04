package Controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;

import AccesoDatos.CuentaDao;
import AccesoDatos.MovimientoDao;
import Dominio.Cuenta;
import Negocio.CuentaNegocio;
import Negocio.MovimientoNegocio;

@Controller
public class TransferenciaController {
	
	@Autowired
	private CuentaNegocio cuentaN;
	
	@Autowired
	private MovimientoNegocio movN;
	
	@Autowired
	private MovimientoDao movDao;
	
	@Autowired
	private CuentaDao cuentaDao;
	
	@RequestMapping(value="redirecNavBar.html", params = {"transferencias"})
	public ModelAndView redirecTrans(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		String IDUsuario = request.getSession().getAttribute("IDUsuario").toString();
		MV.addObject("listadoTransferencias", movDao.transferenciasxUsuario(Integer.parseInt(IDUsuario)));
		MV.setViewName("transferencias");
		return MV;
	}
	
	@RequestMapping(value="redirecNuevaTransferencia.html", params = { "normal" })
	public ModelAndView redirecNuevaTrans(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		String IDUsuario = request.getSession().getAttribute("IDUsuario").toString();
		MV.addObject("cuentasUsuario",cuentaN.CuentaUsuario(IDUsuario));
		MV.setViewName("nuevaTransferencia");
		return MV;
	}

	@RequestMapping(value="redirecNuevaTransferencia.html", params= { "terceros" })
	public ModelAndView redirecNuevaTransTerceros(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		String IDUsuario = request.getSession().getAttribute("IDUsuario").toString();
		MV.addObject("cuentasUsuario",cuentaN.CuentaUsuario(IDUsuario));
		MV.setViewName("nuevaTransferenciaTerceros");
		return MV;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="nuevaTransferencia.html")
	@ResponseBody
	public String nuevaTransferencia(String cuentaDestino, String cuentaOrigen, String importe, String motivo) {
		if(movN.nuevaTransferencia(Integer.parseInt(cuentaDestino), Integer.parseInt(cuentaOrigen), importe, motivo)) {
			return new Gson().toJson("Exito");
		}
		else {
			return new Gson().toJson("Error");
		}
	}
	
	@RequestMapping(method= RequestMethod.POST, value="nuevaTransferenciaTerceros.html")
	@ResponseBody
	public String nuevaTransferenciaTerceros(String cuentaOrigen, String CBUCuenta, String importe, String motivo ) {
		Double cbuDestino = Double.parseDouble(CBUCuenta);
		int cuentaDestino = cuentaDao.buscarCuentaCBU(cbuDestino).getIdCuenta();
		if(movN.nuevaTransferencia(cuentaDestino, Integer.parseInt(cuentaOrigen), importe, motivo)) {
			return new Gson().toJson("Exito");
		}
		else {
			return new Gson().toJson("Error");
		}

	}
	
	@RequestMapping(method = RequestMethod.POST, value="verificarCBU.html")
	@ResponseBody
	public String verificarCBU(String CBU, HttpServletRequest request) {
		int IDUsuario = Integer.parseInt(request.getSession().getAttribute("IDUsuario").toString());
		Cuenta cuenta = cuentaDao.buscarCuentaCBU(Double.parseDouble(CBU.substring(CBU.lastIndexOf("0")+1)));
		if(cuenta.getUsuario().getIdUsu() == IDUsuario) {
			return new Gson().toJson("CBU userAct");
		}
		
		return new Gson().toJson(cuenta);
	}

}
