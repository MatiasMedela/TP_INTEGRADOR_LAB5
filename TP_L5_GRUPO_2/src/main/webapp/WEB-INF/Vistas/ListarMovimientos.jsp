<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel=stylesheet
	href="<c:url value="resources/Estilos/styles.css"/>" type="text/css"
	media=screen>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
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
	<!-- END NAVBAR -->
	<%@ include file="NavbarClient.html"%>
	<!-- CONTENT -->

	<div class="container-md">
		<h3 style="margin-top: 20px;">Movimientos - ${Alias} - CBU:
			${CBU}</h3>
		<table id="TablaMov" class="table tableMovements">
			<thead>
				<tr>
					<th scope="col">Fecha</th>
					<th scope="col">Tipo</th>
					<th scope="col">Descripci�n</th>
					<th scope="col">Importe</th>
				</tr>
			</thead>
			<tbody id="ModalBodyMovimientos">
				<c:forEach items="${ listadoMovimientos }" var="movimiento"
					varStatus="loop">
					<tr>
						<td>${movimiento[0].getFecha()}</td>
						<c:if test="${movimiento[0].getTipoMovimiento().getIdTipoMovimiento() == '1'}" > <!-- ALTA CUENTA -->
							<td>${movimiento[0].getTipoMovimiento().getDescripcion()}</td>
							<td>CBU Nro. ${movimiento[0].getCbuOrigen()} dado de alta. </td>
							<td class="ImporteCredito">$ ${movimiento[0].getImporte()}</td>						
						</c:if>
						<c:if test="${movimiento[0].getTipoMovimiento().getIdTipoMovimiento() == '2'}"> <!-- ALTA PRESTAMO -->
								<td>${movimiento[0].getTipoMovimiento().getDescripcion()}</td>
								<td>Prestamo N�${movimiento[0].getCbuOrigen()} dado de alta.</td>						
								<td class="ImporteCredito">$ ${movimiento[0].getImporte()}</td>
						</c:if>
						<c:if test="${movimiento[0].getTipoMovimiento().getIdTipoMovimiento() == '3'}"> <!-- PAGO PRESTAMO-->
								<td>${movimiento[0].getTipoMovimiento().getDescripcion()}</td>
								<td>Cuota ${movimiento[0].getCbuOrigen()} paga</td>						
								<td class="ImporteDebito">$ ${movimiento[0].getImporte()}</td>
						</c:if>		
						<c:if test="${movimiento[0].getTipoMovimiento().getIdTipoMovimiento() == '4' && movimiento[0].getCbuOrigen() == CBU}">
								<td>Acreditaci�n</td>
								<td>CBU Origen: ${movimiento[0].getCbuOrigen()}</td>						
								<td class="ImporteCredito">$ ${movimiento[0].getImporte()}</td>

						</c:if>
						<c:if test="${movimiento[0].getTipoMovimiento().getIdTipoMovimiento() == '4' && movimiento[0].getCbuOrigen() != CBU}">
								<td>Debitaci�n</td>
								<td>CBU Destino: ${movimiento[1]}</td>						
								<td class="ImporteDebito">$ ${movimiento[0].getImporte()}</td>
						</c:if>
						<c:if test="${movimiento[0].getTipoMovimiento().getIdTipoMovimiento() == '5' && movimiento[0].getCbuOrigen() == CBU}">
								<td>Debitaci�n</td>
								<td>CBU Destino: ${movimiento[1]}</td>						
								<td class="ImporteDebito">$ ${movimiento[0].getImporte()}</td>
						</c:if>
						<c:if test="${movimiento[0].getTipoMovimiento().getIdTipoMovimiento() == '5' && movimiento[0].getCbuOrigen() != CBU}">
								<td>Acreditaci�n</td>
								<td>CBU Origen: ${movimiento[0].getCbuOrigen()}</td>						
								<td class="ImporteCredito">$ ${movimiento[0].getImporte()}</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<!-- END CONTENT -->
</body>

<script type="text/javascript">
	CurrentItem = document.getElementById("mnInicio");
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
	$('#TablaMov').DataTable({
		"ordering" : false,
		"bInfo" : false,
		"lengthChange" : false,
		"pageLength" : cantPags,
		"dom" : 'frtip',
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

