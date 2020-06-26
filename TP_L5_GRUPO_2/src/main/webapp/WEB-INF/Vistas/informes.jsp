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
		<form class="form-inline pull-left" action="filtrarFechas.html" mehotd="get">
		<span class="mr-2">Transferencias entre </span>
			<input class="form-control form-control-sm mr-2" type="date" name="startDate" id="example-date-input" value="${stDate }"> 
			<span class="mr-2">y</span>
			<input	class="form-control form-control-sm mr-2" type="date" name="endDate" id="example-date-input" value="${edDate}"> 
			<button class="btn btn-primary" style="padding: .2rem .5rem;">Filtrar</button>
		</form>
		<input type="hidden" id="PresAutorizados" value="${InformePrestamos[0]}" />
		<input type="hidden" id="PresNoAutorizados" value="${InformePrestamos[1]}" />
		<div id="PrestamosChart" style="height: 250px;"></div>
		
		<h4 style="margin-top: 20px;">Cantidad de transferencias</h4>

		<div id="TransferenciasChart" style="height: 250px;"></div>
		
	</div>
	<!-- END CONTENT -->

</body>
<script type="text/javascript">
	CurrentItem = document.getElementById("mnInformes");
	CurrentItem.className +=" active";
	
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
	
	new Morris.Line({
		  element: 'TransferenciasChart',
		  data: [
			    { month: '2020-01', value: 5 },
			    { month: '2020-02', value: 6 },
			    { month: '2020-03', value: 2 },
			    { month: '2020-04', value: 30 },
			    { month: '2020-05', value: 1 },
			    { month: '2020-06', value: 10 },
			    { month: '2020-07', value: 0 },
			    { month: '2020-08', value: 43 },
			    { month: '2020-09', value: 0 },
			    { month: '2020-10', value: 65 },
			    { month: '2020-11', value: 23 },
			    { month: '2020-12', value: 12 }
			  ],
		  xkey: 'month',
		  ykeys: ['value'],
		  labels: ['Transferencias']
		});

	
</script>
</html>