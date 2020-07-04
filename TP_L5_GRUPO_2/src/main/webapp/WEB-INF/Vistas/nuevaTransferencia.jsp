<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<link rel=stylesheet href="<c:url value="resources/Estilos/styles.css"/>" type="text/css" media=screen>
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
  <c:forEach items="${cuentasUsuario}" var="cuentaO">
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
    <input name="importe" type="text" class="form-control" id="formGroupImporte" placeholder="1000">
  </div>
    <div class="form-group">
    <label for="formGroupMotivo">Motivo</label>
    <input name="motivo" type="text" class="form-control" id="formGroupMotivo" placeholder="Varios">
  </div>
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Acepto los términos y condiciones</label>
  </div>
  <button id="btnTransferir" type="button" onClick="verificarCuentasDistintas()" class="btn btn-primary btn-lg btn-block">Transferir</button>
  </fieldset>
</form>
</div>

<div id="confirmarModal" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Confirmar transferencia</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="row">
        	<div class="col-6 text-right">
        		<p>Cuenta a debitar:</p>
        		<p>Cuenta a acreditar:</p>
        		<p>Importe:</p>
        		<p>Motivo:</p>
        	</div>
        	<div class="col-6">
        		<p id="modalCuentaO"></p>
        		<p id="modalCuentaD"></p>
        		<p id="modalImporte"></p>
        		<p id="modalMotivo"></p>
        	</div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Transferir</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
      </div>
    </div>
  </div>
</div>

	<!-- END CONTENT -->

</body>
<script type="text/javascript">
   function verificarCuentasDistintas(){
	   var origen = $("#cuentaOrigen").children("option:selected").val();
	   var destino = $("#cuentaDestino").children("option:selected").val();
	   if(origen == destino){
		   alert("Ambas cuentas seleccionadas son la misma, seleccione diferentes cuentas!")
	   }
	   else{
		   $("#modalCuentaO").html();
		   $("#modalCuentaD").html();
		   $("#modalImporte").html();
		   $("#modalMotivo").html();
		   $("#confirmarModal").modal("toggle");
	   }
   }

		  /*  $("#formTransferencia").submit(); */
</script>
</html>
