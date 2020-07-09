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
<link rel=stylesheet href="<c:url value="resources/Estilos/styles.css"/>" type="text/css" media=screen>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script type="text/javascript" src="<c:url value="resources/Funciones/funciones.js"/>"></script>
</head>
<body>
<%@ include file="NavbarClient.html"%>
	<!-- END NAVBAR -->

	<!-- CONTENT -->
<div class="container-md">
<form id="formTransferencia" action="nuevaTransferencia.html" method="post" style="padding: 20px">
<fieldset class="border p-2">
<legend class="w-auto">Nueva transferencia - Cuenta propia</legend>
  <div class="form-group" >
    <label for="cuentaDeb">Cuenta a debitar</label>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Cuenta</label>
  </div>
  <select name="cuentaOrigen" class="custom-select" id="cuentaOrigen">
  <c:forEach items="${cuentasUsuario}" var="cuentaO" varStatus="loop">
    <option value="${cuentaO.idCuenta}">${cuentaO.tipoCuenta.descripcion} - ${cuentaO.alias} - <fmt:formatNumber type="number" pattern="00" minIntegerDigits="22" value="${cuentaO.cbu}"/> - ${cuentaO.tipoCuenta.moneda} : $ <fmt:formatNumber type="number" maxFractionDigits="2" value="${cuentaO.saldo}" /></option>
  </c:forEach>
  </select>
</div>
  </div>
  <div class="form-group">
    <label for="cuentaAc">Cuenta a acreditar</label>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="cuentaDestino">Cuenta</label>
  </div>
  <select class="custom-select" name="cuentaDestino" id="cuentaDestino">
  <c:forEach items="${cuentasUsuario}" var="cuentaD">
    <option value="${cuentaD.idCuenta}">${cuentaD.tipoCuenta.descripcion} - ${cuentaD.alias} - <fmt:formatNumber type="number" pattern="00" minIntegerDigits="22" value="${cuentaD.cbu}"/> - ${cuentaD.tipoCuenta.moneda} : $ <fmt:formatNumber type="number" maxFractionDigits="2" value="${cuentaD.saldo}" /></option>
  </c:forEach>
  </select>
</div>
  </div>
  <div class="form-group">
    <label for="formGroupImporte">Importe</label>
    <div class="input-group mb-3">
    <div class="input-group-prepend">
    <label class="input-group-text" for="importe">$</label>
    </div>
    <input id="importe" name="importe" onkeypress="return soloNumeros(event);" type="text" class="form-control" id="formGroupImporte" placeholder="1000.00">
  </div>
  </div>
    <div class="form-group">
    <label for="formGroupMotivo">Motivo</label>
    <input id="motivo" name="motivo" type="text" class="form-control" id="formGroupMotivo" placeholder="Varios">
  </div>
  <div class="form-group form-check">
    <input  type="checkbox" class="form-check-input" id="checkTerminos">
    <label class="form-check-label" for="exampleCheck1">Acepto los términos y condiciones</label>
  </div>
  <button id="btnTransferir" type="button" onClick="verificarCampos()" class="btn btn-primary btn-lg btn-block">Transferir</button>
  </fieldset>
</form>
</div>

	<!-- END CONTENT -->

</body>
<script type="text/javascript">
   
   function verificarCampos(){
	   var origen = $("#cuentaOrigen").children("option:selected").val();
	   var destino = $("#cuentaDestino").children("option:selected").val();
	   var cuentas = "";
	   $.ajax({
			url: '${request.getContextPath()}/TP_L5_GRUPO_2/datosCuentas.html',
			type: 'POST',
	        data: { idOrigen: origen,
	        	    idDestino: destino},
			success: function(data){
				cuentas = JSON.parse(data);
				   var importeFloat = parseFloat($("#importe").val());
				   var importe = parseFloat($("#importe").val()).toLocaleString(undefined);
				   
				   if($("#motivo").val() == ""){
					   var motivo = "Varios";		   
				   }
				   else{
				   		var motivo = $("#motivo").val(); 			   
				   }
				    	
				   if(cuentas[0].idCuenta == cuentas[1].idCuenta){
					   Swal.fire({
						   title: "Atención!",
						   icon: "warning",
						   text: "Ambas cuentas seleccionadas iguales",
						   confirmButtonText: "Entendido"
					   })
				   }
				   else if(cuentas[0].tipoCuenta.moneda != cuentas[1].tipoCuenta.moneda){
					   Swal.fire({
						   title: "Atención!",
						   icon: "warning",
						   text: "Las cuenta seleccionadas poseen diferentes tipos de moneda",
						   confirmButtonText: "Entendido"
					   }) 
				   }
				   else if($("#importe").val() == "" || importeFloat == 0){
					   Swal.fire({
						   position: "top-end",
						   text: "Debe ingresar un importe para realizar la transferencia.",
					   	   toast: true,
					   	   timer: 8000,
					   	   timerProgressBar: true,
					   })
				   }
				   else if(!$("#checkTerminos").prop("checked")){
					   Swal.fire({
						   position: "top-end",
						   text: "Debe aceptar los términos y condiciones.",
					   	   toast: true,
					   	   timer: 8000,
					   	   timerProgressBar: true,
					   })
				   }
				   else if(cuentas[0].saldo < importeFloat){
					   Swal.fire({
						   title: "Atención!",
						   icon: "warning",
						   text: "El importe ingresado es mayor al saldo de la cuenta de origen.",
						   confirmButtonText: "Entendido"
					   })
				   }
				   else{
					   Swal.fire({
						   title: 'Confirmar transferencia',
						   html: 
						    '<p>Cuenta a debitar: ' + cuentas[0].alias + '</p>' +
				        	'<p>Cuenta a acreditar: '  + cuentas[1].alias + '</p>' +
			       			'<p>Importe: $' + importe + '</p>' +
			       			'<p>Motivo: ' + motivo  + '</p>',
						   showCancelButton: true,
						   reverseButtons: true,
						   cancelButtonText: 'Cancelar',
						   confirmButtonText: 'Transferir'}).then((result) => {
							   if(result.value){
								   var cuentaOrig = $("#cuentaOrigen option:selected").val();
								   var cuentaDest = $("#cuentaDestino option:selected").val();
								   var importeIngresado = $("#importe").val();
								   var motivoIngresado = $("#motivo").val();
								   $('html, body').css("cursor", "wait");
								   $.ajax({
										url: '${request.getContextPath()}/TP_L5_GRUPO_2/nuevaTransferencia.html',
										type: 'POST',
								        data: { cuentaOrigen: cuentaOrig,
								        		cuentaDestino: cuentaDest,
								        		importe : importeIngresado,
								        		motivo: motivoIngresado},
										success: function(data){
											$('html, body').css("cursor", "auto");
											if(data == "\"Exito\""){
												Swal.fire({
													icon: "success",
													title: "Transferencia realizada",
													confirmButtonText: "Entendido"
												}).then((result) => {
													if(result.value){
														location.reload();
													}
												})
											}
											else{
												Swal.fire({
													icon: "error",
													title: "La transferencia falló",
													confirmButtonText: "Entendido"
												})
											}
										}
									}); 					   
							   }
						   })
				   }
			}
		}); 
	   

   }
</script>
</html>
