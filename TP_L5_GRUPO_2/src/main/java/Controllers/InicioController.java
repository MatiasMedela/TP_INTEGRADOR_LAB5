package Controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InicioController {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	@RequestMapping("redireccLogin.html")
	public ModelAndView RedireccionarLogin() {
		ModelAndView MV = (ModelAndView) appContext.getBean("ModelView");
		MV.setViewName("Login");
		return MV;
	}
}
