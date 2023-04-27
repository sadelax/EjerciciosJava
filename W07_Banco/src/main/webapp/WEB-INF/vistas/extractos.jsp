<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>cuentas asociadas a ${cliente.nombre}</title>
	<link rel="stylesheet" href="${css}/index.css">
	
</head>
<body>
	<div id="cabecera">
		<h2>extractos</h2>
	</div>
	<div class="cuerpo">
		<form action="${home}/extracto" method="get">
			<input id="anyo" name="anyo" placeholder="año"/>
			<input id="mes" name="mes" placeholder="mes"/>
			<input id="extracto" class="boton" type="submit" value="mostrar">
			
			<!-- TO-DO A PARTIR DE AQUÍ!!!!111 -->
		</form>
		<table id="tabla_datos">
			<thead>
				<tr>
					<th>extracto de ${ext.cuenta}</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="extracto" items="${ext.cuenta}">
					<tr>
						<td>${cuenta}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan=7>cantidad cuentas: ${cli.cuentas.size()}</td>
				</tr>
			</tfoot>
		</table>
		<div id="botones">
		<p> <a href="${home}/listado_clientes">volver al listado de clientes</a> </p>
		<p> <a href="${home}/menu_principal">volver al menú principal</a> </p>
		</div>
	</div>
</body>
</html>
