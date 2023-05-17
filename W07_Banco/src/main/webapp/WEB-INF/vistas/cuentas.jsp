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
<title>cuentas asociadas a ${cli.nombre}</title>
<link rel="stylesheet" href="${css}/cuentas.css">
<script>
	function seleccionaCliente(ev) {
		var id = ev.currentTarget.id;
		location.href = "${home}/extractos?id=" + id;
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
				<li><a href="${home}/listado_usuarios">listado de usuarios</a></li>
				<li><a href="${home}/listado_clientes">listado de clientes</a></li>
				<li><a href="${home}/registro_cliente">registrar nuevo
						cliente</a></li>
				<li><a href="${home}/cerrar_sesion">cerrar sesión</a></li>
			</ul>
		</nav>
		<hr>
		<h2>${cli.nombre} ${cli.apellido1} ${cli.apellido2}</h2>
	</header>
	<main class="cuerpo">
		<div id="menu-extracto">
		
			<form id="buscar-extracto" action="${home}/extracto" method="get">
				<div class="select-cuenta-container">
					<label for="select-cuenta">selecciona cuenta:</label>
					<select name="select-cuenta" id="select-cuenta">
						<c:forEach var="cuenta" items="${cli.cuentas}">
							<option value="${cuenta.idCuenta}">${cuenta.numeroCuenta}</option>
						</c:forEach>
					</select>
				</div>
				<div id="contenedor-inputs">
					<label id="mes">mes:</label>
					<input class="mes" id="mes" type="text" name="mes" maxlength="2" size="4">
					<label id="anyo">año:</label>
					<input class="anyo" id="anyo" type="text" name="anyo" maxlength="4" size="4">
					<input id="buscar_ext" class="boton" type="submit" value="buscar">
				</div>
			</form>
			
		</div>

		<div id="tabla-resultados-extracto">
			<table id="tabla_datos">
				<thead>
					<tr>
						<th>tarjeta</th>
						<th>fecha</th>
						<th>descripción</th>
						<th>importe</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tarjeta" items="${tarjetaMovs.keySet()}">				
						<c:forEach var="movimiento" items="${tarjetaMovs.get(tarjeta)}">
							<tr>
								<td>${tarjeta.getPan()}</td>
								<td>${movimiento.getFechaFormat()}</td>
								<td>${movimiento.getTipo().getTipo()} en ${movimiento.getProveedor()}</td>
								<td><fmt:formatNumber type="currency" value="${movimiento.getImporte()}"/></td>
							</tr>
						</c:forEach>
					</c:forEach>
				
				
				
				</tbody>
				<tfoot>
				</tfoot>
			</table>
		</div>
		<div id="botones">
			<p>
				<a href="${home}/listado_clientes">volver al listado de clientes</a>
			</p>
		</div>
	</main>
</body>
</html>


<%-- <td><a href="${home}/cuentas?id=${cliente.idCliente}">consultar</a></td> --%>
