package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoContactos;
import model.Contacto;

/**
 * Servlet implementation class Alta
 */
@WebServlet(urlPatterns = {"/AltaAction"})
public class AltaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DaoContactos miejb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		DaoContactos dao=new DaoContactos();
		Contacto contacto = new Contacto(0,
				request.getParameter("nombre"),
				request.getParameter("email"),
				Integer.parseInt(request.getParameter("edad"))); 
		 miejb.altaContacto(contacto);
	}

}
