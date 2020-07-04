<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<link rel=stylesheet
	href="<c:url value="resources/Estilos/styles.css"/>" type="text/css"
	media=screen>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
</head>
<body>
	<!-- END NAVBAR -->
	<%@ include file="NavbarClient.html"%>
	<!-- CONTENT -->

	<div class="container-md">
		<h3 style="margin-top: 20px;">Mis cuentas</h3>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Tipo de cuenta</th>
					<th scope="col">Identificación</th>
					<th scope="col">Moneda</th>
					<th scope="col">Saldo</th>
					<th scope="col" style="text-align: center;">Detalle</th>
					<th scope="col" style="text-align: center;">Movimientos</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ listadoCuentasUsuario }" var="cuenta" varStatus="loop">
					<form action="listarMovimientosCuenta.html" method="get">
					<tr>
						<input type="hidden" name="CbuCuenta" value="${cuenta.cbu}" id="Cbu${loop.index}" />
						<input type="hidden" name="AliasCuenta" value="${cuenta.alias}">
						<td id="Tipo${loop.index}">${cuenta.tipoCuenta.descripcion}</td>
						<td id="Ident${loop.index}">${cuenta.alias}</td>
						<td id="Moneda${loop.index}">${cuenta.tipoCuenta.moneda}</td>
						<td id="Saldo${loop.index}">${cuenta.saldo}</td>
						<td><button onClick="mostrarModalDetalles(${loop.index})"
								type="button" class="btn btn-grid btn-light" data-toggle="modal"
								data-target="#ModalDetails">Ver detalles</button></td>
						<td><button	type="submit" class="btn btn-grid btn-light" >Ver movimientos</button></td>
					</tr>
						</form>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<!-- END CONTENT -->

	<!-- MODAL DETAILS -->
	<div class="modal fade" id="ModalDetails" tabindex="-1" role="dialog"
		aria-labelledby="ModalDetailsAccount" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Detalle de
						cuenta</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-4" style="text-align: right;">
							<p>Tipo de cuenta:</p>
							<p>Identificación:</p>
							<p>Moneda:</p>
							<p>CBU:</p>
							<p>ALIAS CBU:</p>
							<p>Saldo:</p>
						</div>
						<div class="col-8">
							<p id="Tipo">Caja ahorro en pesos</p>
							<div class="row">
								<div class="col-8">
									<p id="text-ident">Cuenta principal</p>
									<input id="input-ident" type="text"
										class="form-control form-detalle" value="Cuenta principal"
										hidden>
								</div>
								<div class="col-4">
									<p class="edit-text" id="edit-ident">Editar</p>
								</div>
							</div>
							<p id="Moneda">Pesos</p>
							<div class="row">
								<div class="col-8">
									<input class="input-copy" readonly id="Cbu" value="0000000000000000000000"/>
								</div>
								<div class="col-4">
									<button data-toggle="tooltip" data-placement="top" title="CBU copiado!" onClick="copiarCBU()" class="edit-text" id="copy-cbu">Copiar</button>
								</div>
							</div>
							<p id="Alias">WORD.WORD.WORD</p>
							<p id="Saldo">$10.000</p>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" disabled>Guardar
						cambios</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cerrar</button>
				</div>
			</div>
		</div>
	</div>
	<!-- END MODAL DETAILS -->
	<input type="hidden" value="${NombreDelUsuario}" id="userName" />
</body>

<script type="text/javascript">	
	CurrentItem = document.getElementById("mnInicio");
	CurrentItem.className +=" active";

	  $('#copy-cbu').tooltip({
			 trigger: "manual"
	  });
	
	$("#nombreUsuario").html($("#userName").val());
	
	$('#edit-ident').click(function() {
		if ($('#edit-ident').html() == "Editar") {
			$('#text-ident').attr('hidden', true);
			$('#input-ident').attr('hidden', false);
			$('#edit-ident').html('Aceptar');
		} else {
			$('#text-ident').attr('hidden', false);
			$('#input-ident').attr('hidden', true);
			$('#edit-ident').html('Editar');
		}
	})
	
	function copiarCBU(){
	  var copyText = document.getElementById("Cbu");
	  copyText.select();
	  document.execCommand("copy");
	  copyText.blur();
	  $('#copy-cbu').tooltip("show");
	  }
	
	
	function mostrarModalDetalles(index){
		var cbu = parseInt($("#Cbu" + index).val())
		$("#Saldo").html($("#Saldo" + index).html())
		$("#Tipo").html($("#Tipo" + index).html())
		$("#Moneda").html($("#Moneda" + index).html())
		$("#text-ident").html($("#Ident" + index).html())
		$("#Cbu").val(cbu.toString().padStart(22,"0"))
	}
	
</script>
</html>


