package Controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import AccesoDatos.CuentaDao;
import AccesoDatos.PrestamoDao;
import Dominio.Cuenta;

@Controller
public class PrestamoController {
	
	@RequestMapping(value="redirecNavBar.html", params = {"prestamos"})
	public ModelAndView redirecPrestamo() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("prestamos");
		return MV;
	}
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"prestamos"})
	public ModelAndView redirecPrestamoAdmin() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("autorizarPrestamos");
		return MV;
	}
	
	@RequestMapping(value="cargarPrestamo.html")
	public ModelAndView cargarPrestamo(String idCuenta, String importe, String meses, String importeAPagar) {
		ModelAndView MV = new ModelAndView();
		PrestamoDao presDao = new PrestamoDao();
		try {
			presDao.cargarPrestamo(Float.parseFloat(importe), Integer.parseInt(meses), Float.parseFloat(importeAPagar), Integer.parseInt(idCuenta));
			MV.addObject("prestamo", "Exito");
			MV.setViewName("prestamos");
		} catch (Exception e) {
			e.printStackTrace();
			MV.addObject("prestamo", "Error");
			MV.setViewName("solicitudPrestamo");
		}
		return MV;
	}
	
	@RequestMapping(value="solicitarPrestamo.html")
	public ModelAndView redirecNuevaTrans(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();
		CuentaDao cuentaDao = new CuentaDao();
		if(request.getSession().getAttribute("IDUsuario") != null) {
			String IDUsuario = (String) request.getSession().getAttribute("IDUsuario").toString();
			ArrayList<Cuenta> listadoCuentas = (ArrayList<Cuenta>) cuentaDao.CuentaUsuario(IDUsuario);
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
	public ModelAndView redirecPrestamosAprob() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("prestamosAprobados");
		return MV;
	}
	
	@RequestMapping(value="redirecPrestamos.html", params = { "rechazados" })
	public ModelAndView redirecPrestamosRech() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("prestamosRechazados");
		return MV;
	}
	
	@RequestMapping(value="redirecPrestamos.html", params = { "pendientes" })
	public ModelAndView redirecAutorizarPres() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("autorizarPrestamos");
		return MV;
	}

}
