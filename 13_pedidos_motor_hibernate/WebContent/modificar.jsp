<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>Modificar pedido</title>
</head>
<body>
<c:set var="ped" value="${requestScope.ped1}"/>

<form action="Controller?op=doModificar&idPedido=${ped.idPedido}" method="POST">
<!-- <form action="Controller?op=doModificar" method="POST"> -->
		Producto:<input type="text" name="producto" value="${ped.producto}"/></br>
		Precio:<input type="number" name="precio" value="${ped.precio}"/></br>
		Categoria:<input type="text" name="categoria" value="${ped.categoria}"/></br>
<!-- 		<input type="hidden" name="idPedido" value="${ped.idPedido}" />  -->
		<input type="submit" value="Guardar"/>		
	</form>
	<br/>
	<a href="Controller?op=toInicio">Volver</a>
</body>
</html>