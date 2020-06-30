<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
<meta charset="ISO-8859-1">
<!-- Jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<!-- Bootstrap CSS y Script -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" 
crossorigin="anonymous">

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" 
integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" 
crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
crossorigin="anonymous"></script>

<!-- Data Tables -->
<script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"/>
<link rel=stylesheet
	href="<c:url value="resources/Estilos/styles.css"/>" type="text/css"
	media=screen>
<script type="text/javascript">
$(document).ready(function(){
	CurrentItem = document.getElementById("mnClientes");
	CurrentItem.className += " active";	
})
	$(document).ready(
		function() {
			$('#TClientes').DataTable(
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
            const tableReg = document.getElementById('TClientes');
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
     const tableReg = document.getElementById('TClientes');
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
	 const tableReg = document.getElementById('TClientes');
	 for (var i = 1; i < tableReg.rows.length; i++) {
		 tableReg.rows[i].style.display = '';
	 }
	 document.getElementById("NomApeTxtId").value=''; 
	 document.querySelector('#LblApeNomId').innerText = '';
}
 function LimpiarFiltroDni(){
	 const tableReg = document.getElementById('TClientes');
	 for (var i = 1; i < tableReg.rows.length; i++) {
		 tableReg.rows[i].style.display = '';
	 }
	 document.getElementById("TxtDniId").value=''; 
	 document.querySelector('#LblDniId').innerText = '';
}
 
//con esta funcion pasamos los paremtros a los text del modal.
  function selCliente(Cadena){
	 var array=Cadena.split(",");
	 document.getElementById('DnieditId').value=array[0];
	 document.getElementById('NomEditId').value=array[1];
	 document.getElementById('ApeEditId').value=array[2];
	 //cmb genero
	  if (array[3] == "Masculino" ){
		  $("#GenEditId option[value=1]").attr("selected",true);
		   }else{
			   if(array[3]=="Femenino"){
				   $("#GenEditId option[value=2]").attr("selected",true);
				   }else{
					   $("#GenEditId  option[value=3]").attr("selected",true);
					}
		    }
	    //cmb localidades
	    $("#LocEditId option").each(function(){
		    if(array[5]==$(this).text()){
		    	$("#LocEditId option[value="+$(this).attr('value')+"]").attr("selected",true);
			}
		});
	//Fecha nacimiento
	 var array2=array[4].split(" ");
	 document.getElementById('FnacEditId').value = array2[0];
	//cmb provincias
	    $("#ProvEditId option").each(function(){
		    if(array[10]==$(this).text()){
		    	$("#ProvEditId option[value="+$(this).attr('value')+"]").attr("selected",true);
			}
		});
	 document.getElementById('DirEditId').value=array[6];
	 document.getElementById('NacEditId').value=array[7];
	 document.getElementById('EmailEditId').value=array[8];
	 document.getElementById('TelEditId').value=array[9];
 };
 function PasarDniBaja(dni){
	 document.getElementById('IdTxtBajaClient').value=dni;
}
 function PasarDniAlta(dni){
	 document.getElementById('IdTxtAltaClient').value=dni;
}
    </script>
<title></title>
</head>
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
	<table id="TClientes" class="table table-hover table-sm" style="padding-left: 5px">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">DNI</th>
	      <th scope="col">Nombre y Apellido</th>
	      <th scope="col">Genero</th>
	      <th scope="col">Fecha De Nacimiento</th>
	      <th scope="col">Localidad</th>
	      <th scope="col">Direccion</th>
	      <th scope="col">Provincia</th>
	      <th scope="col">Nacionalidad</th>
	      <th scope="col">E-mail</th>
	      <th scope="col">Telefono</th>
	      <th scope="col">Editar</th>
	      <th scope="col">Estado</th>
	    </tr>
	  </thead>
	  <tbody>
		  <c:forEach var="Cliente" items="${ ClientesList }">
		  <form action="ModificarCliente.html" method="get">
			 <tr id="Cliente-${ Cliente.getIdUsu() }">
				<td>${ Cliente.getDni() }</td>
				<td>${ Cliente.getNombre() }, ${ Cliente.getApellido() }</td>
				<td>${ Cliente.getGen().getDescripcion()}</td>
				<td>${ Cliente.getFechaNac()}</td>
				<td>${ Cliente.getLoc().getLocNombre() }</td>
				<td>${ Cliente.getDireccion() }</td>
				<td>${ Cliente.getLoc().getProvLoc().getProvNombre() }</td>
				<td>${ Cliente.getNacionalidad() }</td>
				<td>${ Cliente.getEmail() }</td>
				<td>${ Cliente.getTel() }</td>
				<td class="text-center">
				<a href="#" style="border-radius: 1;border-color: white;text-align: center;" 
				name="BtnEditClie" data-toggle="modal" data-target="#ModalEditarCliente" 
				onclick="selCliente('${ Cliente.getDni()}'+','+'${ Cliente.getNombre()}'+','+'${ Cliente.getApellido()}'+','+'${ Cliente.getGen().getDescripcion()}'+','+'${ Cliente.getFechaNac()}'+','+'${ Cliente.getLoc().getLocNombre()}'+','+'${ Cliente.getDireccion()}'+','+'${ Cliente.getNacionalidad()}'+','+'${ Cliente.getEmail()}'+','+'${  Cliente.getTel()}'+','+'${ Cliente.getLoc().getProvLoc().getProvNombre() }');"> 
				<img 
				src="<c:url value="resources/Imagenes/edit.png"/>"
				width="18" height="18" alt="imagen editar">
				</a>
				</td>
		     	<td class="text-center">
					<c:choose>
					    <c:when test="${Cliente.isEstado()==true}">
						    <input type="submit" class="btn-sm btn-success" name="BtnBajaClie" 
					     	value="Alta" data-toggle="modal" data-target="#ModalBajaCliente" onclick="PasarDniBaja(${ Cliente.getDni()})"/>
					    </c:when>    
					    <c:otherwise>
					       <input type="submit" class="btn-sm  btn-danger" name="BtnAltaClie" 
		     				value="Baja" data-toggle="modal" data-target="#ModalAltaCliente" onclick="PasarDniAlta(${ Cliente.getDni()})"/>
					    </c:otherwise>
					</c:choose>
		     	</td>
			 </tr>
		  </form>
		  </c:forEach>
	  </tbody>
	</table>
</fieldset>	   
<!--Fin Tabla-->
</div>
	</div>	
		</div>		

<!-- modal cerrar session  -->
<div class="modal fade" id="ModalCerrarSession" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Cerrar Sesion</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ¿Desea cerrar la sesion?
      </div>
      <div class="modal-footer">
     <form action="#" method="post" accept-charset=utf-8>
     <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	 <button type="Submit" class="btn btn-primary" name="BtnCerrarSesion" >Cerrar Sesion</button>		
		</form>
      </div>
    </div>
  </div>
</div>  
<!-- modal cerrar session  -->

<!-- modal Editar cliente  -->
<div class="modal fade" id="ModalEditarCliente" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Editar Cliente</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
	      <form action="">
	      	<div class="container-fluid">
	      	<div class="row">
			<div class="col-8 col-sm-6">
			
			 <div class="form-group"> <!-- DNI -->
		        <label for="full_name_id" class="control-label">Numero De Documento</label>
		        <input type="number" class="form-control form-control-sm" id="DnieditId" name="DniEditName" placeholder="D.N.I">
		    </div>  
		    <div class="form-group"> <!-- Nombre -->
		        <label for="full_name_id" class="control-label">Nombre</label>
		        <input type="text" class="form-control form-control-sm" id="NomEditId" name="NomEditName" placeholder="NOMBRE">
		    </div>    
		    <div class="form-group"> <!-- Apellido -->
		        <label for="full_name_id" class="control-label">Apellido</label>
		        <input type="text" class="form-control form-control-sm" id="ApeEditId" name="ApeEditName" placeholder="APELLIDO">
		    </div> 

		      <div class="form-group"> <!-- Correo electronico -->
		        <label for="full_name_id" class="control-label">Correo Electronico</label>
		        <input type="email" class="form-control form-control-sm" id="EmailEditId" name="EmailEditName" placeholder="e-mail" required>
		    </div> 
		    
		    <div class="form-group"> <!-- Telefono -->
		        <label for="full_name_id" class="control-label">Numero de telefono</label>
		        <input type="number" class="form-control form-control-sm" id="TelEditId" name="TelEditName" placeholder="Telefono">
		    </div> 
		    
		     <div class="form-group"> <!-- Sexo -->
		        <label for="state_id" class="control-label">Sexo</label>
		        <select class="form-control form-control-sm" id="GenEditId" name="GenEditName">
		            <option value="1">Masculino</option>
		            <option value="2">Femenino</option>
		            <option value="3">Otro</option>
		        </select>                    
		    </div>
		    
			</div>
			<div class="col-8 col-sm-6">
			<div class="form-group"> <!-- Nacionalidad -->
		        <label for="full_name_id" class="control-label">Nacionalidad</label>
		        <input type="text" class="form-control form-control-sm" id="NacEditId" name="NacEditName" placeholder="NACIONALIDAD">
		    </div> 
		     <div class="form-group "><!-- Fecha De Nacimiento -->
		     <label for="full_name_id" class="control-label">Fecha De Nacimiento</label>
			    <input class="form-control form-control-sm" type="date"  id="FnacEditId" name="FnacEditName">
			</div>
		   <div class="form-group"> <!-- Direccion -->
		        <label for="full_name_id" class="control-label">Direccion</label>
		        <input type="text" class="form-control form-control-sm" id="DirEditId" name="DirEditName" placeholder="DIRECCION">
		    </div>
		            
		    <div class="form-group"> <!-- Localidad -->
		      <label for="state_id" class="control-label">Localidad</label>
		      <select class="form-control form-control-sm" id="LocEditId" name="LocEditName">  
		      <c:forEach items="${LocalidadesList}" var="loc" varStatus="loop">
		      		<option value="${loc.getIdLocalidad()}">${loc.getLocNombre()}</option>
		      </c:forEach>
			  </select>                     
		    </div>                
		            
		    <div class="form-group"> <!-- Provincia -->
		        <label for="state_id" class="control-label">Provincia</label>
		        <select class="form-control form-control-sm" id="ProvEditId" name="ProvEditName">
		            <option value="BSAS">Buenos Aires</option>
		            <option value="CABA">Ciudad Autonoma De Buenos Aires</option>
		            <option value="TUC">Tucuman</option>
		            <option value="ER">Entre Rios</option>
		            <option value="MIS">Misiones</option>
		            <option value="FOR">Formosa</option>
		            <option value="COR">Corrientes</option>
		            <option value="SF">Santa Fe</option>
		            <option value="COR">Cordoba</option>
		            <option value="JUJ">Jujuy</option>
		            <option value="CHU">Chubut</option>
		            <option value="TDF">Tierra Del Fuego</option>
		            <option value="NEU">Neuquen</option>
		            <option value="IL">Chaco</option>
		            <option value="IN">San Juan</option>
		            <option value="IA">San Luis</option>
		            <option value="KS">La Pampa</option>
		            <option value="KY">Santa Cruz</option>
		            <option value="LA">Salta</option>
		            <option value="ME">Catamarca</option>
		            <option value="MD">La Rioja</option>
		            <option value="MA">Santiago Del Estero</option>
		            <option value="MI">Mendoza</option>
		        </select>                    
		    </div>
		      
		</div>
		</div>
			</div>
	      </form>
      </div>
      <div class="modal-footer">
     <form action="#" method="post" accept-charset=utf-8>
     <button type="button" class="btn-sm btn-secondary" data-dismiss="modal">Cancelar</button>
	 <button type="Submit" class="btn-sm btn-success" name="BtnGrabar" >Grabar</button>		
		</form>
      </div>
    </div>
  </div>
</div>  
<!-- modal Editar cliente  -->

<!-- modal Dar de baja cliente  -->
<div class="modal fade" id="ModalBajaCliente" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmar Baja Cliente</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body text-center">
     <strong >¿Esta seguro que quiere dar de baja a este cliente?</strong>
      </div>
      <div class="modal-footer">
     <form action="RedireccionarDarDeBajaCliente.html" method="post" accept-charset=utf-8>
     <input type="hidden" class="form-control" name="TxtBajaClientName"id="IdTxtBajaClient" value=""/>
     <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	 <button type="Submit" class="btn btn-danger" name="BtnCerrarSesion" >Confirmar</button>		
		</form>
      </div>
    </div>
  </div>
</div>  
<!-- modal Dar de baja cliente  -->

<!-- modal Dar de alta cliente  -->
<div class="modal fade" id="ModalAltaCliente" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmar Alta Cliente</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body text-center">
     <strong >¿Esta seguro que quiere dar de alta a este cliente?</strong>
      </div>
      <div class="modal-footer">
     <form action="RedireccionarDarDeAltaCliente.html" method="post" accept-charset=utf-8>
     <input type="hidden" class="form-control" name="TxtAltaClientName"id="IdTxtAltaClient" value=""/>
     <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	 <button type="Submit" class="btn btn-success" name="BtnCerrarSesion" >Confirmar</button>		
		</form>
      </div>
    </div>
  </div>
</div>  
<!-- modal Dar de alta cliente  -->

</body>
</html>