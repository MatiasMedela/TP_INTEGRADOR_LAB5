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

<%-- <jsp:include page="NavbarClient.html"></jsp:include> --%>
<%@ include file="NavbarClient.html" %>
	<!-- END NAVBAR -->

	<!-- CONTENT -->

	<div class="container-md">
		<div class="row align-items-center">
			<div class="col">
				<h3 style="margin-top: 20px;">Mis transferencias</h3>
			</div>
<div class="dropdown">
  <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownTransf" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Nueva transferencia
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownTransf">
    <a class="dropdown-item" href="./nuevaTransferencia.jsp">A cuenta propia</a>
    <a class="dropdown-item" href="./nuevaTransferenciaTerceros.jsp">A terceros</a>

  </div>

		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Fecha</th>
					<th scope="col">CBU origen</th>
					<th scope="col">CBU destino</th>
					<th scope="col">Importe</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>25/5/20</td>
					<td>0000000000000000000000</td>
					<td>0000000000000000000005</td>
					<td>$2.500</td>
				</tr>
				<tr>
					<td>26/5/20</td>
					<td>0000000000000000000001</td>
					<td>0000000000000000000003</td>
					<td>$5.000</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- END CONTENT -->

</body>
<script type="text/javascript">
	CurrentItem = document.getElementById("mnTransferencias");
	CurrentItem.className +=" active";
</script>

</html>


