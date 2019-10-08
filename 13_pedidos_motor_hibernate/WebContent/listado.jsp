<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado</title>
<meta charset="ISO-8859-1">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
</head>
<body>
	<c:set var="pedidos" value="${requestScope.pedidos}"/>
	<c:choose>
		<c:when test="${!empty pedidos}">
			<table border="1">
				<tr>
					<th>Producto</th><th>Precio</th><th>Categoria</th><th></th><th></th>
				</tr>
				<c:forEach var="ped" items="${pedidos}" varStatus="v">
					<tr>
						<td>${ped.producto}</td>
						<td>${ped.precio}</td>
						<td>${ped.categoria}</td>
						<td><a href="Controller?op=doEliminar&idPedido=${ped.idPedido}">Eliminar</a></td>
						<td><a href="Controller?op=toModificar&idPedido=${ped.idPedido}">Editar</a></td>
					</tr>
				</c:forEach>
			</table>	
		</c:when>
		<c:otherwise>
			<h1>No hay pedidos</h1>
		</c:otherwise>
	</c:choose>
	<br/>
	<a href="Controller?op=toInicio">Volver</a>
</body>
</html>