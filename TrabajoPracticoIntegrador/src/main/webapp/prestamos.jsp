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
		<div class="row align-items-center">
			<div class="col">
				<h3 style="margin-top: 20px;">Mis préstamos</h3>
			</div>
			<div class="col">
				<a href="./solicitudPrestamo.jsp" class="btn btn-primary" style="float:right;">Solicitar
					préstamo</a>
			</div>

		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Cuenta</th>
					<th scope="col">Importe solicitado</th>
					<th scope="col">Importe a pagar</th>
					<th scope="col">Cuotas</th>
					<th scope="col">Restante</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Cuenta principal</td>
					<td>$100.000</td>
					<td>$125.000</td>
					<td>0/3</td>
					<td>$125.000</td>
					<td><button type="button" class="btn btn-grid btn-light">Pagar
							cuota</button></td>
				</tr>
				<tr>
					<td>Cuenta secundaria</td>
					<td>$50.000</td>
					<td>$62.500</td>
					<td>11/12</td>
					<td>$5.208,33</td>
					<td><button type="button" class="btn btn-grid btn-light">Pagar
							cuota</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- END CONTENT -->

</body>
</html>


