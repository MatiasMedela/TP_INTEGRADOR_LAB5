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
<link rel=StyleSheet href="styles.css" type="text/css" media=screen>
</head>
<body>
<%-- <jsp:include page="NavbarClient.html"></jsp:include> --%>
<%@ include file="NavbarClient.html" %>
	<!-- END NAVBAR -->

	<!-- CONTENT -->
<div class="container-md">
<form style="padding: 20px">
<fieldset class="border p-2">
<legend class="w-auto">Nueva transferencia - Cuenta propia</legend>
  <div class="form-group" >
    <label for="cuentaDeb">Cuenta a debitar</label>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Cuenta</label>
  </div>
  <select class="custom-select" id="inputGroupSelect01">
    <option selected>CA - 2154-135977/2 - CUENTA - PESOS: $10.000,00</option>
    <option value="1">CA - 2154-186273/4 - CUENTA - DOLARES: U$D 1.000,00</option>

  </select>
</div>
  </div>

  <div class="form-group">
    <label for="cuentaAc">Cuenta a acreditar</label>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Cuenta</label>
  </div>
  <select class="custom-select" id="inputGroupSelect01">
    <option selected>CA - 2154-135977/2 - CUENTA - PESOS: $10.000,00</option>
    <option value="1">CA - 2154-186273/4 - CUENTA - DOLARES: U$D 1.000,00</option>

  </select>
</div>
  </div>

  <div class="form-group">
    <label for="formGroupImporte">Importe</label>
    <input type="text" class="form-control" id="formGroupImporte" placeholder="1000">
  </div>
  
    <div class="form-group">
    <label for="formGroupMotivo">Motivo</label>
    <input type="text" class="form-control" id="formGroupMotivo" placeholder="Varios">
  </div>

  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Acepto los términos y condiciones</label>
  </div>
  </br>		
  <button type="submit" class="btn btn-primary btn-lg btn-block">Transferir</button>
  </fieldset>
</form>
</div>



	</div>
	<!-- END CONTENT -->

</body>
</html>
