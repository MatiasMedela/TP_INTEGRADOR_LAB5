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
</head>
<body>

		<!-- NAVBAR -->
<%@ include file="NavbarAdmin.html"%>
	<!-- END NAVBAR -->

	<!-- CONTENT -->

	<div class="container-md">
				<h3 style="margin-top: 20px;">Autorizar préstamos</h3>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Cliente</th>
					<th scope="col">Cuenta</th>
					<th scope="col">Importe solicitado</th>
					<th scope="col">Importe a pagar</th>
					<th scope="col">Cuotas</th>
					<th scope="col">Fecha solicitud</th>
					<th scope="col">Estado</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Juan Gómez</td>
					<td>Cuenta principal</td>
					<td>$100.000</td>
					<td>$125.000</td>
					<td>3</td>
					<td>03/06/2020</td>
					<td>Pendiente</td>
					<td><div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Acción
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">Aprobar</a>
    <a class="dropdown-item" href="#">Rechazar</a>

  </div>
</div>
</td>
				</tr>
				<tr>
					<td>Tomás Ramírez</td>				
					<td>Cuenta secundaria</td>
					<td>$50.000</td>
					<td>$62.500</td>
					<td>12</td>
					<td>08/05/2020</td>
					<td>Pendiente</td>
					<td><div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Acción
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">Aprobar</a>
    <a class="dropdown-item" href="#">Rechazar</a>

  </div>
</div>
</td>
				</tr>
			</tbody>
		</table>
		
<form action="redirecPrestamos.html" method="get">
	<input type="submit" name="pendientes" class="btn btn-primary" value="Pendientes"/>
	<input type="submit" name="aprobados" class="btn btn-primary"  value="Aprobados"/>
	<input type="submit" name="rechazados" class="btn btn-primary"  value="Rechazados"/>
</form>

		
		
	</div>
	<!-- END CONTENT -->

</body>
</html>