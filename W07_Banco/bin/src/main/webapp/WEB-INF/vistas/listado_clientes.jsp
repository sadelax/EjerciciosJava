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
	<title>listado usuarios</title>
	<link rel="stylesheet" href="${css}/index.css">
	<script>

		function seleccionaCliente(ev){
			var id = ev.currentTarget.id;
			location.href = "${home}/cuentas?id="+ id;
		}

// 		window.onload = function(){
// 			var filas = document.getElementsByClassName("filas_clientes");
// 			for (let i = 0; i < filas.length; i++) {
// 				filas[i].addEventListener("click", seleccionaCliente);

// 			}
// 		}
	</script>
</head>
<body>
	<div id="cabecera">
		<h2>usuarios activos</h2>
	</div>
	<div class="cuerpo">
		<table id="tabla_datos">
			<thead>
				<tr>
					<th>nombre</th>
					<th>apellido</th>
					<th>nif</th>
					<th>sexo</th>
					<th>municipio</th>
					<th>provincia</th>
					<th>cuentas</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cliente" items="${clientes}">
					<tr id="${cliente.idCliente}" class="filas_clientes">
						<td>${cliente.nombre}</td>
						<td>${cliente.apellido1}</td>
						<td>${cliente.nif}</td>
						<td>${cliente.genero}</td>
						<td>${cliente.municipio}</td>
						<td>${cliente.provincia}</td>
						<td><a href="${home}/cuentas?id=${cliente.idCliente}">consultar</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan=7>cantidad clientes: ${clientes.size()}</td>
				</tr>
			</tfoot>
		</table>
		<div id="botones">
		<p> <a href="${home}/menu_principal">volver al menú principal</a> </p>
		</div>
	</div>
</body>
</html>
