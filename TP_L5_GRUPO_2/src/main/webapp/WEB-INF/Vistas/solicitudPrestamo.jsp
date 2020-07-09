<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
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
<link rel=stylesheet
	href="<c:url value="resources/Estilos/styles.css"/>" type="text/css"
	media=screen>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script type="text/javascript" src="<c:url value="resources/Funciones/funciones.js"/>"></script>
<title>Solicitar préstamo</title>
</head>
<body>
<%@ include file="NavbarClient.html"%>
	<!-- END NAVBAR -->

	<!-- CONTENT -->

	<div class="container-md">
	<fieldset class="border p-2">
	<legend class="w-auto">Solicitar préstamo</legend>
	<div class="container-sm mt-4 container-prestamo rounded-lg">
		<div class="row pt-4">
			<div class="col-4 pt-2 mb-3 align-items-center"
				style="text-align: right;">
				<p>Cuenta:</p>
			</div>
			<div class="col-8 mb-3">
				<select id="cuentaSelect" class="custom-select form-prestamo" id="inputGroupSelect01">
					<c:forEach items="${listadoCuentas }" var="cuenta">
						<option value="${cuenta.idCuenta}">${cuenta.alias} - <fmt:formatNumber type="number" pattern="00" minIntegerDigits="22" value="${cuenta.cbu}"/></option>
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
				<input id="importeSolicitado" onkeypress="return soloNumeros(event);" type="text" class="form-control"
					placeholder="100000">
			</div>
			 <p class="flex text-secondary" style="position: absolute;top: 260px;right: 430px;">Monto mínimo $1000</p>
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
		<div style="justify-content: center; display: flex;">
		<button id="solicitarModal" class="btn mb-3 btn-primary" disabled >Solicitar</button>
		</div>
		</div>
	</fieldset>
	</div>
	<!-- END CONTENT -->
</body>
<script type="text/javascript">
$(document).ready(function(){
	
	CurrentItem = document.getElementById("mnPrestamos");
	CurrentItem.className +=" active";
	
	$("#solicitarModal").click(function(){
		if(parseFloat($("#importeSolicitado").val()) >= 1000){
		var id = $("#cuentaSelect").val();
		var cuenta = $("#cuentaSelect option:selected").text();
		var importeSelect = parseFloat($("#importeSolicitado").val());
		var mesesSelect = $("#mesesSelect option:selected").text();
		var importePagar = parseFloat($("#importeSolicitado").val())*1.25;
		Swal.fire({
			html:"<p>Cuenta:</p>" +
				"<p>"+ cuenta +"</p>" + 
				"<div class='row'>" +
						"<div class='col-6 text-right'>" +
						"<p>Importe solicitado:</p>" +
						"<p>Cantidad de meses:</p>" +
						"<p>Total a pagar:</p>" +
					"</div>" +
					"<div class='col text-left'>" +
						"<p>$"+ importeSelect.toLocaleString() +"</p>" +
						"<p>"+ mesesSelect +"</p>" +
						"<p>$"+ importePagar.toLocaleString() +"</p>" +
					"</div>" +
				"</div>",
			showCancelButton: true,
			reverseButtons: true,
			cancelButtonText: "Cancelar",
			confirmButtonText: "Solicitar"
		}).then((result) => {
			if(result.value){
				$.ajax({
					url: '${request.getContextPath()}/TP_L5_GRUPO_2/cargarPrestamoAsync.html',
					type: 'POST',
			        data: { idCuenta: id,
			        	    importe: importeSelect,
			        	    meses: mesesSelect ,
			        	    importeAPagar: importePagar},
					success: function(data){
						if(data == "\"Exitoso\""){
							Swal.fire({
								icon: "success",
								title: "Prestamo solicitado",
								confirmButtonText: "Entendido"
							}).then((result) => {
								if(result.value){
									document.location.href = "/TP_L5_GRUPO_2/redirecNavBar.html?prestamos"
								}
							})
						}
						else{
							Swal.fire({
								icon: "error",
								title: "Hubo un error al solicitar el préstamo",
								confirmButtonText: "Entendido"
							})
						}
					}
			 });
			}
		})
		}else{
			Swal.fire({
				icon: "warning",
				title:"El monto mínimo es de $1000",
				confirmButtonText: "Entendido"
			})
		}
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


