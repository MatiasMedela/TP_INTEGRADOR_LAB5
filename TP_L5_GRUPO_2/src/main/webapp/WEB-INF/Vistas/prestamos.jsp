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
<script type="text/javascript" src="<c:url value="resources/Funciones/funciones.js"/>"></script>
		<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
</head>
<body onload="cantidadPaginas()" onresize="cantidadPaginas()">

	<%@ include file="NavbarClient.html"%>
	<!-- END NAVBAR -->

	<!-- CONTENT -->

	<div class="container-md">
		<h3 style="margin-top: 20px;">Mis préstamos</h3>
		<form method="post" action="solicitarPrestamo.html">
			<input type="submit" class="btn btn-primary pull-right mb-1" value="Solicitar préstamo"/>
		</form>
		<table id="TableMisPrestamos" class="table">
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
			<c:forEach items="${listadoPrestamos}" var="prestamo" varStatus="loop">
				<tr>
					<td>${prestamo[0]}</td>
 					<td class="txt-dinero">${prestamo[1]}</td>
					<td class="txt-dinero">${prestamo[2]}</td>
					<td>${prestamo[3]}</td>
					<td class="txt-dinero">${prestamo[4]}</td>
					<td class="btn-pagar-cuota"><button type="button" class="btn btn-grid btn-light">Pagar
							cuota</button></td>
				</tr>			
			</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- END CONTENT -->
		<div class="toast" role="alert" aria-live="assertive" aria-atomic="true" style="position: absolute; bottom: 0; right: 5px;">
  <div class="toast-header">
    <strong class="mr-auto">Solicitud de préstamo</strong>
    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
  </div>
  <div class="toast-body">
  	<p>El préstamo ha sido solicitado exitosamente.</p>
  </div>
</div>
<input type="hidden" id="resultadoSolicitud" value="${prestamo}"/>

</body>

<script type="text/javascript">
	CurrentItem = document.getElementById("mnPrestamos");
	CurrentItem.className +=" active";
	
	$(".toast").toast({delay: 2000});
	
	if($("#resultadoSolicitud").val() == "Exito"){
		$(".toast").toast('show');
	}
	
	$(document).ready(function(){
		$(".txt-dinero").each(function(){
			$(this).html("$ " + parseFloat($(this).html()).toLocaleString());
		})
	});
	
	$('#TableMisPrestamos').DataTable({
		"ordering" : false,
		"bInfo" : false,
		"lengthChange" : false,
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


