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
				<li><a href="${home}/listado_productos">listado de productos</a></li>
				<li><a href="${home}/registro_fabricante">alta nuevo fabricante</a></li>
				<li><a href="${home}/registro_producto">agregar nuevo producto</a></li>
				<li><a href="${home}/listado_fabricantes">fabricantes que suministran productos</a></li>
			</ul>
		</nav>
		<hr>
		<h2>listado de clientes</h2>
	</header>
	<main class="cuerpo">
		<form id="buscar-prod" action="${home}/buscar_productos" method="post">
			<label for="valor">buscar productos:</label>
			<input class="input_reg" id="valor" type="text" name="valor"
				placeholder="&#128269;"/>
			<div id="botones">
				<input id="buscar-prod" class="boton" type="submit"
					value="buscar">
			</div>
		</form>

		<div id="tabla-clientes">
			<table id="tabla_datos">
				<thead>
					<tr>
						<th>descripcion</th>
						<th>precio</th>
						<th>fabricante</th>
						<th>añadir nuevo</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="producto" items="${productos}">
						<tr id="${producto.idProducto}">
							<td>${producto.producto}</td>
							<td>${producto.precio}</td>
							<td>${producto.fabricante}</td>
							<td><a href="${home}/cuentas?id=${cliente.idCliente}">+</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan=7>cantidad productos: ${productos.size()}</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</main>
</body>
</html>
