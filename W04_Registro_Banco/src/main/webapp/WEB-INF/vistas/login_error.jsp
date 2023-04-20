<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>error en el login</title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<div id="cabecera">
		<h4>login incorrecto</h4>
	</div>
	<div id="cuerpo">
		<c:choose>
			<c:when test="${error eq 'inexistente'}">
				<p id="campos_obligatorios">el usuario no existe &#9785;</p>
			</c:when>
			<c:when test="${error eq 'oblig'}">
				<p id="campos_obligatorios">todos los campos son obligatorios</p>
			</c:when>
		</c:choose>
	</div>
	<div id="botones">
		<p>no estás registrado? <a href="registro.html">regístrate</a>!</p>
		<p><a href="login.html">volver a la página de login</a>.</p>
	</div>
</body>
</html>