package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="solicitarPrestamo.html")
	public ModelAndView redirecNuevaTrans() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("solicitudPrestamo");
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
