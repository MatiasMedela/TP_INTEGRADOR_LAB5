package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransferenciaController {
	
	@RequestMapping(value="redirecNavBar.html", params = {"transferencias"})
	public ModelAndView redirecTrans() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("transferencias");
		return MV;
	}
	
	@RequestMapping(value="redirecNuevaTransferencia.html", params = { "normal" })
	public ModelAndView redirecNuevaTrans() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("nuevaTransferencia");
		return MV;
	}

	@RequestMapping(value="redirecNuevaTransferencia.html", params= { "terceros" })
	public ModelAndView redirecNuevaTransTerceros() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("nuevaTransferenciaTerceros");
		return MV;
	}

}
