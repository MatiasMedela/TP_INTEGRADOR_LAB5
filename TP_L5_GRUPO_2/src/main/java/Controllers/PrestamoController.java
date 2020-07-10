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
import AccesoDatos.PrestamoDao;
import AccesoDatos.UsuarioDao;
import Dominio.Cuenta;
import Dominio.Usuario;

@Controller
public class PrestamoController {
	
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	
	@Autowired
	private PrestamoDao prestDao;
	
	@Autowired
	private UsuarioDao userDao;
	
	@Autowired
	private CuentaDao cuentaDao;
	
	@RequestMapping(value="redirecNavBar.html", params = {"prestamos"})
	public ModelAndView redirecPrestamo(HttpServletRequest request) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		if(request.getSession().getAttribute("IDUsuario") != null) {
			String IDUsuario = 	request.getSession().getAttribute("IDUsuario").toString();
			Usuario user = userDao.buscarUsuario(IDUsuario);
			MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
			MV.addObject("listadoPrestamos", prestDao.listarPrestamosUsuario(Integer.parseInt(IDUsuario)));	
			MV.setViewName("prestamos");
		}
		else {
			MV.setViewName("Login");
		}
		return MV;
	}
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"prestamos"})
	public ModelAndView redirecPrestamoAdmin(HttpServletRequest request) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		if(request.getSession().getAttribute("IDUsuario") != null) {
			String IDUsuario = 	request.getSession().getAttribute("IDUsuario").toString();
			Usuario user = userDao.buscarUsuario(IDUsuario);
			if(user.getTipoUsu().getIdTipoUsuario() == 1) {
				MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
				MV.addObject("listadoPrestamosAdm", prestDao.listarPrestamosPorEstado(0));		
				MV.setViewName("autorizarPrestamos");
			}
			else {
				MV.setViewName("Login");
			}
		}
		else {
			MV.setViewName("Login");
		}
		return MV;
	}
	
	@RequestMapping(value="cargarPrestamo.html")
	public ModelAndView cargarPrestamo(String idCuenta, String importe, String meses, String importeAPagar) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		try {
			prestDao.cargarPrestamo(Float.parseFloat(importe), Integer.parseInt(meses), Float.parseFloat(importeAPagar), Integer.parseInt(idCuenta));
			MV.addObject("prestamo", "Exito");
			MV.setViewName("redirect:/redirecNavBar.html?prestamos");
		} catch (Exception e) {
			e.printStackTrace();
			MV.addObject("prestamo", "Error");
			MV.setViewName("redirect:/solicitarPrestamo.html");
		}
		return MV;
	}
	
	@RequestMapping(value="solicitarPrestamo.html")
	public ModelAndView redirecNuevaTrans(HttpServletRequest request) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		if(request.getSession().getAttribute("IDUsuario") != null) {
			String IDUsuario = (String) request.getSession().getAttribute("IDUsuario").toString();
			Usuario user = userDao.buscarUsuario(IDUsuario);
			ArrayList<Cuenta> listadoCuentas = (ArrayList<Cuenta>) cuentaDao.CuentaUsuario(IDUsuario);
			MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
			MV.addObject("listadoCuentas", listadoCuentas);
			MV.setViewName("solicitudPrestamo");
		}
		else {			
			MV.setViewName("Login");
		}
		//GET CUENTAS X USUARIO
		return MV;
	}

	@RequestMapping(value="redirecPrestamos.html", params = { "aprobados" })
	public ModelAndView redirecPrestamosAprob(HttpServletRequest request) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		if(request.getSession().getAttribute("IDUsuario") != null) {
			String IDUsuario = 	request.getSession().getAttribute("IDUsuario").toString();
			Usuario user = userDao.buscarUsuario(IDUsuario);
			if(user.getTipoUsu().getIdTipoUsuario() == 1) {
				MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
				MV.addObject("listadoPrestamosAdm", prestDao.listarPrestamosPorEstado(1));	
				MV.setViewName("prestamosAprobados");
			}
			else {
				MV.setViewName("Login");
			}
		}
		else {
			MV.setViewName("Login");
		}
		return MV;
	}
	
	@RequestMapping(value="redirecPrestamos.html", params = { "rechazados" })
	public ModelAndView redirecPrestamosRech(HttpServletRequest request) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		if(request.getSession().getAttribute("IDUsuario") != null) {
			String IDUsuario = 	request.getSession().getAttribute("IDUsuario").toString();
			Usuario user = userDao.buscarUsuario(IDUsuario);
			if(user.getTipoUsu().getIdTipoUsuario() == 1) {
				MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
				MV.addObject("listadoPrestamosAdm", prestDao.listarPrestamosPorEstado(2));	
				MV.setViewName("prestamosRechazados");
			}
			else {
				MV.setViewName("Login");
			}
		}
		else {
			MV.setViewName("Login");
		}
		return MV;
	}
	
	@RequestMapping(value="redirecPrestamos.html", params = { "pendientes" })
	public ModelAndView redirecAutorizarPres(HttpServletRequest request) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		if(request.getSession().getAttribute("IDUsuario") != null) {
			String IDUsuario = 	request.getSession().getAttribute("IDUsuario").toString();
			Usuario user = userDao.buscarUsuario(IDUsuario);
			if(user.getTipoUsu().getIdTipoUsuario() == 1) {
				MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
				MV.addObject("listadoPrestamosAdm", prestDao.listarPrestamosPorEstado(0));	
				MV.setViewName("autorizarPrestamos");
			}
			else {
				MV.setViewName("Login");
			}
		}
		else {
			MV.setViewName("Login");
		}
		return MV;
	}
	
	@RequestMapping(value="aprobarPrestamo.html")
	public ModelAndView aprobarPrestamo(int idPrestamo) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		prestDao.cambiarEstadoPrestamo(idPrestamo, 1);
		MV.setViewName("redirect:/redirecNavBarAdmin.html?prestamos");
		return MV;
	}
	

	@RequestMapping(value="rechazarPrestamo.html")
	public ModelAndView rechazarPrestamo(int idPrestamo) {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		prestDao.cambiarEstadoPrestamo(idPrestamo, 2);
		MV.setViewName("redirect:/redirecNavBarAdmin.html?prestamos");
		return MV;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="aprobarPrestamoAsync.html")
	@ResponseBody
	public String aprobarPrestamoAsync(String idPrestamo) {
		if (prestDao.cambiarEstadoPrestamo(Integer.parseInt(idPrestamo), 1))
		{
			return new Gson().toJson("Exitoso");
		}
		else
		{
			return new Gson().toJson("Error");
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value="rechazarPrestamoAsync.html")
	@ResponseBody
	public String rechazarPrestamoAsync(String idPrestamo) {
		if (prestDao.cambiarEstadoPrestamo(Integer.parseInt(idPrestamo), 2))
		{
			return new Gson().toJson("Exitoso");
		}
		else
		{
			return new Gson().toJson("Error");
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value="cargarPrestamoAsync.html")
	@ResponseBody
	public String cargarPrestamoAsync(String idCuenta, String importe, String meses, String importeAPagar) {
		if(prestDao.cargarPrestamo(Float.parseFloat(importe), Integer.parseInt(meses), Float.parseFloat(importeAPagar), Integer.parseInt(idCuenta))) {
			return new Gson().toJson("Exitoso");
		} else {
			return new Gson().toJson("Error");
		}
	}
}
