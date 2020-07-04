package Controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	public ModelAndView redirecNuevaTransTerceros() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("nuevaTransferenciaTerceros");
		return MV;
	}
	
	@RequestMapping(value="nuevaTransferencia.html")
	public ModelAndView nuevaTransferencia(int cuentaDestino, int cuentaOrigen,String importe, String motivo) {
		ModelAndView MV = new ModelAndView();
		if(movN.nuevaTransferencia(cuentaDestino, cuentaOrigen, importe, motivo)) {
			MV.addObject("resultado", "Exitoso");
			MV.setViewName("redirect:/redirecNavBar.html?transferencias");
		}
		else {
			MV.addObject("resultado", "Error");
			MV.setViewName("nuevaTransferenciaTerceros");
		}
		return MV;
	}
	
	@RequestMapping(value="nuevaTransferenciaTerceros.html")
	public ModelAndView nuevaTransferenciaTerceros() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("nuevaTransferenciaTerceros");
		return MV;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/verificarCBU.html", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String verificarCBU(String CBUCuenta) {
		CuentaDao cuentaDao = new CuentaDao();
		Cuenta cuenta = cuentaDao.buscarCuentaCBU(Double.parseDouble(CBUCuenta.substring(CBUCuenta.lastIndexOf("0")+1)));
		return new Gson().toJson(cuenta);
	}

}
