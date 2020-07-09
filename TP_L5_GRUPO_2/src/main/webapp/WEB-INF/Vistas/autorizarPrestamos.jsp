<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  <!-- agregada -->
<!--  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script> -->
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
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>  <!-- agregada -->
	<script type="text/javascript" src="<c:url value="resources/Funciones/funciones.js"/>"></script> <!-- agregada -->
		<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
</head>
<body>

		<!-- NAVBAR -->
<%@ include file="NavbarAdmin.html"%>
	<!-- END NAVBAR -->

	<!-- CONTENT -->

	<div class="container-md">
				<h3 style="margin-top: 20px;">Autorizar préstamos</h3>
<form action="redirecPrestamos.html" class="pull-right mb-1" method="get">
	<input type="submit" name="pendientes" class="btn btn-primary" value="Pendientes"/>
	<input type="submit" name="aprobados" class="btn btn-primary"  value="Aprobados"/>
	<input type="submit" name="rechazados" class="btn btn-primary"  value="Rechazados"/>
</form>
		<table id="TablePrestamosP" class="table">
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
			
					<c:forEach items="${ listadoPrestamosAdm}" var="prestamo" varStatus="loop">			
					<tr>
						<td id="Nombre${loop.index}">${prestamo.getUsuario().getNombre()} ${prestamo.getUsuario().getApellido()}</td>
						<td id="Tipo${loop.index}">${prestamo.getCbu().getTipoCuenta().descripcion}</td>
						<td id="ImporteSol${loop.index}">$ <fmt:formatNumber type="number" maxFractionDigits="2" value="${prestamo.importeTotal}"/></td>
						<td id="ImporteFinal${loop.index}">$ <fmt:formatNumber type="number" maxFractionDigits="2" value="${prestamo.montoPagar}"/></td>
						<td id="Meses${loop.index}">${prestamo.cantidadMeses}</td>
						<td id="FechaSol${loop.index}"><fmt:formatDate type="both" timeStyle="short" dateStyle="short" value="${prestamo.fechaSolicitud}"/></td>
						<td id="Estado${loop.index}">${prestamo.estado.descripcion}</td>
						<td><div class="dropdown">
				  <button class="btn btn-secondary dropdown-toggle btn-grid-action" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    Acción
				  </button>
				  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				    <button class="dropdown-item" value="${prestamo.idPrestamo}" href="#" id="btnAbrirModalAp" onClick="modalAprobar(this)">Aprobar</button>
				    <button class="dropdown-item" value="${prestamo.idPrestamo}" href="#" id="btnAbrirModalRe" onClick="modalRechazar(this)">Rechazar</button>
				
				  </div>
				</div>
				</td>
					</tr>						
				</c:forEach>		
			</tbody>
		</table>		
	</div>
	
		<div class="modal fade" id="ModalAprobar" tabindex="-1" role="dialog"
		aria-labelledby="ModalDetailsAccount" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Aprobar prestamo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
						<h6>¿Está seguro que desea aprobar este prestamo?</h6>
				</div>
				<div class="modal-footer">
				<form method="get" action=borrarCuenta.html>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
					<button type="submit" name="idCuenta" class="btn btn-danger" id="btnModalEliminar" value="">Eliminar</button>
				</form>
				</div>
			</div>
		</div>
	</div>
	
		<div class="modal fade" id="ModalRechazar" tabindex="-1" role="dialog"
		aria-labelledby="ModalDetailsAccount" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Rechazar prestamo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
						<h6>¿Está seguro que desea rechazar este prestamo?</h6>
				</div>
				<div class="modal-footer">
				<form method="get" action=borrarCuenta.html>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
					<button type="submit" name="idCuenta" class="btn btn-danger" id="btnModalEliminar" value="">Eliminar</button>
				</form>
				</div>
			</div>
		</div>
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
	
	function modalAprobar(btn){
		var id = $(btn).val();
		Swal.fire({
			title:"¿Desea aprobar este préstamo?",
			showCancelButton: true,
			confirmButtonColor: "#218838",
		    cancelButtonText: "Cancelar",
		    confirmButtonText: "Aprobar",
		    reverseButtons: true
		}).then((result) => {
			if(result.value){
			   $.ajax({
					url: '${request.getContextPath()}/TP_L5_GRUPO_2/aprobarPrestamoAsync.html',
					type: 'POST',
			        data: { idPrestamo: id },
					success: function(data){
						if(data == "\"Exitoso\""){
							Swal.fire({
								icon: "success",
								title: "Préstamo aprobado",
								confirmButtonText: "Entendido"
							}).then((result) => {
								if(result.value){
									location.reload();
								}
							})
						}
					}
				});
			}
		})
	}
	
	function modalRechazar(btn){
		var id = $(btn).val();
		Swal.fire({
			title:"¿Desea rechazar este préstamo?",
			showCancelButton: true,
			confirmButtonColor: "#d41111",
		    cancelButtonText: "Cancelar",
		    confirmButtonText: "Rechazar",
		    reverseButtons: true
		}).then((result) => {
			if(result.value){
			   $.ajax({
					url: '${request.getContextPath()}/TP_L5_GRUPO_2/rechazarPrestamoAsync.html',
					type: 'POST',
			        data: { idPrestamo: id },
					success: function(data){
						if(data == "\"Exitoso\""){
							Swal.fire({
								icon: "success",
								title: "Préstamo rechazado",
								confirmButtonText: "Entendido"
							}).then((result) => {
								if(result.value){
									location.reload();
								}
							})
						}
					}
				});
			}
		})
	}
	
	
	$('#TablePrestamosP').DataTable({
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