<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>listado productos</title>
<link rel="stylesheet" href="${css}/ofertas.css">
<script>

	var destino;
	var vacia;

	function borrarVacia(){
		if(vacia){
			destino.removeChild(vacia);
			vacia = null;
		}
	}

	function inicio(ev){
		ev.dataTransfer.setData('id', ev.currentTarget.id);
		console.log(ev.currentTarget.id);
	}
	
	function soltar(ev){
		ev.preventDefault();
		borrarVacia();
		var id = ev.dataTransfer.getData('id');
		console.log(id);
		ev.currentTarget.appendChild(document.getElementById(id));
	}
	
	function mover(ev){
		borrarVacia();
		destino.appendChild(ev.currentTarget);
	}
	
	window.onload = function(){
		vacia = document.querySelector('#vacia');
		
		var moviles = document.querySelectorAll('.moviles');

		for(var i = 0; i < moviles.length; i++){
			moviles[i].addEventListener('dragstart', inicio);
			moviles[i].addEventListener('dblclick', mover);
		}
		destino = document.querySelector('#tabla_ofertas tbody');
		destino.addEventListener('dragover', 
		function(ev){
			ev.preventDefault();
		});
		destino.addEventListener('drop', soltar);

	}
</script>
</head>
<body>
	<header class="cabecera">
		<nav>
			<ul>
				<li><a href="${home}/listado_productos">listado de productos</a></li>
				<li><a href="${home}/registro_fabricante">alta nuevo fabricante</a></li>
				<li><a href="${home}/registro_producto">agregar nuevo producto</a></li>
				<li><a href="${home}/productos_fabricante">productos por fabricante</a></li>
				<li><a href="${home}/ofertas">ofertones</a></li>
			</ul>
		</nav>
		<hr>
		<h2>ofertas</h2>
	</header>
	<main class="container">
		<div id="productos">
			<table id="tabla_datos" class="datos">
				<thead>
					<tr>
						<th>descripcion</th>
						<th>precio</th>
						<th>fabricante</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="producto" items="${productos}">
						<tr id="${producto.idProducto}" draggable="true" class="moviles">
							<td>${producto.producto}</td>
							<td>${producto.precio}</td>
							<td>${producto.fabricante}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="ofertas">
			<table id="tabla_ofertas" class="ofertas">
				<thead>
					<tr>
						<th>descripcion</th>
						<th>precio</th>
						<th>fabricante</th>
					</tr>
				</thead>
				<tbody>
					<tr id="vacia">
						<td colspan="3"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</main>
</body>
</html>
