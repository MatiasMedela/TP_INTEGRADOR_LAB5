package Controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
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
		DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String StartDate = Year.now().getValue() + "-01-01 00:00:00"; 
		String EndDate = Year.now().getValue() + "-12-31 23:59:59";
		Date sDateMethod = formatUS.parse(StartDate);
		Date eDateMethod = formatUS.parse(EndDate);
		ArrayList<String> informe = (ArrayList<String>) infDao.informePrestamos(sDateMethod, eDateMethod);
		
		MV.addObject("stDate", new SimpleDateFormat("yyyy-MM-dd").format(sDateMethod));
		MV.addObject("edDate", new SimpleDateFormat("yyyy-MM-dd").format(eDateMethod));
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
		ArrayList<String> informe = (ArrayList<String>) infDao.informePrestamos(sDate, eDate);
		MV.addObject("stDate", new SimpleDateFormat("yyyy-MM-dd").format(sDate));
		MV.addObject("edDate", new SimpleDateFormat("yyyy-MM-dd").format(eDate));
		MV.addObject("InformePrestamos", informe);
		MV.setViewName("informes");
		return MV;
	}


}
