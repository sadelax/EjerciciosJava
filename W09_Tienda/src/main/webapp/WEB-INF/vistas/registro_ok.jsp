<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Registro</title>
	<link rel="stylesheet" type="text/css" href="${css}/general.css">
</head>
<body>
	<header class="cabecera">
		<h1>Registro de Usuarios</h1>
	</header>
	<div id="contPrincipal">
		<p class="info"><c:out value="${nombre}" /> te has registrado correctamente</p>
		<p class="info">Usuario: <c:out value="${usuario}" /></p>
		<a href="${home}/login"><button class="boton">Login</button></a>
	</div>
</body>
</html>