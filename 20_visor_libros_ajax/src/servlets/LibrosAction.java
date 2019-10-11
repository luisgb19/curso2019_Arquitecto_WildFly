package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import daos.DaoLibros;
import model.Libro;

/**
 * Servlet implementation class LibrosAction
 */
@WebServlet("/LibrosAction")
public class LibrosAction extends HttpServlet {
	

@EJB
DaoLibros daoLibros;
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTema= Integer.parseInt(request.getParameter("idTema"));
		List<Libro> libros = daoLibros.librosPorTema(idTema);
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain");
		out.println(convertirJson(libros));
		
	}

private String convertirJson(List<Libro> libros) {
	JSONArray array = new JSONArray();
	for(Libro lib:libros) {
/*		
		JSONObject obj = new JSONObject();
		obj.put("titulo", lib.getTitulo());
		obj.put("autor", lib.getAutor());
		obj.put("precio", lib.getPrecio());
		obj.put("paginas", lib.getPaginas());
		array.add(obj);
*/
		JSONObject obj=new JSONObject();
		obj.put("titulo", lib.getTitulo());
		obj.put("autor", lib.getAutor());
		obj.put("precio", lib.getPrecio());
		obj.put("paginas", lib.getPaginas());
		array.add(obj);
	}
	return array.toJSONString();
}

}
