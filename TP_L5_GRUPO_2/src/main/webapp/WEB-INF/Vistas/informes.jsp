<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>	
	
	<!--  INCLUDES FOR GRAPHIC-->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
 <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
 <script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
</head>
<body onload="filtrarPrestamos(); filtrarTransferencias()">

	<!-- NAVBAR -->
<%@ include file="NavbarAdmin.html"%>
	<!-- END NAVBAR -->

	<!-- CONTENT -->

	<div class="container-md">
		<h4 style="margin-top: 20px;">Prestamos aprobados/rechazados</h4>
		<!-- <form action="filtrarInforme.html" mehotd="post"> -->
		<div class="form-inline pull-left">
		<span class="mr-2">Prestamos entre </span>
			<input class="form-control form-control-sm mr-2" type="date" name="startDate" id="startDate" value="${stDate }"> 
			<span class="mr-2">y</span>
			<input	class="form-control form-control-sm mr-2" type="date" name="endDate" id="endDate" value="${edDate}"> 
			<button type="button" id="btnFiltrarPrestamos" class="btn btn-primary" onClick="filtrarPrestamos()" style="padding: .2rem .5rem;">Filtrar</button>
		</div>
		<div id="PrestamosChart" style="height: 250px;"></div>
		
		<!-- INFORME TRANSFERENCIAS -->
		<h4 style="margin-top: 20px;">Cantidad de transferencias</h4>
		<div class="form-inline">
		<span class="mr-2">Transferencias en el año: </span>
		<select id="cmbAnio" name="anioSelect" class="custom-select mr-2">
			<option value="2020">2020</option>
			<option value="2019">2019</option>
			<option value="2018">2018</option>
		</select>
			<button class="btn btn-primary" onClick="filtrarTransferencias()" style="padding: .2rem .5rem;">Filtrar</button>
		</div>
		
		<div id="TransferenciasChart" style="height: 250px;"></div>
		<!-- </form> -->
		
	</div>
	<!-- END CONTENT -->
	<input type="hidden" id="anioSelected" value="<c:out value="${anio}"/>"/>
	<c:forEach items="${informeTransferencia}" var="transfer" varStatus="loop">
		<input type="hidden" id="informeTransferencias${loop.count}" value="${transfer[1]}" />
	</c:forEach>
</body>

<script type="text/javascript">
	CurrentItem = document.getElementById("mnInformes");
	CurrentItem.className +=" active";
	
	function filtrarPrestamos(){
		var sDate = $("#startDate").val();
		var eDate = $("#endDate").val();
		if(sDate == ""){
			sDate = new Date().getFullYear() + "-01-01";
			$("#startDate").val(sDate);
		}
		if(eDate == ""){
			eDate = new Date().getFullYear() + "-12-31";
			$("#endDate").val(eDate);
		}
	$('html, body').css("cursor", "wait");
	   $.ajax({
			url: '${request.getContextPath()}/TP_L5_GRUPO_2/filtrarInformeAsync.html',
			type: 'POST',
	        data: { startDate: sDate,
	        	    endDate: eDate},
			success: function(data){
				$('html, body').css("cursor", "auto");
				var prestamos = JSON.parse(data);
				var PresAutorizados = prestamos[0];
				var PresNoAutorizados = prestamos[1];
				
				if(PresAutorizados == 0 && PresNoAutorizados == 0){
					var data = [{label: "Sin datos", value: 100}]
				}
				else{
					var data = [
					    { label: 'Aprobados', value: PresAutorizados },
					    { label: 'Rechazados', value: PresNoAutorizados }] 
				}
				$("#PrestamosChart").empty();
				Morris.Donut({
					  element: 'PrestamosChart',
					  data: data,
					  colors: ["green", "red"],
				});
			}
	   });		
	};
			
	function filtrarTransferencias(){
		var anioSelected = $("#cmbAnio").val();
		if(anioSelected == ""){
			anioSelected = new Date().getFullYear();
		}
		$('html, body').css("cursor", "wait");
		   $.ajax({
				url: '${request.getContextPath()}/TP_L5_GRUPO_2/filtrarTransferenciasAsync.html',
				type: 'POST',
		        data: { anio: anioSelected},
				success: function(data){
					$('html, body').css("cursor", "auto");
					var transferencias = JSON.parse(data);
					$("#TransferenciasChart").empty();
					Morris.Line({
						  element: 'TransferenciasChart',
						  data: [{
							      month: 'Enero', value: transferencias[0][1] },
							    { month: 'Febrero', value: transferencias[1][1] },
							    { month: 'Marzo', value: transferencias[2][1] },
							    { month: 'Abril', value: transferencias[3][1] },
							    { month: 'Mayo', value: transferencias[4][1] },
							    { month: 'Junio', value:transferencias[5][1] },
							    { month: 'Julio', value: transferencias[6][1] },
							    { month: 'Agosto', value: transferencias[7][1] },
							    { month: 'Septiembre', value: transferencias[8][1] },
							    { month: 'Octubre', value: transferencias[9][1] },
							    { month: 'Noviembre', value: transferencias[10][1] },
							    { month: 'Diciembre', value: transferencias[11][1] }],
						  xkey: 'month',
						  parseTime: false,
						  ykeys: ['value'],
						  labels: ['Transferencias']
						});
				}
		   });
	}	
</script>
</html>