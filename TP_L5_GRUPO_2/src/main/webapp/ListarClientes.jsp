<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
<meta charset="ISO-8859-1">
<!-- Jquery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<!-- Bootstrap CSS y Script -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<!-- JS, Popper.js -->
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

<!-- Data Tables -->
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" />


<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#TLClientes')
								.DataTable(
										{
											"scrollX" : true,
											"scrollY" : 350,
											sDom : '<"top"fli>t<"bottom"p><"clear">r',
											sPaginationType : "full_numbers",
											bProcessing : true,
											bAutoWidth : true,
											"sScrollX" : "100%",
											"sScrollXInner" : "100%",
											language : {
												decimal : "",
												emptyTable : "No se han encontrado registros",
												info : "Mostrando desde el _START_ al _END_ del total de _TOTAL_ registros",
												infoEmpty : "Mostrando desde el 0 al 0 del total de  0 registros",
												infoFiltered : "(Filtrados del total de _MAX_ registros)",
												infoPostFix : "",
												thousands : ",",
												lengthMenu : "Mostrar _MENU_ registros por página",
												loadingRecords : "Cargando...",
												processing : "Procesando...",
												search : "Buscar registro:",
												zeroRecords : "No se han encontrado registros",
												paginate : {
													first : "Primera",
													last : "Última",
													next : "Siguiente",
													previous : "Anterior"
												},
												aria : {
													sortAscending : ": activate to sort column ascending",
													sortDescending : ": activate to sort column descending"
												}
											}
										});
					});
</script>
<title></title>
</head>
<body>
	<!-- NAVBAR -->
	<jsp:include page="NavbarAdmin.html"></jsp:include>
	<!-- END NAVBAR -->
	<fieldset class="border p-1">
		<legend class="w-auto">Listado de clientes</legend>
		<div class="container-fluid">
			<div class="row row-cols-2">
				<div class="col-2">
					<fieldset class="border p-2">
						<legend class="w-auto">Busquedas</legend>

						<form class="form" id="form-1">
							<div class="form-group ">
								<!-- DNI -->
								<label for="full_name_id" class="control-label">Número
									de documento</label> <input type="number"
									class="form-control form-control-sm" id="full_name_id"
									name="full_name" placeholder="D.N.I">
							</div>
							<div class="form-group text-center" style="padding-left: 10px">
								<!-- Submit Button -->
								<button type="submit" class="btn-sm btn-primary">Buscar</button>
							</div>
						</form>

						<form class="form" id="form-1">
							<div class="form-group">
								<!-- Apellido -->
								<label for="full_name_id" class="control-label">Apellido</label>
								<input type="number" class="form-control form-control-sm"
									id="full_name_id" name="full_name" placeholder="APELLIDO">
							</div>
							<div class="form-group text-center" style="padding-left: 10px">
								<!-- Submit Button -->
								<button type="submit" class="btn-sm btn-primary">Buscar</button>
							</div>
						</form>
					</fieldset>
				</div>
				<div class="col-10">
					<!-- inicio tabla -->
					<fieldset class="border p-1">
						<legend class="w-auto">Clientes</legend>
						<table id="TLClientes" class="table table-hover table-sm"
							style="padding-left: 5px">
							<thead class="thead-dark">
								<tr>
									<th scope="col">DNI</th>
									<th scope="col">Nombre</th>
									<th scope="col">Apellido</th>
									<th scope="col">E-mail</th>
									<th scope="col">Telefono</th>
									<th scope="col">Estado</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>12345678</td>
									<td>Esteban</td>
									<td>Arriaga</td>
									<td>Estarrist@gmail.com</td>
									<td>1124879660</td>
									<td>Alta</td>
								</tr>
								<tr>
									<td>23456789</td>
									<td>Carlos</td>
									<td>Gonzales</td>
									<td>CcarlosGon@hotmail.com.ar</td>
									<td>1154789635</td>
									<td>Baja</td>
								</tr>
								<tr>
									<td>34587962</td>
									<td>Pedro</td>
									<td>Lopez</td>
									<td>Plopex@gmail.com</td>
									<td>1125647893</td>
									<td>Alta</td>
								</tr>
							</tbody>
						</table>
					</fieldset>
					<!--Fin Tabla-->
				</div>
			</div>
		</div>
	</fieldset>

	<!-- modal cerrar session  -->
	<div class="modal fade" id="ModalCerrarSession" tabindex="-1"
		role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Cerrar Sesion</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">¿Desea cerrar la sesion?</div>
				<div class="modal-footer">
					<form action="#" method="post" accept-charset=utf-8>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<button type="Submit" class="btn btn-primary"
							name="BtnCerrarSesion">Cerrar Sesion</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- modal cerrar session  -->

</body>
</html>