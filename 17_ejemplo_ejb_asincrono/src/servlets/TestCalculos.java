package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Future;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.Calculo;

/**
 * Servlet implementation class TestCalculos
 */
@WebServlet("/TestCalculos")
public class TestCalculos extends HttpServlet {
	
	@EJB
	Calculo calculo;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =  response.getWriter();
		try {
			Future<Integer> future=calculo.sumaNumeros(60);
			out.println("<html><body>");
			int i=0;
			int a=0;
			while(!future.isDone()) {
				if(i==10000000) {
					out.println(" Esperando "+a+"<br>");
					i=0;
					a++;
				}
				//System.out.println("Esperando respuesta Tiempo="+i);
				i++;
			}
			int res=future.get();
			out.println("<h1>La suma es "+res+"</h1>");
			out.println("<html><body>");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
