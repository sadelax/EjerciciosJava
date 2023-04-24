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
	<title>Document</title>
	<link rel="stylesheet" href="${css}/index.css">
	<script>

 		function validaForm(ev){

			ev.preventDefault();
 			console.log("has hecho submit");

			var nombre = document.getElementById("name").value;
 			var usuario = document.getElementById("user").value;
 			var email = document.getElementById("email").value;
 			var pwd = document.getElementById("pwd").value;
 			var pwd2 = document.getElementById("pwd2").value;
 			var error = document.getElementById("error");

 			if(!nombre.trim() || !usuario.trim() || !email.trim() || !pwd.trim() || !pwd2.trim()) {
 				error.textContent = "todos los campos son obligatorios";
 			} else if(pwd != pwd2) {
 				error.textContent = "las password no coinciden";
 			} else {
 				error.textContent = "";
 				this.submit();				
 			}
 		}

		window.onload = function(){
			document.getElementById("frm_reg").addEventListener("submit", validaForm);
		}
	</script>
</head>
<body>
	<div id="cabecera">
		<h2>&#127812; registro &#127812;</h2>
	</div>
	<div id="formulario_reg">
		<form id="frm_reg" action="${home}/registro_usuario" method="post" autocomplete="off">
			<input class="input_reg" id="nombre (*)" type="text" name="nombre" placeholder="nombre" required="required"></input>
			<input class="input_reg" id="user (*)" type="text" name="usuario" placeholder="usuario" required="required"></input>
			<input class="input_reg" id="email (*)" type="text" name="email" placeholder="e-mail" required="required"></input>
			<input class="input_reg" id="ciudad" type="text" name="ciudad" placeholder="ciudad"></input>
			<input class="input_reg" id="pais" type="text" name="pais" placeholder="paÃ­s"></input>
			<input class="input_reg" id="pwd (*)" type="password" name="password" placeholder="password" required="required"></input>
			<input class="input_reg" id="pwd2 (*)" type="password" name="password-bis" placeholder="repita password" required="required"></input>
			<div id="botones">
				<input id="login" class="boton" type="submit" value="registrarme">
				<p><a href="${home}/login">volver a la pÃ¡gina de login</a>.</p>
			</div>
		</form>
		<p id="error"></p>
	</div>
</body>
</html>
