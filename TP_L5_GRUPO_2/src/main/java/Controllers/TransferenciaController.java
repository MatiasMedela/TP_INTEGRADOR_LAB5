package Controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;

import AccesoDatos.CuentaDao;
import AccesoDatos.TransferenciaDao;
import Dominio.Cuenta;

@Controller
public class TransferenciaController {
	
	@RequestMapping(value="redirecNavBar.html", params = {"transferencias"})
	public ModelAndView redirecTrans(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		TransferenciaDao transDao = new TransferenciaDao();
		String IDUsuario = request.getSession().getAttribute("IDUsuario").toString();
		MV.addObject("listadoTransferencias", transDao.transferenciasxUsuario(Integer.parseInt(IDUsuario)));
		MV.setViewName("transferencias");
		return MV;
	}
	
	@RequestMapping(value="redirecNuevaTransferencia.html", params = { "normal" })
	public ModelAndView redirecNuevaTrans() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("nuevaTransferencia");
		return MV;
	}

	@RequestMapping(value="redirecNuevaTransferencia.html", params= { "terceros" })
	public ModelAndView redirecNuevaTransTerceros() {
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
