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

		<!-- NAVBAR -->
<jsp:include page="NavbarAdmin.html"></jsp:include>
	<!-- END NAVBAR -->

	<!-- CONTENT -->

	<div class="container-md">
				<h3 style="margin-top: 20px;">Prestamos aprobados</h3>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Cliente</th>
					<th scope="col">Cuenta</th>
					<th scope="col">Importe solicitado</th>
					<th scope="col">Importe a pagar</th>
					<th scope="col">Cuotas</th>
					<th scope="col">Fecha solicitud</th>
					<th scope="col">Fecha resoluci�n</th>
					<th scope="col">Estado</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
					<tr>
					<td>Martina Rodr�guez</td>				
					<td>Cuenta secundaria</td>
					<td>$50.000</td>
					<td>$75.000</td>
					<td>5</td>
					<td>04/04/2020</td>
					<td>06/04/2020</td>
					<td>Aprobado</td>
					
				</tr>
				
				<tr>
					<td>Elvira P�rez</td>				
					<td>Cuenta secundaria</td>
					<td>$750.000</td>
					<td>$900.000</td>
					<td>9</td>
					<td>09/04/2020</td>
					<td>10/04/2020</td>
					<td>Aprobado</td>
					
				</tr>
			</tbody>
		</table>
		
<a href=./autorizarPrestamos.jsp class="btn btn-primary">Pendientes</a>
<a href=./prestamosAprobados.jsp class="btn btn-primary">Aprobados</a>
<a href=./prestamosRechazados.jsp class="btn btn-primary">Rechazados</a>

		
		
	</div>
	<!-- END CONTENT -->

</body>
</html>