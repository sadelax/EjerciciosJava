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
	<title>menú principal</title>
	<link rel="stylesheet" href="${css}/index.css">
	<script>
	
	</script>
</head>
<body>
	<div class="cabecera">
		<h2>menú principal</h2>
	</div>
	<div class="cuerpo">
		<ul>
			<li><a href="${home}/listado_usuarios">listado de usuarios</a></li>
			<li><a href="${home}/nominas">liquidación de nóminas</a></li>
			<hr>
			<li><a href="${home}/cerrar_sesion">cerrar sesión</a></li>
		</ul>

	</div>
</body>
</html>
