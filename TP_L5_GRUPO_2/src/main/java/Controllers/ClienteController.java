package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {
	
	@RequestMapping("FormCagarCliente")
	public ModelAndView Redireccionar() {
		ModelAndView MV=new ModelAndView();
		MV.setViewName("Login");
		return MV;
	}

}