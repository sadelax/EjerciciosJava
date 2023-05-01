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
	<title>Felicidades!</title>
	<link rel="stylesheet" href="${css}/index.css">
</head>
<body>
	<div id="cabecera">
		<h4><c:out value="${clienteNuevo.nombre}" /> se ha añadido con éxito a la base de datos.</h4>
	</div>
	<div id="registro_ok">
		<a href="${home}/menu_principal">volver al menú principal.</a>
	</div>
</body>
</html>
