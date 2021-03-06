package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoPedidos;

/**
 * Servlet implementation class EliminarAction
 */
@WebServlet("/EliminarAction")
public class EliminarAction extends HttpServlet {
	@EJB
	DaoPedidos miejb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		miejb.eliminarPedido(Integer.parseInt(request.getParameter("idPedido")));
		request.getRequestDispatcher("ListarAction").include(request, response);
	}

}
