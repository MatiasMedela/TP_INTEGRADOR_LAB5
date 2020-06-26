package Controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import AccesoDatos.InformeDao;

@Controller
public class InformeController {
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"informes"})
	public ModelAndView redirecInformes() throws ParseException {
		ModelAndView MV = new ModelAndView();
		InformeDao infDao = new InformeDao();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String StartDate = "01/01/" + Year.now().getValue();
		String EndDate = "31/12/" + Year.now().getValue();
		ArrayList<String> informe = (ArrayList<String>) infDao.informePrestamos(StartDate, EndDate);
		
		Date sDate = format.parse(StartDate);
		Date eDate = format.parse(EndDate);
		
		MV.addObject("stDate", new SimpleDateFormat("yyyy-MM-dd").format(sDate));
		MV.addObject("edDate", new SimpleDateFormat("yyyy-MM-dd").format(eDate));
		MV.addObject("InformePrestamos", informe);
		MV.setViewName("informes");
		return MV;
	}
	
	@RequestMapping(value="filtrarFechas.html")
	public ModelAndView filtrarFechas(String startDate, String endDate) throws ParseException {
		ModelAndView MV = new ModelAndView();
		InformeDao infDao = new InformeDao();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		Date sDate = format.parse(startDate);
		Date eDate = format.parse(endDate);
		String FechaInicio = new SimpleDateFormat("dd/MM/yyyy").format(sDate).toString();
		String FechaFinal = new SimpleDateFormat("dd/MM/yyyy").format(eDate).toString();
		ArrayList<String> informe = (ArrayList<String>) infDao.informePrestamos(FechaInicio, FechaFinal);
		MV.addObject("stDate", new SimpleDateFormat("yyyy-MM-dd").format(sDate));
		MV.addObject("edDate", new SimpleDateFormat("yyyy-MM-dd").format(eDate));
		MV.addObject("InformePrestamos", informe);
		MV.setViewName("informes");
		return MV;
	}

}
