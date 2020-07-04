<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
</head>
<body>

<%@ include file="NavbarClient.html"%>
	<!-- END NAVBAR -->

	<!-- CONTENT -->

	<div class="container-md">
	<h3 style="margin-top: 20px;">Mis transferencias</h3>
	<form action="redirecNuevaTransferencia.html" method="get">
		<div class="dropdown pull-right mb-1">
		  <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownTransf" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Nueva transferencia
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownTransf">
		    <input type="submit" name="normal" class="dropdown-item" value="A cuenta propia"/>
		    <input type="submit" name="terceros" class="dropdown-item" value="A terceros"/>
		  </div>
		 </div>
	</form>
		<table id="MisTransferencias" class="table">
			<thead>
				<tr>
					<th scope="col">Fecha</th>
					<th scope="col">CBU origen</th>
					<th scope="col">CBU destino</th>
					<th scope="col">Importe</th>
				</tr>
			</thead>
			<tbody>
			    <c:forEach items="${listadoTransferencias}" var="transfer" varStatus="loop">
					<tr>
						<td><fmt:formatDate type="both" timeStyle="short" dateStyle="short" value="${transfer[0]}"/></td>
						<td><fmt:formatNumber type="number" pattern="00" minIntegerDigits="22" value="${transfer[1]}"/></td>
						<td><fmt:formatNumber type="number" pattern="00" minIntegerDigits="22" value="${transfer[2]}"/></td>
						<td>$ <fmt:formatNumber type="number" maxFractionDigits="2" value="${transfer[3]}"/></td>
					</tr>
			    </c:forEach>
			</tbody>
		</table>
	</div>
	<!-- END CONTENT -->

</body>
<script type="text/javascript">
	CurrentItem = document.getElementById("mnTransferencias");
	CurrentItem.className +=" active";
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
	$('#MisTransferencias').DataTable({
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


