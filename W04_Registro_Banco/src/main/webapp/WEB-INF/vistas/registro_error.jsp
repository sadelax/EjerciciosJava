<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>error en el registro</title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<div id="cabecera">
		<h1>registro incorrecto</h1>
	</div>
	<div id="cuerpo">
		<c:choose>
			<c:when test="${error eq 'pass'}">
				<p>los passwords no coinciden, inténtelo de nuevo.</p>
			</c:when>
			<c:when test="${error eq 'oblig'}">
				<p id="campos_obligatorios">todos los campos son obligatorios</p>
			</c:when>
		</c:choose>
	</div>
	<div id="botones">
		<p><a href="registro.html">volver al registro</a>.</p>
	</div>
</body>
</html>