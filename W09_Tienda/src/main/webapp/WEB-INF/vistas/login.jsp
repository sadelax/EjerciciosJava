<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${css}/formularios.css">
<script type="text/javascript">
	function validaForm(ev) {
		ev.preventDefault();
		var usuario = document.getElementById("usr").value;
		var password = document.getElementById("pwd").value;
		var mensaje = document.getElementById("error");

		if (!usuario.trim() || !password.trim()) {
			mensaje.textContent = "Todos los campos son obligatorios";
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
		document.getElementById("frm_login").addEventListener("submit",
				validaForm);
	};
</script>
</head>
<body>
	<header class="cabecera">
		<h1>Acceso Usuarios</h1>
	</header>
	<div id="contPrincipal">
		<form id="form_login" action="${home}/login" method="post">
			<input id="usr" name="usuario" type="text" placeholder="Usuario" autofocus="autofocus"> 
			<input id="pwd" name="password" type="password" placeholder="Password"> 
			<button class="boton" type="submit">Login</button>
		</form>
		<a id="registro" href="${home}/registro">Registrarse</a>
		<div id="mensajes">
			<p id="error">
				<c:if test="${error eq 'login'}">
				Credenciales incorrectas
			</c:if>
			</p>
		</div>
	</div>
</body>
</html>