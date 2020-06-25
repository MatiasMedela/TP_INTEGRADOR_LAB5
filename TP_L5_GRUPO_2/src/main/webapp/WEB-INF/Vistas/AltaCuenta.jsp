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
<!-- Hoja de estilos-->
<link rel=stylesheet
	href="<c:url value="resources/Estilos/styles.css"/>" type="text/css"
	media=screen>
<meta charset="ISO-8859-1">
<title>Alta Cliente</title>

</head>

<body>
		<!-- NAVBAR -->
<%@ include file="NavbarAdmin.html"%>
	<!-- END NAVBAR -->
	<form style="padding: 20px">
		<fieldset class="border p-2">
			<legend class="w-auto">Alta cuenta</legend>
			<div class="container-fluid">
				<div class="row row-cols-2">
					<div class="col">
						<div class="form-group">
							<!-- Tipo de cuenta -->
							<label for="state_id" class="control-label">Tipo de Cuenta</label> <select
								class="form-control" id="state_id">
								<option value="01">Caja de ahorro en pesos</option>
								<option value="02">Caja de ahorro en dolares</option>
								<option value="03">Cuenta corriente</option>
								<option value="04">Cuenta corriente especial en pesos</option>
								<option value="05">Cuenta corriente especial en dolares</option>
							</select>
						</div>
						<div class="form-group">
							<!-- CBU -->
							<label for="full_name_id" class="control-label">CBU</label>
							<label for="full_name_id" class="control-label">XXXX.XXXX.XXXX</label>
						</div>
						<div class="form-group">
							<!-- CBU -->
							<label for="full_name_id" class="control-label">Alias</label>
							<label for="full_name_id" class="control-label">facultadPacheco2020</label>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<!-- Cliente -->
							<label for="state_id" class="control-label">Cliente</label> <select
								class="form-control" id="state_id">
								<option value="01">Leandro Lescano</option>
								<option value="02">Juan Cassano</option>
								<option value="03">Sebastian Font</option>
								<option value="04">Matias Medela</option>
								<option value="05">Cuenta corriente especial en dolares</option>
							</select>
						</div>
						<div class="form-group">
							<!-- Direccion -->
							<label for="full_name_id" class="control-label">Saldo</label>
							<label for="full_name_id" class="control-label">$10.000</label>
						</div>
						
					</div>
				</div>
				<div class="form-group text-center">
					<!-- Submit Button -->
					<button type="submit" class="btn btn-primary">Grabar</button>
				</div>
			</div>
		</fieldset>
	</form>
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
	CurrentItem = document.getElementById("mnClientes");
	CurrentItem.className +=" active";
</script>

</html>