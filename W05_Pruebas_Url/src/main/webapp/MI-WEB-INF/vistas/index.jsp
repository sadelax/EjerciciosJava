<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>index</title>
	<link rel="stylesheet" type="text/css" href="${css}/index.css">
</head>
<body>
	<div id="cabecera">
		<h2>Hola, <c:out value="${usuario}"/>!</h2>
	</div>
	<div id="cuerpo">
		<p>A continuación te muestro unas imágenes que te servirán para el desarrollo del curso</p>
		<p>(pasa el cursor por encima para poder visualizarlas):</p>
		<div id="imagenes">
			<img src="https://miro.medium.com/v2/resize:fit:640/1*MMDphOGx_jetXb0RhBnRIw.gif" alt="Descripción de la imagen">
			<img src="https://miro.medium.com/v2/resize:fit:640/1*Hd6mWoraRdfF2e4d2XkDRA.gif" alt="Descripción de la imagen">
			<img src="https://miro.medium.com/v2/resize:fit:640/format:webp/1*DfLKHreOsvXedQcrgFjM7Q.png" alt="Descripción de la imagen">
			<img src="https://miro.medium.com/v2/resize:fit:640/1*z31nIcES1bnEww-_JCjVEA.gif" alt="">
			<img src="https://miro.medium.com/v2/resize:fit:640/1*8zZd2dsfruj54TLND5ZZVA.gif" alt="">
			<img src="https://miro.medium.com/v2/resize:fit:640/1*-p6P0HBhpo2jzJQWkC-SfA.gif" alt="">
			<img src="https://miro.medium.com/v2/resize:fit:720/format:webp/1*isxywYFPEui0YbcXNkPGMw.png" alt="">
			<img src="https://miro.medium.com/v2/resize:fit:720/1*KZDtf6VdhTm45oOOme9Bjw.gif" alt="">
			<img src="https://miro.medium.com/v2/resize:fit:720/1*x96b41G9y84eC--p18ghcQ.gif" alt="">
			<img src="https://miro.medium.com/v2/resize:fit:640/1*fyvrwRvoOY4buJh0Xr5T-A.gif" alt="">
			<img src="https://miro.medium.com/v2/resize:fit:640/1*6VYc7_CA0gxmt3sQiCc2PA.gif" alt="">
			<img src="https://miro.medium.com/v2/resize:fit:720/1*zbrn1mF-L4819HDKHHIXuQ.gif" alt="">
			<img src="https://miro.medium.com/v2/resize:fit:640/1*cX3aIu7Lcqw-BSviSi9mDg.gif" alt="">
			<img src="https://miro.medium.com/v2/resize:fit:640/1*hMR8hdQIcssq2tHeU5Axjg.gif" alt="">
			<img src="https://miro.medium.com/v2/resize:fit:720/1*-FH6An0jPOsOmTQTbJDavA.gif" alt="">
			<img src="https://miro.medium.com/v2/resize:fit:720/format:webp/1*SOycLdthNrq7Qtx7vojB0A.png" alt="">
			<img src="https://miro.medium.com/v2/resize:fit:640/1*oO1bCXhhLR3kIsG662Wwuw.gif" alt="">
			<img src="https://miro.medium.com/v2/resize:fit:640/format:webp/1*47aZu9SXNThIHTnMA_Ihtg.png" alt="">
		</div>
	</div>
</body>
</html>