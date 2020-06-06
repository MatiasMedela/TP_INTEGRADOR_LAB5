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
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#"> <img
			src="https://toppng.com/uploads/preview/indian-bank-icon-bank-sign-icon-11553435301aafxlgwngt.png"
			width="35" height="35" alt="" loading="lazy">
		</a>
		<!-- NAVBAR -->
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="./index.jsp">Inicio</a></li>
				<li class="nav-item"><a class="nav-link" href="./transferencias.jsp">Transferencias</a>
				</li>
				<li class="nav-item active"><a class="nav-link"
					href="./prestamos.jsp">Préstamos</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Cuenta </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Configuración</a> <a
							class="dropdown-item" href="#">Salir</a>
					</div></li>
			</ul>
		</div>
	</nav>
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
				<select class="custom-select form-prestamo" id="inputGroupSelect01">
					<option value="1">Cuenta principal</option>
					<option value="2">Cuenta secundaria</option>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="col-4 pt-2 mb-3"
				style="text-align: right;">
				<p>Importe:</p>
			</div>
			<div class="col-8 mb-3">
				<input type="text" class="form-control form-prestamo"
					placeholder="$100.000">
			</div>
		</div>
		<div class="row">
			<div class="col-4 pt-2 mb-3"
				style="text-align: right;">
				<p>Meses:</p>
			</div>
			<div class="col-8 mb-3">
				<select class="custom-select form-prestamo-mes"
					id="inputGroupSelect01">
					<option value="1">3</option>
					<option value="2">6</option>
					<option value="3">12</option>
					<option value="4">24</option>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="col-4 mb-3" style="text-align: right;">
				<p>Total a pagar:</p>
			</div>
			<div class="col-8 mb-3">
				<p>$ .-</p>
			</div>
		</div>
		<div style="justify-content: flex-end; display:flex;">
			<button class="btn mb-3 btn-success" data-toggle="modal" data-target="#ModalPrestamo">Solicitar</button>
		</div>
	</div>
	<!-- END CONTENT -->

<!-- MODAL DETAILS -->
<div class="modal fade" id="ModalPrestamo" tabindex="-1" role="dialog" aria-labelledby="ModalDetailsPrestamo" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Confirmar solicitud de préstamo</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      	<div class="row">
      		<div class="col-6" style="text-align:right;">
    		  <p>Cuenta:</p>
	          <p>Importe solicitado:</p>
	          <p>Cantidad de meses:</p>
	          <p>Total a pagar:</p>
      		</div>
      		<div class="col">
    		  <p>Cuenta principal</p>
	          <p>$100.000</p>
	          <p>3</p>
	          <p>$125.000</p>
	          </div>
          </div>
      	</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal" >Cancelar</button>
        <button type="button" class="btn btn-success">Solicitar</button>
      </div>
    </div>
  </div>
</div>
<!-- END MODAL DETAILS -->

</body>
</html>


