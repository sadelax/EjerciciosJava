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
	<script>
	
	</script>
</head>
<body>
	<div id="cabecera">
		<h2>cuentas</h2>
	</div>
	<div class="cuerpo">
		<table id="tabla_datos">
			<caption>${cliente.nombre}</caption>
			<thead>
				<tr>
					<th>cuentas</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cliente" items="${clientes.cuentas}">
					<tr>
						<td>${cliente.cuentas}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan=7>cantidad cuentas: ${cuentas.size()}</td>
				</tr>
			</tfoot>
		</table>
		<div id="botones">
		<p> <a href="${home}/menu_principal">volver al menú principal</a> </p>
		</div>
	</div>
</body>
</html>
