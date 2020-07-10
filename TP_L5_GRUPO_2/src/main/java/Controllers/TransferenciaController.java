package Controllers;

import java.util.ArrayList;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;

import AccesoDatos.CuentaDao;
import AccesoDatos.MovimientoDao;
import AccesoDatos.UsuarioDao;
import Dominio.Cuenta;
import Dominio.Usuario;
import Negocio.MovimientoNegocio;

@Controller
public class TransferenciaController {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	
	@Autowired
	private MovimientoNegocio movN;
	
	@Autowired
	private MovimientoDao movDao;
	
	@Autowired
	private CuentaDao cuentaDao;
	
	@Autowired
	private UsuarioDao userDao;
	
	@RequestMapping(value="redirecNavBar.html", params = {"transferencias"})
	public ModelAndView redirecTrans(HttpServletRequest request) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		if(request.getSession().getAttribute("IDUsuario") !=null) {			
			String IDUsuario = request.getSession().getAttribute("IDUsuario").toString();
			Usuario user = userDao.buscarUsuario(IDUsuario);
			MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
			MV.addObject("listadoTransferencias", movDao.transferenciasxUsuario(Integer.parseInt(IDUsuario)));
			MV.setViewName("transferencias");
		}
		else {
			MV.setViewName("Login");
		}
		return MV;
	}
	
	@RequestMapping(value="redirecNuevaTransferencia.html", params = { "normal" })
	public ModelAndView redirecNuevaTrans(HttpServletRequest request) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		if(request.getSession().getAttribute("IDUsuario") !=null) {			
			String IDUsuario = request.getSession().getAttribute("IDUsuario").toString();
			Usuario user = userDao.buscarUsuario(IDUsuario);
			MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
			MV.addObject("cuentasUsuario",cuentaDao.CuentaUsuario(IDUsuario));
			MV.setViewName("nuevaTransferencia");
		}
		else {
			MV.setViewName("Login");
		}
		return MV;
	}

	@RequestMapping(value="redirecNuevaTransferencia.html", params= { "terceros" })
	public ModelAndView redirecNuevaTransTerceros(HttpServletRequest request) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		if(request.getSession().getAttribute("IDUsuario") !=null) {			
			String IDUsuario = request.getSession().getAttribute("IDUsuario").toString();
			Usuario user = userDao.buscarUsuario(IDUsuario);
			MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
			MV.addObject("cuentasUsuario",cuentaDao.CuentaUsuario(IDUsuario));
			MV.setViewName("nuevaTransferenciaTerceros");
		}
		else {
			MV.setViewName("Login");
		}
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
	
	@RequestMapping(method = RequestMethod.POST, value="datosCuentas.html")
	@ResponseBody
	public String devolverDatosCuentas(String idOrigen, String idDestino) {
		ArrayList<Cuenta> listado = (ArrayList<Cuenta>) appContext.getBean("ArrayList");
		listado.add(cuentaDao.buscarCuenta(Integer.parseInt(idOrigen))); 
		listado.add(cuentaDao.buscarCuenta(Integer.parseInt(idDestino)));
		return new Gson().toJson(listado);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="datosCuentasTerceros.html")
	@ResponseBody
	public String devolverDatosCuentasTerceros(String idOrigen, String cbuDestino) {
		ArrayList<Cuenta> listado = (ArrayList<Cuenta>) appContext.getBean("ArrayList");;
		listado.add(cuentaDao.buscarCuenta(Integer.parseInt(idOrigen))); 
		listado.add(cuentaDao.buscarCuentaCBU(Double.parseDouble(cbuDestino)));
		return new Gson().toJson(listado);
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
	public String verificarCBU(String CBU, String Alias, HttpServletRequest request) {
		int IDUsuario = Integer.parseInt(request.getSession().getAttribute("IDUsuario").toString());
		Cuenta cuenta = null;
		if(CBU != "") {
			CBU = CBU.replaceFirst("^0+(?!$)", "");
			cuenta = cuentaDao.buscarCuentaCBU(Double.parseDouble(CBU));			
		}
		else {
			cuenta = cuentaDao.buscarCuentaAlias(Alias);
		}
		if(cuenta == null) {
			return new Gson().toJson("CBU no encontrado");
		}
		else if(cuenta.getUsuario().getIdUsu() == IDUsuario) {
			return new Gson().toJson("CBU userAct");
		}
		return new Gson().toJson(cuenta);
	}

}
