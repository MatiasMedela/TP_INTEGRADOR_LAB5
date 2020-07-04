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
<form style="padding: 20px">
<fieldset class="border p-2">
<legend class="w-auto">Nueva transferencia - Cuenta de terceros</legend>
  <div class="form-group">
    <label for="cuentaDeb">Cuenta a debitar</label>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Cuenta</label>
  </div>
  <select class="custom-select" name="cuentaOrigen" id="cuentaOrigen">
  <c:forEach items="${cuentasUsuario}" var="cuentaD">
    <option value="${cuentaD.idCuenta}">${cuentaD.tipoCuenta.descripcion} - ${cuentaD.alias} - <fmt:formatNumber type="number" pattern="00" minIntegerDigits="22" value="${cuentaD.cbu}"/> - ${cuentaD.tipoCuenta.moneda} : $ <fmt:formatNumber type="number" maxFractionDigits="2" value="${cuentaD.saldo}" /></option>
  </c:forEach>
  </select>
</div>
  </div>

  <div class="form-group">
    <label for="formGroupCBU">CBU</label>
    <input type="text" class="form-control" name="CBUCuenta" id="formGroupCBU" placeholder="0110357805411825791353">
  </div>

  <div class="form-inline mb-2">
<button id="btnVerificarCBU" type="button" class="btn btn-primary">Verificar CBU</button> 
<small id="userCBUIngresado" class="ml-2 form-text text-muted"></small>
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
    <input type="checkbox" class="form-check-input" id="checkTerminos">
    <label class="form-check-label" for="exampleCheck1">Acepto los términos y condiciones</label>
  </div>	
  <button type="button" onClick="verificarCampos()" class="btn btn-primary btn-lg btn-block">Transferir</button>
  </fieldset>
</form>
</div>
	<!-- END CONTENT -->

</body>
<script type="text/javascript">
$("#btnVerificarCBU").click(function(){
	if($(this).val() != ""){	
	var cbu = $("#formGroupCBU").val();
    $.ajax({
		url: '${request.getContextPath()}/TP_L5_GRUPO_2/verificarCBU.html',
		type: 'POST',
        data: { CBU: cbu },
		success: function(data){
			if(data == "\"CBU userAct\""){
				Swal.fire({
					icon: "warning",
					title: "CBU Incorrecto",
					text: "El CBU ingresado corresponde a otra cuenta de su propiedad, para transferir entre cuentras propias debe volver al menú de transferencias y seleccionar Transferencia a cuenta propia",
					confirmButtonText: "Entendido"
				})
			}
			else{
		    var obj = JSON.parse(data)
		    	$("#userCBUIngresado").html("CBU correspondiente a: "+obj.usuario.Apellido + ", " + obj.usuario.Nombre +" DNI: " + obj.usuario.Dni)
				Swal.fire({
					icon: "success",
					title: "Cuenta encontrada",
					html: "<p>El CBU ingresado corresponde a</p>" +
					      "<p>"+ obj.usuario.Apellido + ", " + obj.usuario.Nombre + 
						  " DNI: " + obj.usuario.Dni + "</p>",
					confirmButtonText: "Entendido"
				})
			}
		}
	});
	}
	else{
	   Swal.fire({
		   position: "top-end",
		   text: "Debe ingresar un CBU para verificarlo.",
	   	   toast: true,
	   	   timer: 8000,
	   	   timerProgressBar: true,
	   })
	}
})

   function verificarCampos(){
	   var saldoString = $("#cuentaOrigen option:selected").html().substring($("#cuentaOrigen option:selected").html().indexOf("$")+2);
	   var saldo = parseFloat(saldoString.slice(0, saldoString.indexOf(".")) + saldoString.slice(saldoString.indexOf(".")+1));
	   var importeFloat = parseFloat($("#importe").val());
	   var cuentaO = $("#cuentaOrigen option:selected").html().substring(0, $("#cuentaOrigen option:selected").html().indexOf("-")-1);
	   var cbuDestino = $("#formGroupCBU").val();
	   var importe = parseFloat($("#importe").val()).toLocaleString(undefined);
	   
	   if($("#motivo").val() == ""){
		   var motivo = "Varios";		   
	   }
	   else{
	   		var motivo = $("#motivo").val(); 			   
	   }
	    	
	   if($("#importe").val() == ""){
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
	   else if(saldo < importeFloat){
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
			    '<p>Cuenta a debitar: ' + cuentaO + '</p>' +
	        	'<p>CBU a depositar: '  + cbuDestino + '</p>' +
       			'<p>Importe: $' + importe + '</p>' +
       			'<p>Motivo: ' + motivo  + '</p>',
			   showCancelButton: true,
			   reverseButtons: true,
			   cancelButtonText: 'Cancelar',
			   confirmButtonText: 'Transferir'}).then((result) => {
				   if(result.value){
					 $("#formTransferenciaTerceros").submit();   					   
				   }
			   })
	   }
   }
</script>

</html>