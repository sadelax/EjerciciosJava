<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Ofertas</title>
	<link rel="stylesheet" type="text/css" href="${css}/ofertas.css">
	<link rel="stylesheet" type="text/css" href="${css}/formularios.css">
<script>

	var destino;
	var vacia;

	function borrarVacia() {
		if(vacia){
			destino.removeChild(vacia);
			vacia = null;
		}
	}

	function inicio(ev) {
		ev.dataTransfer.setData("id", ev.currentTarget.id);
	}

	function soltar(ev) {
		if (validaDescuento()) {
			ev.preventDefault();
			borrarVacia();
			var id = ev.dataTransfer.getData('id');
			if(id != '')
				moverFila(ev.currentTarget, document.getElementById(id));
		}
	}

	function mover(ev) {
		if (validaDescuento()) {
			borrarVacia();
			moverFila(destino, ev.currentTarget);
		}	
	}

	function moverFila(body, tr) {
		tr.removeEventListener('dragstart', inicio);
		tr.removeEventListener('dblclick', mover);
		//crear 1 td
		var tdDto = document.createElement('td');
		//crear 1 td
		var tdFinal = document.createElement('td');
		//hacer td1 hijo del tr
		tr.insertBefore(tdDto, tr.querySelector('td:nth-child(3)'));
		//hacer td2 hijo del tr
		tr.insertBefore(tdFinal, tr.querySelector('td:nth-child(4)'));
		//colocar el valor del input de descuento en el td1
		var descuento = (Number(document.getElementById('input_descuento').value)).toFixed(1);
		// Number('123');
		tdDto.textContent = descuento + ' %';
		//colocar el precio con descuento en el td2
		var precioActual = tr.querySelector('td:nth-child(2)').textContent;
		tdFinal.textContent = (Math.round((precioActual - precioActual * descuento / 100) * 100) / 100).toFixed(2);
		// ev.currentTarget.appendChild(document.getElementById(id));
		body.appendChild(tr);
	}

	function validaDescuento() {
		var iDto = document.getElementById('input_descuento').value;
		if (isNaN(iDto) || iDto <= 0 || iDto > 100) {
			alert('El descuento es incorrecto');
			return false;
		} else
			return true;
	}

	function enviar(ev) {
		ev.preventDefault();
		var idsOfertas = new Array();
		var descuentos = new Array();
		var filas = document.querySelectorAll('#tabla_ofertas tbody tr');
		for (var i=0; i<filas.length; i++){
			idsOfertas[i] = filas[i].id;
			var tdDcto = filas[i].querySelector('td:nth-child(3)').textContent;
			descuentos[i] = tdDcto.substring(0, tdDcto.length - 2);
		}
		document.querySelector('#id_prods').value = idsOfertas;
		document.querySelector('#descuentos').value = descuentos;
		this.submit();
	}

	window.onload = function(){
		var moviles = document.querySelectorAll('.moviles');
		for(var i=0; i<moviles.length; i++) {
			moviles[i].addEventListener('dragstart', inicio);
			moviles[i].addEventListener('dblclick', mover);
		}
		destino = document.querySelector('#tabla_ofertas tbody');
		destino.addEventListener('dragover', function(ev){ev.preventDefault();});
		destino.addEventListener('drop', soltar);

		vacia = document.querySelector('#vacia');

		document.getElementById('frm_envio').addEventListener('submit', enviar);

	};

</script>
</head>
<body>
	<div id="contPrincipal">
		<h1>Ofertas</h1>
		<div id="productos">
			<table id="tabla_datos" class="datos">
				<thead>
					<tr>
						<th>Descripcion</th>
						<th>Precio</th>
						<th>Fabricante</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="producto" items="${prods}">
						<tr id="${producto.idProducto}" draggable="true" class="moviles">
							<td>${producto.producto}</td>
							<td>${producto.precio}</td>
							<td>${producto.fabricante.fabricante}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
		<div id="ofertas">
			<input id="input_descuento" type="number" placeholder="Descuento 0-100"
			  min="0" max="100" step="0.1">
			<table id="tabla_ofertas" class="datos">
				<thead>
					<tr>
						<th>Descripcion</th>
						<th>Precio</th>
						<th>Dto</th>
						<th>c/Dto</th>
						<th>Fabricante</th>
					</tr>
				</thead>
				<tbody>
					<tr id="vacia"><td colspan="5"></td></tr>
				</tbody>
			</table>
			<form id="frm_envio" action="${home}/ofertas" method="post">
				<input id="id_prods" name="id_prods" type="hidden">
				<input id="descuentos" name="descuentos" type="hidden">
				<button type="submit">Enviar</button>
			</form>
		</div>	
		<a href="${home}/menu_principal"><button>Volver</button></a>
	</div>
</body>
</html>