package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlFinal = "entrada.html"; // direccion de la vista a la que hay que ir
		String op = request.getParameter("op");
		switch (op) {
			case "doContactos":
				request.getRequestDispatcher("ContactosAction").include(request, response);
				urlFinal=((Integer)request.getAttribute("resultado"))==1?"contactos.jsp":"sinContactos.html";
				// urlFinal="contactos.jsp";
				break;
			case "doAlta":
				request.getRequestDispatcher("AltaAction").include(request, response);
				urlFinal="entrada.html";
				break;
			case "toDatos":
				urlFinal="datos.html";
				break;
			case "toEntrada":
				urlFinal="entrada.html";
				break;
			case "doEliminar":
				request.getRequestDispatcher("EliminarAction").include(request, response);
				request.getRequestDispatcher("ContactosAction").include(request, response);
				urlFinal=((Integer)request.getAttribute("resultado"))==1?"contactos.jsp":"sinContactos.html";
				break;
				
		}
		// transferimos la peticion a la vista
		request.getRequestDispatcher(urlFinal).forward(request, response);
		
		
	}

}
