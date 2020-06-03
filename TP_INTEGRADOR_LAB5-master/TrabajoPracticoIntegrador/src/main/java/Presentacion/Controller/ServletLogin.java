package Presentacion.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import Negocio.NegocioUsuario;
//import NegocioImpl.UsuarioNegImpl;



/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//NegocioUsuario NegUsu = new UsuarioNegImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {super();}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*boolean Username,key,exist;
		if(request.getParameter("BtnIngresar")!=null) {
			if(NegUsu.ValidarIngreso(request.getParameter("LoginUser"), request.getParameter("LoginKey")) == true) {
				//En htttpSession obtengo todas las variables session creadas
				HttpSession session = request.getSession();
				String usr="",tc="",Key="";
					usr=request.getParameter("LoginUser");
					tc=NegUsu.ObtenerUsuario(request.getParameter("LoginUser"), request.getParameter("LoginKey")).getTC();
					Key=request.getParameter("LoginKey");
				//Mediate el setAttribute creo la variable session
				session.setAttribute("UsernameSession", usr);
				session.setAttribute("tcSession", tc);
				session.setAttribute("tcSessionKey", Key);
				session.setMaxInactiveInterval(600);
							
				if(NegUsu.ObtenerUsuario(request.getParameter("LoginUser"), request.getParameter("LoginKey")).getTC().equals("Administrador")) {
					//redireccionar apara volver al jsp con requestdispatcher
					request.getRequestDispatcher("MenuAdministrador.jsp").forward(request, response);
				}else {
						//redireccionar apara volver al jsp con requestdispatcher
						request.getRequestDispatcher("MenuDocente.jsp").forward(request, response);
				}
			}else {
				Username=NegUsu.ValidarIngresoUserName(request.getParameter("LoginUser"));
				key=NegUsu.ValidarIngresoUserKey(request.getParameter("LoginKey"));
				exist=NegUsu.ValidarExistUserName(request.getParameter("LoginUser"));
				
				request.setAttribute("UsuarioInvalido", Username);
				request.setAttribute("ContraseñaInvalida", key);
				request.setAttribute("usuarionoexiste", exist);
				//redireccionar apara volver al jsp con requestdispatcher 
			    request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}*/
	}
}
