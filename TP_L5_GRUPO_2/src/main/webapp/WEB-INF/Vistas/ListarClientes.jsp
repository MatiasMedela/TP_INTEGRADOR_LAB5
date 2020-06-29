<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
<meta charset="ISO-8859-1">
<!-- Jquery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<!-- Bootstrap CSS y Script -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<!-- JS, Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>

<!-- Data Tables -->
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" />
<link rel=stylesheet href="<c:url value="resources/Estilos/styles.css"/>" type="text/css" media=screen>

<title></title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	CurrentItem = document.getElementById("mnClientes");
	CurrentItem.className += " active";	
})
	$(document).ready(
		function() {
			$('#TLClientes').DataTable(
							{
								"searching": true,
								"scrollX" : true,
								"scrollY" : 500,
								sPaginationType : "full_numbers",
								bProcessing : true,
								bAutoWidth : true,
								"sScrollX" : "100%",
								"sScrollXInner" : "100%",
								"lengthMenu": [[25, 50,100, -1], [25, 50,100, "All"]],
								language : {
									decimal : "",
									emptyTable : "No se han encontrado registros",
									infoEmpty : "Mostrando desde el 0 al 0 del total de  0 registros",
									infoFiltered : "(Filtrados del total de _MAX_ registros)",
									infoPostFix : "",
									thousands : ",",
									lengthMenu : "Mostrar _MENU_ registros por página",
									loadingRecords : "Cargando...",
									processing : "Procesando...",
									search : "Buscar registro:",
									zeroRecords : "No se han encontrado registros",
									info : "Mostrando desde el _START_ al _END_ del total de _TOTAL_ registros",
									paginate : {
										first : "Primera",
										last : "Última",
										next : "Siguiente",
										previous : "Anterior"
									},
									aria : {
										sortAscending : ": activate to sort column ascending",
										sortDescending : ": activate to sort column descending"
									}
								}
							});
					 });
</script>
<script type="text/javascript">
 function doSearchNomApe()
        {
            const tableReg = document.getElementById('TLClientes');
            const searchText = document.getElementById('NomApeTxtId').value.toLowerCase();
            var total = 0;
 
            // Recorremos todas las filas con contenido de la tabla
            for (let i = 1; i < tableReg.rows.length; i++) {
                // Si el td tiene la clase "noSearch" no se busca en su cntenido
                if (tableReg.rows[i].classList.contains("noSearch")) {
                    continue;
                }
 
                var found = false;
                var NoIngresado = false;
                const cellsOfRow = tableReg.rows[i].getElementsByTagName('td');
                // Recorremos todas las celdas
                for (var j = 0; j < cellsOfRow.length && !found; j++) {
                    const compareWith = cellsOfRow[1].innerHTML.toLowerCase();
                    // Buscamos el texto en el contenido de la celda
                    if (compareWith.includes(searchText)) {
                        found = true;
                        total++;
                    }
                    if(searchText.length == 0 ){
                   	 NoIngresado = true;
                    }
                }
                if (found) {
                    tableReg.rows[i].style.display = '';
                } else {
                    // si no ha encontrado ninguna coincidencia, esconde la fila de la tabla
                    tableReg.rows[i].style.display = 'none';
                }
            }
            if(NoIngresado == false){
	            // mostramos las coincidencias
	            const lastTR=tableReg.rows[tableReg.rows.length-1];
	            const td=lastTR.querySelector("td");
	            lastTR.classList.remove("hide", "red");
	            if (searchText == "") {
	                lastTR.classList.add("hide");
	            } else if (total) {
	                document.getElementById("LblApeNomId").style.color="green";
	                document.querySelector('#LblApeNomId').innerText = "Se ha encontrado "+total+" coincidencia"+((total>1)?"s":"");
	            } else {
	                document.getElementById("LblApeNomId").style.color="red";
	                document.querySelector('#LblApeNomId').innerText = 'No se han encontrado coincidencias';
	            }
            }else{
           	 document.getElementById("LblApeNomId").style.color="red";
             document.querySelector('#LblApeNomId').innerText = 'Ingrese el apellido o nombre del cliente';
         }
       }
 function doSearchDni()
 {
     const tableReg = document.getElementById('TLClientes');
     const searchText = document.getElementById('TxtDniId').value.toLowerCase();
     var total = 0;

     // Recorremos todas las filas con contenido de la tabla
     for (let i = 1; i < tableReg.rows.length; i++) {
         // Si el td tiene la clase "noSearch" no se busca en su cntenido
         if (tableReg.rows[i].classList.contains("noSearch")) {
             continue;
         }

         var found = false; 
         var NoIngresado = false;
         const cellsOfRow = tableReg.rows[i].getElementsByTagName('td');
         // Recorremos todas las celdas
         for (let j = 0; j < cellsOfRow.length && !found; j++) {
             const compareWith = cellsOfRow[0].innerHTML.toLowerCase();
             // Buscamos el texto en el contenido de la celda
             if (compareWith.indexOf(searchText) > -1) {
                 found = true;
                 total++;
             }
             if(searchText.length == 0 ){
            	 NoIngresado = true;
             }
         }
         if (found) {
             tableReg.rows[i].style.display = '';
         } else {
             // si no ha encontrado ninguna coincidencia, esconde la fila de la tabla
             tableReg.rows[i].style.display = 'none';
         }
     }

     // mostramos las coincidencias
     const lastTR=tableReg.rows[tableReg.rows.length-1];
     const td=lastTR.querySelector("td");
     lastTR.classList.remove("hide", "red");
     if(NoIngresado == false){
	     if (searchText == "") {
	         lastTR.classList.add("hide");
	     } else if (total) {
	         document.getElementById("LblDniId").style.color="green";
	         document.querySelector('#LblDniId').innerText = "Se ha encontrado "+total+" coincidencia"+((total>1)?"s":"");
	     } else {
	         document.getElementById("LblDniId").style.color="red";
	         document.querySelector('#LblDniId').innerText = 'No se han encontrado coincidencias';
	     }
     }else{
    	 document.getElementById("LblDniId").style.color="red";
         document.querySelector('#LblDniId').innerText = 'Ingrese el numero de DNI';
     }
 }

 function LimpiarFiltroNomApe(){
	 const tableReg = document.getElementById('TLClientes');
	 for (var i = 1; i < tableReg.rows.length; i++) {
		 tableReg.rows[i].style.display = '';
	 }
	 document.getElementById("NomApeTxtId").value=''; 
	 document.querySelector('#LblApeNomId').innerText = '';
}
 function LimpiarFiltroDni(){
	 const tableReg = document.getElementById('TLClientes');
	 for (var i = 1; i < tableReg.rows.length; i++) {
		 tableReg.rows[i].style.display = '';
	 }
	 document.getElementById("TxtDniId").value=''; 
	 document.querySelector('#LblDniId').innerText = '';
}
    </script>
<body>
	<!-- NAVBAR -->
	<%@ include file="NavbarAdmin.html"%>
	<!-- END NAVBAR -->
		<div class="container-fluid">
			<div class="row row-cols-2">
				<div class="col-2">
					<fieldset class="border p-2">
						<legend class="w-auto">Busquedas</legend>
						<form class="form" id="form-Filter-Dni">
							<div class="form-group ">
								<!-- DNI -->
								<label for="full_name_id" class="control-label">Número de documento</label> 
								<input type="number" class="form-control form-control-sm" id="TxtDniId"
									name="TxtDniName" placeholder="D.N.I" required>
								<label for="full_name_id" class="control-label" id="LblDniId"></label>
							</div>
							<div class="form-group text-center" style="padding-left: 10px">
								<!-- Submit Button -->
								<button type="button" class="btn-sm btn-primary" name="DniNameSearch" onclick="doSearchDni()">Buscar</button>
								<button type="button" class="btn-sm btn-primary" name="LimpiarDniTxtSearch" onclick="LimpiarFiltroDni()">Limpiar</button>
							</div>
						</form>

						<form class="form" id="form-Filter-NomApe">
							<div class="form-group">
								<!-- Nombre y Apellido -->
								<label for="full_name_id" class="control-label">Nombre y Apellido</label>
								<input type="text" class="form-control form-control-sm"
									id="NomApeTxtId" name="NomApeTxtName" placeholder="Nombre y Apellido">
								<label for="full_name_id" class="control-label" id="LblApeNomId" required></label>
							</div>
							<div class="form-group text-center" style="padding-left: 10px">
								<!-- Submit Button -->
								<button type="button" class="btn-sm btn-primary" name="NomApeNameSearch" onclick="doSearchNomApe()">Buscar</button>
								<button type="button" class="btn-sm btn-primary" name="LimpiarNomApeTxtSearch" onclick="LimpiarFiltroNomApe()">Limpiar</button>
							</div>
						</form>
					</fieldset>
				</div>
				<div class="col-10">
					<!-- inicio tabla -->
					<fieldset class="border p-1" >
						<legend class="w-auto">Clientes</legend>
						<table id="TLClientes" class="table table-hover table-sm "
							style="padding-left: 4px">
							<thead class="thead-dark">
								<tr>
									<th scope="col">DNI</th>
									<th scope="col">Nombre y Apellido</th>
									<th scope="col">E-mail</th>
									<th scope="col">Telefono</th>
									<th scope="col">Estado</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="Cliente" items="${ ClientesList }">
								  <tr id="Cliente-${ Cliente.getIdUsu() }">
								    <td>${ Cliente.getDni() }</td>
								    <td>${ Cliente.getNombre() }, ${ Cliente.getApellido() }</td>
								    <td>${ Cliente.getEmail() }</td>
								    <td>${ Cliente. getTel() }</td>
								    <td>${ Cliente.isEstado() }</td>
								  </tr>
								</c:forEach>
							</tbody>
						</table>
					</fieldset>
					<!--Fin Tabla-->
				</div>
			</div>
		</div>

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
</html>