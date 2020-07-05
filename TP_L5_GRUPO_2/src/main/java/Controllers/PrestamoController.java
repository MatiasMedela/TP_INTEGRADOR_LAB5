package Controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="redirecNavBar.html", params = {"prestamos"})
	public ModelAndView redirecPrestamo(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
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
			MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
			MV.addObject("listadoPrestamosAdm", prestDao.listarPrestamosPorEstado(0));		
			MV.setViewName("autorizarPrestamos");
		}
		else {
			MV.setViewName("Login");
		}
		return MV;
	}
	
	@RequestMapping(value="cargarPrestamo.html")
	public ModelAndView cargarPrestamo(String idCuenta, String importe, String meses, String importeAPagar) {
		ModelAndView MV = new ModelAndView();
		PrestamoDao presDao = new PrestamoDao();
		try {
			presDao.cargarPrestamo(Float.parseFloat(importe), Integer.parseInt(meses), Float.parseFloat(importeAPagar), Integer.parseInt(idCuenta));
			MV.addObject("prestamo", "Exito");
			MV.setViewName("redirec:/redirecNavBar.html?prestamos");
		} catch (Exception e) {
			e.printStackTrace();
			MV.addObject("prestamo", "Error");
			MV.setViewName("redirec:/solicitarPrestamo.html");
		}
		return MV;
	}
	
	@RequestMapping(value="solicitarPrestamo.html")
	public ModelAndView redirecNuevaTrans(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		CuentaDao cuentaDao = new CuentaDao();
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
			MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
			MV.addObject("listadoPrestamosAdm", prestDao.listarPrestamosPorEstado(1));	
			MV.setViewName("prestamosAprobados");
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
			MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
			MV.addObject("listadoPrestamosAdm", prestDao.listarPrestamosPorEstado(2));	
			MV.setViewName("prestamosRechazados");
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
			MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
			MV.addObject("listadoPrestamosAdm", prestDao.listarPrestamosPorEstado(0));	
			MV.setViewName("autorizarPrestamos");
		}
		else {
			MV.setViewName("Login");
		}
		return MV;
	}

}
