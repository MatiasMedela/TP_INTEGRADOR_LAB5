package Controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import AccesoDatos.InformeDao;
import AccesoDatos.MovimientoDao;
import AccesoDatos.UsuarioDao;
import Dominio.Usuario;

@Controller
public class InformeController {
	
	@Autowired
	private MovimientoDao movDao;
	
	@Autowired
	private InformeDao infDao;
	
	@Autowired
	private UsuarioDao userDao;
	
	@RequestMapping(value="redirecNavBarAdmin.html", params = {"informes"})
	public ModelAndView redirecInformes(HttpServletRequest request) throws ParseException {
		ModelAndView MV = new ModelAndView();
		if(request.getSession().getAttribute("IDUsuario") !=null) {			
			String IDUsuario = request.getSession().getAttribute("IDUsuario").toString();
			Usuario user = userDao.buscarUsuario(IDUsuario);
			if(user.getTipoUsu().getIdTipoUsuario() == 1) {
				MV.addObject("NomApeUser", user.getNombre() + ", " + user.getApellido());
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
				
				/* --  FIN PRESTAMOS  --*/
		
				MV.addObject("informeTransferencia", filtrarTransferenciasAnio(Integer.parseInt(Year.now().toString())));
				MV.addObject("anio", Year.now().toString());
				MV.setViewName("informes");	
			}
			else {
				MV.setViewName("Login");
			}
		}
		else {
			MV.setViewName("Login");
		}
		return MV;
	}
	
	@RequestMapping(value="filtrarInforme.html")
	public ModelAndView filtrarFechas(String startDate, String endDate, String anioSelect) throws ParseException {
		ModelAndView MV = new ModelAndView();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		Date sDate = format.parse(startDate);
		Date eDate = format.parse(endDate);
		ArrayList<String> informe = (ArrayList<String>) infDao.informePrestamos(sDate, eDate);
		MV.addObject("informeTransferencia", filtrarTransferenciasAnio(Integer.parseInt(anioSelect)));
		MV.setViewName("informes");
		return MV;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="filtrarInformeAsync.html")
	@ResponseBody
	public String filtrarFechasAsync(String startDate, String endDate) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		Date sDate = format.parse(startDate);
		Date eDate = format.parse(endDate);
		ArrayList<String> informe = (ArrayList<String>) infDao.informePrestamos(sDate, eDate);
		return new Gson().toJson(informe);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="filtrarTransferenciasAsync.html")
	@ResponseBody
	public String filtrarTransferenciasAsync(String anio) throws ParseException {
		return new Gson().toJson(filtrarTransferenciasAnio(Integer.parseInt(anio)));
	}
	
	public List<String[]> filtrarTransferenciasAnio(int anio){
		ArrayList<Object[]> informeTransferencias = movDao.transferenciasxMes(anio);
		ArrayList<String[]> informeMeses = new ArrayList<String[]>();
		Integer mes = 1;
		int count = 0;
		for (int i = 1; i <= 12; i++) {
			String[] valores = new String[2];
			if(count < informeTransferencias.size()){	
				if( Integer.parseInt(informeTransferencias.get(count)[0].toString()) == mes) {
					valores[0] = informeTransferencias.get(count)[0].toString();
					valores[1] = informeTransferencias.get(count)[1].toString();
					count++;
				}
				else {
					valores[0] = mes.toString();
					valores[1] = "0";
				}
			}
			else {
				valores[0] = mes.toString();
				valores[1] = "0";
			}
			informeMeses.add(valores);
			mes++;
		}
		return informeMeses;
	}


}
