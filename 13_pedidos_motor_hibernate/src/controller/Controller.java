package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		String url="menu.html";
		switch (op) {
		case "toAlta":
			url="alta.html";
			break;
		case "doAlta":
			request.getRequestDispatcher("AltaAction").include(request, response);
			url="menu.html";
			break;
		case "toModificar":
			request.getRequestDispatcher("ListarPedidoAction").include(request, response);
			url="modificar.jsp";
			break;
		case "doModificar":
			request.getRequestDispatcher("ModificarAction").include(request, response);
			url="listado.jsp";
			break;
		case "doEliminar":
			request.getRequestDispatcher("EliminarAction").include(request, response);
			url="listado.jsp";
			break;
		case "toListar":
			request.getRequestDispatcher("ListarAction").include(request, response);
			url="listado.jsp";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
