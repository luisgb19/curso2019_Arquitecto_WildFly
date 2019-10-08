package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoClientes;
import daos.DaoTemas;



@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	
	@EJB
	DaoClientes gestion;
	@EJB
	DaoTemas gtemas;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean resultado=false;
		if(gestion.autenticar(request.getParameter("user"),request.getParameter("pwd"))){
			request.setAttribute("temas", gtemas.obtenerTemas());
            resultado=true;
		}
		else{
			request.setAttribute("mensaje", "Usuario no registrado");
		}
       
        request.setAttribute("resultado",resultado);
	}
	

}
