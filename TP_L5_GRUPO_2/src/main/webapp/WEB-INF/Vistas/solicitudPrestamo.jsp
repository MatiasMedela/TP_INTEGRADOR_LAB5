<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<link rel=stylesheet
	href="<c:url value="resources/Estilos/styles.css"/>" type="text/css"
	media=screen>
<title>Solicitar préstamo</title>
</head>
<body>
<%@ include file="NavbarClient.html"%>
	<!-- END NAVBAR -->

	<!-- CONTENT -->

	<div class="container-md">
		<h3 style="margin-top: 20px;">Solicitar préstamo</h3>
	</div>
	<div class="container-sm mt-4 container-prestamo rounded-lg">
		<div class="row pt-4">
			<div class="col-4 pt-2 mb-3 align-items-center"
				style="text-align: right;">
				<p>Cuenta:</p>
			</div>
			<div class="col-8 mb-3">
				<select id="cuentaSelect" class="custom-select form-prestamo" id="inputGroupSelect01">
					<c:forEach items="${listadoCuentas }" var="cuenta">
						<option value="${cuenta.idCuenta}">${cuenta.alias}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="col-4 pt-2 mb-3" style="text-align: right;">
				<p>Importe:</p>
			</div>
			<div class="col-8 mb-3 input-group">
			  <div class="input-group-prepend">
			    <span class="input-group-text" style="height:38px;">$</span>
			  </div>
				<input id="importeSolicitado" type="text" class="form-control form-prestamo"
					placeholder="100.000">
			</div>
		</div>
		<div class="row">
			<div class="col-4 pt-2 mb-3" style="text-align: right;">
				<p>Meses:</p>
			</div>
			<div class="col-8 mb-3">
				<select class="custom-select form-prestamo-mes"
					id="mesesSelect">
					<option value="3">3</option>
					<option value="6">6</option>
					<option value="12">12</option>
					<option value="24">24</option>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="col-4 mb-3" style="text-align: right;">
				<p>Total a pagar:</p>
			</div>
			<div class="col-8 mb-3 form-inline">
				<p>$ </p><p id="totalAPagar"></p>
			</div>
		</div>
		<div style="justify-content: flex-end; display: flex;">
			<button id="solicitarModal" class="btn mb-3 btn-success" data-toggle="modal"
				data-target="#ModalPrestamo" disabled>Solicitar</button>
		</div>
	</div>
	<!-- END CONTENT -->

	<!-- MODAL DETAILS -->
	<div class="modal fade" id="ModalPrestamo" tabindex="-1" role="dialog"
		aria-labelledby="ModalDetailsPrestamo" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Confirmar
						solicitud de préstamo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-6" style="text-align: right;">
							<p>Cuenta:</p>
							<p>Importe solicitado:</p>
							<p>Cantidad de meses:</p>
							<p>Total a pagar:</p>
						</div>
						<div class="col">
							<p id="cuentaModal">Cuenta principal</p>
							<p id="importeSolicitadoModal">$100.000</p>
							<p id="mesesModal">3</p>
							<p id="importePagarModal">$125.000</p>
						</div>
					</div>
				</div>
				<form action="cargarPrestamo.html" method="post">
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
					<button type="submit" class="btn btn-success">Solicitar</button>
					<input id="idCuenta" type="hidden" name="idCuenta" value="" />		
					<input id="importe" type="hidden" name="importe" value="" />	
					<input id="meses" type="hidden" name="meses" value="" />	
					<input id="importeAPagar" type="hidden" name="importeAPagar" value="" />									
				</div>
				</form>
			</div>
		</div>
	</div>
	<!-- END MODAL DETAILS -->
	
	<div class="toast" role="alert" aria-live="assertive" aria-atomic="true" style="position: absolute; bottom: 0; right: 0;">
  <div class="toast-header">
    <strong class="mr-auto">Solicitud de préstamo</strong>
    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
  </div>
  <div class="toast-body">
  	<p>Ha ocurrido un error en la solicitud del préstamo.</p>
  </div>
</div>
<input type="hidden" id="resultadoSolicitud" value="${prestamo}"/>
</body>
<script type="text/javascript">
$(document).ready(function(){
	
	CurrentItem = document.getElementById("mnPrestamos");
	CurrentItem.className +=" active";
	
	$(".toast").toast({delay: 2000});
	
	if($("#resultadoSolicitud").val() == "Error"){
		$(".toast").toast('show');
	}
		
	$("#solicitarModal").click(function(){
		$("#cuentaModal").html($("#cuentaSelect option:selected").text());
		$("#importeSolicitadoModal").html("$" + parseFloat($("#importeSolicitado").val()).toLocaleString());
		$("#mesesModal").html($("#mesesSelect option:selected").text());
		$("#importePagarModal").html("$" + $("#totalAPagar").html());
		
		$("#idCuenta").val($("#cuentaSelect").val());
		$("#importe").val($("#importeSolicitado").val());
		$("#meses").val($("#mesesSelect option:selected").text());
		$("#importeAPagar").val(parseFloat($("#importe").val())*1.25);
	});
	
	$("#importeSolicitado").keyup(function(){
		var Total = parseFloat($(this).val()) * 1.25;
		if(Total > 0 ){
			$("#totalAPagar").html(Total.toLocaleString());			
			$("#solicitarModal").prop('disabled', false);
		}
		else{
			$("#totalAPagar").html(" .-");
			$("#solicitarModal").prop('disabled', true);
		}
	});
});
</script>

</html>


