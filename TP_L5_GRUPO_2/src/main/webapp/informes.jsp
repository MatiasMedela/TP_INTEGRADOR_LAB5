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
<%-- <jsp:include page="NavbarAdmin.html"></jsp:include> --%>
<%@ include file="NavbarAdmin.html" %>
	<!-- END NAVBAR -->

	<!-- CONTENT -->

	<div class="container-md">
		<h3 style="margin-top: 20px;">Informe - Transferencias</h3>
		<form class="form-inline">
		<span class="mr-2">Transferencias entre </span>
			<input class="form-control form-control-sm mr-2" type="date"	id="example-date-input"> 
			<span class="mr-2">y</span>
			<input	class="form-control form-control-sm mr-2" type="date" id="example-date-input"> 
			<button class="btn btn-primary" style="padding: .2rem .5rem;">Filtrar</button>
		</form>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Fecha</th>
					<th scope="col">Cliente Origen</th>
					<th scope="col">CBU Origen</th>
					<th scope="col">Cliente Destino</th>
					<th scope="col">CBU Destino</th>
					<th scope="col">Importe</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>9/6/2020</td>
					<td>Gomez Juan</td>
					<td>000000000001</td>
					<td>Herrera Gonzalo</td>
					<td>000000000002</td>
					<td>$75.000</td>
				</tr>

				<tr>
					<td>5/5/2020</td>
					<td>Herrera Gonzalo</td>
					<td>000000000002</td>
					<td>Gomez Juan</td>
					<td>000000000001</td>
					<td>$900.000</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- END CONTENT -->

</body>
<script>
CurrentItem = document.getElementById("mnInformes");
CurrentItem.className +=" active";
</script>
</html>