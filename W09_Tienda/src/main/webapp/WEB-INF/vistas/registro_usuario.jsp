<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registro</title>
<link rel="stylesheet" type="text/css" href="${css}/formularios.css">
<script type="text/javascript">
	function validaForm(ev) {
		ev.preventDefault();
		var nombre = document.getElementById("nombre").value;
		var usuario = document.getElementById("usuario").value;
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
		var password2 = document.getElementById("password2").value;
		var mensaje = document.getElementById("error");

		if (!nombre.trim() || !usuario.trim() || !email.trim() || !password.trim()
				|| !password2.trim()) {
			mensaje.textContent = "Todos los campos son obligatorios";
		} else if (password != password2) {
			mensaje.textContent = "Las passwords no coinciden";
		} else if (!checkPassword(password)) {
			mensaje.innerHTML = "Password incorrecta <br/> Minimo 8 caracteres y al menos 1 minuscula, 1 mayuscula y 1 numero";
		} else {
			mensaje.textContent = '';
			// 		ev.currentTarget.submit();
			this.submit();
		}
	}

	function checkPassword(pass) {
		// 	var myregex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
		// 	return myregex.test(pass); 
		return true;
	}

	window.onload = function() {
		document.getElementById("frm_reg").addEventListener("submit",
				validaForm);
	};
</script>
</head>
<body>
	<header class="cabecera">
		<h1>Registro Usuarios</h1>
	</header>
	<div id="contPrincipal">
		<form id="frm_reg" action="${home}/registro" method="post"
			autocomplete="off">
			<input id="nombre" name="nombre" placeholder="Nombre"> 
			<input id="usuario" name="usuario" placeholder="Usuario">
			<input id="email" name="email" type="email" placeholder="Correo electronico">
			<input id="password" name="password" type="password" placeholder="Password">
			<input id="password2" name="password2" type="password" placeholder="Repita Password"> 
			<button class="boton" type="submit">Registro</button>
			<p id="error">
				<c:choose>
					<c:when test="${error eq 'pass' or error eq 'obli'}">
						<c:out value="${nombre}" /> no fue posible registrarte
					</c:when>
					<c:when test="${error eq 'existe'}">
						<c:out value="${nombre}" /> no fue posible registrarte
							El usuario <c:out value="${usuario}" /> ya existe
					</c:when>
				</c:choose>
			</p>
		</form>
	</div>
</body>
</html>