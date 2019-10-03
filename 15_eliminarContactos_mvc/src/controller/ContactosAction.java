package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoContactos;
import model.Contacto;

@WebServlet("/ContactosAction")
public class ContactosAction extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoContactos dao = new DaoContactos();
		List<Contacto> contactos= dao.mostrarContactos();
		if(contactos.size()>0) {
			request.setAttribute("resultado", 1);
			//request.setAttribute("url", "contactos.jsp");
			request.setAttribute("contactos", contactos);
		}else {
			//request.setAttribute("url", "sinContactos.html");
			request.setAttribute("resultado", 0);
		}
	}

}
