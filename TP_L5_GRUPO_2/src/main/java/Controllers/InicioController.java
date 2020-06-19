package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InicioController {
	@RequestMapping("RedireccionarLogin")
	public ModelAndView RedireccionarLogin() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Login");
		return MV;
	}
}
