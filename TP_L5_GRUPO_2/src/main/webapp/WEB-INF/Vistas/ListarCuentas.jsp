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

	<div class="container-md">
		<h3 style="margin-top: 20px;">Cuentas</h3>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Tipo de cuenta</th>
					<th scope="col">Nombre cliente</th>
					<th scope="col">Moneda</th>
					<th scope="col">Saldo</th>
					<th scope="col" style="text-align: center;"></th>
					<th scope="col" style="text-align: center;"></th>
				</tr>
			</thead>
			<tbody>
			
					<c:forEach items="${ listadoCuentas }" var="cuenta" varStatus="loop">
					
					<tr>

						<td id="Tipo${loop.index}">${cuenta.tipoCuenta.descripcion}</td>
						<td id="Nombre${loop.index}">${cuenta.getUsuario().getNombre()} ${cuenta.getUsuario().getApellido()}</td>
						<td id="Moneda${loop.index}">${cuenta.tipoCuenta.moneda}</td>
						<td id="Saldo${loop.index}">${cuenta.saldo}</td>
						<td><img src="<c:url value="resources/Imagenes/edit.png"/>" style="display:block;" id="edit" name ="edit"/></td>
					    <td><button type="button" class="btn btn-danger btn-sm" value ="${cuenta.getIdCuenta()}" id="btnAbrirModalE" data-toggle="modal" data-target="#ModalDelete">x</button></td>
					    
						
					</tr>
						
				</c:forEach>
			
			
				
			</tbody>
		</table>

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
					<h5 class="modal-title" id="exampleModalLongTitle">Eliminar Cuenta</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<h4>¿Estás seguro que desea eliminar la cuenta?</h4>
					</div>
				</div>
				<div class="modal-footer">
				<form method=get action=borrarCuenta.html>
					<button type="button" class="btn btn-secondary data-dismiss="modal"" >Cancelar</button>
					<button type="submit" name="idCuenta" class="btn btn-danger" id="btnModalEliminar" value="">Eliminar</button>
						</form>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	CurrentItem = document.getElementById("mnInicio");
	//CurrentItem.className +=" active";

	var editar = document.getElementById("edit");
	
	editar.addEventListener("click", function(){
		$('#ModalDetails').modal('show');
		
	}, false);
	
	var eliminar = document.getElementById("delete");
	
	//eliminar.addEventListener("click", function(){
		//$('#ModalDelete').modal('show');
		
	//}, false);


		$('#btnAbrirModalE').click(function() {
			$('#btnModalEliminar').val($(this).val());
			
	})
	
	
	
	
</script>
</html>