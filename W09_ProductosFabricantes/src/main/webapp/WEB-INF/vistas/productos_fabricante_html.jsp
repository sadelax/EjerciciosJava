<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Productos</title>
	<link rel="stylesheet" type="text/css" href="${css}/productos.css">
	<link rel="stylesheet" type="text/css" href="${css}/formularios.css">
<script type="text/javascript">

function solicitud(){
	
	//Preparamos los parametros de la peticion - Ej:    idFabricante=17
	var params = "idFabricante=" + 
	      encodeURIComponent(document.getElementById("idFabricante").value);
	
	//Creamos req, objeto que nos permitira hacer la peticion
	var req = new XMLHttpRequest();	

	//Definimos el metodo y URL
	req.open("post", "productos_fabricante_html_respuesta");
	
// 	req.addEventListener('readystatechange', function(){});
	
	req.onreadystatechange = function(){
		if(req.readyState == 4 && req.status == 200){
			cargaTabla(req);
		}
	};
	
	// armar la cabecera
	req.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	
	//realizar la peticion
	req.send(params);
}

function cargaTabla(req){
	document.querySelector("#id_tabla").innerHTML = req.responseText;
}

window.onload = function(){
	document.getElementById("idFabricante").addEventListener("change", solicitud);
};

</script>
</head>
<body>
	<div id="contPrincipal">
		<h1>Búsqueda de Productos por Fabricante</h1>
		<select id="idFabricante" name="idFabricante">
			<c:if test="${empty fab}">
				<option hidden="hidden">Seleccione Fabricante</option>
			</c:if>
			<c:forEach var="fabricante" items="${fabs}">
				<option value="${fabricante.idFabricante}" 
				${fabricante.idFabricante==fab.idFabricante ? "selected='selected'" : ""}
				>${fabricante.fabricante}</option>
			</c:forEach>
		</select>
		<div id="id_tabla"></div>

		<a href="${home}/menu_principal"><button>Volver</button></a>
	</div>
</body>
</html>