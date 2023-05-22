<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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