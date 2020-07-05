<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<!-- JS, Popper.js, and jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	
<meta charset="ISO-8859-1">
<title>Alta cuenta</title>	
	
</head>
<body onload="cantidadPaginas()" onresize="cantidadPaginas()">

<body onClick="checkUserSelected()">
		<!-- NAVBAR -->
<%@ include file="NavbarAdmin.html"%>
	<!-- END NAVBAR -->
	<div style="padding: 20px">
		<fieldset class="border p-2">
			<legend class="w-auto">Alta cuenta</legend>
			<div class="container-fluid">
				<div class="row row-cols-2">
					<div class="col">
						<div class="form-group">
							<!-- Tipo de cuenta -->
							<label for="state_id" class="control-label">Tipo de cuenta</label> 
							<select	class="form-control" id="cuentaSelect" name="cbxTipo">
								<c:forEach items="${ listadoTipos }" var="tipos" varStatus="loop">							
									<option value="${tipos.idTipoCuenta}">${tipos.descripcion}</option>					
							    </c:forEach>
						    </select>
						</div>
						<div class="form-group">
							<!-- CBU -->
							<label for="full_name_id" class="control-label">CBU:</label>
							<label for="full_name_id" class="control-label">${proxCBU}</label>
						</div>
						<div class="form-group">
							<!-- CBU -->
							<label for="full_name_id" class="control-label">Alias:</label>
							<label name="aliasCuenta" id="aliasCuenta" class="control-label">${proxAlias}</label>
						</div>
						<div class="form-group">
							<label for="full_name_id" class="control-label">Saldo:</label>
							<label for="full_name_id" class="control-label">$10.000</label>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
		<!-- Cliente -->
		<input type="hidden" id="clienteSeleccionado" name="clienteSeleccionado" value="">
							
		<table id="TableCuentasAll" class="table table-hover">
			<thead>
				<tr>
				<th scope="col">DNI</th>
				<th scope="col">Cliente</th>
				<th scope="col">Email</th>
				</tr>
			</thead>
			<tbody>	
				<c:forEach items="${ listadoUsuarios }" var="user" varStatus="loop">			
					<tr>
					<td id="DNI${loop.index}">${user.getDni()}</td>
					<td id="NombreAp${loop.index}">${user.getNombre()} ${user.getApellido()}</td>
					<td id="Email${loop.index}">${user.getEmail()}</td>							
					</tr>						
				</c:forEach>			
			</tbody>
		</table>
						</div>						
					</div>
				</div>
				<div class="form-group text-center">
					<!-- Submit Button -->
					<button id="btnGrabar" onClick="verificarDatos()" disabled class="btn btn-primary">Grabar</button>
				</div>
			</div>
		</fieldset>
		</div>
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

<script type="text/javascript">
CurrentItem = document.getElementById("mnCuentas");
CurrentItem.className +=" active";

$('#TableCuentasAll').DataTable({
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

var table = $('#TableCuentasAll').DataTable();   

	function verificarDatos(){
		var dni = $("#clienteSeleccionado").val();
	   $.ajax({
			url: '${request.getContextPath()}/TP_L5_GRUPO_2/cantidadCuentas.html',
			type: 'POST',
	        data: { dniCliente: dni },
			success: function(data){
				if(parseInt(JSON.parse(data)) >= 4){
					Swal.fire({
						icon: "warning",
						title: "Este cliente posee 4 o más cuentas activas.",
						confirmButtonText: "Entendido"
					})					
				}
				else{
				    var ApeNom =  table.rows(['.selected-table']).data().pluck(1).toArray();
					Swal.fire({
						title: "Confirmar alta de cuenta",
						html: "<p>Cliente: " + ApeNom + " - DNI: " + dni + "</p>" + 
							  "<p>Cuenta: " + $("#cuentaSelect option:selected").html() + "</p>",	
						showCancelButton: true,
						confirmButtonColor: "#218838",
						cancelButtonText: "Cancelar",
						confirmButtonText: "Dar de alta",
						reverseButtons: true
					}).then((result) => {
						if(result.value){
							var tipoC = $("#cuentaSelect").val();
							var aliasGenerado = $("#aliasCuenta").html();
							$.ajax({
								url: '${request.getContextPath()}/TP_L5_GRUPO_2/crearCuentaAsync.html',
								type: 'POST',
						        data: { tipoCuenta: tipoC ,
						        		dniCliente: dni,
						        		alias: aliasGenerado},
								success: function(data){
									if(data == "\"Exitoso\""){
										Swal.fire({
											icon: "success",
											title: "Cuenta creada",
											confirmButtonText: "Entendido"
										}).then((result) => {
											if(result.value){
												location.reload();
											}
										})
									}
									else{
										Swal.fire({
											icon: "error",
											title: "Hubo un problema al crear la cuenta",
											confirmButtonText: "Entendido"
										})
									}
								}
							});
						}
					})
				}
		}});
	}

	function checkUserSelected(){
		if($("#clienteSeleccionado").val() != ""){
			$("#btnGrabar").attr("disabled", false);
		}
		else{
			$("#btnGrabar").attr("disabled", true);
		}
	}
    
$('#TableCuentasAll tbody').on( 'click', 'tr', function () {
	if ( $(this).hasClass('selected-table') ) {
    }
    else {
        table.$('tr.selected-table').removeClass('selected-table');
        $(this).addClass('selected-table');
    }	
     $("#clienteSeleccionado").val(table.rows(['.selected-table']).data().pluck(0).toArray());
     $("#aliasCuenta")
});	
</script>
</html>