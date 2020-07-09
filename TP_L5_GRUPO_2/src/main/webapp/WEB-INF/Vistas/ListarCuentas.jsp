<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
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
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
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

		<!-- NAVBAR -->
<%@ include file="NavbarAdmin.html"%>
	<!-- END NAVBAR -->
	<div style="padding: 20px">
<fieldset class="border p-2">
	<legend class="w-auto">Cuentas</legend>
	<div class="container-md">
		<table id="TableCuentasAll" class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Tipo de cuenta</th>
					<th scope="col">Nombre cliente</th>
					<th scope="col">Moneda</th>
					<th scope="col">Saldo</th>
					<th scope="col" style="text-align: center;">Editar</th>
					<th scope="col" style="text-align: center;">Estado</th>
				</tr>
			</thead>
			<tbody>	
					<c:forEach items="${ listadoCuentas }" var="cuenta" varStatus="loop">			
					<tr>
						<td id="Tipo${loop.index}">${cuenta.tipoCuenta.descripcion}</td>
						<td id="Nombre${loop.index}">${cuenta.getUsuario().getNombre()} ${cuenta.getUsuario().getApellido()}</td>
						<td id="Moneda${loop.index}">${cuenta.tipoCuenta.moneda}</td>
						<td id="Saldo${loop.index}">${cuenta.saldo}</td>
						<td  class="text-center"><input type="image" src="resources/Imagenes/edit.png" id="btnAbrirModalM" value ="${cuenta.getIdCuenta()}" data-toggle="modal" data-target="#ModalEdit" onClick="llenarModal(${loop.index}, ${cuenta.tipoCuenta.idTipoCuenta }, ${cuenta.getUsuario().getDni() })"></td>
					    <c:if test="${cuenta.estado}">
						    <td class="text-center"><button type="button" class="btn-sm btn-success btn-state-account" value="${cuenta.getIdCuenta()}" id="btnAbrirModalE" onClick="modalEliminar(this)">Alta</button></td>	
					    </c:if>
					    <c:if test="${!cuenta.estado}">
						    <td class="text-center"><button type="button" class="btn-sm btn-danger btn-state-account" value="${cuenta.getIdCuenta()}" id="btnAbrirModalA" onClick="modalAbrir(this)">Baja</button></td>	
					    </c:if>
					</tr>						
				</c:forEach>			
			</tbody>
		</table>

	</div>
</fieldset>
</div>
	
		<div class="modal fade" id="ModalDetails" tabindex="-1" role="dialog"
		aria-labelledby="ModalDetailsAccount" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Detalle de
						cuenta</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-4" style="text-align: right;">
							<p>Tipo de cuenta:</p>
							<p>Cliente:</p>
							<p>Moneda:</p>
							<p>CBU:</p>
							<p>ALIAS CBU:</p>
							<p>Saldo:</p>
						</div>
						<div class="col-8">
							<p>Caja ahorro en pesos</p>
							<div class="row">
								<div class="col-8">
									<p id="text-ident">Cuenta principal</p>
									<input id="input-ident" type="text"
										class="form-control form-detalle" value="Cuenta principal"
										hidden>
								</div>
								<div class="col-4">
									<p class="edit-text" id="edit-ident">Editar</p>
								</div>
							</div>
							<p>Pesos</p>
							<div class="row">
								<div class="col-8">
									<p>0000000000000000000000</p>
								</div>
								<div class="col-4">
									<p class="edit-text" id="edit-ident">Copiar</p>
								</div>
							</div>
							<p>WORD.WORD.WORD</p>
							<p>$10.000</p>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" disabled>Guardar
						cambios</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cerrar</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="ModalDelete" tabindex="-1" role="dialog"
		aria-labelledby="ModalDetailsAccount" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Eliminar cuenta</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
						<h6>¿Está seguro que desea eliminar la cuenta?</h6>
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
	
		<div class="modal fade" id="ModalEdit" tabindex="-1" role="dialog"
		aria-labelledby="ModalDetailsAccount" aria-hidden="true">
		<div class="modal-dialog modal-xl" style="max-width: 1100px;" role="document">
			<div class="modal-content">
			<form method=get action=modificarCuenta.html>
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Modificar Cuenta</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>	
				<div class="modal-body">
				<div class="row">
				<div class="col-4">
								<label for="state_id" class="control-label">Tipo de Cuenta</label> <select
								class="form-control" id="state_id" name="cbxTipo">
								
								<c:forEach items="${ listadoTipos }" var="tipos" varStatus="loop">							
								<option value="${tipos.idTipoCuenta}">${tipos.descripcion}</option>					
							    </c:forEach>
							</select>	     
				<label for="full_name_id" class="control-label mt-2">Saldo</label>
		        <input type="number" class="form-control form-control-sm" id="saldoM" name="saldoM" placeholder="10000" required>
		        <label for="clienteSelectModal" class="control-label mt-2">Cliente</label>
		        <input type="text" readonly class="form-control form-control-sm" id="clienteSelectModal">
		    </div>
			<div class="col-8">
		    <input type="hidden" id="clienteSeleccionado" name="clienteSeleccionado" value="">		
			<table id="TableClientesAll" class="table table-hover table-sm">
			<thead>
				<tr>
				<th scope="col">DNI</th>
				<th scope="col">Cliente</th>
				</tr>
			</thead>
			<tbody>	
				<c:forEach items="${ listadoUsuarios }" var="user" varStatus="loop">			
				<tr>			
					<td id="DNI${loop.index}">${user.getDni()}</td>
					<td id="NombreAp${loop.index}">${user.getNombre()} ${user.getApellido()}</td>				
				</tr>						
				</c:forEach>
			</tbody>
		</table>  
			</div>
				</div>	
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
					<button type="button" onClick="modificarCuenta(this)" disabled name="idCuentaM" class="btn btn-primary" id="btnModalModificar" value="">Grabar</button>
				</div>
				</form>
			</div>
		</div>
	</div>

	
	
</body>

<script type="text/javascript">
	CurrentItem = document.getElementById("mnCuentas");
	CurrentItem.className +=" active";

	function llenarModal(id, tipoCuenta, dni){
		$("#saldoM").val($("#Saldo" + id).html());
		$("#state_id option[value="+tipoCuenta+"]").attr("selected", "selected");
		$("#clienteSelectModal").val(dni + " - " + $("#Nombre" + id).html());
		$('#btnModalModificar').val($('#btnAbrirModalM').val());		
	};

	function modificarCuenta(btn){
		var IDCuenta = $("#btnModalModificar").val();
		var Tipo = $("#state_id option:selected").val();
		var saldoM = $("#saldoM").val();
		var dni = table.rows(['.selected-table']).data().pluck(0).toArray();
	   $.ajax({
			url: '${request.getContextPath()}/TP_L5_GRUPO_2/cantidadCuentas.html',
			type: 'POST',
	        data: { dniCliente: dni[0] },
			success: function(data){
				if(parseInt(JSON.parse(data)) >= 4){
					Swal.fire({
						icon: "warning",
						title: "Este cliente posee 4 cuentas activas.",
						confirmButtonText: "Entendido"
					})					
				}
				else{
					Swal.fire({
						title: "Desea modificar la cuenta?",
						icon: "question",
						showCancelButton: true,
						reverseButtons: true,
						confirmButtonColor: "#218838",
						confirmButtonText: "Modificar",
					}).then((result) => {
						if(result.value){	
							$('html, body').css("cursor", "wait");
					   $.ajax({
							url: '${request.getContextPath()}/TP_L5_GRUPO_2/modificarCuentaAsync.html',
							type: 'POST',
					        data: { idCuenta: IDCuenta,
					        		cbxTipo: Tipo,
					        		saldo: saldoM,
					        		dniCliente: dni[0] },
							success: function(data){
								$('html, body').css("cursor", "auto");
								if(data == "\"Exitoso\""){
									Swal.fire({
										icon: "success",
										title: "Cuenta modificada",
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
										title: "Hubo un error al modificar la cuenta",
										confirmButtonText: "Entendido"
									})
								}
							}
							});
						}
					})
				}
			}
	    });
	}
	
	function modalEliminar(btn){
		var id = $(btn).val();
		Swal.fire({
			title:"¿Desea dar de baja esta cuenta?",
			showCancelButton: true,
			confirmButtonColor: "#c82333",
		    cancelButtonText: "Cancelar",
		    confirmButtonText: "Dar de baja",
		    reverseButtons: true
		}).then((result) => {
			if(result.value){
				$('html, body').css("cursor", "wait");
				   $.ajax({
						url: '${request.getContextPath()}/TP_L5_GRUPO_2/cerrarCuentaAsync.html',
						type: 'POST',
				        data: { idCuenta: id },
						success: function(data){
							$('html, body').css("cursor", "auto");
							if(data == "\"Exitoso\""){
								Swal.fire({
									icon: "success",
									title: "Cuenta dada de baja",
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

	function modalAbrir(btn){
		var id = $(btn).val();
		Swal.fire({
			title:"¿Desea dar de alta esta cuenta?",
			showCancelButton: true,
			confirmButtonColor: "#218838",
		    cancelButtonText: "Cancelar",
		    confirmButtonText: "Dar de alta",
		    reverseButtons: true
		}).then((result) => {
			if(result.value){
				$('html, body').css("cursor", "wait");
			   $.ajax({
					url: '${request.getContextPath()}/TP_L5_GRUPO_2/abrirCuentaAsync.html',
					type: 'POST',
			        data: { idCuenta: id },
					success: function(data){
						$('html, body').css("cursor", "auto");
						if(data == "\"Exitoso\""){
							Swal.fire({
								icon: "success",
								title: "Cuenta dada de alta",
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
	
	$('#TableCuentasAll').DataTable({
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
	
		$('#TableClientesAll').DataTable({
			"ordering" : false,
			"bInfo" : false,
			"lengthChange" : false,
			"pageLength" : 4,
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
	
		
		var table = $('#TableClientesAll').DataTable();    
	    
		$('#TableClientesAll tbody').on( 'click', 'tr', function () {
			
			if ( $(this).hasClass('selected-table') ) {
		       // $(this).removeClass('selected');
		    }
		    else {
		        table.$('tr.selected-table').removeClass('selected-table');
		        $(this).addClass('selected-table');
		    }
		    //$(this).toggleClass('selected');	
		    $("#clienteSeleccionado").val(table.rows(['.selected-table']).data().pluck(0).toArray());
		    $("#clienteSelectModal").val(table.rows(['.selected-table']).data().pluck(0).toArray() + " - " + table.rows(['.selected-table']).data().pluck(1).toArray());
		    $("#btnModalModificar").attr("disabled", false);
		                    
		});
		
</script>
</html>