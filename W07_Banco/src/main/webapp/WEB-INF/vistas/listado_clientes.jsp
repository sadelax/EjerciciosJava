<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>listado usuarios</title>
<link rel="stylesheet" href="${css}/index.css">
<script>
	function seleccionaCliente(ev) {
		var id = ev.currentTarget.id;
		location.href = "${home}/cuentas?id=" + id;
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
	<header class="cabecera">
		<nav>
			<ul>
				<li><a href="${home}/menu_principal">&#127968;</a></li>
				<li><a href="${home}/listado_usuarios">listado de usuarios</a></li>
				<li id="nav-act"><a href="${home}/listado_clientes">listado
						de clientes</a></li>
				<li><a href="${home}/registro_cliente">registrar nuevo
						cliente</a></li>
				<li><a href="${home}/cerrar_sesion">cerrar sesión</a></li>
			</ul>
		</nav>
		<hr>
		<h2>listado de clientes</h2>
	</header>
	<main class="cuerpo">
		<form id="buscar-cliente" action="${home}/listado_clientes"
			method="get">
			<label for="valor">buscar cliente:</label> <input class="input_reg"
				id="valor" type="text" name="valor" placeholder="&#128269;" />
			<div id="botones">
				<input id="buscar-cliente" class="boton" type="submit"
					value="buscar">
				<p>
					<a href="${home}/registro_cliente">registrar nuevo cliente</a>
				</p>
			</div>
		</form>

		<p id="error">
			<c:choose>
				<c:when test="${eliminado eq 'si'}">cliente eliminado correctamente</c:when>
				<c:when test="${eliminado eq 'no'}">imposible eliminar: el cliente tiene cuentas a su nombre</c:when>
			</c:choose>
		</p>

		<div id="tabla-clientes">
			<table id="tabla_datos">
				<thead>
					<tr>
						<th>nombre</th>
						<th>apellido</th>
						<th>nif</th>
						<th>cuentas</th>
						<th>eliminar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cliente" items="${clientes}">
						<tr id="${cliente.idCliente}" class="filas_clientes">
							<td>${cliente.nombre}</td>
							<td>${cliente.apellido1}</td>
							<td>${cliente.nif}</td>
							<td><a href="${home}/cuentas?id=${cliente.idCliente}">consultar</a></td>
							<td><a href="${home}/eliminar?id=${cliente.idCliente}">eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan=7>cantidad clientes: ${clientes.size()}</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</main>
</body>
</html>
