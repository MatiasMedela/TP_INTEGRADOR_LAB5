package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InformeController {
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"informes"})
	public ModelAndView redirecInformes() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("informes");
		return MV;
	}

}
