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
		<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
</head>
<body>
		<!-- NAVBAR -->
<%@ include file="NavbarAdmin.html"%>
	<!-- END NAVBAR -->

	<!-- CONTENT -->

	<div class="container-md">
				<h3 style="margin-top: 20px;">Prestamos rechazados</h3>

<form action="redirecPrestamos.html" class="pull-right mb-1" method="get">
	<input type="submit" name="pendientes" class="btn btn-primary" value="Pendientes"/>
	<input type="submit" name="aprobados" class="btn btn-primary"  value="Aprobados"/>
	<input type="submit" name="rechazados" class="btn btn-primary"  value="Rechazados"/>
</form>
		<table id="TablePrestamosR" class="table">
			<thead>
				<tr>
					<th scope="col">Cliente</th>
					<th scope="col">Cuenta</th>
					<th scope="col">Importe solicitado</th>
					<th scope="col">Importe a pagar</th>
					<th scope="col">Cuotas</th>
					<th scope="col">Fecha solicitud</th>
					<th scope="col">Fecha resolución</th>
					<th scope="col">Estado</th>
				</tr>
			</thead>
			<tbody>
										<c:forEach items="${ listadoPrestamosAdm}" var="prestamo" varStatus="loop">			
					<tr>
						<td id="Nombre${loop.index}">${prestamo.getUsuario().getNombre()} ${prestamo.getUsuario().getApellido()}</td>
						<td id="Tipo${loop.index}">${prestamo.getCbu().getTipoCuenta().descripcion}</td>
						<td id="ImporteSol${loop.index}">${prestamo.importeTotal}</td>
						<td id="ImporteFinal${loop.index}">${prestamo.montoPagar}</td>
						<td id="Meses${loop.index}">${prestamo.cantidadMeses}</td>
						<td id="FechaSol${loop.index}">${prestamo.fechaSolicitud}</td>
						<td id="FechaSol${loop.index}">${prestamo.fechaResolucion}</td>
						<td id="Estado${loop.index}">${prestamo.estado.descripcion}</td>
						
					</tr>						
				</c:forEach>	
			</tbody>
		</table>
		
		
	</div>
	<!-- END CONTENT -->

</body>
<script type="text/javascript">
	CurrentItem = document.getElementById("mnPrestamosAdm");
	CurrentItem.className += " active";
	var screenH = window.innerHeight;
	var cantPags;
	if(screenH < 615){
		cantPags = 4;
	}
	else if(screenH < 680){
		cantPags = 5;
	}
	else if(screenH < 740){
		cantPags = 6;
	}
	else{
		cantPags = 7;
	}
	$('#TablePrestamosR').DataTable({
		"ordering" : false,
		"bInfo" : false,
		"lengthChange" : false,
		"pageLength" : cantPags,
		"dom" : '<"pull-left"f>rtip',
		"oLanguage" : {
			"sSearch" : "Busqueda:",
		},
		"language" : {
			"zeroRecords" : "No se encontraron registros coincidentes",
			"paginate" : {
				"next" : "Siguiente",
				"previous" : "Previo"
			},
		}
	});
</script>
</html>