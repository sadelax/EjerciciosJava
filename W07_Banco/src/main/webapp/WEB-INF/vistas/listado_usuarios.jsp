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
		<h2>listado de usuarios</h2>
	</header>
	<main class="cuerpo">
	
		<div id="tabla-usuarios">
			<table id="tabla_datos">
				<thead>
					<tr>
						<th>id usuario</th>
						<th>nombre</th>
						<th>usuario</th>
						<th>password</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="usr" items="${usuarios}">
						<tr>
							<td>${usr.idUsuario}</td>
							<td>${usr.name}</td>
							<td>${usr.username}</td>
							<td>${usr.password}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan=4>cantidad usuarios: ${usuarios.size()}</td>
					</tr>
				</tfoot>
			</table>
		</div>
		<div id="botones">
			<p>
				<a href="${home}/menu_principal">volver al menú principal</a>
			</p>
		</div>
	</main>
</body>
</html>
