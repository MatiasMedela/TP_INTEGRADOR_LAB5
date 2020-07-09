<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>Pago de cuotas</title>
</head>
<body onload="cantidadPaginas()" onresize="cantidadPaginas()">
	<%@ include file="NavbarClient.html"%>
	<!-- END NAVBAR -->
	<!-- CONTENT -->
	<div class="container-md">
	<h3>Préstamo N° ${idPrestamo}</h3>
		<table id="TableCuotas" class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Nro. cuota</th>
					<th scope="col">Importe</th>
					<th scope="col">Fecha vto.</th>
					<th scope="col">Fecha pago</th>
					<th scope="col">Estado</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${listadoCuotas}" var="cuota" varStatus="loop">
				<tr>
					<td>${loop.index+1}</td>
 					<td>$ <fmt:formatNumber type="number" maxFractionDigits="2" value="${cuota.prestamo.montoPagar/cuota.prestamo.cantidadMeses}"/></td>
					<td><fmt:formatDate type="date" dateStyle="short" value="${cuota.fechaVencimiento}"/></td>
					<c:if test="${cuota.pagada == true }"> <!-- CUOTA PAGADA -->
						<td><fmt:formatDate type="date" dateStyle="short" value="${cuota.fechaPago}"/></td>
						<td id="estado${loop.index}">Paga</td>
						<td></td>
					</c:if>
					<c:if test="${cuota.pagada == false }"> <!-- CUOTA PENDIENTE -->
						<td>-</td>
						<td id="estado${loop.index}">Pendiente</td>
					<td class="btn-pagar-cuota"><button type="button" value="${cuota.numeroCuota}" onClick="pagarCuota(this, ${loop.index+1},${cuota.prestamo.montoPagar/cuota.prestamo.cantidadMeses}, ${loop.index})" class="btn btn-grid btn-light">Pagar cuota</button></td>
					</c:if>
				</tr>			
			</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- END CONTENT -->

</body>
<script type="text/javascript">
	CurrentItem = document.getElementById("mnPrestamos");
	CurrentItem.className +=" active";
	
	function pagarCuota(btn, numCuota, importeCuota, cuotaAnt){
		cuotaAnt--;
		estadoCuotaAnt = $("#estado" +cuotaAnt).html();
		if(estadoCuotaAnt == undefined || estadoCuotaAnt == "Paga" ){
				id = $(btn).val();
				Swal.fire({
					title:"¿Desea pagar la cuota N°" + numCuota + "?",
					html: "<p>Cuenta a debitar:</p><select id='cuentaSelect' class='custom-select form-prestamo' id='cuentaSelect'>" +
					"<c:forEach items='${ listadoCuentas }' var='cuenta'>" +
							"<option name='${cuenta.saldo}' value='${cuenta.idCuenta}'>${cuenta.alias} - <fmt:formatNumber type='number' pattern='00' minIntegerDigits='22' value='${cuenta.cbu}'/> - $<fmt:formatNumber type='number' maxFractionDigits='2' value='${cuenta.saldo}'/></option>" +
					"</c:forEach>" +
					"</select>",
					showCancelButton: true,
					reverseButtons: true,
					cancelButtonText: "Cancelar",
					confirmButtonText: "Pagar"
				}).then((result) => {
					if(result.value){
						idCuentaSelect = $("#cuentaSelect option:selected").val();
						saldoCuenta = parseFloat($("#cuentaSelect option:selected").attr('name'))
						if(saldoCuenta >= importeCuota){
							$('html, body').css("cursor", "wait");
							 $.ajax({
									url: '${request.getContextPath()}/TP_L5_GRUPO_2/pagarCuotaAsync.html',
									type: 'POST',
							        data: { idCuota: id, 
							        		idCuenta: idCuentaSelect},
									success: function(data){
										 $('html, body').css("cursor", "auto");
										if(data == "\"Exitoso\""){
											Swal.fire({
												icon: "success",
												title: "Cuota pagada",
												confirmButtonText: "Entendido"
											}).then((result) =>{
												location.reload();
											})
										}else{
											Swal.fire({
												icon: "error",
												title: "Hubo un error al procesar el pago de la cuota",
												confirmButtonText: "Entendido"
											})
										}
									}
							 });				
						}else{
							Swal.fire({
								icon: "warning",
								title: "No posee el dinero suficiente para pagar esta cuota",
								confirmButtonText: "Entendido"
							}).then((result) =>{
								Swal.close();									
							})
						}		
					}
				});		
		}else{
			Swal.fire({
				icon: "warning",
				title: "Debe abonar las cuotas en orden",
				confirmButtonText: "Entendido"
			})
		}
	}
	
	$('#TableCuotas').DataTable({
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
</script>
</html>


