<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
	
	<!--  INCLUDES FOR GRAPHIC-->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
 <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
 <script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
</head>
<body>

	<!-- NAVBAR -->
<%@ include file="NavbarAdmin.html"%>
	<!-- END NAVBAR -->

	<!-- CONTENT -->

	<div class="container-md">
		<h4 style="margin-top: 20px;">Prestamos aprobados/rechazados</h4>
		<form action="filtrarInforme.html" mehotd="post">
		<div class="form-inline pull-left">
		<span class="mr-2">Prestamos entre </span>
			<input class="form-control form-control-sm mr-2" type="date" name="startDate" id="example-date-input" value="${stDate }"> 
			<span class="mr-2">y</span>
			<input	class="form-control form-control-sm mr-2" type="date" name="endDate" id="example-date-input" value="${edDate}"> 
			<button class="btn btn-primary" style="padding: .2rem .5rem;">Filtrar</button>
		</div>
		<input type="hidden" id="PresAutorizados" value="${InformePrestamos[0]}" />
		<input type="hidden" id="PresNoAutorizados" value="${InformePrestamos[1]}" />
		<div id="PrestamosChart" style="height: 250px;"></div>
		
		<!-- INFORME TRANSFERENCIAS -->
		<h4 style="margin-top: 20px;">Cantidad de transferencias</h4>
		<div class="form-inline">
		<span class="mr-2">Transferencias en el año: </span>
		<select id="cmbAnio" name="anioSelect" class="custom-select mr-2">
			<option value="2020">2020</option>
			<option value="2019">2019</option>
		</select>
			<button class="btn btn-primary" style="padding: .2rem .5rem;">Filtrar</button>
		</div>
		
		<div id="TransferenciasChart" style="height: 250px;"></div>
		</form>
		
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
	$("#cmbAnio").val($("#anioSelected").val());
	var PresAutorizados = $("#PresAutorizados").val();
	var PresNoAutorizados = $("#PresNoAutorizados").val();
	
	if(PresAutorizados == 0 && PresNoAutorizados == 0){
		var data = [{label: "Sin datos", value: 100}]
	}
	else{
		var data = [
		    { label: 'Aprobados', value: PresAutorizados },
		    { label: 'Rechazados', value: PresNoAutorizados }] 
	}
	
	
	new Morris.Donut({
		  element: 'PrestamosChart',
		  data: data,
		  colors: ["green", "red"],
		});
	
	console.log($("#informeTransferencias").val())
	var anioActual = $("#anioSelected").val()
	new Morris.Line({
		  element: 'TransferenciasChart',
		  data: [{
			      month: 'Enero', value: $("#informeTransferencias1").val() },
			    { month: 'Febrero', value: $("#informeTransferencias2").val() },
			    { month: 'Marzo', value: $("#informeTransferencias3").val() },
			    { month: 'Abril', value: $("#informeTransferencias4").val() },
			    { month: 'Mayo', value: $("#informeTransferencias5").val() },
			    { month: 'Junio', value: $("#informeTransferencias6").val() },
			    { month: 'Julio', value: $("#informeTransferencias7").val() },
			    { month: 'Agosto', value: $("#informeTransferencias8").val() },
			    { month: 'Septiembre', value: $("#informeTransferencias9").val() },
			    { month: 'Octubre', value: $("#informeTransferencias10").val() },
			    { month: 'Noviembre', value: $("#informeTransferencias11").val() },
			    { month: 'Diciembre', value: $("#informeTransferencias12").val() }],
		  xkey: 'month',
		  parseTime: false,
		  ykeys: ['value'],
		  labels: ['Transferencias']
		});

	
</script>
</html>