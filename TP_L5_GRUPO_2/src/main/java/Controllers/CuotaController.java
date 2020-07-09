package Controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

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
import AccesoDatos.CuotaDao;
import AccesoDatos.PrestamoDao;
import AccesoDatos.UsuarioDao;
import Dominio.Cuenta;
import Dominio.Usuario;

@Controller
public class CuotaController {
	
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	
	@Autowired
	private UsuarioDao userDao;
	
	@Autowired
	private CuotaDao cuotaDao;
	
	@Autowired
	private CuentaDao cuentaDao;
	
	@Autowired
	private PrestamoDao prestDao;
	
	@RequestMapping(value="pagarCuotas.html")
	public ModelAndView redirecCuotas(int idPrestamo, HttpServletRequest request) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		if(request.getSession().getAttribute("IDUsuario") != null) {
			String IDUsuario = 	request.getSession().getAttribute("IDUsuario").toString();
			Usuario user = userDao.buscarUsuario(IDUsuario);
			MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
			MV.addObject("idPrestamo", idPrestamo);
			MV.addObject("listadoCuotas", cuotaDao.listarCuotas(idPrestamo));	
			MV.addObject("listadoCuentas", cuentaDao.CuentaUsuario(IDUsuario, prestDao.buscarPrestamo(idPrestamo).getCbu().getTipoCuenta().getMoneda()));
			MV.setViewName("pagoCuotas");
		}
		else {
			MV.setViewName("Login");
		}
		return MV;
	}

	
	@RequestMapping(method = RequestMethod.POST, value="pagarCuotaAsync.html")
	@ResponseBody
	public String pagarCuotaAsync(String idCuota, String idCuenta) {
		if (cuotaDao.pagarCuota(Integer.parseInt(idCuota), Integer.parseInt(idCuenta)))
		{
			return new Gson().toJson("Exitoso");
		}
		else
		{
			return new Gson().toJson("Error");
		}
	}

}
