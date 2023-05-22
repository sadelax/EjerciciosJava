<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Productos</title>
	<link rel="stylesheet" type="text/css" href="${css}/productos.css">
	<link rel="stylesheet" type="text/css" href="${css}/formularios.css">
<script type="text/javascript">

window.onload = function(){
	document.getElementById("idFabricante").addEventListener("change",
	function(){
		this.form.submit();		
	});
};

</script>
</head>
<body>
	<div id="contPrincipal">
		<h1>Búsqueda de Productos por Fabricante</h1>
		<form action="${home}/productos_fabricante" method="post">
			<select id="idFabricante" name="idFabricante">
				<c:if test="${empty fab}">
					<option hidden="hidden">Seleccione Fabricante</option>
				</c:if>
				<c:forEach var="fabricante" items="${fabs}">
					<option value="${fabricante.idFabricante}" 
					${fabricante.idFabricante==fab.idFabricante ? "selected='selected'" : ""}
					>${fabricante.fabricante}</option>
				</c:forEach>
			</select>
		</form>
		<c:if test="${not empty fab}">
			<table id="tabla_datos" class="datos">
				<thead>
					<tr>
						<th>Descripcion</th>
						<th>Precio</th>
						<th>Fabricante</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="producto" items="${fab.productos}">
						<tr>
							<td>${producto.producto}</td>
							<td>${producto.precio}</td>
							<td>${producto.fabricante.fabricante}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>		
		</c:if>	
		<a href="${home}/menu_principal"><button>Volver</button></a>
	</div>
</body>
</html>