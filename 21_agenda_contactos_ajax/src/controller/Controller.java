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
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlFinal="entrada.html";
		String op=request.getParameter("op");
		switch(op) {
		case "doContactos":
			request.getRequestDispatcher("ContactosAction").forward(request, response);
			return;
		case "doAlta":
			request.getRequestDispatcher("AltaAction").include(request,response);
			urlFinal="entrada.html";
			break;
		case "doEliminar":
			request.getRequestDispatcher("EliminarAction").include(request,response);
			request.getRequestDispatcher("ContactosAction").forward(request, response);
			return;
		case "toDatos":
			urlFinal="datos.html";
			break;
		case "toEntrada":
			urlFinal="entrada.html";
			break;			
	}
	//transferimos la petici�n a la vista
	request.getRequestDispatcher(urlFinal).forward(request,response);
}

}
