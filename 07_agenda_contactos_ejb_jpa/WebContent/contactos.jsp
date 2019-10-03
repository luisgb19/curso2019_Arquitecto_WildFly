<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="daos.DaoContactos,java.util.List,model.Contacto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar contactos</title>
</head>
<body>
<table border=1>
<tr>
<th width="100">Accion</th>
<th width="200">Nombre</th>
<th width="200">Email</th>
<th width="200">Edad</th>
</tr>
<% 

List<Contacto> lista = (List<Contacto>)request.getAttribute("contactos");

	for(Contacto contacto: lista){
		%>
	<tr><td><a href="Controller?op=doEliminar&id=<%=contacto.getIdContacto()%>">Eliminar</a>	
	</td><td>
	<%=contacto.getNombre()%>
	</td><td>
	<%=contacto.getEmail()%>
	</td><td>
	<%=contacto.getEdad()%>
	</td></tr>
<% 	
	}
%>
</table>

<a type="button" href='Controller?op=toEntrada'>Volver</a>
</body>
</html>