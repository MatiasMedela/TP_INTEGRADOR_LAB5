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
		<h3 style="margin-top: 20px;">Informes</h3>
		<h4 style="margin-top: 20px;">Prestamos aprobados/rechazados</h4>
		
		<div id="PrestamosChart" style="height: 250px;"></div>


		
		<form class="form-inline pull-left">
		<span class="mr-2">Transferencias entre </span>
			<input class="form-control form-control-sm mr-2" type="date"	id="example-date-input"> 
			<span class="mr-2">y</span>
			<input	class="form-control form-control-sm mr-2" type="date" id="example-date-input"> 
			<button class="btn btn-primary" style="padding: .2rem .5rem;">Filtrar</button>
		</form>
		<table id="TableInforme" class="table">
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
<script type="text/javascript">
	CurrentItem = document.getElementById("mnInformes");
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
	$('#TableInforme').DataTable({
		"ordering" : false,
		"bInfo" : false,
		"lengthChange" : false,
		"pageLength" : cantPags,
		"dom" : '<"pull-right"f>rtip',
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
	
	
	
	new Morris.Donut({
		  // ID of the element in which to draw the chart.
		  element: 'PrestamosChart',
		  // Chart data records -- each entry in this array corresponds to a point on
		  // the chart.
		  data: [
		    { Tipo: 'Aprobados', value: 200 },
		    { Tipo: 'Rechazados', value: 50 }
		  ],
		  // The name of the data record attribute that contains x-values.
		  xkey: 'Tipo',
		  // A list of names of data record attributes that contain y-values.
		  ykeys: ['value'],
		  // Labels for the ykeys -- will be displayed when you hover over the
		  // chart.
		  labels: ['Value']
		});
	
</script>
</html>